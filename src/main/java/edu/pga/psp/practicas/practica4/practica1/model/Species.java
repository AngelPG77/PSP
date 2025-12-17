package edu.pga.psp.practicas.practica4.practica1.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Species {

    @Expose
    private String name;
    @Expose
    private String classification;
    @Expose
    private String designation;
    @Expose
    @SerializedName("average_height")
    private String averageHeight;
    @Expose
    @SerializedName("average_lifespan")
    private String averageLifespan;
    @Expose
    @SerializedName("eye_colors")
    private String eyeColors;
    @Expose
    @SerializedName("hair_colors")
    private String hairColors;
    @Expose
    @SerializedName("skin_colors")
    private String skinColors;
    @Expose
    private String language;
    @Expose
    private String homeworld;
    @Expose
    private String[] people;
    @Expose
    private String[] films;
    @Expose
    private String url;
    @Expose
    private String created;
    @Expose
    private String edited;
    @Expose(deserialize = false)
    private List<People> peopleArr;
    @Expose(deserialize = false)
    private List<Films> filmsArr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getAverageHeight() {
        return averageHeight;
    }

    public void setAverageHeight(String averageHeight) {
        this.averageHeight = averageHeight;
    }

    public String getAverageLifespan() {
        return averageLifespan;
    }

    public void setAverageLifespan(String averageLifespan) {
        this.averageLifespan = averageLifespan;
    }

    public String getEyeColors() {
        return eyeColors;
    }

    public void setEyeColors(String eyeColors) {
        this.eyeColors = eyeColors;
    }

    public String getHairColors() {
        return hairColors;
    }

    public void setHairColors(String hairColors) {
        this.hairColors = hairColors;
    }

    public String getSkinColors() {
        return skinColors;
    }

    public void setSkinColors(String skinColors) {
        this.skinColors = skinColors;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public String[] getPeople() {
        return people;
    }

    public void setPeople(String[] people) {
        this.people = people;
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

    public List<People> getPeopleArr() {
        return peopleArr;
    }

    public void setPeopleArr(List<People> peopleArr) {
        this.peopleArr = peopleArr;
    }

    public List<Films> getFilmsArr() {
        return filmsArr;
    }

    public void setFilmsArr(List<Films> filmsArr) {
        this.filmsArr = filmsArr;
    }

    @Override
    public String toString() {
        return "Información de la Especie:\n" +
                "  - Nombre: " + name + "\n" +
                "  - Clasificación: " + classification + "\n" +
                "  - Color de pelo: " + hairColors + "\n" +
                "  - Origen: " + homeworld + "\n" +
                "  - Idioma: " + language;
    }

}
