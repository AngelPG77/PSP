package edu.pga.psp.practicas.practica2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Master {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Introduce la ruta del archivo a analizar");
        String url = sc.nextLine().trim();
        System.out.println("¿En cuantos procesos quiere usted dividir el trabajo?");
        int nProcesos = Integer.parseInt(sc.nextLine().trim());
        Fusioner fusioner = new Fusioner();

        List<Worker> workers = new ArrayList<>();
        int lineasBloque = dividirArchivo(nProcesos, contarLineas(new File(url)));
        int inicio = 0;
        int fin = 0;
        for (int i = 0; i < nProcesos; i++) {
            inicio = i * lineasBloque;
            fin = Math.min(inicio + lineasBloque, contarLineas(new File(url)));
            workers.add(new Worker(new File(url), inicio, fin));
        }

        for(Worker el: workers){
            try {
                el.leerArchivo();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        fusioner.leerArchivosTemp();

    }

    static int contarLineas(File file){
        int lineasTotales = 0;
        try(BufferedReader bf = new BufferedReader(new FileReader(file))){
            lineasTotales = (int)bf.lines().count();
        } catch (IOException e){
            e.printStackTrace();
        }
        return lineasTotales;
    }

    static int dividirArchivo(int nProcesos, int lineasTotales){

        int lineasBloque;
        if (lineasTotales%nProcesos != 0){
            lineasBloque = (lineasTotales/nProcesos) + 1;
        } else {
            lineasBloque = lineasTotales/nProcesos;
        }
        return lineasBloque;
    }

}
