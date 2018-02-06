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
		
		console.log(usu);
		
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
	this.alterar = function(usu, sucesso, erro){
						
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
		
		console.log("dentro do service", usu);
		
		xhttp.open("PUT", "usucontroller?"+usu, true);		
		xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");		
		xhttp.send();
	}
	
	//DELETE
	this.deletar = function(id, cb){
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function(){			
			if(this.readyState == 4 && this.status == 200){												
				cb();
			}			
		};
		xhttp.open("DELETE", "usucontroller?id="+id, true);
		xhttp.send();		
	}
	
	this.buscarPorId = function(id, cb){		
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function(){			
			if(this.readyState == 4 && this.status == 200){												
				cb(JSON.parse(this.responseText));
			}			
		};
		xhttp.open("GET", "usucontroller?id="+id, true);
		xhttp.send();		
	}
	
	
	
	
	
	
	
	
	
	
}