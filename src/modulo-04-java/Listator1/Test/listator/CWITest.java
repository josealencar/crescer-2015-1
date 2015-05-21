package listator;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
		
    }
	
	@After
    public void tearDown()
    {
		
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
		Filme filme = new Filme("Resident Evil", Genero.SUSPENSE);
		//Act
		filme.elenco.add(ator1);
		filme.elenco.add(ator2);
		filme.elenco.add(ator3);
		//Assert
		ArrayList<Ator> esperado = new ArrayList<>();
		esperado.add(ator1);
		esperado.add(ator2);
		esperado.add(ator3);
		ArrayList<Ator> retornado = filme.getElenco();
		
		Assert.assertEquals(esperado, retornado);
	}
	
	@Test
	public void returnActorWithSequence() throws Exception{
		//Arrange
		Ator ator1 = new Ator("Albert","M");
		Ator ator2 = new Ator("Borat","F");
		Ator ator3 = new Ator("BoraBora","M");
		Filme filme = new Filme("Resident Evil", Genero.SUSPENSE);
		//Act
		filme.elenco.add(ator1);
		filme.elenco.add(ator2);
		filme.elenco.add(ator3);
		//Assert
		ArrayList<Ator> esperado = new ArrayList<>();
		esperado.add(ator2);
		esperado.add(ator3);
		ArrayList<Ator> retornado = filme.contemNoNome("Bo");
		
		Assert.assertEquals(esperado, retornado);
	}
	
	@Test
	public void addUmFilmeNoAcervoNetflox() throws Exception{
		//Arrange
		Filme umFilme = new Filme("Resident Evil", Genero.SUSPENSE);
		Netflox net = new Netflox();
		//Act
		net.acervo.add(umFilme);
		//Assert
		ArrayList<Filme> esperado = new ArrayList<>();
		esperado.add(umFilme);
		
		Assert.assertEquals(esperado, net.acervo);
	}
	
	@Test
	public void addDoisFilmeNoAcervoNetflox() throws Exception{
		//Arrange
		Filme umFilme = new Filme("Resident Evil", Genero.SUSPENSE);
		Filme doisFilmes = new Filme("Uma noite no museu", Genero.COMEDIA);
		Netflox net = new Netflox();
		//Act
		net.acervo.add(umFilme);
		net.acervo.add(doisFilmes);
		//Assert
		ArrayList<Filme> esperado = new ArrayList<>();
		esperado.add(umFilme);
		esperado.add(doisFilmes);
		
		Assert.assertEquals(esperado, net.acervo);
	}
	
	@Test
	public void addTresFilmeNoAcervoNetflox() throws Exception{
		//Arrange
		Filme umFilme = new Filme("Resident Evil", Genero.SUSPENSE);
		Filme doisFilmes = new Filme("Uma noite no museu", Genero.COMEDIA);
		Filme tresFilmes = new Filme("Avengers", Genero.ACAO);
		Netflox net = new Netflox();
		//Act
		net.acervo.add(umFilme);
		net.acervo.add(doisFilmes);
		net.acervo.add(tresFilmes);
		//Assert
		ArrayList<Filme> esperado = new ArrayList<>();
		esperado.add(umFilme);
		esperado.add(doisFilmes);
		esperado.add(tresFilmes);
		
		Assert.assertEquals(esperado, net.acervo);
	}
	
	@Test
	public void addUmFilmeNoAcervoIltube() throws Exception{
		//Arrange
		Filme umFilme = new Filme("Resident Evil", Genero.SUSPENSE);
		Iltube il = new Iltube();
		//Act
		il.acervo.add(umFilme);
		//Assert
		ArrayList<Filme> esperado = new ArrayList<>();
		esperado.add(umFilme);
		
		Assert.assertEquals(esperado, il.acervo);
	}
	
	@Test
	public void addDoisFilmeNoAcervoIltube() throws Exception{
		//Arrange
		Filme umFilme = new Filme("Resident Evil", Genero.SUSPENSE);
		Filme doisFilmes = new Filme("Uma noite no museu", Genero.COMEDIA);
		Iltube il = new Iltube();
		//Act
		il.acervo.add(umFilme);
		il.acervo.add(doisFilmes);
		//Assert
		ArrayList<Filme> esperado = new ArrayList<>();
		esperado.add(umFilme);
		esperado.add(doisFilmes);
		
		Assert.assertEquals(esperado, il.acervo);
	}
	
	@Test
	public void addTresFilmeNoAcervoIltube() throws Exception{
		//Arrange
		Filme umFilme = new Filme("Resident Evil", Genero.SUSPENSE);
		Filme doisFilmes = new Filme("Uma noite no museu", Genero.COMEDIA);
		Filme tresFilmes = new Filme("Avengers", Genero.ACAO);
		Iltube il = new Iltube();
		//Act
		il.acervo.add(umFilme);
		il.acervo.add(doisFilmes);
		il.acervo.add(tresFilmes);
		//Assert
		ArrayList<Filme> esperado = new ArrayList<>();
		esperado.add(umFilme);
		esperado.add(doisFilmes);
		esperado.add(tresFilmes);
		
		Assert.assertEquals(esperado, il.acervo);
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
		net.reproduzirFilme(doisFilmes);
		net.reproduzirFilme(tresFilmes);
		net.reproduzirFilme(umFilme);
		net.reproduzirFilme(quatroFilme);
		//Assert
		String esperado = "Visualizações por Gênero:";
		esperado += "\nGênero: COMEDIA Visualizações: 1";
		esperado += "\nGênero: ACAO Visualizações: 1";
		esperado += "\nGênero: SUSPENSE Visualizações: 3";
		Assert.assertEquals(esperado, net.geraRelatorio());
	}
	
	@Test
	public void gerarRelatorioIltube() throws Exception{
		//Arrange
		Filme umFilme = new Filme("Resident Evil", Genero.SUSPENSE);
		Filme doisFilmes = new Filme("Uma noite no museu", Genero.COMEDIA);
		Filme tresFilmes = new Filme("Avengers", Genero.ACAO);
		Filme quatroFilme = new Filme("Resident Evil 2", Genero.SUSPENSE);
		Iltube il = new Iltube();
		//Act
		il.reproduzirFilme(umFilme);
		il.reproduzirFilme(doisFilmes);
		il.reproduzirFilme(tresFilmes);
		il.reproduzirFilme(umFilme);
		il.reproduzirFilme(quatroFilme);
		il.reproduzirFilme(umFilme);
		il.reproduzirFilme(doisFilmes);
		il.reproduzirFilme(tresFilmes);
		il.reproduzirFilme(umFilme);
		il.reproduzirFilme(quatroFilme);
		il.reproduzirFilme(doisFilmes);
		il.reproduzirFilme(doisFilmes);
		//Assert
		String esperado = "Visualizações por Gênero:";
		esperado += "\nGênero: COMEDIA Visualizações: 4";
		esperado += "\nGênero: ACAO Visualizações: 2";
		esperado += "\nGênero: SUSPENSE Visualizações: 6";
		Assert.assertEquals(esperado, il.geraRelatorio());
	}
}
