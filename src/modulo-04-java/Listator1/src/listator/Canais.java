package listator;

import java.util.HashMap;
import java.util.Map;

public class Canais {
	public String geraRelatorio(HashMap<Genero, Integer> exibido) {
		String relatorio = "Visualiza��es por G�nero:";
		for(Map.Entry<Genero, Integer> ex : exibido.entrySet()){
			relatorio += "\nG�nero: "+ex.getKey() +" Visualiza��es: "+ ex.getValue();
		}
		return relatorio;
	}
}
