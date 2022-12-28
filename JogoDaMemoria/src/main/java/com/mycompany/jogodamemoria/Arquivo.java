/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jogodamemoria;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;  
import java.io.PrintWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 *
 * @author timoteo
 */
public class Arquivo {

    public static String Ler(String caminho) {

        Path lugar = Paths.get(caminho);
        try {
            //ler todo o rquivo
            byte[] texto = Files.readAllBytes(lugar);
            String leitura = new String(texto);
            System.out.println(leitura);
        } catch (IOException erro) {

        }
        return null;
    }

    public static boolean Escrever(String Caminho, String texto) {

        try {
            //para escrever sempre na proxima linha vazia 
            FileWriter Arq = new FileWriter(Caminho, true);
            PrintWriter gravarArq = new PrintWriter(Arq);
            //passando nickname escolhido para o arquivo
            gravarArq.println(texto);
            gravarArq.close();
            return true;

        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
}
