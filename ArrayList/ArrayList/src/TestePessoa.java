import Pessoa;

public class TestePessoa {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int opc;
        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        pessoas.add(new Pessoa ("João", 20));
        System.out.println(pessoas);

        do {
            System.out.print("Informe o nome");
            String nome = entrada.nextLine();
            System.out.println("Deseja continuar? 1 - Sim, 2 - Não");
            opc = entrada.nextInt();
            entrada.nextLine();
        } while (opc == 1);

        System.out.println(pessoas);

        //procurar nome
        System.out.println("Informe o nome a ser procurado.");
        String nomeProcurado = entrada.nextLine();

        int posProcurado = -1;
        int contMaiorIdade = 0;
        // vc tem um objeto na mão pra fazer o que quiser
        for(Pessoa p : pessoas){
            if(p.getNome().equalsIgnoraCase(nomeProcurado)){
                posProcurado = pessoas.indexOf(p);
            }

            if(p.getIdade() >= 18){
                contMaiorIdade++;
            }
        }

        if (posProcurado == -1){
            System.out.println(nomeProcurado + "Não está na lista");
        } else {
            System.out.println(nomeProcurado + "Está na lista na posição: " + posProcurado);
        }

        System.out.println("Quantidade de Pessoas de maior de idade: " + contMaiorIdade);
    }
}
