package filmator.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import filmator.dao.AvaliacaoDao;
import filmator.dao.FilmeDao;
import filmator.dao.UsuarioDao;
import filmator.model.Avaliacao;
import filmator.model.Filme;
import filmator.model.Genero;
import filmator.model.Usuario;

@Controller
public class FilmeController {

	private final String ADMIN = "admin";
	
	@Inject 
	private FilmeDao filmeDao;
	
	@Inject
	private UsuarioDao usuarioDao;
	
	@Inject
	private AvaliacaoDao avaliacaoDao;
	
	private boolean isAdmin(Usuario usuario){
		boolean eAdmin = usuario != null && usuario.getNomeusuario().equals(ADMIN);
		return eAdmin;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {
		session.invalidate();
		return "index";
	}
	
	@RequestMapping(value = "/logar", method = RequestMethod.POST)
	public String logar(Model model, @RequestParam("usuario") String nome, 
			@RequestParam("senha") String senha, HttpSession session) {
		List<Usuario> usuarios;
		usuarios = usuarioDao.buscarUsuario(nome, senha);
		Usuario usuario = null;
		if(usuarios.size() > 0) usuario = usuarios.get(0);
		if(usuario == null) return "redirect:/erro";
		else if(isAdmin(usuario)){
			session.setAttribute("usuarioLogado", usuario);
			return "redirect:/telaAdmin";
		}
		session.setAttribute("usuarioLogado", usuario);
		return "redirect:/listar";
	}
	
	@RequestMapping(value = "/erro", method = RequestMethod.GET)
	public String erroLogin(Model model) {
		model.addAttribute("mensagem", "Usuário não cadastrado no sistema.");
		return "index";
	}
	
	@RequestMapping(value = "/telaAdmin", method = RequestMethod.GET)
	public String telaAdmin(Model model, HttpSession session) {
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		if(!isAdmin(usuarioLogado)){
			return "redirect:/";
		}
		return "adminPage";
	}
	
	@RequestMapping(value = "/cadastroUsuario", method = RequestMethod.GET)
	public String cadastrarUsuario(Model model) {
		return "cadastroCliente";
	}
	
	@RequestMapping(value = "/cadastroUsuario", method = RequestMethod.POST)
	public String cadastrarUsuarioBanco(Model model, Usuario usuario) {
		usuarioDao.inserir(usuario);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
	public String cadastrar(Model model, HttpSession session) {
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		if(!isAdmin(usuarioLogado)){
			return "redirect:/";
		}
		model.addAttribute("genero", Genero.values());
		return "cadastrarFilme";
	}
	
	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	public String inserir(Model model, Filme filme, HttpSession session) {
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		if(!isAdmin(usuarioLogado)){
			return "redirect:/";
		}
		filmeDao.inserir(filme);
		return "redirect:/listarAdmin";
	}
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Model model, HttpSession session) {
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		if(usuarioLogado == null){
			return "redirect:/";
		}
		model.addAttribute("filmes", filmeDao.buscaTodosFilmes());
		return "consultaFilmes";
	}
	
	@RequestMapping(value = "/listarAdmin", method = RequestMethod.GET)
	public String listarAdmin(Model model, HttpSession session) {
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		if(!isAdmin(usuarioLogado)){
			return "redirect:/";
		}
		model.addAttribute("filmes", filmeDao.buscaTodosFilmes());
		return "consultaFilmesAdmin";
	}
	
	@RequestMapping(value = "/excluir", method = RequestMethod.GET)
	public String excluirFilme(Model model, @RequestParam("id") int id,
			HttpSession session) {
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		if(!isAdmin(usuarioLogado)){
			return "redirect:/";
		}
		filmeDao.excluirFilme(id);
		return "redirect:/listarAdmin";
	}
	
	@RequestMapping(value = "/alterar", method = RequestMethod.GET)
	public String alterarFilme(Model model, @RequestParam("id") int id,
			HttpSession session) {
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		if(!isAdmin(usuarioLogado)){
			return "redirect:/";
		}
		List<Filme> filmes = filmeDao.buscaFilme(id);
		Filme filme = filmes.get(0);
		model.addAttribute("filme", filme);
		model.addAttribute("genero", Genero.values());
		return "alterarFilme";
	}
	
	@RequestMapping(value = "/alterarFilme", method = RequestMethod.POST)
	public String salvarAlteracao(Model model, Filme filme, HttpSession session) {
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		if(!isAdmin(usuarioLogado)){
			return "redirect:/";
		}
		filmeDao.alterarFilme(filme);
		return "redirect:/listarAdmin";
	}
	
	@ResponseBody //@ResponseBody faz transformar o retorno para JSON!
	@RequestMapping(value = "/avaliar", method = RequestMethod.POST)
	public Avaliacao avaliarFilme(Model model, @RequestParam("estrelas") int estrelas,
			@RequestParam("idfilme") int idfilme, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		avaliacaoDao.avaliar(estrelas, idfilme, usuario.getIdusuario());
		return avaliacaoDao.avaliacaoUsuario(idfilme, usuario.getIdusuario());
	}
	
	@ResponseBody
	@RequestMapping(value = "/atualiarMedia", method = RequestMethod.POST)
	public Avaliacao atualizaMedia(Model model, @RequestParam("idfilme") int idfilme, 
			HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		List<Avaliacao> notas = avaliacaoDao.notasDoFilme(idfilme);
		int n = 0;
		int media = 0;
		for(Avaliacao a : notas){
			n += a.getNota();
		}
		media = (int) (n/notas.size());
		Avaliacao retorno = new Avaliacao(idfilme, usuario.getIdusuario(), media);
		return retorno;
	}
	
	@ResponseBody //@ResponseBody faz transformar o retorno para JSON!
	@RequestMapping(value = "/minhaAva", method = RequestMethod.POST)
	public Avaliacao minhaAvaliacao(Model model, @RequestParam("idfilme") int idfilme,
			HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		return avaliacaoDao.avaliacaoUsuario(idfilme, usuario.getIdusuario());
	}
}