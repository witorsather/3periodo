package model;

public class Municipio {
	
	public String codUf;
	public String cod;
	public String nome;
	
	public Municipio(String codUf, String cod, String nome) {
		super();
		this.codUf = codUf;
		this.cod = cod;
		this.nome = nome;
	}

	public String getCodUf() {
		return codUf;
	}

	public void setCodUf(String codUf) {
		this.codUf = codUf;
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

	@Override
	public String toString() {
		return "Municipio [codUf = " + codUf + " | cod = " + cod + "| nome = " + nome + "]";
	}
	
}
