package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuarioRepositoryBanco implements UsuarioRepository{
	
	private Connection conexao = ConexaoFactory.criarConexao();
	//Connection conexao = ConexaoFactory.criarConexao();
	
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
		// Para vetor		
	}
	
	public void alterar(Usuario usuario){
		PreparedStatement prepared;
		try {
			prepared = conexao.prepareStatement("UPDATE usuario set nome=?, senha=? where id=?");
			prepared.setString(1, usuario.getNome());
			prepared.setString(2, usuario.getSenha());
			prepared.setInt(3, usuario.getId());				
			prepared.execute();
			prepared.close();			
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
			
	}
					
	public void excluir(int id){
		PreparedStatement prepared;
		try {
			prepared = conexao.prepareStatement("DELETE FROM usuario where id=?");
			prepared.setInt(1, id);									
			prepared.execute();
			prepared.close();			
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
	} 
				 
	public List<Usuario> buscarTodos(){
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		PreparedStatement prepared;
		try {
			prepared = conexao.prepareStatement("SELECT * FROM usuario");						
			ResultSet rs = prepared.executeQuery();
			
			while(rs.next()){				
				Usuario usu = new Usuario();
				usu.setId(rs.getInt("id"));
				usu.setNome(rs.getString("nome"));
				usu.setSenha(rs.getString("senha"));
				
				usuarios.add(usu);
			}
						
			prepared.close();						
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		
		return usuarios;
	}
	
	

}
