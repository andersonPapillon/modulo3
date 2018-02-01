UsuarioService = function(){
	
	this.usuarios = [];
	
	//CREATE
	this.adicionar = function(usu, sucesso, erro){									
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function(){
			if(this.readyState === 4){
				if(this.status === 200){
					sucesso();
				}else{
					erro();
				}							
			}								
		};
		
		xhttp.open("POST", "usucontroller", true);		
		xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");		
		xhttp.send(usu);
								
	}
	
	//RETRIEVE		
	this.buscarTodos = function(cb){		
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function(){			
			if(this.readyState == 4 && this.status == 200){
				cb(this.usuarios = JSON.parse(this.responseText));
			}			
		};
		xhttp.open("GET", "usucontroller", true);
		xhttp.send();			
	}
	
	//UPDATE
	this.alterar = function(indice, usu){
		this.usuarios.splice(indice, 1, usu);
	}
	
	//DELETE
	this.deletar = function(usu){
		this.usuarios.push(usu);
	}
	
	this.buscarPorId = function(id, cb){
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function(){			
			if(this.readyState == 4 && this.status == 200){
				cb(this.usuarios = JSON.parse(this.responseText));
			}			
		};
		xhttp.open("GET", "usucontroller", true);
		xhttp.send("id="+id);
	}
	
	
	
	
	
	
	
	
	
	
}