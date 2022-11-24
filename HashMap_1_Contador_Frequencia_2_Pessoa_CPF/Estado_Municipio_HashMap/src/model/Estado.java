package model;

public class Estado {

	public String cod;
	public String nome;
	public String sigla;
	
	public Estado(String cod, String nome, String sigla) {
		super();
		this.cod = cod;
		this.nome = nome;
		this.sigla = sigla;
	}

	@Override
	public String toString() {
		return "Estado [cod=" + cod + ", nome=" + nome + ", sigla=" + sigla + "]";
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
}
