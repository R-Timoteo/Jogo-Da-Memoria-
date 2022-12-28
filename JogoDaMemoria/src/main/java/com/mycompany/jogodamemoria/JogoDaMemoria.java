/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.jogodamemoria;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * 
 * @author timoteo
 */
public class JogoDaMemoria {
    
    public static void main(String[] Args) throws IOException {
                
        while (true) {
            System.out.println("---------------------------------------");
            System.out.println("Aperte -J- para jogar ou -S- para sair ");
            System.out.println("---------------------------------------");
            // menu do jogo
            String play = scanner.nextLine();
            if (play.equals("s")) {
                System.out.println("Saindo");
                break;
            } else if (play.equals("j")) {
                
                System.out.println( "## Escolha seu Nick com 3 Letras maiusculas ##");
                System.out.println("");
                
                // variavel inicias recebem o nick do jogador
                String iniciais= scanner.nextLine();
                System.out.println("");
                
                System.out.println(" Descubra o tabuleiro no menor numero "
                        + " de jogadas " +"\n"+ " Escolha uma posicao no tabuleiro"
                        + " digitando primeiro uma posicao de 1 - 4 na linha Horizontal" +"\n"
                        + " Depois uma coluna de 1 - 4 do na Vertcical do Tabuleiro");
                System.out.println();
                
                // variavel cartas recebe 8 pares de letras 
                embaralharCartas();
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        tabuleiro[i][j] = "_";
                    }
                }
                
                //metodo verificar vai atualizando "tabuleiro" com "cartas"
                printarTabuleiro();
                verificar(cartas);
                
                
                //duas variaveis recebem um local de para armazenar os dados dos jogadores nome e pontuacao
                String arq = "/home/timoteo/Documents/Ranking";
                String nome = "    " + Pontuacao + "         " + iniciais;

                if (Arquivo.Escrever(arq, nome)) {
                    System.out.println("Sua Pontuacao   " + Pontuacao);
                } else {
                    System.out.println("erro ao salvar nome ");
                }
                
                //metodo para ordenar o arquivo que recebe os dados dos jogadores                
                OrdenaNomes.OrdemString();
                
                //metodo para ler e mostrar a sua posicao no ranking
                Arquivo.Ler(arq);

                
                break;

            } else {
                System.out.println("Caracter invalido");
                continue;
            }
        }
    }
    // declaracao das vaiaveis globais //
    public static int Pontuacao = 1;
    public static String[][] tabuleiro = new String[4][4];
    public static String[][] cartas = new String[4][4];
    public static Scanner scanner = new Scanner(System.in);

    public static void printarTabuleiro() {
        
        // preencho a matrix(variavel global)tabuleiro, com barras e espaco e 
        // vou atualizando e mostrando posteriormente com os valores de cartas  //
        for (int i = 0; i < 4; i++) {
            System.out.print("| ");
            for (int j = 0; j < 4; j++) {
                System.out.print(tabuleiro[i][j]);
                System.out.print("| ");                                
            }
            System.out.println();
                        
        }

    }

    public static void embaralharCartas() {
        //instancio uma classe ramdom do tipo ramdom//
        Random random = new Random();
        ArrayList<String> letras = new ArrayList();

        letras.add("A");
        letras.add("B");
        letras.add("C");
        letras.add("D");
        letras.add("E");
        letras.add("F");
        letras.add("G");
        letras.add("H");
        letras.add("A");
        letras.add("B");
        letras.add("C");
        letras.add("D");
        letras.add("E");
        letras.add("F");
        letras.add("G");
        letras.add("H");

        int indice;
        // variavel indice pra armazenar os indices "ramdomicos" 
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //recebe as posicoes selecionadas do array letras
                indice = random.nextInt(letras.size());
                //tabuleiro auxiliar (cartas)recebe as Strings
                cartas[i][j] = letras.get(indice);
                //metodo remove posicoes ja selecionadas
                letras.remove(indice);

            }
        }

    }

    public static void verificar(String[][] cartas) {
        //chamo metodo gameover(ele verifica a existencia de alguma posicao que ainda possua possua "-", caso exista
        //ele continuara devolvendo boolean true 
        // caso nao retornara false e fim do metodo entao ele sempre estara retornando false ate acabar as posicoes 
        while (true) {
            if (!gameOver()) {
                System.out.println("Linha: 1-4");
                int linha1 = scanner.nextInt();
                System.out.println("Coluna: 1-)");
                int coluna1 = scanner.nextInt();
                
                //verifico se o objeto ja nao e diferente de - ou seja se ja nao foi atualizado com algum conteudo
                if (!tabuleiro[linha1 - 1][coluna1 - 1].equals("_")) {
                    System.out.println("ja digitou");
                    System.out.println();

                    printarTabuleiro();
                    //contador de jogadas inicializado
                    Pontuacao = Pontuacao +1;
                    continue;
                } else {
                    //variavel tabuleiro troca de valores com variavel cartas nas respectivas mesmas posicoes
                    //atualizando tabuleiros
                    tabuleiro[linha1 - 1][coluna1 - 1] = "" + cartas[linha1 - 1][coluna1 - 1] + "";
                    //atualizo tabuleiro
                    printarTabuleiro();
                    //contador de jogadas 
                    Pontuacao = Pontuacao +1;
                }

                System.out.println("Linha: 1-4");
                int linha2 = scanner.nextInt();
                System.out.println("Coluna: 1-4");
                int coluna2 = scanner.nextInt();
                
                //verifico se o objeto ja nao e diferente de - ou seja se ja nao foi atualizado com algum conteudo
                if (!tabuleiro[linha2 - 1][coluna2 - 1].equals("_")) {
                    System.out.println("ja digitou");
                    System.out.println();
                    tabuleiro[linha1 - 1][coluna1 - 1] = "_";
                    System.out.println();
                    //atualizo tabuleiro
                    printarTabuleiro();
                    //atualizo pontuacao
                    Pontuacao = Pontuacao +1;
                    continue;
                } else {
                    //atualizo o tabuleiro com a posicao digitada
                    tabuleiro[linha2 - 1][coluna2 - 1] = "" + cartas[linha2 - 1][coluna2 - 1] + "";
                    //se a posicao digitada tiver um conteudo igual ao da posicao ja digitada
                    if (tabuleiro[linha1 - 1][coluna1 - 1].equals(tabuleiro[linha2 - 1][coluna2 - 1])) {
                        //atualizo tabuleiro
                        printarTabuleiro();
                        //atualizo pontuacao se nao so mostro do novo as possicoes com "_"
                        Pontuacao = Pontuacao +1;
                        System.out.println("Acertou");
                        System.out.println();
                    } else {
                        printarTabuleiro();
                        Pontuacao = Pontuacao +1;
                        System.out.println("Errou");
                        System.out.println();
                        tabuleiro[linha1 - 1][coluna1 - 1] = "_";
                        tabuleiro[linha2 - 1][coluna2 - 1] = "_";
                        printarTabuleiro();
                        Pontuacao = Pontuacao +1;
                    }

                }
            } else {
                //
                System.out.println("Tabuleiro Completo");
                System.out.println();
                break;

            }

        }
    }
    //se na varredura de tabuleiro nao for encontrado "_" retornara false 
    public static boolean gameOver() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (tabuleiro[i][j].equals("_")) {
                    return false;
                }
            }
        }

        return true;

    }


}
