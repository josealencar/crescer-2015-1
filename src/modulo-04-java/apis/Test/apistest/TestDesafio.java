package apistest;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

public class TestDesafio {

	@Test
	public void testIsUpperCase() throws Exception{
		//Arrange
		String teste = "Um Teste";
		List<Integer> resultado;
		//Act
		resultado = Desafio.indiceMaiusculas(teste);
		//Assert
		List<Integer> esperado = new ArrayList<>();
		esperado.add(0);
		esperado.add(3);
		Assert.assertEquals(esperado, resultado);
	}
}
