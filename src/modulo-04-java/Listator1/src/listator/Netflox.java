package listator;

import java.util.ArrayList;
import java.util.HashMap;

public class Netflox extends Canais{

	private int visualizacao;
	
	public static ArrayList<Filme> acervo = new ArrayList<>();
	public static HashMap<Genero, Integer> exibido = new HashMap<>();
	
	public Netflox() {
		
	}
	
	public void reproduzirFilme(Filme filme) {
		if(Netflox.exibido.get(filme.getGenero())!=null){
			int contador = Netflox.exibido.get(filme.getGenero());
			contador ++;
			Netflox.exibido.replace(filme.getGenero(), contador);
		} else{
			Netflox.exibido.put(filme.getGenero(), 1);
		}
	}
	
	public int getVisualizacao() {
		return visualizacao;
	}
	
	public void geraRelatorio(){
		super.geraRelatorio(Netflox.exibido);
	}
}
