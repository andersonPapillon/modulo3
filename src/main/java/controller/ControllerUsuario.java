package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import repository.UsuarioRepository;
import repository.UsuarioRepositoryBanco;
  
@SuppressWarnings("serial")
@WebServlet(urlPatterns={"/usucontroller", "/usuariocontroller"})
public class ControllerUsuario extends HttpServlet{
	
	private UsuarioRepository usuRepo = new UsuarioRepositoryBanco();
			
	@Override
	public void init() throws ServletException {
		
		Usuario u1 = new Usuario("Jao", "123");
		Usuario u2 = new Usuario("Ze", "456");
		Usuario u3 = new Usuario("Maria", "789");
		
		usuRepo.cadastrar(u1);
		usuRepo.cadastrar(u2);
		usuRepo.cadastrar(u3);
				
		super.init();
	}	
	
			
	//METODOS DA CLASSE CONTROLLER	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
									
		List<Usuario> lista = usuRepo.buscarTodos();
		String json = "[";
		
		for(int i = 0;i < lista.size(); i++){
			Usuario usu = lista.get(i);												
			json += "{ \"nome\": \"" + usu.getNome() + "\", \"senha\": \"" + usu.getSenha() + "\"}";
			if(i<lista.size()-1){
				json += ",";
			}
		}
						
		json += "]";
		
		resp.getWriter().println(json);
		
	}
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nome  = req.getParameter("nome");
		String senha = req.getParameter("senha");
							
		Usuario usuario = new Usuario();
		
		usuario.setNome(nome);
		usuario.setSenha(senha);
		
		usuRepo.cadastrar(usuario);
					
		resp.getWriter().println("Usuario cadastrado com sucesso! " + usuario);
						
	}
		
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int indice = Integer.parseInt(req.getParameter("indice"));
		
		String nome  = req.getParameter("nome");
		String senha = req.getParameter("senha");
		
		Usuario usu = new Usuario();
		usu.setNome(nome);
		usu.setSenha(senha);
		
		usuRepo.alterar(indice, usu);
		
	}
			
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int indice = Integer.parseInt(req.getParameter("indice"));
		
		try {
			usuRepo.excluir(indice);			
		} catch (Exception e) {
			throw new ServletException("Não pode excluir");			
		}
				
		
	}
		
}


