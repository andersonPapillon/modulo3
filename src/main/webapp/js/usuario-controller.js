UsuarioController = function(){
	
	this.usuarioService = new UsuarioService();
	
	this.aoClicarSalvar = function(){
		
		var self = this;		
		
		//Constroi um objeto usuario
		/*
		var usu = {
				"nome": document.getElementById("txtUsuario").value,
				"senha": document.getElementById("txtSenha").value
				};
		 */		
		
		idUsuario 	 = document.getElementById("txtId").value;
		nomeUsuario  = document.getElementById("txtUsuario").value;
		senhaUsuario = document.getElementById("txtSenha").value;
										
		if(idUsuario === ""){						
			usu = "nome="+nomeUsuario+"&senha="+senhaUsuario;
			
			this.usuarioService.adicionar(usu, function(){
				window.alert("Salvo com sucesso");
				self.aoClicarListar();
			}, function(){
				window.alert("Não pode ser salvo!");
			});
		}else{			
			usu = "id="+idUsuario+"&nome="+nomeUsuario+"&senha="+senhaUsuario;
			//usu = "nome="+nomeUsuario+"&senha="+senhaUsuario;
			this.usuarioService.alterar(usu, function(){
				window.alert("Salvo com sucesso");
				self.aoClicarListar();				
			}, function(){
				window.alert("Não pode ser salvo!");				
			});
		}
		
			
	}
					
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
			dados += 	"<td>" + arrUsuarios[i]['id']    + "</td>";			
			dados += 	"<td>" + arrUsuarios[i]['nome']  + "</td>";
			dados += 	"<td>" + arrUsuarios[i]['senha'] + "</td>";
			dados += 	"<td> <input type='button' value='Excluir' onclick='uc.aoClicarExcluir("+ arrUsuarios[i]['id'] +")'></input>";
			dados += 	"<td> <input type='button' value='Editar'  onclick='uc.aoClicarEditar("+ arrUsuarios[i]['id'] +")'></input>";			
			dados += "</tr>";
								
		}	
		
		document.getElementById("tbUsuarios").innerHTML = dados;
		
		
	}	
	
	this.aoClicarEditar = function(id){			
		this.usuarioService.buscarPorId(id, function(usuario){						
			document.getElementById("txtId").value      = usuario.id;
			document.getElementById("txtUsuario").value = usuario.nome;
			document.getElementById("txtSenha").value   = usuario.senha;			
		});
				
	}
	
	this.aoClicarExcluir = function(id){
		
		if(window.confirm("Deseja realmente excluir?")){
			var self = this;		
			this.usuarioService.deletar(id, function(){
				window.alert("Excluído com sucesso porra!");
				self.aoClicarListar();
			});			
		}
				
	}
				
}






