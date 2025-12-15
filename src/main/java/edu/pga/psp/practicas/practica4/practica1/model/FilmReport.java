package edu.pga.psp.practicas.practica4.practica1.model;

import java.util.Arrays;

public class FilmReport {

    private Films film;

    public FilmReport(Films film) {
        this.film = film;
    }

    public Films getFilm() {
        return film;
    }

    public void setFilm(Films film) {
        this.film = film;
    }

    //Metodos

    public void print(){
        System.out.println("\n=== INFORME DE LA PELÍCULA: " + film.getTitle() + " ===");
        System.out.println("Planetas(" + film.getPlanets().length + "): ");
        Arrays.stream(film.getPlanetsArr()).forEach( e -> System.out.println(e.toString()));
    }



}
