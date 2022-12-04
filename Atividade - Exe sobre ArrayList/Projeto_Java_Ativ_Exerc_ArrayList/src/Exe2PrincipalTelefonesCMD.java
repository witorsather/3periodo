import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exe2PrincipalTelefonesCMD {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String opc;
        String telefone;
        telefone = "";
        List<Object> listaTelefones = new ArrayList<Object>();

        while(!telefone.equals("s")){
            System.out.println("Digite o telefone");

            System.out.println("Escolha uma opção:");
            System.out.println("(a) adicionar telefone");
            System.out.println("(r) remover telefone");
            System.out.println("(l) listar telefones");
            System.out.println("(s) Sair.");
            opc = entrada.next();

            switch (opc){
                case "a":
                    System.out.println("Digite o telefone que será adicionado");
                    telefone = entrada.next();
                    listaTelefones.add(telefone);
                    break;
                case "r":
                    System.out.println("Digite o telefone que será removido");
                    telefone = entrada.next();
                    listaTelefones.remove(listaTelefones.indexOf(telefone));
                    break;
                case "l":
                    for (int i = 0; i < listaTelefones.size(); i++){
                        System.out.println("Imprimindo telefone " + i + " da lista: ");
                        System.out.println(listaTelefones.get(i));
                        System.out.println();
                    }
                    break;
            }
        }
    }
}
