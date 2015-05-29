package filmator.model;

public class Avaliacao {

	private int idfilme;
	private int idusuario;
	private int nota;
	
	public Avaliacao() {}

	public Avaliacao(int idfilme, int idusuario, int nota) {
		super();
		this.idfilme = idfilme;
		this.idusuario = idusuario;
		this.nota = nota;
	}

	public int getIdfilme() {
		return idfilme;
	}

	public void setIdfilme(int idfilme) {
		this.idfilme = idfilme;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}
}
