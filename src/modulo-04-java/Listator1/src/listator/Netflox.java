package listator;

import java.util.ArrayList;
import java.util.HashMap;

public class Netflox extends Canais{

	private int visualizacao;
	
	public ArrayList<Filme> acervo = new ArrayList<>();
	public HashMap<Genero, Integer> exibido = new HashMap<>();
	
	public Netflox() {
		
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
	
	public int getVisualizacao() {
		return visualizacao;
	}
	
	public String geraRelatorio(){
		return super.geraRelatorio(this.exibido);
	}
}
