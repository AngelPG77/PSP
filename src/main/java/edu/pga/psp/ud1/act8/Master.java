package edu.pga.psp.ud1.act8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Master {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String classpath = System.getProperty("java.class.path");

        System.out.println("¿Cuántos numeros quieres introducir?");
        int cantidad = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < cantidad; i++) {
            System.out.println("Introduce un numero entero");
            sb.append(sc.nextLine().trim());
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());

        ProcessBuilder pb = new ProcessBuilder(
                "java", "-cp", classpath, "edu.pga.psp.ud1.act8.Subordinate", sb.toString()
        );

        pb.redirectErrorStream(true);

       try {
           Process process = pb.start();

           try(BufferedReader bf = new BufferedReader(new InputStreamReader(process.getInputStream()))){
               process.waitFor();
               System.out.println("Numero más alto" + bf.readLine());
           } catch (IOException ee){
               ee.printStackTrace();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }

       } catch (IOException e) {
           e.printStackTrace();
       }


    }

}
