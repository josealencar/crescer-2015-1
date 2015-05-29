package filmator.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import filmator.model.Usuario;

@Component
public class UsuarioDao {

	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public void inserir(Usuario usuario){
		jdbcTemplate.update("INSERT INTO usuario(nomeusuario, senhausuario) VALUES (?, ?)",
				usuario.getNomeusuario(), usuario.getSenhausuario());
	}
	
	public List<Usuario> buscarUsuario(String nome, String senha){
		return jdbcTemplate.query("SELECT * FROM usuario WHERE nomeusuario=? and senhausuario=?",
				new RowMapper<Usuario>(){
					@Override
					public Usuario mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Usuario usuario = new Usuario();
						usuario.setIdusuario(rs.getInt("idusuario"));
						usuario.setNomeusuario(rs.getString("nomeusuario"));
						usuario.setSenhausuario(rs.getString("senhausuario"));
						return usuario;
					}
			
		}, nome, senha);
	}
}
