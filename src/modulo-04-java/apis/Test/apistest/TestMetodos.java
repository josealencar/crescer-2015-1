package apistest;

import org.junit.*;
import org.junit.experimental.theories.suppliers.TestedOn;

public class TestMetodos {
	
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
}
