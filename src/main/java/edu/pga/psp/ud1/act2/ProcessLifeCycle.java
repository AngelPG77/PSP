package edu.pga.psp.ud1.act2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class ProcessLifeCycle {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce una IP:");
        String IP = teclado.nextLine();

        System.out.println("Estado: NUEVO (NEW)");
        System.out.println("Estado: LISTO (READY)");


        Thread t1 = new Thread(() -> {
            try {
                ProcessBuilder pb = new ProcessBuilder("ping", IP, "-n", "6");
                pb.redirectOutput(new File("ping_std_output.txt"));
                pb.redirectError(new File("ping_error_output.txt"));

                Instant start = Instant.now();
                Process p = pb.start();
                System.out.println("Proceso 1 EN EJECUCIÓN (RUNNING)");

                if (!p.waitFor(10, java.util.concurrent.TimeUnit.SECONDS)) {
                    p.destroyForcibly();
                    System.out.println("Proceso 1 parado forzosamente.");
                }

                int exitCode = p.waitFor();
                Instant end = Instant.now();
                long duration = Duration.between(start, end).toMillis();

                System.out.println("Proceso 1 FINALIZADO (TERMINATED), código de salida: " + exitCode);
                System.out.println("Tiempo del proceso 1 en milisegundos: " + duration);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                ProcessBuilder pb2 = new ProcessBuilder("ping", "8.8.8.8", "-n", "6");
                pb2.redirectOutput(new File("ping_std_output2.txt"));
                pb2.redirectError(new File("ping_error_output2.txt"));

                Instant start = Instant.now();
                Process p2 = pb2.start();
                System.out.println("Proceso 2 EN EJECUCIÓN (RUNNING)");

                if (!p2.waitFor(10, java.util.concurrent.TimeUnit.SECONDS)) {
                    p2.destroyForcibly();
                    System.out.println("Proceso 2 parado forzosamente.");
                }

                int exitCode = p2.waitFor();
                Instant end = Instant.now();
                long duration = Duration.between(start, end).toMillis();

                System.out.println("Proceso 2 FINALIZADO (TERMINATED), código de salida: " + exitCode);
                System.out.println("Tiempo del proceso 2 en milisegundos: " + duration);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Ambos procesos han finalizado.");
    }
}
