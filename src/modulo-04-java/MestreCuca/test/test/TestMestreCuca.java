package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import mestreCuca.*;

import org.junit.Before;
import org.junit.Test;

public class TestMestreCuca {
	
	private final double DIFERENCA_TOLERADA = 0.005;

	@Before
	public void setUp(){
		
	}
	
	@Test
	public void testCriaInstrucao() throws Exception {
		//Arrange
		String descricao = "Bata na batedeira";
		Instrucao instrucao;
		//Act
		instrucao = new Instrucao(descricao);
		//Assert
		String esperado = descricao;
		assertEquals(esperado, instrucao.getDescricao());
	}
	
	@Test
	public void testCriaIngrediente() throws Exception{
		//Arrange
		String nomeIngrediente = "Cacau em Pó";
		double quantidade = 2, preco = 0.30;
		UnidadeMedida unidade = UnidadeMedida.COLHER_SOPA;
		Ingrediente novoIngrediente;
		//Act
		novoIngrediente = new Ingrediente(nomeIngrediente, quantidade, unidade, preco);
		//Assert
		String nomeEsperado = nomeIngrediente;
		double quantidadeEsperado = quantidade;
		double precoEsperado = preco;
		UnidadeMedida unidadeEsperado = unidade;
		assertEquals(nomeEsperado, novoIngrediente.getNome());
		assertEquals(quantidadeEsperado, novoIngrediente.getQuantidade(), DIFERENCA_TOLERADA);
		assertEquals(precoEsperado, novoIngrediente.getPreco(), 0.005);
		assertEquals(unidadeEsperado, novoIngrediente.getUnidade());
		assertEquals(nomeEsperado, novoIngrediente.toString());
	}
	
	@Test
	public void testReceitaComTodosOsParametros() throws Exception{
		//Arrange
		Ingrediente um = new Ingrediente("Cacau em pó", 2, UnidadeMedida.COLHER_SOPA, 0.30);
		Ingrediente dois = new Ingrediente("Leite", 1, UnidadeMedida.XICARA, 0.25);
		Instrucao preparo = new Instrucao("Bater na batedeira");
		Receita umaReceita;
		String nome = "Achocolatado sem açúcar";
		List<Ingrediente> ingredientes = new ArrayList<>();
		ingredientes.add(um);
		ingredientes.add(dois);
		List<Instrucao> modoPreparo = new ArrayList<>();
		modoPreparo.add(preparo);
		//Act
		umaReceita = new Receita(nome, ingredientes, modoPreparo);
		//Assert
		String nomeEsperado = nome;
		List<Ingrediente> ingredientesEsperado = ingredientes;
		List<Instrucao> instrucaoEsperado = modoPreparo;
		assertEquals(nomeEsperado, umaReceita.getNome());
		assertEquals(ingredientesEsperado, umaReceita.getIngredientes());
		assertEquals(instrucaoEsperado, umaReceita.getInstrucao());
	}
	
	@Test
	public void testReceitaComNomeNoConstrutorEParametrosAdicionadosApos() throws Exception{
		//Arrange
		Ingrediente um = new Ingrediente("Cacau em pó", 2, UnidadeMedida.COLHER_SOPA, 0.30);
		Ingrediente dois = new Ingrediente("Leite", 1, UnidadeMedida.XICARA, 0.25);
		Instrucao preparo = new Instrucao("Bater na batedeira");
		Receita umaReceita;
		String nome = "Achocolatado sem açúcar";
		//Act
		umaReceita = new Receita(nome);
		umaReceita.adicionarIngrediente(um);
		umaReceita.adicionarIngrediente(dois);
		umaReceita.adicionarInstrucao(preparo);
		//Assert
		String nomeEsperado = nome;
		List<Ingrediente> ingredientesEsperado = new ArrayList<>();
		ingredientesEsperado.add(um);
		ingredientesEsperado.add(dois);
		List<Instrucao> instrucaoEsperado = new ArrayList<>();
		instrucaoEsperado.add(preparo);
		assertEquals(nomeEsperado, umaReceita.getNome());
		assertEquals(ingredientesEsperado, umaReceita.getIngredientes());
		assertEquals(instrucaoEsperado, umaReceita.getInstrucao());
	}
	
