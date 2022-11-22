package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TimeZone;

public class Main {

    public static void main(String[] args) throws ParseException {

    	Map<Integer, Pessoa> pessoaHm = new HashMap<>();
    	
        Scanner entrada = new Scanner(System.in);
        
        String cpf = "1";

        String nome;

        String dataDeNascimento;
        
        Double peso;
        
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
            
            peso = entrada.nextDouble();
            
            SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");

            Date date = formatter.parse(dataDeNascimento);

            System.out.println(date);
            
            pessoaHm.put(1, new Pessoa(cpf, nome, date, peso));
            
        }

    }

}