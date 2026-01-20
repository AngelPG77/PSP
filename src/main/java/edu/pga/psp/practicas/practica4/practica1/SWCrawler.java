package edu.pga.psp.practicas.practica4.practica1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.pga.psp.practicas.practica4.practica1.model.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class SWCrawler {
    HttpClient client = HttpClient.newHttpClient();
    Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .setDateFormat("dd-MM-yyyy HH:mm:ss")
            .serializeNulls()
            .create();

    final String URL_BASE = "https://swapi.info/api/";

    public CompletableFuture<FilmReport> crawlFilm(int filmId) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL_BASE + "films/" + filmId))
                .GET()
                .build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(e -> gson.fromJson(e, Films.class))
                .thenCompose(film -> {
                    CompletableFuture<List<Planets>> listPlanets = getLists(film.getPlanets(), Planets.class);
                    CompletableFuture<List<Species>> listSpecies = getLists(film.getSpecies(), Species.class);
                    CompletableFuture<List<People>> listPeople = getLists(film.getCharacters(), People.class)
                            .thenCompose(characters -> {
                                characters.forEach(e -> {
                                    CompletableFuture<List<Starships>> listNave = getLists(e.getStarships(), Starships.class);
                                    CompletableFuture<List<Vehicles>> listVehicle = getLists(e.getVehicles(), Vehicles.class);

                                    e.setStarshipsArr(listNave.join());
                                    e.setVehiclesArr(listVehicle.join());
                                });
                                return CompletableFuture.completedFuture(characters);
                            });

                    return CompletableFuture.allOf(listPlanets, listSpecies, listPeople)
                            .thenApply(v -> {
                                film.setPlanetsArr(listPlanets.join());
                                film.setSpeciesArr(listSpecies.join());
                                film.setCharactersArr(listPeople.join());
                                return new FilmReport(film);
                            });
                })
                .exceptionally(ex -> {
                    System.err.println("Error critico: " + ex.getMessage());
                    return null;
                });
    }

    public <T> CompletableFuture<List<T>> getLists(String[] urls, Class<T> c) {
        if (urls == null) return CompletableFuture.completedFuture(Collections.emptyList());

        List<CompletableFuture<T>> listFutures = Arrays.stream(urls)
                .distinct()
                .map(url -> {
                    try {
                        HttpRequest requestLocal = HttpRequest.newBuilder()
                                .uri(URI.create(url))
                                .GET()
                                .build();

                        return client.sendAsync(requestLocal, HttpResponse.BodyHandlers.ofString())
                                .thenApply(res -> {
                                    if (res.statusCode() >= 400) throw new RuntimeException("Error" + res.statusCode());
                                    return res.body();
                                })
                                .thenApply(e -> gson.fromJson(e, c))
                                .exceptionally(ex -> {
                                    System.err.println("Error "+ ex.getMessage());
                                    return null;
                                });
                    } catch (Exception e) {
                        return CompletableFuture.completedFuture((T) null);
                    }
                }).toList();

        return CompletableFuture.allOf(listFutures.toArray(new CompletableFuture[0]))
                .thenApply(e -> listFutures.stream()
                        .map(CompletableFuture::join)
                        .filter(Objects::nonNull)
                        .toList());
    }
}