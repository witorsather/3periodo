import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Exe3Principal {
    private static Object aluno;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Scanner entrada = new Scanner(System.in);

        int nDaMatricula = 0;
        String nome = "";
        Double notaBimestre1 = -1.0;
        Double notaBimestre2 = -1.0;
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("Controle da Situação de Alunos de Sistemas de Informação");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println();

        List<Exe3Aluno> listaAlunos = new ArrayList<Exe3Aluno>();

        while(nDaMatricula >= 0){
            notaBimestre1 = -1.0;
            notaBimestre2 = -1.0;
            System.out.println("Digite o Número da Matrícula:");
            nDaMatricula = entrada.nextInt();
            if(nDaMatricula < 0){
                break;
            }
            System.out.println();
            System.out.println("Digite o Nome:");
            nome = entrada.next();
            System.out.println();
            while(notaBimestre1 < 0 || notaBimestre1 > 10){
                System.out.println("Digite a nota do 1º Bimetre:");
                notaBimestre1 = entrada.nextDouble();
                if(notaBimestre1 < 0 || notaBimestre1 > 10){
                    System.out.println("Digite uma nota válida!");
                    System.out.println();
                }
            };

            System.out.println();
            while(notaBimestre2 < 0 || notaBimestre2 > 10){
                System.out.println("Digite a nota do 2º Bimetre:");
                notaBimestre2 = entrada.nextDouble();
                if(notaBimestre2 < 0 || notaBimestre2 > 10){
                    System.out.println("Digite uma nota válida!");
                    System.out.println();
                }
            };

            System.out.println("Resultado do ALuno");
            System.out.println();
            Double mediaNotas = 0.0;
            mediaNotas = (notaBimestre1 + notaBimestre2) / 2.0;
            System.out.println("O aluno " + nome + " obteve média: " + mediaNotas);
            System.out.println();

            if (mediaNotas <= 4){
                System.out.println("REPROVADO");
                System.out.println();

            } else if (mediaNotas > 4 && mediaNotas < 6) {
                System.out.println("EXAME");
                System.out.println();
            }
            else if (mediaNotas > 6) {
                System.out.println("APROVADO");
                System.out.println();
            }

            Exe3Aluno aluno = new Exe3Aluno(nDaMatricula, nome, notaBimestre1, notaBimestre2);
            listaAlunos.add(aluno);

            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println();
        }
        System.out.println("Resultado da Classe");
        System.out.println("--------------------------------------------------------------------------------------");

        System.out.println("O total de alunos: " + listaAlunos.size());
        System.out.println();
        Double mediaNotas = 0.0;
        Double somaNotasClasse = 0.0;
        int exame = 0;
        int reprovado = 0;
        int aprovado = 0;
        Double maiorMedia = 0.0;
        Double menorMedia = 10.0;
        Double provMaior = 0.0;
        Double provMenor = 0.0;
        String nomeMaiorMedia = "";
        String nomeMenorMedia = "";
        String nomeProvMaior = "";
        String nomeProvMenor = "";

        for (Exe3Aluno aluno : listaAlunos){
            somaNotasClasse += aluno.getNotaBimestre1() + aluno.getNotaBimestre2();
            // String teste = a.getNome();

            mediaNotas = (aluno.getNotaBimestre1()  + aluno.getNotaBimestre2()) / 2.0;

            if(mediaNotas > maiorMedia){
                maiorMedia = mediaNotas;
                provMaior = maiorMedia;
                nomeMaiorMedia = aluno.getNome();
                nomeProvMaior = nomeMaiorMedia;

            }
            if (mediaNotas < menorMedia) {
                menorMedia = mediaNotas;
                provMenor = menorMedia;
                nomeMenorMedia = aluno.getNome();
                nomeProvMenor = nomeMenorMedia;
            }

            if (mediaNotas <= 4){
                reprovado++;
            } else if (mediaNotas > 4 && mediaNotas < 6) {
                exame++;
            }
            else if (mediaNotas > 6) {
                aprovado++;
            }
        }
        System.out.println("Quantidade de alunos Aprovados foi " + aprovado + ", de Reprovados foi " + reprovado + " e de Exame foi " + exame + ".");
        System.out.println();
        Double mediaClasse = somaNotasClasse/2/listaAlunos.size();
        System.out.println("A Média da classe é: " + mediaClasse + ".");
        System.out.println("O aluno com a maior média foi o " + nomeMaiorMedia + " com média " + maiorMedia + " e o com menor média foi o " + nomeMenorMedia + " com média " + menorMedia + ".");
    }
}
