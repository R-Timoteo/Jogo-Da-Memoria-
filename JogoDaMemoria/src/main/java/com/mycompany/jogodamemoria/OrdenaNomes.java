/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jogodamemoria;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author timoteo
 */
public class OrdenaNomes {
    
    public static void OrdemString() throws IOException {

        String str;
        //array nomes recebera cada linha do arquivo
        ArrayList<String> nomes = new ArrayList<String>();

        try (BufferedReader in = new BufferedReader(new FileReader("/home/timoteo/Documents/Ranking"))) {
            while ((str = in.readLine()) != null) {
                nomes.add(str);
            }
        }
        
        //ordeno nomes com collections sort
        Collections.sort(nomes);

        try (BufferedWriter out = new BufferedWriter(new FileWriter("/home/timoteo/Documents/Ranking"))) {
            for (int i = 0; i < nomes.size(); i++) {
                out.write(nomes.get(i));
                out.newLine();
            }
        }

        System.out.println("Sua posicao no Ranking");

    }

}
