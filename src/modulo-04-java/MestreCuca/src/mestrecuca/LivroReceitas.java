package mestrecuca;

import java.util.List;

public interface LivroReceitas {

	void inserir(Receita receita);
	
	void atualizar(String nome, Receita receitaAtualizada) throws Exception;
	
	void excluir(String nome) throws Exception;
	
	List<Receita> getTodasReceitas();
	
	Receita buscaReceitaPeloNome(String nome) throws Exception;
}
