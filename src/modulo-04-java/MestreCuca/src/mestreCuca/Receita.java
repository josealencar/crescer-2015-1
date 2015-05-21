package mestreCuca;

import java.util.ArrayList;
import java.util.List;

public class Receita {

	private String nome;
	private List<Ingrediente> ingredientes = new ArrayList<>();
	private List<Instrucao> instrucao = new ArrayList<>();
	
	public Receita(String nome) {
		this.nome = nome;
	}
	
	public Receita() {
		// TODO Auto-generated constructor stub
	}
	
	public Receita(String nome, List<Ingrediente> ingredientes, List<Instrucao> instrucao){
		this(nome);
		this.ingredientes.addAll(ingredientes);
		this.instrucao.addAll(instrucao);
	}
	
	public void adicionarIngrediente(Ingrediente ingrediente){
		this.ingredientes.add(ingrediente);
	}
	
	public void adicionarInstrucao(Instrucao instrucao){
		this.instrucao.add(instrucao);
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public List<Ingrediente> getIngredientes() {
		return this.ingredientes;
	}
	
	public List<Instrucao> getInstrucao() {
		return this.instrucao;
	}
	
	public double valorReceita(){
		double valorTotal = 0;
		for(Ingrediente i : this.ingredientes){
			valorTotal += i.getPreco();
		}
		return valorTotal;
	}
	
	@Override
	public String toString() {
		return this.getNome();
	}
}
