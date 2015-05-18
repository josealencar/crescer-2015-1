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
		Netflox.acervo.removeAll(Netflox.acervo);
		Netflox.exibido.clear();
		Iltube.acervo.removeAll(Iltube.acervo);
		Iltube.exibido.clear();
    }
	
	@After
    public void tearDown()
    {
		Filme.elenco.removeAll(Filme.elenco);
		Netflox.acervo.removeAll(Netflox.acervo);
		Netflox.exibido.clear();
		Iltube.acervo.removeAll(Iltube.acervo);
		Iltube.exibido.clear();
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
	public void addElenco() throws Exception{
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
	
	@Test
	public void addUmFilmeNoAcervoNetflox() throws Exception{
		//Arrange
		Filme umFilme = new Filme("Resident Evil", Genero.SUSPENSE);
		//Act
		Netflox.acervo.add(umFilme);
		//Assert
		ArrayList<Filme> esperado = new ArrayList<>();
		esperado.add(umFilme);
		
		Assert.assertEquals(esperado, Netflox.acervo);
	}
	
	@Test
	public void addDoisFilmeNoAcervoNetflox() throws Exception{
		//Arrange
		Filme umFilme = new Filme("Resident Evil", Genero.SUSPENSE);
		Filme doisFilmes = new Filme("Uma noite no museu", Genero.COMEDIA);
		//Act
		Netflox.acervo.add(umFilme);
		Netflox.acervo.add(doisFilmes);
		//Assert
		ArrayList<Filme> esperado = new ArrayList<>();
		esperado.add(umFilme);
		esperado.add(doisFilmes);
		
		Assert.assertEquals(esperado, Netflox.acervo);
	}
	
	@Test
	public void addTresFilmeNoAcervoNetflox() throws Exception{
		//Arrange
		Filme umFilme = new Filme("Resident Evil", Genero.SUSPENSE);
		Filme doisFilmes = new Filme("Uma noite no museu", Genero.COMEDIA);
		Filme tresFilmes = new Filme("Avengers", Genero.ACAO);
		//Act
		Netflox.acervo.add(umFilme);
		Netflox.acervo.add(doisFilmes);
		Netflox.acervo.add(tresFilmes);
		//Assert
		ArrayList<Filme> esperado = new ArrayList<>();
		esperado.add(umFilme);
		esperado.add(doisFilmes);
		esperado.add(tresFilmes);
		
		Assert.assertEquals(esperado, Netflox.acervo);
	}
	
	@Test
	public void addUmFilmeNoAcervoIltube() throws Exception{
		//Arrange
		Filme umFilme = new Filme("Resident Evil", Genero.SUSPENSE);
		//Act
		Iltube.acervo.add(umFilme);
		//Assert
		ArrayList<Filme> esperado = new ArrayList<>();
		esperado.add(umFilme);
		
		Assert.assertEquals(esperado, Iltube.acervo);
	}
	
	@Test
	public void addDoisFilmeNoAcervoIltube() throws Exception{
		//Arrange
		Filme umFilme = new Filme("Resident Evil", Genero.SUSPENSE);
		Filme doisFilmes = new Filme("Uma noite no museu", Genero.COMEDIA);
		//Act
		Iltube.acervo.add(umFilme);
		Iltube.acervo.add(doisFilmes);
		//Assert
		ArrayList<Filme> esperado = new ArrayList<>();
		esperado.add(umFilme);
		esperado.add(doisFilmes);
		
		Assert.assertEquals(esperado, Iltube.acervo);
	}
	
	@Test
	public void addTresFilmeNoAcervoIltube() throws Exception{
		//Arrange
		Filme umFilme = new Filme("Resident Evil", Genero.SUSPENSE);
		Filme doisFilmes = new Filme("Uma noite no museu", Genero.COMEDIA);
		Filme tresFilmes = new Filme("Avengers", Genero.ACAO);
		//Act
		Iltube.acervo.add(umFilme);
		Iltube.acervo.add(doisFilmes);
		Iltube.acervo.add(tresFilmes);
		//Assert
		ArrayList<Filme> esperado = new ArrayList<>();
		esperado.add(umFilme);
		esperado.add(doisFilmes);
		esperado.add(tresFilmes);
		
		Assert.assertEquals(esperado, Iltube.acervo);
	}
	
	@Test
	public void gerarRelatorioNetflox() throws Exception{
		//Arrange
		Filme umFilme = new Filme("Resident Evil", Genero.SUSPENSE);
		Filme doisFilmes = new Filme("Uma noite no museu", Genero.COMEDIA);
		Filme tresFilmes = new Filme("Avengers", Genero.ACAO);
		Filme quatroFilme = new Filme("Resident Evil 2", Genero.SUSPENSE);
		Netflox net = new Netflox();
		//Act
		net.reproduzirFilme(umFilme);
		//Assert
	}
}
