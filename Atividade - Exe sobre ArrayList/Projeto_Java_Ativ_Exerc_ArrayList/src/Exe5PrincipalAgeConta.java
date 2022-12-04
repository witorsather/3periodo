import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Exe5PrincipalAgeConta {
    public static void main(String[] args) {
        System.out.println("**** Menu Principal ****");
        System.out.println("[ 1 ] Incluir Contato");
        System.out.println("[ 2 ] Excluir Contato");
        System.out.println("[ 3 ] Listar Contatos");
        System.out.println("[ 4 ] Pesquisar Contatos");
        System.out.println("[ 0 ] Encerrar o Programa");
        Scanner entrada = new Scanner(System.in);
        String nome;
        String email;
        String telefone;

        //lista
        Exe5AgendaAgeConta contatos = new Exe5AgendaAgeConta();

        //****************************************teste input****************************************************************
        nome = "Paulo Ferreira";
        email = "pauloferreira@gmail.com";
        telefone = "62985688998";
        Exe5ContatoAgeConta contatoTeste = new Exe5ContatoAgeConta(nome, email, telefone);
        contatos.getContatos().add(contatoTeste);

        nome = "Maria Braga";
        email = "mariabraga@hotmail.com";
        telefone = "62999898585";
        Exe5ContatoAgeConta contatoTeste2 = new Exe5ContatoAgeConta(nome, email, telefone);
        contatos.getContatos().add(contatoTeste2);

        nome = "Ze";
        email = "ze@hotmail.com";
        telefone = "62985893585";
        Exe5ContatoAgeConta contatoTeste3 = new Exe5ContatoAgeConta(nome, email, telefone);
        contatos.getContatos().add(contatoTeste3);
        //****************************************teste input****************************************************************

        int opcao = entrada.nextInt();
        while (opcao != 0) {
            switch (opcao) {
                case 1:
                    System.out.println("Informe o nome do contato:");
                    nome = entrada.next();
                    System.out.println("Informe o email do contato:");
                    email = entrada.next();
                    System.out.println("Informe o telefone do contato:");
                    telefone = entrada.next();

                    Exe5ContatoAgeConta contato = new Exe5ContatoAgeConta(nome, email, telefone);
                    contatos.getContatos().add(contato);

                    listarContatos(contatos);
                    break;
                case 2:
//                    mostrar itens que podem ser excluídos
                    listarContatos(contatos);

                    System.out.println("Informe o nome do contato a ser excluído:");
                    String nomeExcluir = entrada.next();
                    for (int i = 0; i < contatos.getContatos().size(); i++) {
                        if (contatos.getContatos().get(i).getNome().equals(nomeExcluir)) {
                            contatos.getContatos().remove(i);
                        }
                    }

                    //após excluir lista os itens da agenda
                    listarContatos(contatos);
                    break;
                case 3:
//                    foreach
//                    System.out.println("Listando os itens da Agenda:");
//                    for(Exe5ContatoAgeConta contato4 : contatos.getContatos()){
//                        System.out.println(contato4 + " " + contato4.getNome());
//                        System.out.println(contato4.getEmail());
//                        System.out.println(contato4.getTelefone());
//                    }
                    listarContatos(contatos);
                    break;
                case 4:
                    System.out.println("Informe o nome do contato para pesquisar:");
                    String nomePesquisar = entrada.next();

                    for (int i = 0; i < contatos.getContatos().size(); i++) {
                        boolean res3 = Pattern.compile(Pattern.quote(nomePesquisar),Pattern.CASE_INSENSITIVE).matcher(contatos.getContatos().get(i).getNome()).find();
                        if (res3) {
                            System.out.print("Posição " + i + " - ");
                            System.out.print(contatos.getContatos().get(i).getNome() + " | ");
                            System.out.print(contatos.getContatos().get(i).getEmail() + " | ");
                            System.out.print(contatos.getContatos().get(i).getTelefone());
                            System.out.println();
                        }
                    }
                    break;
                case 0:
                    System.out.println("-*-*- Programa Encerrado -*-*-");
                    break;
            }
            System.out.println("**** Menu Principal ****");
            System.out.println("[ 1 ] Incluir Contato");
            System.out.println("[ 2 ] Excluir Contato");
            System.out.println("[ 3 ] Listar Contatos");
            System.out.println("[ 4 ] Pesquisar Contatos");
            System.out.println("[ 0 ] Encerrar o Programa");
            opcao = entrada.nextInt();
        }
        }
        public static void listarContatos(Exe5AgendaAgeConta contatos){
            System.out.println("Listando os itens da Agenda:");
            for (int i = 0; i < contatos.getContatos().size(); i++) {
                System.out.print("Posição " + i + " - ");
                System.out.print(contatos.getContatos().get(i).getNome() + " | ");
                System.out.print(contatos.getContatos().get(i).getEmail() + " | ");
                System.out.print(contatos.getContatos().get(i).getTelefone());
                System.out.println();
            }
        }
}
