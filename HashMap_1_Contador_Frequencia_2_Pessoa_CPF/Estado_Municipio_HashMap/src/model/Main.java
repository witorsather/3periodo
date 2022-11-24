package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {
	
	static Map<Integer, Municipio> municipioMap = new HashMap<Integer, Municipio>();

	static Map<Integer, Estado> estadoMap = new HashMap<Integer, Estado>();
    
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
        preecherHashMapMunicipio();
        
        preecherHashMapEstado();
        
        listaDeMunicipios();
        
        listaDeEstados();
            
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
	
}
