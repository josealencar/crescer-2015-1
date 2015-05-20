package mestreCuca;

public class Instrucao {
	
	private String descricao;
	
	public Instrucao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	@Override
	public String toString() {
		return this.getDescricao();
	}
}
