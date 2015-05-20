package mestreCuca;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class MeuLivroDeReceitas implements LivroReceitas{
	
	private final String MESSAGE_INSERT = "Não pode ser inserido Receita com nome nulo ou vazio!";
	
	private List<Receita> receitas = new ArrayList<>();

	@Override
	public void atualizar(String nome, Receita receitaAtualizada) {
		Receita receita;
		try {
			if(validaReceita(receitaAtualizada)){
				receita = buscaReceitaPeloNome(nome);
				int index = buscaIndexDaReceita(receita);
				this.receitas.set(index, receitaAtualizada);
			} else {
				JOptionPane.showMessageDialog(null, MESSAGE_INSERT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private int buscaIndexDaReceita(Receita receita){
		return this.receitas.indexOf(receita);
	}
	
	@Override
	public Receita buscaReceitaPeloNome(String nome) throws Exception{
		int index = -1;
		for(Receita c : this.receitas){
			if(c.getNome().equals(nome)){
				index = this.receitas.indexOf(c);
			}
		}
		return this.receitas.get(index);
	}
	
	@Override
	public void excluir(String nome) {
		Receita paraExcluir;
		try {
			paraExcluir = buscaReceitaPeloNome(nome);
			this.receitas.remove(paraExcluir);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Receita> getTodasReceitas() {
		return this.receitas;
	}
	
	@Override
	public void inserir(Receita receita){
		if(validaReceita(receita)){
			this.receitas.add(receita);
		} else {
			JOptionPane.showMessageDialog(null, MESSAGE_INSERT);
		}
	}
	
	private boolean validaReceita(Receita receita){
		boolean podeAdicionar = receita != null && receita.getNome() != null && !receita.getNome().trim().equals("");
		return podeAdicionar;
	}
	
	public double calcularValorTotalDasReceitas(List<Receita> receitas){
		double totalReceitas = 0;
		for(Receita r : receitas){
			totalReceitas += r.valorReceita();
		}
		return totalReceitas;
	}
	
	public List<Receita> receitasSemIngredientesEspecificados(List<Ingrediente> alergico){
		List<Receita> receitasOk = new ArrayList<>();
		boolean ok = false;
		for(Receita r : this.receitas){
			for(Ingrediente i : alergico){
				if(!r.getIngredientes().contains(i)){
					ok = true;
				} else {
					ok = false;
					break;
				}
			}
			if(ok) receitasOk.add(r);
			ok = false;
		}
		return receitasOk;
	}
	
	public List<Ingrediente> listaDeCompras(List<Receita> comprarIngredientes){
		List<Ingrediente> listaDeCompras = new ArrayList<>();
		boolean temNaLista = false;
		for(Receita r : comprarIngredientes){
			List<Ingrediente> novaLista = new ArrayList<>();
			novaLista.addAll(r.getIngredientes());
			for(Ingrediente i : novaLista){
				for(Ingrediente li : listaDeCompras){
					if(i.getNome().equals(li.getNome()) && i.getUnidade().equals(li.getUnidade())){
						temNaLista = true;
						double total = i.getQuantidade() + li.getQuantidade();
						li.setQuantidade(total);
					}
				}
				if(temNaLista == false){
					listaDeCompras.add(i);
				}
				temNaLista = false;
			}
		}
		return listaDeCompras;
	}
}
