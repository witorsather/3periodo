package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class DataBaseManipulate {

    private String nameFile1 = "English_American_dic.txt";
    private String nameFile2 = "Portuguese_Brazilian_dic.txt";
    private String nameFile3 = "Dutch.txt";

    public String[] ObterDicPortugues() throws Exception {

        try (BufferedReader br = new BufferedReader(new FileReader(nameFile2))) {

            String vet = br.readLine();
            int tamanhoVetor = Integer.parseInt(vet);
            String[] vetor = new String[tamanhoVetor];
            String linha = "";

            while ((linha = br.readLine()) != null) {

                for (int i = 0; i < vetor.length; i++) {

                    vetor[i] = br.readLine();

                }

            }
            return vetor;

        }

    }

    public String[] ObterDicEnglish() throws Exception {

        try (BufferedReader br = new BufferedReader(new FileReader(nameFile1))) {

            String vet = br.readLine();
            int tamanhoVetor = Integer.parseInt(vet);
            String[] vetor = new String[tamanhoVetor];
            String linha = "";

            while ((linha = br.readLine()) != null) {

                for (int o = 0; o < vetor.length; o++) {

                    vetor[o] = br.readLine();

                }
            }
            return vetor;
        }

    }

    public String[] ObterDicDutch() throws Exception {

        try (BufferedReader br = new BufferedReader(new FileReader(nameFile3))) {

            String vet = br.readLine();
            int tamanhovetor = Integer.parseInt(vet);
            String[] vetor = new String[tamanhovetor];
            String linha = "";

            while ((linha = br.readLine()) != null) {

                for (int t = 0; t < 10; t++) {

                    vetor[t] = br.readLine();

                }

            }

            return vetor;
        }

    }

}
