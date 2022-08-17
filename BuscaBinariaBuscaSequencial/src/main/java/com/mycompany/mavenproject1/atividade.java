package com.mycompany.mavenproject1;

import java.util.Random;

public class atividade {

    private static int[] selectionSort() {

        int vetorPrincipal[] = new int[100000];
        for (int i = 0; i < vetorPrincipal.length; i++) {

            vetorPrincipal[i] = geradorAleatorioNumero(1, 1000000);
        }
        int menorValor;
        int aux;
        for (int i = 0; i <= vetorPrincipal.length - 2; i++) {
            menorValor = i;
            for (int j = i; j <= vetorPrincipal.length - 1; j++) {

                if (vetorPrincipal[j] < vetorPrincipal[menorValor]) {
                    menorValor = j;
                }
            }
            aux = vetorPrincipal[menorValor];
            vetorPrincipal[menorValor] = vetorPrincipal[i];
            vetorPrincipal[i] = aux;

        }

        return vetorPrincipal;

    }

    public static void main(String[] args) {
        long timeInicio = System.nanoTime();
        int vetorPrincipal[]= selectionSort();

        //System.out.println("Busca sequencial: " + buscaSeq(vetorPrincipal, 5241));
        System.out.println("Busca Binaria: " + buscaBin(vetorPrincipal, 1, 0, vetorPrincipal.length));
        System.out.println("Busca Binaria: " + buscaBin(vetorPrincipal, 8544, 0, vetorPrincipal.length));
        System.out.println("Busca Binaria: " + buscaBin(vetorPrincipal, 6354, 0, vetorPrincipal.length));
        System.out.println("Busca Binaria: " + buscaBin(vetorPrincipal, 471, 0, vetorPrincipal.length));
        System.out.println("Busca Binaria: " + buscaBin(vetorPrincipal, 2568, 0, vetorPrincipal.length));
        System.out.println("Busca Binaria: " + buscaBin(vetorPrincipal, 4789, 0, vetorPrincipal.length));
        System.out.println("Busca Binaria: " + buscaBin(vetorPrincipal, 2014, 0, vetorPrincipal.length));
        System.out.println("Busca Binaria: " + buscaBin(vetorPrincipal, 6532, 0, vetorPrincipal.length));

        long timeFim = System.nanoTime();
        System.out.println(timeFim - timeInicio);

    }

    public static int geradorAleatorioNumero(int numeroInicial, int numeroFinal) {
        Random r = new Random();
        return r.nextInt(numeroFinal - numeroInicial + 1) + numeroInicial;
    }

    static boolean buscaSeq(int A[], int x) {
        for (int i = 0; i < A.length; i++) {
            if (x == A[i]) {
                return true;
            }

        }

        return false;
    }

    static boolean buscaBin(int A[], int x, int inicio, int fim) {
        int meio;
        if (inicio > fim) {
            return false;
        }
        meio = (inicio + fim) / 2;
        if (x == A[meio]) {
            return true;

        } else if (x < A[meio]) {
            return (buscaBin(A, x, inicio, meio - 1));

        } else {
            return (buscaBin(A, x, meio + 1, fim));
        }

    }

}
