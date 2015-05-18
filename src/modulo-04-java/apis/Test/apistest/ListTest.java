package apistest;

import org.junit.*;
import java.util.*;

public class ListTest {

	@Test
	public void testAdd() throws Exception{
		//Arrange
		List<String> lista = new ArrayList<>();
		//Act
		lista.add("Um");
		lista.add("teste");
		lista.add("do");
		lista.add("add");
		//Assert
		List<String> esperado = new ArrayList<>();
		esperado.add("Um");
		esperado.add("teste");
		esperado.add("do");
		esperado.add("add");
		Assert.assertEquals(esperado, lista);
	}
	
	@Test
	public void testContains() throws Exception{
		//Arrange
		List<String> lista = new ArrayList<>();
		lista.add("Um");
		lista.add("teste");
		lista.add("do");
		lista.add("contains");
		//Act
		//Assert
		Assert.assertTrue(lista.contains("contains"));
	}
	
	@Test
	public void testGet() throws Exception{
		//Arrange
		List<String> lista = new ArrayList<>();
		lista.add("Um");
		lista.add("teste");
		lista.add("do");
		lista.add("get");
		//Act
		//Assert
		String esperado = "get";
		Assert.assertEquals(esperado, lista.get(3));
	}
	
	@Test
	public void testSize() throws Exception{
		//Arrange
		List<String> lista = new ArrayList<>();
		lista.add("Um");
		lista.add("teste");
		lista.add("do");
		lista.add("size");
		//Act
		//Assert
		int esperado = 4;
		Assert.assertEquals(esperado, lista.size());
	}
	
	@Test
	public void testIsEmpty() throws Exception{
		//Arrange
		List<String> lista = new ArrayList<>();
		lista.add("Um");
		lista.add("teste");
		lista.add("do");
		lista.add("isEmpty");
		//Act
		//Assert
		Assert.assertFalse(lista.isEmpty());
	}
	
	@Test
	public void testAddAll() throws Exception{
		//Arrange
		List<String> lista = new ArrayList<>();
		lista.add("Um");
		lista.add("teste");
		List<String> lista2 = new ArrayList<>();
		lista2.add("do");
		lista2.add("addAll");
		//Act
		lista.addAll(lista2);
		//Assert
		List<String> esperado = new ArrayList<>();
		esperado.add("Um");
		esperado.add("teste");
		esperado.add("do");
		esperado.add("addAll");
		Assert.assertEquals(esperado, lista);
	}
	
	@Test
	public void testSet() throws Exception{
		//Arrange
		List<String> lista = new ArrayList<>();
		lista.add("Um");
		lista.add("teste");
		lista.add("do");
		lista.add("isEmpty");
		//Act
		lista.set(3, "set");
		//Assert
		List<String> esperado = new ArrayList<>();
		esperado.add("Um");
		esperado.add("teste");
		esperado.add("do");
		esperado.add("set");
		Assert.assertEquals(esperado, lista);
	}
	
	@Test
	public void testSubList() throws Exception{
		//Arrange
		List<String> lista = new ArrayList<>();
		lista.add("Um");
		lista.add("teste");
		lista.add("do");
		lista.add("subList");
		//Act
		List<String> lista2 = lista.subList(2, 4);
		//Assert
		List<String> esperado = new ArrayList<>();
		esperado.add("do");
		esperado.add("subList");
		Assert.assertEquals(esperado, lista2);
	}
	
	@Test
	public void testIndexOf() throws Exception{
		//Arrange
		List<String> lista = new ArrayList<>();
		lista.add("Um");
		lista.add("teste");
		lista.add("do");
		lista.add("indexOf");
		//Act
		//Assert
		int esperado = 3;
		Assert.assertEquals(esperado, lista.indexOf("indexOf"));
	}
}
