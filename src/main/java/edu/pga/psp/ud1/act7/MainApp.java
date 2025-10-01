package edu.pga.psp.ud1.act7;

import java.io.IOException;

public class MainApp {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Lanzando Worker en un proceso independiente…");

        // Obtenemos el classpath actual del proyecto
        String classpath = System.getProperty("java.class.path");

        // Comando para iniciar la segunda JVM
        ProcessBuilder pb = new ProcessBuilder(
                "java", "-cp", classpath, "edu.pga.psp.ud1.act7.Worker"
        );

        Process proceso = pb.start();
        int exitCode = proceso.waitFor();
        System.out.println("Proceso finalizado con código: " + exitCode);
    }
}
