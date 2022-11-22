package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    	Map<Integer, String> pessoaHm = new HashMap<>();
    	
        Scanner entrada = new Scanner(System.in);
        
        String cpf = null;

        String nome;

        String dataDeNascimento;

        String peso;
        
        int opc;

        while(!cpf.equals("0")) {
        	
            System.out.println("Digite o cpf da pessoa:");
            
            cpf = entrada.next();
            
            if (cpf.equals("0")){
            
            	break;
            
            }
            
            System.out.println("Digite o nome da pessoa:");

            nome = entrada.next();
            
            System.out.println("Digite a data de nascimento da pessoa:");
            
            dataDeNascimento = entrada.next();
            
            System.out.println("Digite o peso da pessoa:");
            
            peso = entrada.next();
            
        }

    }

}