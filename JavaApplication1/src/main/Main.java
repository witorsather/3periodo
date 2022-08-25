package main;

import java.awt.BorderLayout;
import java.util.Random;
import persistence.DataBaseManipulate;
import sort.Sort;

public class Main {

    public static void main(String[] args) throws Exception {

        DataBaseManipulate teste = new DataBaseManipulate();
        Sort testeordecao = new Sort();

        String[] vet = teste.ObterDicEnglish();
        String[] vetMerge = vet.clone();

        testeordecao.mergeSort(vetMerge, 0, vetMerge.length - 1);

        Random rd = new Random();
        int[] posRandom = new int[5000];
        for (int i = 0; i < posRandom.length; i++) {
            posRandom[i] = rd.nextInt(vet.length + 1);
        }

        imprimeVetor(posRandom);

        long totalTime = 0L;
        for (int pos : posRandom) {
            long init = System.nanoTime();

            int positionFound = buscaSeq(vetMerge, vet[pos]);
            long fim = System.nanoTime();

            totalTime += (fim - init);

        }

        double media = (totalTime / new Double(posRandom.length));

        System.out.println("Tempo medio: " + media);

//        System.out.println("Vetor Ordenado: ");
//       imprimeVetor(vetMerge);
//       
//           System.out.println("Vetor Original: ");
//       imprimeVetor(vet);
    }

    public static int buscaSeq(String[] vet, String palavra) {

        for (int i = 0; i < vet.length; i++) {
            if (vet[i].equals(palavra)) {
                return i;
            }
        }
        return -1;
    }

    public static void imprimeVetor(int[] vet) {
        System.out.println("");
        for (int i = 0; i < vet.length; i++) {

            System.out.print(vet[i] + ", ");
            if (i % 10 == 0) {
                System.out.println("");
            }
        }

        System.out.println("\n");
    }

    public static void imprimeVetor(String[] vet) {
        System.out.println("");
        for (int i = 0; i < vet.length; i++) {

            System.out.print(vet[i] + ", ");
            if (i % 10 == 0) {
                System.out.println("");
            }
        }

        System.out.println("\n");
    }
}
