package edu.pga.psp.practicas.practica4.practica1.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Planets {

    @Expose
    private String name;
    @Expose
    private String diameter;
    @Expose
    @SerializedName("rotation_period")
    private String rotationPeriod;
    @Expose
    @SerializedName("orbital_period")
    private String orbitalPeriod;
    @Expose
    private String gravity;
    @Expose
    private String population;
    @Expose
    private String climate;
    @Expose
    private String terrain;
    @Expose
    @SerializedName("surface_water")
    private String surfaceWater;
    @Expose
    private String[] residents;
    @Expose
    private String[] films;
    @Expose
    private String url;
    @Expose
    private String created;
    @Expose
    private String edited;
    @Expose(deserialize = false)
    private List<People> residentsArr = new ArrayList<>() ;
    @Expose(deserialize = false)
    private List<Films> filmsArr = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public String getRotationPeriod() {
        return rotationPeriod;
    }

    public void setRotationPeriod(String rotationPeriod) {
        this.rotationPeriod = rotationPeriod;
    }

    public String getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public void setOrbitalPeriod(String orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public String getGravity() {
        return gravity;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public String getSurfaceWater() {
        return surfaceWater;
    }

    public void setSurfaceWater(String surfaceWater) {
        this.surfaceWater = surfaceWater;
    }

    public String[] getResidents() {
        return residents;
    }

    public void setResidents(String[] residents) {
        this.residents = residents;
    }

    public String[] getFilms() {
        return films;
    }

    public void setFilms(String[] films) {
        this.films = films;
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

    public List<People> getResidentsArr() {
        return residentsArr;
    }

    public void setResidentsArr(List<People> residentsArr) {
        this.residentsArr = residentsArr;
    }

    public List<Films> getFilmsArr() {
        return filmsArr;
    }

    public void setFilmsArr(List<Films> filmsArr) {
        this.filmsArr = filmsArr;
    }

    @Override
    public String toString() {
        return "Información del Planeta:\n" +
                "  - Nombre: " + name + "\n" +
                "  - Clima: " + climate + "\n" +
                "  - Terreno: " + terrain + "\n" +
                "  - Gravedad: " + gravity + "\n" +
                "  - Población: " + population + "\n" +
                "  - Diámetro: " + diameter;
    }
}