	@Test
	public void testCalculaValorTotalDaReceita() throws Exception{
		//Arrange
		Ingrediente um = new Ingrediente("Cacau em pó", 2, UnidadeMedida.COLHER_SOPA, 0.30);
		Ingrediente dois = new Ingrediente("Leite", 1, UnidadeMedida.XICARA, 0.25);
		Instrucao preparo = new Instrucao("Bater na batedeira");
		Receita umaReceita;
		String nome = "Achocolatado sem açúcar";
		List<Ingrediente> ingredientes = new ArrayList<>();
		ingredientes.add(um);
		ingredientes.add(dois);
		List<Instrucao> modoPreparo = new ArrayList<>();
		modoPreparo.add(preparo);
		umaReceita = new Receita(nome, ingredientes, modoPreparo);
		double valorRetornado;
		//Act
		valorRetornado = umaReceita.valorReceita();
		//Assert
		double valorEsperado = 0.55;
		assertEquals(valorEsperado, valorRetornado, DIFERENCA_TOLERADA);
	}
	
	@Test
	public void testAdicionaReceitaNoMeuLivroDeReceitas() throws Exception{
		//Arrange
		Ingrediente um = new Ingrediente("Cacau em pó", 2, UnidadeMedida.COLHER_SOPA, 0.30);
		Ingrediente dois = new Ingrediente("Leite", 1, UnidadeMedida.XICARA, 0.25);
		Instrucao preparo = new Instrucao("Bater na batedeira");
		Receita umaReceita;
		String nome = "Achocolatado sem açúcar";
		List<Ingrediente> ingredientes = new ArrayList<>();
		ingredientes.add(um);
		ingredientes.add(dois);
		List<Instrucao> modoPreparo = new ArrayList<>();
		modoPreparo.add(preparo);
		umaReceita = new Receita(nome, ingredientes, modoPreparo);
		MeuLivroDeReceitas book = new MeuLivroDeReceitas();
		//Act
		book.inserir(umaReceita);
		//Assert
		List<Receita> receitaEsperada = new ArrayList<>();
		receitaEsperada.add(umaReceita);
		assertEquals(receitaEsperada, book.getTodasReceitas());
	}
	
	@Test
	public void testAdicionaReceitaSemNome() throws Exception{
		//Arrange
		Ingrediente um = new Ingrediente("Cacau em pó", 2, UnidadeMedida.COLHER_SOPA, 0.30);
		Ingrediente dois = new Ingrediente("Leite", 1, UnidadeMedida.XICARA, 0.25);
		Instrucao preparo = new Instrucao("Bater na batedeira");
		Receita umaReceita;
		String nome = "";
		List<Ingrediente> ingredientes = new ArrayList<>();
		ingredientes.add(um);
		ingredientes.add(dois);
		List<Instrucao> modoPreparo = new ArrayList<>();
		modoPreparo.add(preparo);
		umaReceita = new Receita(nome, ingredientes, modoPreparo);
		MeuLivroDeReceitas book = new MeuLivroDeReceitas();
		//Act
		book.inserir(umaReceita);
		//Assert
		List<Receita> receitasEsperado = new ArrayList<>();
		assertEquals(receitasEsperado, book.getTodasReceitas());
	}
	
	@Test
	public void testAdicionaReceitaComNomeNull() throws Exception{
		//Arrange
		Ingrediente um = new Ingrediente("Cacau em pó", 2, UnidadeMedida.COLHER_SOPA, 0.30);
		Ingrediente dois = new Ingrediente("Leite", 1, UnidadeMedida.XICARA, 0.25);
		Instrucao preparo = new Instrucao("Bater na batedeira");
		Receita umaReceita;
		String nome = null;
		List<Ingrediente> ingredientes = new ArrayList<>();
		ingredientes.add(um);
		ingredientes.add(dois);
		List<Instrucao> modoPreparo = new ArrayList<>();
		modoPreparo.add(preparo);
		umaReceita = new Receita(nome, ingredientes, modoPreparo);
		MeuLivroDeReceitas book = new MeuLivroDeReceitas();
		//Act
		book.inserir(umaReceita);
		//Assert
		List<Receita> receitasEsperado = new ArrayList<>();
		assertEquals(receitasEsperado, book.getTodasReceitas());
	}
	
