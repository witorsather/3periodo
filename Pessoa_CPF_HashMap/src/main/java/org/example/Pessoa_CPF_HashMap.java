package org.example;

import java.util.*;

public class Pessoa_CPF_HashMap {

    private Map< String , Integer> mapa;

    private Scanner leitura;

    public Pessoa_CPF_HashMap(){

        mapa = new HashMap< String, Integer >(); //Cria o HashMap

        leitura = new Scanner( System.in ); //Faz a leitura da frase

    }

}
