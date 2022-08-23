package main;

import persistence.DataBaseManipulate;
import sort.Sort;

public class Main {

    public static void main(String[] args) throws Exception {

        DataBaseManipulate teste = new DataBaseManipulate();
        Sort testeordecao = new Sort();

        String[] vet = teste.ObterDicEnglish();

        testeordecao.BubbleSort(vet);

        for (int i = 0; i < vet.length; i++) {

            System.out.println("" + vet[i]);
        }

    }
}
