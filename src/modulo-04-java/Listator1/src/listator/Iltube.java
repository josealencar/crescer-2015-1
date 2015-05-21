package listator;

import java.util.ArrayList;
import java.util.HashMap;

public class Iltube extends Canais{

	private int visualizacao;
	
	public ArrayList<Filme> acervo = new ArrayList<>();
	public HashMap<Genero, Integer> exibido = new HashMap<>();
	
	public Iltube() {
		
	}
	
	public void setVisualizacao(int visualizacao) {
		this.visualizacao = visualizacao;
	}
	
	public int getVisualizacao() {
		return visualizacao;
	}
	
	public void reproduzirFilme(Filme filme) {
		if(this.exibido.get(filme.getGenero())!=null){
			int contador = this.exibido.get(filme.getGenero());
			contador ++;
			this.exibido.replace(filme.getGenero(), contador);
		} else{
			this.exibido.put(filme.getGenero(), 1);
		}
	}
	
	public String geraRelatorio(){
		return super.geraRelatorio(this.exibido);
	}
}
