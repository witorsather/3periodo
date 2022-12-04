public class Exe3Aluno {
    private int nDaMatricula;
    private String nome;
    private Double notaBimestre1;
    private Double notaBimestre2;

    public Exe3Aluno(int nDaMatricula, String nome, Double notaBimestre1, Double notaBimestre2) {
        this.nDaMatricula = nDaMatricula;
        this.nome = nome;
        this.notaBimestre1 = notaBimestre1;
        this.notaBimestre2 = notaBimestre2;
    }

    public int getnDaMatricula() {
        return nDaMatricula;
    }

    public void setnDaMatricula(int nDaMatricula) {
        this.nDaMatricula = nDaMatricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getNotaBimestre1() {
        return notaBimestre1;
    }

    public void setNotaBimestre1(Double notaBimestre1) {
        this.notaBimestre1 = notaBimestre1;
    }

    public Double getNotaBimestre2() {
        return notaBimestre2;
    }

    public void setNotaBimestre2(Double notaBimestre2) {
        this.notaBimestre2 = notaBimestre2;
    }
}
