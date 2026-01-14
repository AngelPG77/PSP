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
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class SWCrawler {
    HttpClient client = HttpClient.newHttpClient();
    Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .setDateFormat("dd-MM-yyyy HH:mm:ss")
            .serializeNulls()
            .create();
    HttpRequest requestObject;
    final String URL_BASE = "https://swapi.info/api/";

    public CompletableFuture<Films> crawlFilm(int filmId) {
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
                                    .thenCompose(character ->{
                                        CompletableFuture<List<Starships>> listNave = getLists(film.getStarships(), Starships.class);
                                        CompletableFuture<List<Vehicles>> listVehicle = getLists(film.getVehicles(), Vehicles.class);
                                        return CompletableFuture.allOf(listNave, listVehicle)
                                                .thenApply(v -> {
                                                    person.setVehiclesList(listVehicle.join());
                                                    person.setStarshipsList(listNave.join());
                                                    return person;
                                                });

                                    });
                            return new Films(

                            );

                        }
                )


    }

    public <T> CompletableFuture<List<T>> getLists(String[] urls, Class<T> c) {
        List<CompletableFuture<T>> listFutures = Arrays.stream(urls)
                .map(url -> {
                            requestObject = HttpRequest.newBuilder()
                                    .uri(URI.create(url))
                                    .GET()
                                    .build();
                            return client.sendAsync(requestObject, HttpResponse.BodyHandlers.ofString())
                                    .thenApply(HttpResponse::body)
                                    .thenApply(e -> gson.fromJson(e, c));
                        }
                ).toList();
        return CompletableFuture.allOf(listFutures.toArray(new CompletableFuture[0])).thenApply(e-> listFutures.stream().map(CompletableFuture::join).toList());
    }

}
