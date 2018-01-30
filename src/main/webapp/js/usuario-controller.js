UsuarioController = function(){
	
	this.usuarioService = new UsuarioService();
				
	this.aoClicarListar = function(){		
		
			
		var self = this;		
		usuarios = this.usuarioService.buscarTodos(function(usuarios){			
			self.renderizarTabelaUsuarios(usuarios);
		});
				
	}
	
	this.renderizarTabelaUsuarios = function(arrUsuarios){
									
		let dados = "";
								
		for(var i = 0;i < arrUsuarios.length; i++){
						
			dados += "<tr>";			
			dados += 	"<td>" + arrUsuarios[i]['nome']  + "</td>";
			dados += 	"<td>" + arrUsuarios[i]['senha'] + "</td>";
			dados += 	"<td> <input type='button' value='Excluir' onclick=''></input>";
			dados += 	"<td> <input type='button' value='Editar'  onclick=''></input>";			
			dados += "</tr>";
								
		}	
		
		document.getElementById("tbUsuarios").innerHTML = dados;
		
		
	}	
}