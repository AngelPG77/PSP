package edu.pga.psp.practicas.practica4.practica1.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Films {

    @Expose
    private String title;
    @Expose
    @SerializedName("episode_id")
    private Integer episodeId;
    @Expose
    @SerializedName("opening_crawl")
    private String openingCrawl;
    @Expose
    @SerializedName("director")
    private String director;
    @Expose
    private String producer;
    @Expose
    @SerializedName("release_date")
    private String releaseDate;
    @Expose
    private String[] species;
    @Expose
    private String[] starships;
    @Expose
    private String[] vehicles;
    @Expose
    private String[] characters;
    @Expose
    private String[] planets;
    @Expose
    private String url;
    @Expose
    private String created;
    @Expose
    private String edited;
    @Expose(deserialize = false)
    private List<Species> speciesArr = new ArrayList<>();
    @Expose(deserialize = false)
    private List<Starships> starshipsArr = new ArrayList<>();
    @Expose(deserialize = false)
    private List<Vehicles> vehiclesArr = new ArrayList<>();
    @Expose(deserialize = false)
    private List<People> charactersArr = new ArrayList<>();
    @Expose(deserialize = false)
    private List<Planets> planetsArr = new ArrayList<>();


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(Integer episodeId) {
        this.episodeId = episodeId;
    }

    public String getOpeningCrawl() {
        return openingCrawl;
    }

    public void setOpeningCrawl(String openingCrawl) {
        this.openingCrawl = openingCrawl;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String[] getSpecies() {
        return species;
    }

    public void setSpecies(String[] species) {
        this.species = species;
    }

    public String[] getStarships() {
        return starships;
    }

    public void setStarships(String[] starships) {
        this.starships = starships;
    }

    public String[] getVehicles() {
        return vehicles;
    }

    public void setVehicles(String[] vehicles) {
        this.vehicles = vehicles;
    }

    public String[] getCharacters() {
        return characters;
    }

    public void setCharacters(String[] characters) {
        this.characters = characters;
    }

    public String[] getPlanets() {
        return planets;
    }

    public void setPlanets(String[] planets) {
        this.planets = planets;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public List<Species> getSpeciesArr() {
        return speciesArr;
    }

    public void setSpeciesArr(List<Species> speciesArr) {
        this.speciesArr = speciesArr;
    }

    public List<Starships> getStarshipsArr() {
        return starshipsArr;
    }

    public void setStarshipsArr(List<Starships> starshipsArr) {
        this.starshipsArr = starshipsArr;
    }

    public List<Vehicles> getVehiclesArr() {
        return vehiclesArr;
    }

    public void setVehiclesArr(List<Vehicles> vehiclesArr) {
        this.vehiclesArr = vehiclesArr;
    }

    public List<People> getCharactersArr() {
        return charactersArr;
    }

    public void setCharactersArr(List<People> charactersArr) {
        this.charactersArr = charactersArr;
    }

    public List<Planets> getPlanetsArr() {
        return planetsArr;
    }

    public void setPlanetsArr(List<Planets> planetsArr) {
        this.planetsArr = planetsArr;
    }


}
