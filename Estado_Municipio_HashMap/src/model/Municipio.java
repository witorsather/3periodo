package model;

public class Municipio {
	private Estado UF;
	private Integer codigo;
	private String nome;

	public Municipio(Estado UF, Integer codigo, String nome) {
		super();
		this.UF = UF;
		this.codigo = codigo;
		this.nome = nome;
	}

	public Estado getCodigoUF() {
		return UF;
	}

	public void setCodigoUF(Estado UF) {
		this.UF = UF;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Municipio [Estado="+UF.getSigla() + ", codigo=" + codigo + ", nome=" + nome + "]";
	}
	
}
