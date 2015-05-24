package mestrecuca;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LivroReceitasJson implements LivroReceitas{
	
	List<Receita> livroReceitas = new ArrayList<>();
	
	public LivroReceitasJson(String string) throws JsonParseException, JsonMappingException, IOException {
		File caminho = new File(string);
		File arquivo = new File(caminho + "\\receitas.json");
		if(arquivo.exists()){
			livroReceitas.addAll(criandoReceitas());
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(arquivo, livroReceitas);
			List<Receita> resultado = new ArrayList<>();
			resultado.add(mapper.readValue(arquivo, Receita.class));
			livroReceitas.addAll(resultado);
			System.out.println(resultado);
		} else{
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(arquivo, null);
		}
	}
	
	private List<Receita> criandoReceitas(){
		List<Receita> receitas = new ArrayList<>();
		Ingrediente um = new Ingrediente("Cacau em pó", 2, UnidadeMedida.COLHER_SOPA, 0.30);
		Ingrediente dois = new Ingrediente("Leite", 1, UnidadeMedida.XICARA, 0.25);
		Instrucao preparo = new Instrucao("Bater na batedeira");
		String nome = "Achocolatado sem açúcar";
		List<Ingrediente> ingredientes = new ArrayList<>();
		ingredientes.add(um);
		ingredientes.add(dois);
		List<Instrucao> modoPreparo = new ArrayList<>();
		modoPreparo.add(preparo);
		Receita aux = new Receita(nome, ingredientes, modoPreparo);
		receitas.add(aux);
		receitas.add(aux);
		receitas.add(aux);
		receitas.add(aux);
		return receitas;
	}
	
	@Override
	public void inserir(Receita receita) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(String nome, Receita receitaAtualizada) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(String nome) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Receita> getTodasReceitas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Receita buscaReceitaPeloNome(String nome) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
