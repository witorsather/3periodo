package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
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
	
	static HashMap<String, Estado> estados = new HashMap<>();

	static HashMap<Integer, Municipio> municipios = new HashMap<>();
    
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		preecherHashMapEstado();
        preecherHashMapMunicipio();
        opcoes();
        
		do {
			
        	switch (opcao) {
        	
	        	case "a":
	        		
	        		System.out.println("Segue lista de estados abaixo:");
	        		
	        		listarEstados();
	        		
	        		opcoes();
	        		
	        		System.out.println("");
	        		
	        		break;
	        		
	        		
	        	case "b":
	        		
	        		System.err.println("Listando municipios por código UF: ");
	    			listarMunicipiosPorCodigoUF();
	        		
	        		opcoes();
	        		
	        		System.out.println("");
	        		
	        		break;
	        		
	        		
	        	case "c":
	        		
	        		System.err.println("Listando municipios por Sigla da UF: ");
	        		
	    			listarMunicipiosPorSigla();
	        		
	        		opcoes();
	        		
	        		System.out.println("");
	        		
	        		break;
	        		
	        		
	        	case "d":
	        		
	        		System.err.println("Listando municipios por código de municipio ");
	        		
	        		listarMunicipiosPorCodMunicipal();
	        			    	        
	        		opcoes();
	        		
	        		System.out.println("");
	        		
	        		break;
	        		
	        	case "e":
	        		
	        		System.err.println("Listando estados por quantidade de municipios de forma decrescente");
	    			agruparEstados();
	    	        
	        		opcoes();
	        		
	        		System.out.println("");
	        		
	        		break;
	        		
	        		
	        	case "t":
        			
	    			for (Map.Entry<Integer, Municipio> entry2 : municipios.entrySet()) {
//	    					System.out.println(entry2.getValue().getCodigoUF());
	    					System.out.println(entry2.getValue().toString());
	    			}
	        		
        			opcoes();
	        		
	        		System.out.println("");
	        		
	        		break;
	        		
	        	default:
	        		
	        		break;
        	}
        	
		} while (!opcao.equals("q"));
		
	}
	
	private static void agruparEstados() {
		HashMap<Estado, Integer> qtdMunicipios = new HashMap<>();
		for (Map.Entry<Integer, Municipio> entry2 : municipios.entrySet()) {// * calculando a quantidade de municipios
			Estado codigoUF = entry2.getValue().getCodigoUF();
			if (qtdMunicipios.containsKey(codigoUF)) {
				qtdMunicipios.replace(codigoUF, qtdMunicipios.get(codigoUF) + 1);
			}else {
				qtdMunicipios.put(codigoUF, 1);
			}
		}
		
		for (Map.Entry<Estado, Integer> entry3 : qtdMunicipios.entrySet()) {
			System.out.println(entry3.toString());
		}
		
//		contar a quantidade de estados e salvar o nome do estado como chave
		TreeMap<Integer, Estado> estadosOrdenados = new TreeMap<>();
		for (Map.Entry<Estado, Integer> entry2 : qtdMunicipios.entrySet()) {
			estadosOrdenados.put(entry2.getValue(), entry2.getKey());
		}
		
//		contar a quantidade de estados e salvar quantidade de municipios como chave
		for (Map.Entry<Integer, Estado> entry2 : estadosOrdenados.entrySet()) {
			for (Map.Entry<String, Estado> entry : estados.entrySet()) {
					System.out.println(entry.toString());
			}
		}
	}
	
	private static void listarMunicipiosPorCodMunicipal() {

		for (Map.Entry<String, Estado> entry : estados.entrySet()) {
			for (Map.Entry<Integer, Municipio> entry2 : municipios.entrySet())
				System.out.println(entry2.getValue().toString());
		}
	}
	
	private static void listarMunicipiosPorSigla() {
		ArrayList<String> siglas = new ArrayList<>();
		for (Map.Entry<String, Estado> entry : estados.entrySet()) {
			siglas.add(entry.getValue().getSigla());
		}
		Collections.sort(siglas);
		for (String i : siglas) {
			for (Map.Entry<Integer, Municipio> entry2 : municipios.entrySet())
				if (entry2.getValue().getCodigoUF().getSigla() == i) {
					System.out.println(entry2.getValue().toString());
				}
		}
	}
	
	public static void preecherHashMapMunicipio() throws FileNotFoundException, IOException{
		
		String csvFilePathMunicipios = "src/files/municipios.csv";
		
		try (BufferedReader br = new BufferedReader(new FileReader(csvFilePathMunicipios))) {
		    
			String line;
		    
			Integer contLinha = 0;
			
			while ((line = br.readLine()) != null) {
				
				if (contLinha > 0) {
					
					String[] values = line.split(",");
					Integer codUf = Integer.parseInt(values[0]);; // 004
					Integer codMunicipio = Integer.parseInt(values[1]);
			        String nome = values[2];
			        Municipio m = new Municipio(buscaEstadoPorCodigo(codUf), codMunicipio, nome);
					municipios.put(codMunicipio, m);
			        
				}
		        
		        contLinha++;
		        
		    }
			
		}
		
	}
	
	public static void preecherHashMapEstado() throws FileNotFoundException, IOException{
		
		String csvFilePathEstados = "src/files/estados.csv";
		
		try (BufferedReader br = new BufferedReader(new FileReader(csvFilePathEstados))) {
		    
			String line;
		    
			Integer contLinha = 0;
			
			while ((line = br.readLine()) != null) {
				
				if (contLinha > 0) {
					
					String[] values = line.split(",");
					Integer codigo = Integer.parseInt(values[0]);
					String nome = values[1];
					String sigla = values[2];
			        
					Estado e = new Estado(codigo, nome, sigla);
					estados.put(sigla, e);
				}
		        
		        contLinha++;
		        
		    }
			
		}
		
	}
	
	private static void listarEstados() {

		for (Map.Entry<String, Estado> entry : estados.entrySet()) {
			System.out.println(entry.getValue().toString());
		}
	}
	
	private static Estado buscaEstadoPorCodigo(Integer codigo) {
		for (Map.Entry<String, Estado> entry : estados.entrySet()) {
			Estado val = entry.getValue();
			
			if (val.getCodigo() == codigo) {
				return val;
			}
		}
		return null;
	}
	
	private static void listarMunicipiosPorCodigoUF() {

		ArrayList<Integer> codigosUF = new ArrayList<>();
		for (Map.Entry<String, Estado> entry : estados.entrySet()) {
			codigosUF.add(entry.getValue().getCodigo());
		}
		Collections.sort(codigosUF);
		for (Integer i : codigosUF) {
			for (Map.Entry<Integer, Municipio> entry2 : municipios.entrySet())

				System.out.println(entry2.getValue().toString());
//				if (entry2.getValue().getCodigoUF().getCodigo() == i) {
//					System.out.println(entry2.getValue().toString());
//				}
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
