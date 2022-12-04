import java.util.*;

public class Exe4Inteiros {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Digite a quantidade de números que deverão ser adicionados a um ArrayList de inteiros.");
        int qtd = entrada.nextInt();
        //int qtd = 1000;
        System.out.println();
        int min = 1;
        int max = 100;
        while (qtd > 100) {
            System.out.println("Como estou cumprindo o requisito de não enviar números repetidos para a lista, o programa não é executado com valores acima de 100, se não gera um loop infinito");
            System.out.println("Digite a quantidade de números que deverão ser adicionados a um ArrayList de inteiros.");
            qtd = entrada.nextInt();
        }
            List<Integer> listaInteiros = new ArrayList<Integer>();
            for (int i = 0; listaInteiros.size() < qtd; i++) {
                int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);

                if (existeNalista(listaInteiros, random_int)) {
                    while (!existeNalista(listaInteiros, random_int)) {
                        listaInteiros.add(random_int);
                        break;
                    }
                } else {
                    listaInteiros.add(random_int);
                }
            }
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("Segue o ArrayList na ordem original.");
            for (int i = 0; i < listaInteiros.size(); i++) {
                System.out.println("Posição " + i + ": " + listaInteiros.get(i));
            }
            System.out.println();

            System.out.println("Segue o ArrayList na ordem crescente.");
            Collections.sort(listaInteiros);
            for (int i = 0; i < listaInteiros.size(); i++) {
                System.out.println("Posição " + i + ": " + listaInteiros.get(i));
            }
            System.out.println();

            System.out.println("Segue o ArrayList na ordem decrescente.");
            Collections.sort(listaInteiros, Collections.reverseOrder());
            for (int i = 0; i < listaInteiros.size(); i++) {
                System.out.println("Posição " + i + ": " + listaInteiros.get(i));
            }
            System.out.println();

    }

    static boolean existeNalista(List<Integer> listaInteiros, int valorProcurado) {
        for (int i = 0; i < listaInteiros.size(); i++) {
            if (listaInteiros.get(i) == valorProcurado) {
                return true;
            }
        }
        return false;
    }
}
