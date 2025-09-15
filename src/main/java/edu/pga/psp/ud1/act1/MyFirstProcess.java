package edu.pga.psp.ud1.act1;

import java.io.IOException;

public class MyFirstProcess {
    public static void main(String[] args) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("explorer.exe");
            Process process = processBuilder.start();
            System.out.println("Proceso iniciado: " + process.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
}
}