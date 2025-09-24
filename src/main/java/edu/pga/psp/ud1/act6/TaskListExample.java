package edu.pga.psp.ud1.act6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskListExample {
    public static void main(String[] args) {
        try {

            Process process = new ProcessBuilder("cmd.exe", "/c", "tasklist").start();

            List<String> outputLines = getProcessOutputLines(process);

            for (String elemento : outputLines){
                System.out.println(elemento);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Recoger la informacion de salida del proceso y guardarla en una lista de String
     *
     * @param process
     * @return
     * @throws IOException
     */
    private static List<String> getProcessOutputLines(Process process) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿ Qué proceso deseas buscar ?");
        String procesoInput = sc.nextLine().toLowerCase().trim();

        List<String> output = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()))){
            String line;
            while ((line = br.readLine()) != null){
                if (line.contains(procesoInput)){
                    output.add(line);
                }
            }
        }
        return output;
    }
}
