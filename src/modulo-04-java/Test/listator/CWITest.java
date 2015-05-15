package listator;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import listator.Ator;
import listator.Filme;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CWITest {
	
	@Before
    public void setUp()
    {
		Filme.elenco.removeAll(Filme.elenco);
    }
	
	@After
    public void tearDown()
    {
		Filme.elenco.removeAll(Filme.elenco);
    }
	
	@Test
	public void quandoExecutaToLowerCase() throws Exception {
		assertFalse(false);
	}
	
	@Test
	public void buscaTodosArquivos() throws Exception {
	    
	}
	
	@Test
	public void createActor() throws Exception{
		//Arrange
		String nome = "Will Smith";
		String sexo = "M";
		Ator ator;
		//Act
		ator = new Ator(nome,sexo);
		//Assert
		String esperado = nome;
		String retornado = ator.getNome();
		Assert.assertEquals(esperado, retornado);
	}
	
	@Test
	public void AddElenco() throws Exception{
		//Arrange
		Ator ator1 = new Ator("UmNome","M");
		Ator ator2 = new Ator("UmNome","F");
		Ator ator3 = new Ator("UmNome","M");
		//Act
		Filme.elenco.add(ator1);
		Filme.elenco.add(ator2);
		Filme.elenco.add(ator3);
		//Assert
		ArrayList<Ator> esperado = new ArrayList<>();
		esperado.add(ator1);
		esperado.add(ator2);
		esperado.add(ator3);
		ArrayList<Ator> retornado = Filme.getElenco();
		
		Assert.assertEquals(esperado, retornado);
	}
	
	@Test
	public void returnActorWithSequence() throws Exception{
		//Arrange
		Ator ator1 = new Ator("Albert","M");
		Ator ator2 = new Ator("Borat","F");
		Ator ator3 = new Ator("BoraBora","M");
		//Act
		Filme.elenco.add(ator1);
		Filme.elenco.add(ator2);
		Filme.elenco.add(ator3);
		//Assert
		ArrayList<Ator> esperado = new ArrayList<>();
		esperado.add(ator2);
		esperado.add(ator3);
		ArrayList<Ator> retornado = Filme.contemNoNome("Bo");
		
		Assert.assertEquals(esperado, retornado);
	}
}
