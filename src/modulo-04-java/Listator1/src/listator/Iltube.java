package listator;

import java.util.ArrayList;
import java.util.HashMap;

public class Iltube extends Canais{

	private int visualizacao;
	
	public static ArrayList<Filme> acervo = new ArrayList<>();
	public static HashMap<Genero, Integer> exibido = new HashMap<>();
	
	public Iltube() {
		
	}
	
	public void setVisualizacao(int visualizacao) {
		this.visualizacao = visualizacao;
	}
	
	public int getVisualizacao() {
		return visualizacao;
	}
	
	public void reproduzirFilme(Filme filme) {
		if(Iltube.exibido.get(filme.getGenero())!=null){
			int contador = Iltube.exibido.get(filme.getGenero());
			contador ++;
			Iltube.exibido.replace(filme.getGenero(), contador);
		} else{
			Iltube.exibido.put(filme.getGenero(), 1);
		}
	}
	
	public void geraRelatorio(){
		super.geraRelatorio(Iltube.exibido);
	}
}
