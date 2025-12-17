package edu.pga.psp.practicas.practica4.practica1.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

public class People {

    @Expose
    private String name;
    @Expose
    @SerializedName("birth_year")
    private String birthYear;
    @Expose
    @SerializedName("eye_color")
    private String eyeColor;
    @Expose
    private String gender;
    @Expose
    @SerializedName("hair_color")
    private String hairColor;
    @Expose
    private String height;
    @Expose
    private String mass;
    @Expose
    @SerializedName("skin_color")
    private String skinColor;
    @Expose
    private String homeworld;
    @Expose
    private String[] films;
    @Expose
    private String[] species;
    @Expose
    private String[] starships;
    @Expose
    private String[] vehicles;
    @Expose
    private String url;
    @Expose
    private String created;
    @Expose
    private String edited;
    @Expose(deserialize = false)
    private List<Films> filmsArr;
    @Expose(deserialize = false)
    private List<Species> speciesArr;
    @Expose(deserialize = false)
    private List<Starships> starshipsArr;
    @Expose(deserialize = false)
    private List<Vehicles> vehiclesArr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public String[] getFilms() {
        return films;
    }

    public void setFilms(String[] films) {
        this.films = films;
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

    public List<Films> getFilmsArr() {
        return filmsArr;
    }

    public void setFilmsArr(List<Films> filmsArr) {
        this.filmsArr = filmsArr;
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

    @Override
    public String toString() {
        return "Información del Personaje:\n" +
                "  - Nombre: " + name + "\n" +
                "  - Color de pelo: " + hairColor + "\n" +
                "  - Género: " + gender + "\n" +
                "  - Altura: " + height + "\n" +
                "  - Origen: " + homeworld + "\n" +
                "  - Naves: " + starshipsArr.stream().map(Starships::getName).toList() + "\n" +
                "  - Vehículos: " + vehiclesArr.stream().map(Vehicles::getName).toList();
    }

}
