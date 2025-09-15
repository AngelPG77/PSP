package edu.pga.psp.ud1.act2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ProcessLifeCycle {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce una IP");
        String IP = teclado.nextLine();

        try {
            // NEW: construimos el proceso
            System.out.println("Estado: NUEVO (NEW)");
            ProcessBuilder pb = new ProcessBuilder("ping ", IP);
            // el comando hace N pings -> dura unos segundos

            // READY: proceso creado pero aún no iniciado
            System.out.println("Estado: LISTO (READY)");

            pb.redirectOutput(new File("ping_std_output.txt"));
            pb.redirectError(new File("ping_error_output.txt"));
            // RUNNING: arrancamos
            Process p = pb.start();

            System.out.println("Estado: EN EJECUCIÓN (RUNNING)");


            // Esperamos a que termine (el ping tarda unos segundos)
            int exitCode = p.waitFor();

            // FINISHED: terminó su trabajo
            System.out.println("Estado: FINALIZADO (TERMINATED), código de salida: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}