	@Test
	public void buscarReceitaPeloNome() throws Exception{
		//Arrange
		Ingrediente um = new Ingrediente("Cacau em pó", 2, UnidadeMedida.COLHER_SOPA, 0.30);
		Ingrediente dois = new Ingrediente("Leite", 1, UnidadeMedida.XICARA, 0.25);
		Instrucao preparo = new Instrucao("Bater na batedeira");
		Receita umaReceita;
		String nome = "Achocolatado sem açúcar";
		List<Ingrediente> ingredientes = new ArrayList<>();
		ingredientes.add(um);
		ingredientes.add(dois);
		List<Instrucao> modoPreparo = new ArrayList<>();
		modoPreparo.add(preparo);
		umaReceita = new Receita(nome, ingredientes, modoPreparo);
		MeuLivroDeReceitas book = new MeuLivroDeReceitas();
		book.inserir(umaReceita);
		Receita resultado;
		//Act
		resultado = book.buscaReceitaPeloNome(nome);
		//Assert
		Receita receitaEsperado = umaReceita;
		assertEquals(receitaEsperado, resultado);
	}
	
	@Test(expected = Exception.class)
	public void buscarReceitaQueNaoEstaNaListaPeloNome() throws Exception{
		//Arrange
		Ingrediente um = new Ingrediente("Cacau em pó", 2, UnidadeMedida.COLHER_SOPA, 0.30);
		Ingrediente dois = new Ingrediente("Leite", 1, UnidadeMedida.XICARA, 0.25);
		Instrucao preparo = new Instrucao("Bater na batedeira");
		Receita umaReceita;
		String nome = "Achocolatado sem açúcar";
		List<Ingrediente> ingredientes = new ArrayList<>();
		ingredientes.add(um);
		ingredientes.add(dois);
		List<Instrucao> modoPreparo = new ArrayList<>();
		modoPreparo.add(preparo);
		umaReceita = new Receita(nome, ingredientes, modoPreparo);
		MeuLivroDeReceitas book = new MeuLivroDeReceitas();
		book.inserir(umaReceita);
		Receita resultado;
		String nomeParaBusca = "Nome Qualquer";
		//Act
		resultado = book.buscaReceitaPeloNome(nomeParaBusca);
		//Assert
		Receita receitaEsperado = umaReceita;
		assertEquals(receitaEsperado, resultado);
	}
	
	@Test
	public void testExcluirReceitaPeloNome() throws Exception{
		//Arrange
		Ingrediente um = new Ingrediente("Cacau em pó", 2, UnidadeMedida.COLHER_SOPA, 0.30);
		Ingrediente dois = new Ingrediente("Leite", 1, UnidadeMedida.XICARA, 0.25);
		Instrucao preparo = new Instrucao("Bater na batedeira");
		Receita umaReceita;
		String nome = "Achocolatado sem açúcar";
		List<Ingrediente> ingredientes = new ArrayList<>();
		ingredientes.add(um);
		ingredientes.add(dois);
		List<Instrucao> modoPreparo = new ArrayList<>();
		modoPreparo.add(preparo);
		umaReceita = new Receita(nome, ingredientes, modoPreparo);
		MeuLivroDeReceitas book = new MeuLivroDeReceitas();
		book.inserir(umaReceita);
		//Act
		book.excluir(nome);
		//Assert
		List<Receita> receitasEsperado = new ArrayList<>();
		assertEquals(receitasEsperado, book.getTodasReceitas());
	}
	
	@Test
	public void testExcluirReceitaQueNaoEstaNaListaPeloNome() throws Exception{
		//Arrange
		Ingrediente um = new Ingrediente("Cacau em pó", 2, UnidadeMedida.COLHER_SOPA, 0.30);
		Ingrediente dois = new Ingrediente("Leite", 1, UnidadeMedida.XICARA, 0.25);
		Instrucao preparo = new Instrucao("Bater na batedeira");
		Receita umaReceita;
		String nome = "Achocolatado sem açúcar";
		List<Ingrediente> ingredientes = new ArrayList<>();
		ingredientes.add(um);
		ingredientes.add(dois);
		List<Instrucao> modoPreparo = new ArrayList<>();
		modoPreparo.add(preparo);
		umaReceita = new Receita(nome, ingredientes, modoPreparo);
		MeuLivroDeReceitas book = new MeuLivroDeReceitas();
		book.inserir(umaReceita);
		String nomeParaExcluir = "Um nome qualquer";
		//Act
		book.excluir(nomeParaExcluir);
		//Assert
		List<Receita> receitasEsperado = new ArrayList<>();
		receitasEsperado.add(umaReceita);
		assertEquals(receitasEsperado, book.getTodasReceitas());
	}
	
