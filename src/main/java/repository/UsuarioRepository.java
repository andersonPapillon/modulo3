package repository;

import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuarioRepository {
		
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public UsuarioRepository(){
		
	}
	

	public void cadastrar(Usuario usuario) {
		usuarios.add(usuario);
	} 
	
	public void alterar(int indice, Usuario usuario){							
		usuarios.set(indice, usuario);		
	}
	
	public void excluir(int indice) {
		usuarios.remove(indice);
	}
	 
	public List<Usuario> buscarTodos(){
		return this.usuarios;
	}

}
