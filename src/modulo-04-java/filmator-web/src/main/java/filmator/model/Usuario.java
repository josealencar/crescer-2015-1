package filmator.model;

public class Usuario {

	private int idusuario;
	private String nomeusuario;
	private String senhausuario;
	
	
	public Usuario(int idusuario, String nomeusuario, String senhausuario) {
		this.idusuario = idusuario;
		this.nomeusuario = nomeusuario;
		this.senhausuario = senhausuario;
	}
	
	public Usuario() {}

	public int getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getNomeusuario() {
		return this.nomeusuario;
	}

	public void setNomeusuario(String nomeusuario) {
		this.nomeusuario = nomeusuario;
	}

	public String getSenhausuario() {
		return this.senhausuario;
	}

	public void setSenhausuario(String senhausuario) {
		this.senhausuario = senhausuario;
	}
}
