package filmator.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import filmator.model.Avaliacao;

@Component
public class AvaliacaoDao {
	
	@Inject
	JdbcTemplate jdbcTemplate;

	public void avaliar(int nota, int idfilme, int idusuario) {
		Avaliacao a = new Avaliacao(idfilme, idusuario, nota);
		List<Avaliacao> avaliado = retornarNota(a);
		if(avaliado.isEmpty()){
			inserirAvaliacao(a);
		} else {
			atualizarAvaliacao(a);
		}
	}

	private void atualizarAvaliacao(Avaliacao a) {
		jdbcTemplate.update("UPDATE avaliacao SET nota = ? WHERE idfilme=?  AND idusuario=?",
				a.getNota(), a.getIdfilme(), a.getIdusuario());
	}

	private void inserirAvaliacao(Avaliacao a) {
		jdbcTemplate.update("INSERT INTO avaliacao(idfilme, idusuario, nota) VALUES(?,?,?)",
				a.getIdfilme(), a.getIdusuario(), a.getNota());
	}

	private List<Avaliacao> retornarNota(Avaliacao a) {
		return jdbcTemplate.query("SELECT * FROM avaliacao WHERE idfilme=? AND idusuario=?",
				new RowMapper<Avaliacao>(){
			@Override
			public Avaliacao mapRow(ResultSet rs, int numRow)
					throws SQLException {
				Avaliacao nova = new Avaliacao();
				nova.setIdfilme(rs.getInt("idfilme"));
				nova.setIdusuario(rs.getInt("idusuario"));
				nova.setNota(rs.getInt("nota"));
				return nova;
			}}, a.getIdfilme(), a.getIdusuario());
	}

	public Avaliacao avaliacaoUsuario(int idfilme,
			int idusuario) {
		List<Avaliacao> avaliacoes = jdbcTemplate.query("SELECT * FROM avaliacao WHERE idfilme=? AND idusuario=?",
				new RowMapper<Avaliacao>(){
			@Override
			public Avaliacao mapRow(ResultSet rs, int numRow)
					throws SQLException {
				Avaliacao nova = new Avaliacao();
				nova.setIdfilme(rs.getInt("idfilme"));
				nova.setIdusuario(rs.getInt("idusuario"));
				nova.setNota(rs.getInt("nota"));
				return nova;
			}}, idfilme, idusuario);
		if(avaliacoes.size() > 0){
			return avaliacoes.get(0);
		} else {
			return null;
		}
	}

	public List<Avaliacao> notasDoFilme(int idfilme) {
		return jdbcTemplate.query("SELECT * FROM avaliacao WHERE idfilme=?",
				new RowMapper<Avaliacao>(){
			@Override
			public Avaliacao mapRow(ResultSet rs, int numRow)
					throws SQLException {
				Avaliacao nova = new Avaliacao();
				nova.setIdfilme(rs.getInt("idfilme"));
				nova.setIdusuario(rs.getInt("idusuario"));
				nova.setNota(rs.getInt("nota"));
				return nova;
			}}, idfilme);
	}
}
