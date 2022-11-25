import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Locadora {
	
	static String opcao;
	static Scanner entrada = new Scanner(System.in);
	static InputStreamReader r = new InputStreamReader(System.in); 
	static BufferedReader br = new BufferedReader(r);
	
	public static void main(String[] args) throws IOException {

		Map<Integer, CD> cdHasMap = new HashMap<>();

		Map<Integer, DVD> dvdHasMap = new HashMap<>();
		
		opcoes();
		
		Integer chaveCd = 0;
		Integer chaveDvd = 0;
		String titulo;
		String nomeArtistaOuBanda;
		int qntMusicas;
		Double preco;
		String comentario;
		String tituloDvd;
		String nomeDiretorDvd;
		int anoLancamentoDvd;
		String comentarioDvd;
		
		do {
					
        	switch (opcao) {
        	
	        	case "a":
	        		
	        		System.out.println("Adicionar novo CD ou DVD?");
	        		
	        		String respostaCdDvd = entrada.next();
	        		
	        		if(respostaCdDvd.toLowerCase().equals("cd")) {
	        			
	        			System.out.println("Informe o titulo:");
	        			
	        			titulo = entrada.nextLine();
	        			
	        			System.out.println("Informe o nomeArtistaOuBanda:");
	        			
	        			nomeArtistaOuBanda = entrada.nextLine();
	        			
	        			System.out.println("Informe o qntMusicas:");
	        			
	        			qntMusicas = Integer.parseInt(entrada.next());
	        			
	        			System.out.println("Informe o preco:");
	        			
	        			preco = Double.parseDouble(entrada.next());
	        			
	        			System.out.println("Informe o comentario:");
	        			
	        			comentario = entrada.nextLine();
	        			
	        			cdHasMap.put(chaveCd += 1, new CD(titulo, nomeArtistaOuBanda, qntMusicas, preco, comentario));
	        			
	        		} else if (respostaCdDvd.toLowerCase().equals("dvd")) {
	        			
	        			System.out.println("Informe o titulo:");
	        			
	        			tituloDvd = entrada.nextLine();
	        			
	        			System.out.println("Informe o nomeDiretorDvd:");
	        			
	        			nomeDiretorDvd = entrada.nextLine();
	        			
	        			System.out.println("Informe o anoLancamentoDvd:");
	        			
	        			anoLancamentoDvd = Integer.parseInt(entrada.next());
	        			
	        			System.out.println("Informe o comentario:");
	        			
	        			comentarioDvd = entrada.nextLine();
	        			
	        			dvdHasMap.put(chaveDvd += 1, new DVD(tituloDvd, nomeDiretorDvd, anoLancamentoDvd, comentarioDvd));
	        			
	        		};
	        		
	        		opcoes();
	        		
	        		System.out.println("");
	        		
	        		break;
	        		
	        		
	        	case "b":
	        		
	        		System.out.println("Buscar o titulo do CD ou DVD?");
	        		
	        		String respostaBuscaCdDvd = entrada.next();
	        		
	        		if(respostaBuscaCdDvd.toLowerCase().equals("cd")) {
	        			
	        			System.out.println("Informe o titulo do cd:");
	        			
	        			titulo = br.readLine();
	        			
	        			for (Entry<Integer, CD> entry : cdHasMap.entrySet()) {
		        			
	        				if (entry.getValue().getTitulo().equals(titulo)) {
								
	        					System.out.println("Chave " + entry.getKey() + " : " + entry.getValue().toString());
	        					
							}
		        		    
		        		}
	        			
	        			
	        		} else if (respostaBuscaCdDvd.toLowerCase().equals("dvd")) {
	        			
	        			System.out.println("Informe o titulo do dvd:");
	        			
	        			tituloDvd = br.readLine();
	        			
	        			for (Entry<Integer, DVD> entry : dvdHasMap.entrySet()) {

	        				if (entry.getValue().getTitulo().equals(tituloDvd)) {
								
	        					System.out.println("Chave " + entry.getKey() + " : " + entry.getValue().toString());
	        					
							}
	        				
	        			}

	        		}
	        		
	        		System.out.println("");
	        		
	        		opcoes();
	        		
	        		System.out.println("");
	        		
	        		break;
	        		
	        		
	        	case "c":
	        		System.out.println("Buscar o nome do artista do CD (digite cd) ou o nome do diretor do DVD (digite dvd)?");
	        		
	        		String buscaCdDvdResposta = entrada.next();
	        		
	        		if(buscaCdDvdResposta.toLowerCase().equals("cd")) {
	        			
	        			System.out.println("Informe o nome do artista do cd:");
	        			
	        			titulo = br.readLine();
	        			
	        			for (Entry<Integer, CD> entry : cdHasMap.entrySet()) {
		        			
	        				if (entry.getValue().getNomeArtistaOuBanda().equals(titulo)) {
								
	        					System.out.println("Chave " + entry.getKey() + " : " + entry.getValue().toString());
	        					
							}
		        		    
		        		}
	        			
	        			
	        		} else if (buscaCdDvdResposta.toLowerCase().equals("dvd")) {
	        			
	        			System.out.println("Informe o nome do diretor do dvd:");
	        			
	        			tituloDvd = br.readLine();
	        			
	        			for (Entry<Integer, DVD> entry : dvdHasMap.entrySet()) {

	        				if (entry.getValue().getNomeDiretor().equals(tituloDvd)) {
								
	        					System.out.println("Chave " + entry.getKey() + " : " + entry.getValue().toString());
	        					
							}
	        				
	        			}

	        		}
	        		
	        		System.out.println("");
	        		
	        		opcoes();
	        		
	        		System.out.println("");
	        		
	        		break;
	        		
	        		
	        	case "d":
	        		
	        		System.out.println("CDs");
	        		
	        		for (Entry<Integer, CD> entry : cdHasMap.entrySet()) {
	        			
	        		    System.out.println("Chave " + entry.getKey() + " : " + entry.getValue().toString());
	        		    
	        		}
	        		
	        		System.out.println("");
	        		
	        		for (Entry<Integer, DVD> entry : dvdHasMap.entrySet()) {
	        			
	        		    System.out.println("Chave " + entry.getKey() + " : " + entry.getValue().toString());
	        		    
	        		}
	        		
	        		System.out.println("");
	    	        
	        		opcoes();
	        		
	        		System.out.println("");
	        		
	        		break;
	        		
	        	case "q":
	    	        
	        		opcoes();
	        		
	        		System.out.println("");
	        		
	        		break;
	        		
	        		
	        	case "t":
	        		
	        		titulo = "Rain";
        			nomeArtistaOuBanda = "Guns and Roses";
        			qntMusicas = 20;
        			preco = 60.0;
        			comentario = "cd de uma banda de rock";
        			cdHasMap.put(chaveCd += 1, new CD(titulo, nomeArtistaOuBanda, qntMusicas, preco, comentario));
	        		
        			titulo = "Peoples";
        			nomeArtistaOuBanda = "Elton John";
        			qntMusicas = 35;
        			preco = 45.0;
        			comentario = "cd de uma banda pop";
        			cdHasMap.put(chaveCd += 1, new CD(titulo, nomeArtistaOuBanda, qntMusicas, preco, comentario));
        			
        			titulo = "Familia";
        			nomeArtistaOuBanda = "Roberto Carlos";
        			qntMusicas = 60;
        			preco = 30.0;
        			comentario = "cd de um cantor nacional";
        			cdHasMap.put(chaveCd += 1, new CD(titulo, nomeArtistaOuBanda, qntMusicas, preco, comentario));
        			
        			tituloDvd = "A volta dos que não foram";
        			nomeDiretorDvd = "James Gun";
        			anoLancamentoDvd = 2022;
        			comentarioDvd = "filme muito bom";
        			dvdHasMap.put(chaveDvd += 1, new DVD(tituloDvd, nomeDiretorDvd, anoLancamentoDvd, comentarioDvd));
        			
        			tituloDvd = "homem aranha";
        			nomeDiretorDvd = "kevin fight";
        			anoLancamentoDvd = 2020;
        			comentarioDvd = "filme mais ou menos";
        			dvdHasMap.put(chaveDvd += 1, new DVD(tituloDvd, nomeDiretorDvd, anoLancamentoDvd, comentarioDvd));
        			
        			tituloDvd = "A viagem de Maria";
        			nomeDiretorDvd = "Fabiano Ferreira";
        			anoLancamentoDvd = 2005;
        			comentarioDvd = "filme ótimo";
        			dvdHasMap.put(chaveDvd += 1, new DVD(tituloDvd, nomeDiretorDvd, anoLancamentoDvd, comentarioDvd));
        			
        			opcoes();
	        		
	        		System.out.println("");
	        		
	        		break;
	        		
	        	default:
	        		
	        		break;
        	}
        	
		} while (!opcao.equals("q"));
		
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
