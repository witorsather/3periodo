import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exe1Principal {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int id = 0;
        String nome;
        int idade;
        String telefone;
        Object cliente;
        int opc;

        List<Object> listaCliente = new ArrayList<Object>();

        while(id >= 0) {
            System.out.println("Digite o id do cliente:");
            id = entrada.nextInt();
            if (id <= 0){
                break;
            }
            System.out.println("Digite o nome do cliente:");
            nome = entrada.next();
            System.out.println("Digite a idade do cliente:");
            idade = entrada.nextInt();
            System.out.println("Digite o telefone do cliente:");
            telefone = entrada.next();
            cliente = new Exe1Cliente(id, nome, idade, telefone);
            listaCliente.add(cliente);
        }

        for (int i = 0; i < listaCliente.size(); i++){
            System.out.println("Imprimindo elemento " + i + " da lista");
            System.out.println(listaCliente.get(i));
        }

    }
}