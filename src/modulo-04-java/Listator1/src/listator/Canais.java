package listator;

import java.util.HashMap;
import java.util.Map;

public class Canais {
	public String geraRelatorio(HashMap<Genero, Integer> exibido) {
		String relatorio = "Visualizações por Gênero:";
		for(Map.Entry<Genero, Integer> ex : exibido.entrySet()){
			relatorio += "\nGênero: "+ex.getKey() +" Visualizações: "+ ex.getValue();
		}
		return relatorio;
	}
}
