package listator;

import java.util.ArrayList;

public class Filme {
	
	private String nome;
	private Genero genero;

	public ArrayList<Ator> elenco = new ArrayList<>();
	
	public Filme(String nome, Genero genero) {
		this.nome = nome;
		this.genero = genero;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public Genero getGenero() {
		return this.genero;
	}
	
	public ArrayList<Ator> getElenco() {
		return this.elenco;
	}
	
	public void adicionaAoElenco(Ator ator) {
		this.elenco.add(ator);
	};
	
	public ArrayList<Ator> contemNoNome(String sequencia) {
		ArrayList<Ator> contem = new ArrayList<>();
		for(Ator a: this.elenco){
			if(a.getNome().contains(sequencia)){
				contem.add(a);
			}
		}
		return contem;
	}
	
	public String toString() {
		return this.getNome();
	}
}
