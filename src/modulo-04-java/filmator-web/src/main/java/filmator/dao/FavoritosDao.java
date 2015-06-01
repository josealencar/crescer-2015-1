package filmator.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import filmator.model.Favoritos;
import filmator.model.Filme;
import filmator.model.Genero;

@Component
public class FavoritosDao {

	private final String ADICIONADO = "Adicionado";
	private final String REMOVIDO = "Removido";
	
	@Inject
	JdbcTemplate jdbcTemplate;
	
	public String adicionarAosFavoritos(Favoritos favoritos){
		jdbcTemplate.update("INSERT INTO favoritos(idfilme, idusuario) VALUES(?, ?)",
				favoritos.getIdfilme(), favoritos.getIdusuario());
		return ADICIONADO;
	}
	
	public String removerDosFavoritos(Favoritos favoritos){
		jdbcTemplate.update("DELETE FROM favoritos WHERE idfilme=? AND idusuario=?",
				favoritos.getIdfilme(), favoritos.getIdusuario());
		return REMOVIDO;
	}
	
	public List<Filme> buscaFilmesFavoritos(int idusuario){
		return jdbcTemplate.query("SELECT filme.idfilme, filme.nome, filme.genero, filme.ano, "
				+ "filme.sinopse, filme.imagem FROM filme "
				+ "INNER JOIN favoritos ON filme.idfilme = favoritos.idfilme "
				+ "WHERE favoritos.idusuario = ?",
				new RowMapper<Filme>(){
			@Override
			public Filme mapRow(ResultSet rs, int rowNum) throws SQLException {
				Filme filme = new Filme();
				filme.setIdfilme(rs.getInt("idfilme"));
				filme.setNome(rs.getString("nome"));
				filme.setGenero(Genero.valueOf(rs.getString("genero")));
				filme.setAno(rs.getInt("ano"));
				filme.setSinopse(rs.getString("sinopse"));
				filme.setImagem(rs.getString("imagem"));
				return filme;
			}
		}, idusuario);
	}
}
