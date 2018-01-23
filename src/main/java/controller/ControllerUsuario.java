package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;


  
@WebServlet(urlPatterns={"/usucontroller", "/usuariocontroller"})
public class ControllerUsuario extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	
	public void cadastrar(Usuario usuario) {
		usuarios.add(usuario);
	} 
	
	public void excluir(Usuario usuario) {
		usuarios.remove(usuario);
	}
	 
	
	
	
	
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.getWriter().println("aeee caraio");
		
		
	}
	
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		String nome  = req.getParameter("nome");
		String senha = req.getParameter("senha");
		
		System.out.println(nome + " " + senha);
		
		
		Usuario usuario = new Usuario();
		
		usuario.setNome(nome);
		usuario.setSenha(senha);
		
		cadastrar(usuario);
		
		
		
		resp.getWriter().println("Usuario cadastrado com sucesso! " + usuario);
		
		
		
	}
	
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	
	
	
	
}

