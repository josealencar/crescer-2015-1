package listator;


public class Ator {
	private String nome;
	private String sexo;
	
	public Ator(String nome, String sexo) {
		this.nome = nome;
		this.sexo = sexo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public String toString() {
		return this.getNome();
	}
}
