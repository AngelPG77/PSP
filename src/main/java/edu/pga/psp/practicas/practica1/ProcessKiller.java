package edu.pga.psp.practicas.practica1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessKiller {

    public static void main(String[] args) {

        ProcessBuilder pbNotepad = new ProcessBuilder("cmd.exe", "/c", "tasklist", "/fi", "imagename eq Notepad.exe");
        ProcessBuilder pbCalculator = new ProcessBuilder("cmd.exe", "/c", "tasklist", "/fi", "imagename eq CalculatorApp.exe");


        try {

            Process searchNotepad = pbNotepad.start();
            Process searchCalculator = pbCalculator.start();

            if (isOutputEmpty(searchNotepad)) {
                System.out.println("No se encontraron instancias de Notepad.exe");
            } else {
                System.out.println("Proceso encontrado: Notepad.exe");
                Process killNotepad = new ProcessBuilder("cmd.exe", "/c", "taskkill","/f", "/im", "Notepad.exe").start();
                System.out.println("Proceso Notepad.exe ha sido terminado");
            }
            if (isOutputEmpty(searchCalculator)) {
                System.out.println("No se encontraron instancias de CalculatorApp.exe");
            } else {
                System.out.println("Proceso encontrado: CalculatorApp.exe");
                Process killCalculator = new ProcessBuilder("cmd.exe", "/c", "taskkill","/f", "/im", "CalculatorApp.exe").start();
                System.out.println("Proceso CalculatorApp.exe ha sido terminado");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static boolean isOutputEmpty(Process process) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("notepad.exe") || line.toLowerCase().contains("calculatorapp.exe") ) {
                    return false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

}
