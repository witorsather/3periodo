package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class Main {
	
	static String opcao;
	static Scanner entrada = new Scanner(System.in);
	static InputStreamReader r = new InputStreamReader(System.in); 
	static BufferedReader br = new BufferedReader(r);
	
	static Map<Integer, Municipio> municipioMap = new HashMap<Integer, Municipio>();

	static Map<Integer, Estado> estadoMap = new HashMap<Integer, Estado>();
    
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
        preecherHashMapMunicipio();
        
        preecherHashMapEstado();
        
        listaDeMunicipios();
        
        listaDeEstados();
        
        
		do {
			
        	switch (opcao) {
        	
	        	case "a":
	        		
	        		
	        		
	        		opcoes();
	        		
	        		System.out.println("");
	        		
	        		break;
	        		
	        		
	        	case "b":
	        		
	        		
	        		
	        		opcoes();
	        		
	        		System.out.println("");
	        		
	        		break;
	        		
	        		
	        	case "c":
	        		
	        		opcoes();
	        		
	        		System.out.println("");
	        		
	        		break;
	        		
	        		
	        	case "d":
	        			    	        
	        		opcoes();
	        		
	        		System.out.println("");
	        		
	        		break;
	        		
	        	case "q":
	    	        
	        		opcoes();
	        		
	        		System.out.println("");
	        		
	        		break;
	        		
	        		
	        	case "t":
        			
        			opcoes();
	        		
	        		System.out.println("");
	        		
	        		break;
	        		
	        	default:
	        		
	        		break;
        	}
        	
		} while (!opcao.equals("q"));
		
	}
	
	public static void preecherHashMapMunicipio() throws FileNotFoundException, IOException{
		
		String csvFilePathMunicipios = "src/files/municipios.csv";
		String codUf = null;
		String cod = "0";
		String nome = null;
		
		try (BufferedReader br = new BufferedReader(new FileReader(csvFilePathMunicipios))) {
		    
			String line;
		    
			int contLinha = 0;
			
			while ((line = br.readLine()) != null) {
				
				if (contLinha > 0) {
					
					String[] values = line.split(",");
			        codUf = values[0]; // 004
			        cod = values[1];
			        nome = values[2];
			        
			        Integer codInteger = Integer.parseInt(cod);
			        
			        municipioMap.put(codInteger, new Municipio(codUf, cod, nome));
				}
		        
		        contLinha++;
		        
		    }
			
			
			
		}
		
	}
	
	public static void preecherHashMapEstado() throws FileNotFoundException, IOException{
		
		String csvFilePathEstados = "src/files/estados.csv";
		String cod = "";
		String nome = "";
		String sigla = "";
		
		try (BufferedReader br = new BufferedReader(new FileReader(csvFilePathEstados))) {
		    
			String line;
		    
			int contLinha = 0;
			
			while ((line = br.readLine()) != null) {
				
				if (contLinha > 0) {
					
					String[] values = line.split(",");
					cod = values[0]; // 004
					nome = values[1];
					sigla = values[2];
			        
			        Integer codInteger = Integer.parseInt(cod);
			        
			        estadoMap.put(codInteger, new Estado(cod, nome, sigla));
				}
		        
		        contLinha++;
		        
		    }
			
		}
		
	}
	
	public static void listaDeMunicipios() {
		
		for (Entry<Integer, Municipio> entry : municipioMap.entrySet()) {
			
			System.out.println("Chave " + entry.getKey() + " : " + entry.getValue().toString());
	    
		}

	}
	
	public static void listaDeEstados() {
		
		for (Entry<Integer, Estado> entry : estadoMap.entrySet()) {
			
			System.out.println("Chave " + entry.getKey() + " : " + entry.getValue().toString());
	    
		}

	}
	
    public static void opcoes() {
    	
    	System.out.println("Digite uma das opções");
    	
        System.out.println("a. Deve permitir acrescentar um novo CD ou DVD às entradas já existentes;");
        
        System.out.println("b. Deve permitir a busca por um CD ou DVD pelo seu nome;");
        
        System.out.println("c. Deve permitir procurar CDs e DVDs pelo nome do artista ou pelo nome do Diretor;");
        
        System.out.println("d. Deve permitir listar (toString) toda a informação presente nos CDs e DVDs.");
        
        opcao = entrada.next();
        
        System.out.println();
    
    }
	
}
