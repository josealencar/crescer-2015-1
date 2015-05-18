package apistest;

import org.junit.*;
import org.junit.experimental.theories.suppliers.TestedOn;

public class StringTest {
	
	@Before
    public void setUp()
    {
    }
	
	@After
    public void tearDown()
    {
    }
	
	@Test
	public void testChatAt() throws Exception{
		//Arrange
		String nome = "Um teste de chatAt";
		//Act
		//Assert
		char a = 'A';
		Assert.assertEquals(a, nome.charAt(16));
	}
	
	@Test
	public void testStartsWith() throws Exception{
		//Arrange
		String nome = "Um teste de startWith";
		//Act
		//Assert
		Assert.assertTrue(nome.startsWith("U"));
		Assert.assertFalse(nome.startsWith("P"));
	}
	
	@Test
	public void testEndsWith() throws Exception{
		//Arrange
		String nome = "Um teste de endsWith";
		//Act
		//Assert
		Assert.assertTrue(nome.endsWith("h"));
		Assert.assertFalse(nome.endsWith("e"));
	}
	
	@Test
	public void testContains() throws Exception{
		//Arrange
		String nome = "Um teste de contains";
		//Act
		//Assert
		Assert.assertTrue(nome.contains("contains"));
	}
	
	@Test
	public void testCompareTo() throws Exception{
		//Arrange
		String nome = "Um teste do compareTo";
		//Act
		//Assert
		int esperado = 0;
		Assert.assertEquals(esperado, nome.compareTo("Um teste do compareTo"));
	}
	
	@Test
	public void testIndexOf() throws Exception{
		//Arrange
		String nome = "Um teste do indexOf";
		//Act
		//Assert
		String comparador = "m";
		int esperado = 1;
		Assert.assertEquals(esperado, nome.indexOf(comparador));
	}
	
	@Test
	public void testToLowerCase() throws Exception{
		//Arrange
		String nome = "UM TESTE DO TOLOWERCASE";
		//Act
		//Assert
		String esperado = "um teste do tolowercase";
		Assert.assertEquals(esperado, nome.toLowerCase());
	}
	
	@Test
	public void testToUpperCase() throws Exception{
		//Arrange
		String nome = "um teste do touppercase";
		//Act
		//Assert
		String esperado = "UM TESTE DO TOUPPERCASE";
		Assert.assertEquals(esperado, nome.toUpperCase());
	}
	
	@Test
	public void testLength() throws Exception{
		//Arrange
		String nome = "Um teste do length";
		//Act
		//Assert
		int esperado = 18;
		Assert.assertEquals(esperado, nome.length());
	}
	
	@Test
	public void testReplace() throws Exception{
		//Arrange
		String nome = "Um teste do replace";
		String trocar = "replace";
		String novo = "substituir";
		//Act
		//Assert
		String esperado = "Um teste do substituir";
		Assert.assertEquals(esperado, nome.replace(trocar, novo));
	}
	
	@Test
	public void testReplaceFirst() throws Exception{
		//Arrange
		String nome = "Um teste do replaceFirst";
		String replacement = "Ok";
		String regex = "(.*)replace(.*)";
		//Act
		//Assert
		String esperado = "Ok";
		Assert.assertEquals(esperado, nome.replaceFirst(regex, replacement));
	}
	
	@Test
	public void testSplit() throws Exception{
		//Arrange
		String nome = "Split";
		String[] nomeSplit;
		//Act
		nomeSplit = nome.split("");
		//Assert
		String[] esperado = {"S", "p", "l", "i", "t"};
		Assert.assertArrayEquals(esperado, nomeSplit);
	}
	
	@Test
	public void testTrim() throws Exception{
		//Arrange
		String nome = "                      Um teste do trim                 ";
		//Act
		//Assert
		String esperado = "Um teste do trim";
		Assert.assertEquals(esperado, nome.trim());
	}
	
	@Test
	public void testSubstring() throws Exception{
		//Arrange
		String nome = "Um teste do substring";
		//Act
		//Assert
		String esperado = "Um";
		Assert.assertEquals(esperado, nome.substring(0, 2));
	}
}
