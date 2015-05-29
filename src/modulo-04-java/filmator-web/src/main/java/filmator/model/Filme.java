package filmator.model;

public class Filme {
	
	private int idfilme;
	private String nome;
	private Genero genero;
	private int ano;
	private String sinopse;
	private String imagem;
	
	public Filme() {
	}
	
	public Filme(String nome) {
		this.nome = nome;
	}
	
	public Filme(int idfilme, String nome, Genero genero, int ano, String sinopse,
			String imagem) {
		super();
		this.idfilme = idfilme;
		this.nome = nome;
		this.genero = genero;
		this.ano = ano;
		this.sinopse = sinopse;
		this.imagem = imagem;
	}

	public void setIdfilme(int idfilme) {
		this.idfilme = idfilme;
	}
	
	public int getIdfilme() {
		return idfilme;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Genero getGenero() {
		return genero;
	}
	
	public String getDescricao(){
		return this.genero.getDescricao();
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	@Override
	public String toString() {
		return this.getNome();
	}
}
