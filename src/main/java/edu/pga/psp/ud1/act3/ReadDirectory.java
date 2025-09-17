package edu.pga.psp.ud1.act3;

import java.io.*;
import java.util.*;

public class ReadDirectory {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe la ruta completa del directorio");
        String ruta = sc.nextLine();

        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "dir", ruta);


                Process p = pb.start();

        int exitCode = p.waitFor();
    }
}