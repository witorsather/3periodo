
public class CD {
	
	public String titulo;
	
	public String nomeArtistaOuBanda;
	
	public int qntMusicas;
	
	public Double preco;
	
	public String comentario;
	
	public CD(String titulo, String nomeArtistaOuBanda, int qntMusicas, Double preco, String comentario) {
		super();
		this.titulo = titulo;
		this.nomeArtistaOuBanda = nomeArtistaOuBanda;
		this.qntMusicas = qntMusicas;
		this.preco = preco;
		this.comentario = comentario;
	}

	@Override
	public String toString() {
		return "CD [titulo = " + titulo + " | nomeArtistaOuBanda = " + nomeArtistaOuBanda + " | qntMusicas = " + qntMusicas
				+ " | preco = " + preco + " | comentario = " + comentario + "]";
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNomeArtistaOuBanda() {
		return nomeArtistaOuBanda;
	}

	public void setNomeArtistaOuBanda(String nomeArtistaOuBanda) {
		this.nomeArtistaOuBanda = nomeArtistaOuBanda;
	}

	public int getQntMusicas() {
		return qntMusicas;
	}

	public void setQntMusicas(int qntMusicas) {
		this.qntMusicas = qntMusicas;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

}
