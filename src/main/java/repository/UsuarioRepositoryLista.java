package repository;

import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuarioRepositoryLista implements UsuarioRepository{
		
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public UsuarioRepositoryLista(){
		
	}	
	public void cadastrar(Usuario usuario) {
		usuarios.add(usuario);
	} 
	
	public void alterar(int indice, Usuario usuario){							
		usuarios.set(indice, usuario);		
	}
	
	public void alterar(Usuario usuario){							
				
	}
	
	public void excluir(int indice) {
		usuarios.remove(indice);
	}
	 
	public List<Usuario> buscarTodos(){
		return this.usuarios;
	}
	public Usuario buscarPorId(Integer id) {		
		return null;
	}

}
