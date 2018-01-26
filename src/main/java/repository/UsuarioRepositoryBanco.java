package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Usuario;

public class UsuarioRepositoryBanco implements UsuarioRepository{
	
	Connection conexao = ConexaoFactory.criarConexao();	
	
	public void cadastrar(Usuario usuario){
		
		try {
			PreparedStatement prepared = conexao.prepareStatement("INSERT INTO usuario (nome, senha) values (?,?)");
			prepared.setString(1, usuario.getNome());
			prepared.setString(2, usuario.getSenha());
			
			prepared.execute();
			prepared.close();						
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}			 
	
	public void alterar(int indice, Usuario usuario){		
	}							
				
	public void excluir(int indice){		
	} 
				 
	public List<Usuario> buscarTodos(){
		return null;
	}
	
	

}
