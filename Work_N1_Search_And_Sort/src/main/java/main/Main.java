package main;

import persistence.DataBaseManipulate;
import sort.Sort;

public class Main {

    public static void main(String[] args) throws Exception {
        
        DataBaseManipulate teste = new DataBaseManipulate();
        
        String[] vet = teste.ObterDicBasque();

        Sort testeordecao = new Sort();
        
        //testeordecao.SelectionSort(vet);
        
        for (int i = 0; i < vet.length; i++) {

            System.out.println("" + vet[i]);
        }

    }
}
