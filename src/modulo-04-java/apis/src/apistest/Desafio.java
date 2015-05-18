package apistest;

import java.util.ArrayList;
import java.util.List;

public class Desafio {
	public static void main(String[] args) {
		String frase = "CWI Software";
		List<Integer> resultado = indiceMaiusculas(frase);
	}

	public static List<Integer> indiceMaiusculas(String frase) {
		List<Integer> resultado = new ArrayList<>();
		for(int i=0; i< frase.length(); i++){
			Character letra = frase.charAt(i);
			if(Character.isUpperCase(letra)){
				System.out.println(i);
				resultado.add(i);
			}
		}
		return resultado;
	}
}
