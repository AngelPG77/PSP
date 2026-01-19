package edu.pga.psp.practicas.practica4.practica1;

import edu.pga.psp.practicas.practica4.practica1.model.FilmReport;

public class Main {
    public static void main(String[] args) {
        SWCrawler crawler = new SWCrawler();
        try {
            crawler.crawlFilm(1).thenAccept(FilmReport::print).join();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("crawler finalizado");
    }
}
