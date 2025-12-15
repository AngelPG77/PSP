package edu.pga.psp.practicas.practica4.practica1.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Starships {

    @Expose
    private String name;
    @Expose
    private String model;
    @Expose
    @SerializedName("starship_class")
    private String starshipClass;
    @Expose
    private String manufacturer;
    @Expose
    @SerializedName("cost_in_credits")
    private String costInCredits;
    @Expose
    private String length;
    @Expose
    private String crew;
    @Expose
    private String passengers;
    @Expose
    @SerializedName("max_atmosphering_speed")
    private String maxAtmospheringSpeed;
    @Expose
    @SerializedName("hyperdrive_rating")
    private String hyperdriveRating;
    @Expose
    @SerializedName("MGLT")
    private String mglt;
    @Expose
    @SerializedName("cargo_capacity")
    private String cargoCapacity;
    @Expose
    private String consumables;
    @Expose
    private String[] films;
    @Expose
    private String[] pilots;
    @Expose
    private String url;
    @Expose
    private String created;
    @Expose
    private String edited;
    @Expose(deserialize = false)
    private Films[] filmsArr;
    @Expose(deserialize = false)
    private People[] pilotsArr;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStarshipClass() {
        return starshipClass;
    }

    public void setStarshipClass(String starshipClass) {
        this.starshipClass = starshipClass;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCostInCredits() {
        return costInCredits;
    }

    public void setCostInCredits(String costInCredits) {
        this.costInCredits = costInCredits;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public String getPassengers() {
        return passengers;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    public String getMaxAtmospheringSpeed() {
        return maxAtmospheringSpeed;
    }

    public void setMaxAtmospheringSpeed(String maxAtmospheringSpeed) {
        this.maxAtmospheringSpeed = maxAtmospheringSpeed;
    }

    public String getHyperdriveRating() {
        return hyperdriveRating;
    }

    public void setHyperdriveRating(String hyperdriveRating) {
        this.hyperdriveRating = hyperdriveRating;
    }

    public String getMglt() {
        return mglt;
    }

    public void setMglt(String mglt) {
        this.mglt = mglt;
    }

    public String getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(String cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public String getConsumables() {
        return consumables;
    }

    public void setConsumables(String consumables) {
        this.consumables = consumables;
    }

    public String[] getFilms() {
        return films;
    }

    public void setFilms(String[] films) {
        this.films = films;
    }

    public String[] getPilots() {
        return pilots;
    }

    public void setPilots(String[] pilots) {
        this.pilots = pilots;
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

    public Films[] getFilmsArr() {
        return filmsArr;
    }

    public void setFilmsArr(Films[] filmsArr) {
        this.filmsArr = filmsArr;
    }

    public People[] getPilotsArr() {
        return pilotsArr;
    }

    public void setPilotsArr(People[] pilotsArr) {
        this.pilotsArr = pilotsArr;
    }


}
