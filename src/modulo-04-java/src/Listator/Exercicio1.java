package Listator;

import java.io.File;

public class Exercicio1 {

	public static void main(String[] args) {
		File f = new File(args[0]);
		for(String s: f.list()){
			System.out.println(s);
		}
	}
}
