package listator;

import java.util.ArrayList;

public class Filme {
	
	private String nome;
	private Genero genero;

	public static ArrayList<Ator> elenco = new ArrayList<>();
	
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
	
	public static ArrayList<Ator> getElenco() {
		return elenco;
	}
	
	public void adicionaAoElenco(Ator ator) {
		Filme.elenco.add(ator);
	};
	
	public static ArrayList<Ator> contemNoNome(String sequencia) {
		ArrayList<Ator> contem = new ArrayList<>();
		for(Ator a: elenco){
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