	@Test
	public void testAtualizaReceita() throws Exception{
		//Arrange
		Ingrediente um = new Ingrediente("Cacau em pó", 2, UnidadeMedida.COLHER_SOPA, 0.30);
		Ingrediente dois = new Ingrediente("Leite", 1, UnidadeMedida.XICARA, 0.25);
		Instrucao preparo = new Instrucao("Bater na batedeira");
		Receita umaReceita;
		String nome = "Achocolatado sem açúcar";
		List<Ingrediente> ingredientes = new ArrayList<>();
		ingredientes.add(um);
		ingredientes.add(dois);
		List<Instrucao> modoPreparo = new ArrayList<>();
		modoPreparo.add(preparo);
		umaReceita = new Receita(nome, ingredientes, modoPreparo);
		MeuLivroDeReceitas book = new MeuLivroDeReceitas();
		book.inserir(umaReceita);
		Ingrediente tres = new Ingrediente("Canela", 1, UnidadeMedida.COLHER_XA, 0.05);
		umaReceita.adicionarIngrediente(tres);
		//Act
		book.atualizar(nome, umaReceita);
		//Assert
		List<Receita> receitasEsperado = new ArrayList<>();
		receitasEsperado.add(umaReceita);
		assertEquals(receitasEsperado, book.getTodasReceitas());
	}
	
	@Test
	public void testCalculaValorTotalDaListaDeReceitas() throws Exception{
		//Arrange
		Ingrediente um = new Ingrediente("Cacau em pó", 2, UnidadeMedida.COLHER_SOPA, 0.30);
		Ingrediente dois = new Ingrediente("Leite", 1, UnidadeMedida.XICARA, 0.25);
		Instrucao preparo = new Instrucao("Bater na batedeira");
		Receita umaReceita;
		String nome = "Achocolatado sem açúcar";
		List<Ingrediente> ingredientes = new ArrayList<>();
		ingredientes.add(um);
		ingredientes.add(dois);
		List<Instrucao> modoPreparo = new ArrayList<>();
		modoPreparo.add(preparo);
		umaReceita = new Receita(nome, ingredientes, modoPreparo);
		MeuLivroDeReceitas book = new MeuLivroDeReceitas();
		book.inserir(umaReceita);
		Ingrediente ingredienteReceitaDois = new Ingrediente("Arroz", 1, UnidadeMedida.XICARA, 0.50);
		List<Ingrediente> ingredientesReceitaDois = new ArrayList<>();
		ingredientesReceitaDois.add(ingredienteReceitaDois);
		List<Instrucao> modoPreparoReceitaDois = new ArrayList<>();
		modoPreparoReceitaDois.add(new Instrucao("Ferver com água."));
		Receita segundaReceita = new Receita("Arroz", ingredientesReceitaDois, modoPreparoReceitaDois);
		book.inserir(segundaReceita);
		double resultado;
		//Act
		resultado = book.calcularValorTotalDasReceitas(book.getTodasReceitas());
		//Assert
		double valorEsperado = 1.05;
		assertEquals(valorEsperado, resultado, DIFERENCA_TOLERADA);
	}
	
