package edu.pga.psp.practicas.practica2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fusioner {

    public Fusioner() {
    }

    public void leerArchivosTemp(){
        Map<String, Integer> archivosFusionados = new HashMap<>();

        File folder = new File("src/main/resources/temp");

        if (folder.exists()){
            File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));

            try {
                for (File file : files){
                    try(BufferedReader br = new BufferedReader(new FileReader(file))){
                        String line;
                        while ((line = br.readLine()) != null){
                            line = line.trim();

                            String[] parts = line.split(",", 2);
                            if (parts.length != 2) continue;

                            String key = parts[0].trim();
                            try {
                                int value = Integer.parseInt(parts[1].trim());
                                archivosFusionados.put(key, archivosFusionados.getOrDefault(key, 0) + value);

                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                    file.delete();
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No existe la carpeta");
        }

        List<Map.Entry<String, Integer>> top5 = archivosFusionados.entrySet().stream()
                .sorted((a,b) -> b.getValue().compareTo(a.getValue()))
                .limit(5)
                .toList();

        System.out.println("Top 5 palabras más frecuentes:");
        int contador = 1;
        for (Map.Entry<String, Integer> entry : top5 ){
            System.out.println(contador + ". " + entry.getKey() + " : " + entry.getValue());
            contador++;
        }


    }
}
