
public class DVD {

	public String titulo;
	
	public String nomeDiretor;
	
	public int anoLancamento;
	
	public String comentario;

	public DVD(String titulo, String nomeDiretor, int anoLancamento, String comentario) {
		super();
		this.titulo = titulo;
		this.nomeDiretor = nomeDiretor;
		this.anoLancamento = anoLancamento;
		this.comentario = comentario;
	}

	@Override
	public String toString() {
		return "DVD [titulo = " + titulo + " | nomeDiretor = " + nomeDiretor + " | anoLancamento = " + anoLancamento
				+ " | comentario = " + comentario + "]";
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNomeDiretor() {
		return nomeDiretor;
	}

	public void setNomeDiretor(String nomeDiretor) {
		this.nomeDiretor = nomeDiretor;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
}
