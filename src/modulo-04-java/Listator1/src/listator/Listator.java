package listator;

import java.io.File;

public class Listator {

	public static void main(String[] args) {
		File f = getDiretotio(args);
		
		imprime(f);
	}

	private static File getDiretotio(String[] args) {
		File f = new File(args[0]);
		return f;
	}

	private static void imprime(File f) {
		for(String s: f.list()){
			System.out.println(s);
		}
	}
}
