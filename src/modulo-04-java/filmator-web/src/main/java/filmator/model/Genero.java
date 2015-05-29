package filmator.model;

public enum Genero {
	ACAO("Ação"),
	SUSPENSE("Suspense"),
	AVENTURA("Aventura"),
	COMEDIA("Comédia"),
	TERROR("Terror"),
	FICCAOCIENTIFICA("Ficção científica"),
	ANIMACAO("Animação"),
	DRAMA("Drama");
	
	private String descricao;
	
	private Genero(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao(){
		return this.descricao;
	}
}
