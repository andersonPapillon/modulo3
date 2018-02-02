package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import repository.RepositoryException;
import repository.UsuarioRepository;
import repository.UsuarioRepositoryBanco;
  
@SuppressWarnings("serial")
@WebServlet(urlPatterns={"/usucontroller", "/usuariocontroller"})
public class ControllerUsuario extends HttpServlet{
	
	private UsuarioRepository usuRepo = new UsuarioRepositoryBanco();
			
	@Override
	public void init() throws ServletException {
	}	
	
			
	//METODOS DA CLASSE CONTROLLER	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
						
		if(req.getParameter("id")!=null){
														
			Integer id = Integer.parseInt(req.getParameter("id"));									
			Usuario usuario = usuRepo.buscarPorId(id);			
			
			String json = "{ \"id:\" " + usuario.getId() + ", \"nome:\" " + usuario.getNome() + ", \"senha:\" " + usuario.getSenha() + " }";
			
			resp.getWriter().println(json);
									
		}else{
			List<Usuario> lista = usuRepo.buscarTodos();
			
			String json = "[";
			
			for(int i = 0;i < lista.size(); i++){
				Usuario usu = lista.get(i);												
				json += "{ \"id\": \"" + usu.getId() + "\", \"nome\": \"" + usu.getNome() + "\", \"senha\": \"" + usu.getSenha() + "\"}";
				if(i<lista.size()-1){
					json += ",";
				}
			}
							
			json += "]";
					
			resp.getWriter().println(json);			
		}
	}
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nome  = req.getParameter("nome");
		String senha = req.getParameter("senha");
							
		Usuario usuario = new Usuario();
		
		usuario.setNome(nome);
		usuario.setSenha(senha);
		
		try {
			usuRepo.cadastrar(usuario);
			resp.getWriter().println("Usuario cadastrado com sucesso! " + usuario);
		} catch (RepositoryException e) {			
			throw new ServletException(e);
		}
							
						
	}
		
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		String nome  = req.getParameter("nome");
		String senha = req.getParameter("senha");
		
		Usuario usu = new Usuario();
		
		usu.setId(id);
		usu.setNome(nome);
		usu.setSenha(senha);
		
		usuRepo.alterar(usu);
		
	}
			
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		try {
			usuRepo.excluir(id);			
		} catch (Exception e) {
			throw new ServletException("Não pode excluir");			
		}
				
		
	}
		
}


