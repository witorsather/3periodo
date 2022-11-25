package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	
	static String opcao;
	static Scanner entrada = new Scanner(System.in);
	static InputStreamReader r = new InputStreamReader(System.in); 
	static BufferedReader br = new BufferedReader(r);
	
	static Map<Integer, Municipio> municipioMap = new HashMap<Integer, Municipio>();

	static TreeMap<Municipio, Municipio> map2 = new TreeMap<>(new AccordingMarks());
	
	static Map<Integer, Estado> estadoMap = new HashMap<Integer, Estado>();
    
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
        preecherHashMapMunicipio();
        preecherHashMapEstado();
        
        opcoes();
        
		do {
			
        	switch (opcao) {
        	
	        	case "a":
	        		
	        		System.out.println("Segue lista de estados abaixo:");
	        		
	        		listaDeEstadosAgrupadosPorSigla();
	        		
	        		opcoes();
	        		
	        		System.out.println("");
	        		
	        		break;
	        		
	        		
	        	case "b":
	        		
	        		
//	        		TreeMap<Integer, Municipio> map = new TreeMap<Integer, Municipio>(municipioMap);
	        		
	   
	        		for (Entry<Municipio, Municipio> entry : map2.entrySet()) {
	        				
	        			System.out.println(entry.getValue().toString());
	        				
	        		}
	        		
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
			        map2.put(new Municipio(codUf, cod, nome), new Municipio(codUf, cod, nome));
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
	
	public static void listaDeEstadosAgrupadosPorSigla() {

		List<String> listaSiglaEstado = new ArrayList<String>();
		
		for (Entry<Integer, Estado> entry : estadoMap.entrySet()) {
			
			listaSiglaEstado.add(entry.getValue().sigla);
	    
		}
		
		Collections.sort(listaSiglaEstado);
		
		for (int i = 0; i < listaSiglaEstado.size(); i++){
            System.out.println(listaSiglaEstado.get(i));
        }
		
	}
	
    public static void opcoes() {
    	
    	System.out.println("Digite uma das opções");
    	
        System.out.println("a) Listar todos os Estados agrupados SIGLA.");
        
        System.out.println("b) Listar todos os municípios agrupados por Código do Estado (COD UF).");
        
        System.out.println("c) Listar municípios por SIGLA. O programa deve ler uma SIGLA e listar os municípios pertencentes aquele Estado.");
        
        System.out.println("d) Buscar Município por Código Municipal, apresentando todas as informações do Município e do Estado a que aquele Município pertence.");
        
        System.out.println("e) Retornar um ranking decrescente de Estados de acordo com a quantidade de municípios pertencentes a eles, agrupados por SIGLA.");
        
        opcao = entrada.next();
        
        System.out.println();
    
    }
	
}
