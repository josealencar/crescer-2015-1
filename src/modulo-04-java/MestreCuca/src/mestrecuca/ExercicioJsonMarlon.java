package mestrecuca;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExercicioJsonMarlon implements LivroReceitas{
	
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		List<Receita> receitas = new ArrayList<>();
		receitas.add(new Receita("Arroz"));
		receitas.add(new Receita("Feijão"));
		
		ObjectMapper mapper = new ObjectMapper();
		File caminho = new File("C:\\Users\\José\\Desktop\\receitas.json");
		mapper.writeValue(caminho, receitas);
		
		List<Receita> retorno = mapper.readValue(caminho, new TypeReference<ArrayList<Receita>>() {});
		
		for(Receita r : retorno){
			System.out.println(r);
		}
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
