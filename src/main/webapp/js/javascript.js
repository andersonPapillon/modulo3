function validar(){
			
	usuario = document.getElementById("txtUsuario").value;
	senha   = document.getElementById("txtSenha").value; 
			
	if(usuario === "" || senha ===""){
		window.alert("Os campos usuario e senha estao vazios animal!");
		return false
	}else{
		window.alert("Pode entrar no sistemaaaa");
		return true;
	}
			
}