	@Test
	public void testIngredientesAlergicoLista() throws Exception{
		//Arrange
		//Ingredientes
		Ingrediente ingredienteUm = new Ingrediente("Arroz", 1, UnidadeMedida.XICARA, 0.30);
		Ingrediente ingredienteDois = new Ingrediente("Cacau", 5, UnidadeMedida.COLHERES_SOPA, 0.50);
		Ingrediente ingredienteTres = new Ingrediente("Agua", 1, UnidadeMedida.XICARA, 0.10);
		Ingrediente ingredienteQuatro = new Ingrediente("Leite", 1, UnidadeMedida.XICARA, 0.30);
		Ingrediente ingredienteCinco = new Ingrediente("Farinha", 1, UnidadeMedida.XICARA, 0.30);
		//ListaDeIngredientes
		//ListaReceitaUm
		List<Ingrediente> ingredientesUm = new ArrayList<>();
		ingredientesUm.add(ingredienteUm);
		ingredientesUm.add(ingredienteTres);
		//ListaReceitaDois
		List<Ingrediente> ingredientesDois = new ArrayList<>();
		ingredientesDois.add(ingredienteDois);
		ingredientesDois.add(ingredienteQuatro);
		//ListaReceitaTres
		List<Ingrediente> ingredientesTres = new ArrayList<>();
		ingredientesTres.add(ingredienteDois);
		ingredientesTres.add(ingredienteTres);
		ingredientesTres.add(ingredienteCinco);
		//ModoPreparo
		List<Instrucao> modoPreparo = new ArrayList<>();
		modoPreparo.add(new Instrucao("Ferver em fogo brando"));
		//Receitas
		Receita receitaUm = new Receita("Receita um", ingredientesUm, modoPreparo);
		Receita receitaDois = new Receita("Receita dois", ingredientesDois, modoPreparo);
		Receita receitaTres = new Receita("Receita tres", ingredientesTres, modoPreparo);
		MeuLivroDeReceitas book = new MeuLivroDeReceitas();
		book.inserir(receitaUm);
		book.inserir(receitaDois);
		book.inserir(receitaTres);
		//ListaDeAlergiaEResultado
		List<Ingrediente> alergico = new ArrayList<>();
		alergico.add(ingredienteDois);
		List<Receita> resultado = new ArrayList<>();
		//Act
		resultado = book.receitasSemIngredientesEspecificados(alergico);
		//Assert
		List<Receita> receitasEsperado = new ArrayList<>();
		receitasEsperado.add(receitaUm);
		assertEquals(receitasEsperado, resultado);		
	}
	
	@Test
	public void testIngredientesAlergicoListaRetornando0() throws Exception{
		//Arrange
		//Ingredientes
		Ingrediente ingredienteUm = new Ingrediente("Arroz", 1, UnidadeMedida.XICARA, 0.30);
		Ingrediente ingredienteDois = new Ingrediente("Cacau", 5, UnidadeMedida.COLHERES_SOPA, 0.50);
		Ingrediente ingredienteTres = new Ingrediente("Agua", 1, UnidadeMedida.XICARA, 0.10);
		Ingrediente ingredienteQuatro = new Ingrediente("Leite", 1, UnidadeMedida.XICARA, 0.30);
		Ingrediente ingredienteCinco = new Ingrediente("Farinha", 1, UnidadeMedida.XICARA, 0.30);
		//ListaDeIngredientes
		//ListaReceitaUm
		List<Ingrediente> ingredientesUm = new ArrayList<>();
		ingredientesUm.add(ingredienteUm);
		ingredientesUm.add(ingredienteTres);
		//ListaReceitaDois
		List<Ingrediente> ingredientesDois = new ArrayList<>();
		ingredientesDois.add(ingredienteDois);
		ingredientesDois.add(ingredienteQuatro);
		//ListaReceitaTres
		List<Ingrediente> ingredientesTres = new ArrayList<>();
		ingredientesTres.add(ingredienteDois);
		ingredientesTres.add(ingredienteTres);
		ingredientesTres.add(ingredienteCinco);
		//ModoPreparo
		List<Instrucao> modoPreparo = new ArrayList<>();
		modoPreparo.add(new Instrucao("Ferver em fogo brando"));
		//Receitas
		Receita receitaUm = new Receita("Receita um", ingredientesUm, modoPreparo);
		Receita receitaDois = new Receita("Receita dois", ingredientesDois, modoPreparo);
		Receita receitaTres = new Receita("Receita tres", ingredientesTres, modoPreparo);
		MeuLivroDeReceitas book = new MeuLivroDeReceitas();
		book.inserir(receitaUm);
		book.inserir(receitaDois);
		book.inserir(receitaTres);
		//ListaDeAlergiaEResultado
		List<Ingrediente> alergico = new ArrayList<>();
		alergico.add(ingredienteUm);
		alergico.add(ingredienteDois);
		List<Receita> resultado = new ArrayList<>();
		//Act
		resultado = book.receitasSemIngredientesEspecificados(alergico);
		//Assert
		List<Receita> receitasEsperado = new ArrayList<>();
		assertEquals(receitasEsperado, resultado);		
	}
}
