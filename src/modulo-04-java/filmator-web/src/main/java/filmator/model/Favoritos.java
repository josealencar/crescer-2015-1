package filmator.model;

public class Favoritos {

	private int idusuario;
	private int idfilme;
	
	public Favoritos() {}

	public Favoritos(int idusuario, int idfilme) {
		super();
		this.idusuario = idusuario;
		this.idfilme = idfilme;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public int getIdfilme() {
		return idfilme;
	}

	public void setIdfilme(int idfilme) {
		this.idfilme = idfilme;
	}
}
