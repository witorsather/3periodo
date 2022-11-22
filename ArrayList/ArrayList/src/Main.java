import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //criando array list
        List<String> nomes = new ArrayList<String>();
        //adicionando valor
        nomes.add("João");
        nomes.add("Maria");

        System.out.println(nomes);

        //remover objetos
        nomes.remove(1);
        System.out.println(nomes);

        //removei todos os elementos
        nomes.remove(0);
        System.out.println(nomes);

        //adicionou um elemento para a lista não dar vazia
        nomes.add("Wesley");
        if (nomes.isEmpty()) {
            System.out.println("A lista está vazia.");
        }
        System.out.println(nomes);

        if (nomes.contains("João")){
            System.out.println("O João está vazia.");
        }
        else {
            System.out.println("O João não está na lista.");
        }

        //get
        System.out.println(nomes.get(0));

        //set
        nomes.add("Ana");
        nomes.add("Matheus");
        System.out.println(nomes);
        System.out.println("Tamanho da lista: " + nomes.size());

        //index of
        System.out.println("Posição da Ana: " + nomes.indexOf("Ana"));

        //set substitui elementos
        nomes.set(nomes.indexOf("Ana"), "Carolina");
        System.out.println(nomes);

        //addAll cópia dos nomes
        List<String> copia = new ArrayList<String>();
        copia.addAll(nomes);
        System.out.println("Essa é a cópia " + copia);

        //percorrer a lista
        for (int i = 0; i < nomes.size(); i++){
            System.out.println("Imprimindo elementros da lista");
            System.out.println(nomes.get(i));
        }

        //percorrer a lista por foreach não usando índice mas o objeto
        System.out.println("Imprimindo por referência de Objectos foreach");
        for(String nome : nomes){
            System.out.println(nome);
        }


    }
}