package edu.pga.psp.practicas.practica4.practica1;

import edu.pga.psp.practicas.practica4.practica1.model.Films;

public class Main {
    public static void main(String[] args) {
        SWCrawler crawler = new SWCrawler();
        crawler.crawlFilm(1).thenAccept(Films::print).join();
        System.out.println("crawler finalizado");
    }
}
