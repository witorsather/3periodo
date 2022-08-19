package main;

import persistence.DataBaseManipulate;

public class Main {

    public static void main(String[] args) throws Exception {
        DataBaseManipulate teste = new DataBaseManipulate();
        String[] vet = teste.ObterDicDutch();

        for (int i = 0; i < vet.length; i++) {

            System.out.println("" + vet[i]);
        }

    }
}
