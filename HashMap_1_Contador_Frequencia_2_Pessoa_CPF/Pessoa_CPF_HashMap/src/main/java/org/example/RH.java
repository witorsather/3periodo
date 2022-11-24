package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Scanner;

public class RH {
	
	static String opcao;
	
	static Scanner entrada = new Scanner(System.in);

    /**
     * @param args
     * @throws ParseException
     */
    /**
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {

    	Map<String, Pessoa> pessoaHm = new HashMap<>();
        
        String cpf;

        String nome;

        String dataDeNascimento;
        
        Date date = null;
        
        Double peso;
        
        opcoes();
        
        do {
			
        	switch (opcao) {
        	
        	case "a":
        		
        		String continua = "";
        		
        		while(!continua.equals("n")) {
        			
        			System.out.println("Digite o cpf da pessoa:");
        			
        			cpf = entrada.next();
        			
        			System.out.println("Digite o nome da pessoa:");
        			
        			nome = entrada.next();
        			
        			System.out.println("Digite a data de nascimento da pessoa:");
        			
        			dataDeNascimento = entrada.next();
        			
        			System.out.println("Digite o peso da pessoa:");
        			
        			peso = entrada.nextDouble();
        			
        			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        			date = formatter.parse(dataDeNascimento);
        			
        			Double cpfDouble = Double.parseDouble(cpf);
        			
        			pessoaHm.put(cpf, new Pessoa(cpf, nome, date, peso));
        			
        			System.out.println("Pessoa cadastrada!");
        			
        			System.out.println("Quer cadastrar outra pessoa? s/n");
        			
        			System.out.println();
        			
        			if (continua.equals("n")) {
        				
        				continua = "n";
        				
        			} 
        			
        			opcoes();
        			
        		}
        		
        		
        	case "b":
        			
        		for (Entry<String, Pessoa> entry : pessoaHm.entrySet()) {
        			
        		    System.out.println("Chave " + entry.getKey() + " : " + entry.getValue().toString());
        		    
        		}
        		
        		System.out.println();
        		
        		opcoes();
        		
        	case "c":
        		
        		String nomePessoaMaisIdosa = null;

        		String cpfMaisIdosa = null;
        		
        		String nomePessoaMaisNova = null;

        		String cpfPessoaMaisNova = null;
        		
        		Integer idadeMaior = 0;

        		Integer idadeMenor = 1000;
        		
        		for (Entry<String, Pessoa> entry : pessoaHm.entrySet()) {
        			
	                //Converting obtained Date object to LocalDate object
	                Instant instant = entry.getValue().getdataDeNascimento().toInstant();
	                
	                ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
	                
	                LocalDate givenDate = zone.toLocalDate();
	                
	                //Calculating the difference between given date to current date.
	                Period period = Period.between(givenDate, LocalDate.now());
	                
	                Integer idade = period.getYears();
	                
	                if (idade > idadeMaior) {
	                	
	                	nomePessoaMaisIdosa = entry.getValue().getNome();
	        			
	        			cpfMaisIdosa = entry.getValue().getCpf();
	        			
	        			idadeMaior = idade;
	        			
					}
	                
	                if (idade < idadeMenor){
						
						nomePessoaMaisNova = entry.getValue().getNome();
	        			
						cpfPessoaMaisNova = entry.getValue().getCpf();
						
						idadeMenor = idade;
					
					}
	                
        		}
        		
        		System.out.printf("Pessoa mais idosa --> Nome: " + nomePessoaMaisIdosa + ", CPF: " + cpfMaisIdosa + "\n");

        		System.out.printf("Pessoa mais nova --> Nome: " + nomePessoaMaisNova + ", CPF: " + cpfPessoaMaisNova + "\n");
        		
                System.out.println();
        		
        		opcoes();
        		
        	case "d":
        		
        		Double somaPeso = 0.0;
        		
        		int cont = 0;
        		
        		for (Entry<String, Pessoa> entry : pessoaHm.entrySet()) {
        			
        		    System.out.println("Nome: " + entry.getValue().getNome() + ", Peso: " + entry.getValue().getPeso());
        		    
        		    somaPeso += entry.getValue().getPeso();
        		    
        		    cont++;
        		    
        		}
  
        		Double media = somaPeso/cont;
        		
        		System.out.printf("A média de peso deles é: %.2f \n", media);
        		
        		System.out.println();
        		
        		opcoes();
        		
        	case "e":
        		
        		System.out.println();
        		
        		opcoes();
        		
        	case "f":
        		
        		System.out.println();
        		
        		opcoes();
        		
        	case "q":
        		
        		break;
        		
        	case "t":
        		
        		continua = "";
        		
        		while(!continua.equals("n")) {
        			
        			cpf = "70266559850";
        			nome = "João Paulo";
        			dataDeNascimento = "12/04/1987";
        			peso = 95.50;
        			
        			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        	          //Parsing the given String to Date object
        	          date = formatter.parse(dataDeNascimento);
        			
        			pessoaHm.put(cpf, new Pessoa(cpf, nome, date, peso));
        			
        			cpf = "80566559850";
        			nome = "Fernado Aparecido";
        			dataDeNascimento = "01/12/1960";
        			peso = 101.80;
        			
        	        date = formatter.parse(dataDeNascimento);
        			
        			pessoaHm.put(cpf, new Pessoa(cpf, nome, date, peso));
        			
        			cpf = "95066559850";
        			nome = "Maria Silva";
        			dataDeNascimento = "05/06/1995";
        			peso = 80.00;
        			
        	        date = formatter.parse(dataDeNascimento);
        			
        			pessoaHm.put(cpf, new Pessoa(cpf, nome, date, peso));
        			
        			System.out.println("Pessoa cadastrada!");

        			continua = "n";
        			
        			opcoes();
        			
        		}
        		
        		break;
        		
        	default:
        		
        		break;
        	}
        	
        	
		} while (!opcao.equals("q"));

    }
    
    public static void opcoes() {
    	System.out.println("Digite uma das opções");
        System.out.println("a. Cadastrar pessoas sem CPF repetidos;");
        System.out.println("b. Listar todas as pessoas identificadas pelo CPF;");
        System.out.println("c. Listar o nome e CPF da pessoa mais idosa e mais jovem.");
        System.out.println("d. Listar média do Peso da das pessoas;");
        System.out.println("e. Atualizar os dados de uma Pessoa pesquisando pelo CPF;");
        System.out.println("f. Remover os dados de uma Pessoa pesquisando pelo CPF;");
        
        opcao = entrada.next();
        
        System.out.println();
    
    }
    
}
