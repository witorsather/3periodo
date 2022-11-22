package org.example;

import java.util.Scanner;

//ContadorFrequencia.java
//Programa conta o numero de ocorrencias de cada palavra em uma frase

import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;


public class ContadorFrequencia {
    private Map< String , Integer> mapa;
    private Scanner leitura;

    public ContadorFrequencia()
    {
        mapa = new HashMap < String, Integer >(); //Cria o HashMap
        leitura = new Scanner( System.in ); //Faz a leitura da frase
        criarMapa(); // Cria Mapa baseado na entrada de usuario
        mostrarMapa();// Exibe conteudo do Mapa
    }

    // Cria Mapa baseado na entrada de usuario
    private void criarMapa()
    {
        System.out.println("Entre com a frase"); // Solicita a entrada da frase do usuario
        String input = leitura.nextLine();

        // Cria StringTokenizer para a frase de entrada
        StringTokenizer quebraFrase = new StringTokenizer(input);

        //Processamento de texto de entrada
        while (quebraFrase.hasMoreTokens())//Enquanto houver mais entradas
        {
            String palavra = quebraFrase.nextToken().toLowerCase(); // Obtem palavra

            // Se o mapa tiver a palavra
            if (mapa.containsKey( palavra )) // Palavras esta no mapa
            {
                int contador = mapa.get( palavra ); // Obtem contagem atual
                mapa.put( palavra, contador+1); // Incrementa a contagem
            }
            else
                mapa.put( palavra, 1 ); // Adiciona uma nova palavra com contagem de 1 ao mapa
        }
    }

    // Exibe conteudo do mapa
    private void mostrarMapa()
    {
        Set< String > keys = mapa.keySet(); // Obtem as classes

        // Classifica as classes
        TreeSet< String > orderedKeys = new TreeSet< String > ( keys );
        System.out.println ("Palavras Contidas na frase: \nPalavras\t\t Ocorrencias");

        // Gera a saida de cada chave no mapa
        for ( String key : orderedKeys )
            System.out.printf ("%-10s%10s\n", key, mapa.get( key ));

        System.out.printf ("\nQuantidade de palavras:%d\nFrase esta vazia %b\n", mapa.size(), mapa.isEmpty());
    }



}
