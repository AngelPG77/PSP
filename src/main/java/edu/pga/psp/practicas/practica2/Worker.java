package edu.pga.psp.practicas.practica2;

import java.io.*;
import java.nio.file.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Worker {

    File archivo;
    int inicio;
    int fin;

    public Worker(File archivo, int inicio, int fin) {
        this.archivo = archivo;
        this.inicio = inicio;
        this.fin = fin;
    }

    public Path leerArchivo() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(this.archivo))) {
            List<String> lineas = br.lines()
                    .skip(this.inicio)
                    .limit(this.fin - this.inicio)
                    .collect(Collectors.toList());

            Map<String, Integer> frecuencia = new HashMap<>();

            for (String linea : lineas) {
                String[] palabras = linea.split("\\W+");
                for (String el : palabras) {
                    if (!el.isBlank()) {
                        el = el.toLowerCase();
                        frecuencia.put(el, frecuencia.getOrDefault(el, 0) + 1);
                    }
                }
            }


            Path resourcesDir = Paths.get("src/main/resources/temp");
            if (!Files.exists(resourcesDir)) {
                Files.createDirectories(resourcesDir);
            }


            Path tempFile = Files.createTempFile(resourcesDir, "bloque_", ".txt");
            try (BufferedWriter bw = Files.newBufferedWriter(tempFile)) {
                for (Map.Entry<String, Integer> el : frecuencia.entrySet()) {
                    bw.write(el.getKey() + "," + el.getValue());
                    bw.newLine();
                }
            }
            return tempFile;
        }
    }
}
