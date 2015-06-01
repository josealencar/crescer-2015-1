package filmator.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import filmator.model.Filme;
import filmator.model.Genero;

@Component //Inject só funciona com classe que tenham o @Component
public class FilmeDao {

	@Inject
	private JdbcTemplate jdbcTemplate;
	

	public void inserir(Filme filme){
		jdbcTemplate.update("INSERT INTO Filme (nome, genero, ano, sinopse, imagem) VALUES (?, ?, ?, ?, ?)",
				filme.getNome(), filme.getGenero().name(), filme.getAno(), filme.getSinopse(), filme.getImagem());
	}
	
	public List<Filme> buscaTodosFilmes(){
		return jdbcTemplate.query("SELECT idfilme, nome, genero, ano, sinopse, imagem FROM Filme",
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
		});
	}
	
	/*public List<Filme> buscaTodosFilmesJava8(){
		return jdbcTemplate.query("SELECT nome FROM Filme", (ResultSet rs, int rowNum) -> {	
			Filme filme = new Filme(rs.getString("nome"));
			return filme;
		});
		
	}*/

	public void excluirFilme(int id) {
		jdbcTemplate.update("DELETE FROM filme WHERE idfilme=?", id);
	}

	public List<Filme> buscaFilme(int id) {
		return jdbcTemplate.query("SELECT idfilme, nome, genero, ano, sinopse, imagem FROM Filme WHERE idfilme=?",
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
		}, id);
	}

	public void alterarFilme(Filme filme) {
		jdbcTemplate.update("UPDATE filme SET nome=?, genero=?, ano=?, sinopse=?, imagem=? WHERE idfilme=?",
				filme.getNome(), filme.getGenero().name(), filme.getAno(), filme.getSinopse(),
				filme.getImagem(), filme.getIdfilme());
	}
}