

function validaNick(){
	var nombre = document.getElementById("nickname").value;
	if((nombre === null) || (nombre === "")){
		document.getElementById("mensaje_nick").style.color="#FF3358";
		document.getElementById("nickname").style.border = "2px solid #b03535";
		document.getElementById("nickname").style.boxShadow = "0 0 5px #d45252";
		document.getElementById("mensaje_nick").innerHTML = "Campo requerido";
		return false;
	}
	if(!((/^([0-9a-zA-Z])*$/).test(nombre))){
		document.getElementById("mensaje_nick").style.color = "#FF3358";
		document.getElementById("nickname").style.border = "2px solid #b03535";
		document.getElementById("nickname").style.boxShadow = "0 0 5px #d45252";
		document.getElementById("mensaje_nick").innerHTML = "Caracteres invalidos";
		return false;
	} 
	
	document.getElementById("mensaje_nick").style.color="#0DFF62";
	document.getElementById("nickname").style.border = "2px solid #D2D2D2";
	document.getElementById("nickname").style.boxShadow = "none";
	document.getElementById("mensaje_nick").innerHTML = "Aprobado";
	return true;
}

/*==================================================================*/

function validaEmail(){
	var correo = document.getElementById("mailito").value;
	if((correo == null) || (correo == "")){
		document.getElementById("mensaje_email").style.color= "#FF3358";
		document.getElementById("mailito").style.border = "2px solid #b03535";
		document.getElementById("mailito").style.boxShadow = "0 0 5px #d45252";
		document.getElementById("mensaje_email").innerHTML = "Campo requerido";
		return false;
	} 
	if(!((/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/).test(correo))){
		document.getElementById("mensaje_email").style.color ="#FF3358";
		document.getElementById("mailito").style.border = "2px solid #b03535";
		document.getElementById("mailito").style.boxShadow = "0 0 5px #d45252";
		document.getElementById("mensaje_email").innerHTML = "Correo invalido";
		return false;
	}

	document.getElementById("mensaje_email").style.color ="#0DFF62";
	document.getElementById("mailito").style.border = "2px solid #D2D2D2";
	document.getElementById("mailito").style.boxShadow = "none";
	document.getElementById("mensaje_email").innerHTML = "Aprobado";		
	return true;	
}

/*==================================================================*/

function validaPass(){
	var pass = document.getElementById("password").value;
	if((pass === null) || (pass === "")){
		document.getElementById("mensaje_pass").style.color = "#FF3358";
		document.getElementById("mensaje_pass").innerHTML = "Campo requerido";
		document.getElementById("password").style.border = "2px solid #b03535";
		document.getElementById("password").style.boxShadow = "0 0 5px #d45252";
		return false;
	}
	if(pass.length <= 6){
		document.getElementById("mensaje_pass").style.color = "#FF3358";
		document.getElementById("mensaje_pass").innerHTML = "Longitud incorrecta: 7 caracteres minimo";
		document.getElementById("password").style.border = "2px solid #b03535";
		document.getElementById("password").style.boxShadow = "0 0 5px #d45252";
		return false;
	}
	if(!(/^([^<>])*$/).test(pass)){
		document.getElementById("mensaje_pass").style.color = "#FF3358";
		document.getElementById("mensaje_pass").innerHTML = "No acepta corchetes angulares: < >"
		document.getElementById("password").style.border = "2px solid #b03535";
		document.getElementById("password").style.boxShadow = "0 0 5px #d45252";
		return false
	}
	document.getElementById("mensaje_pass").style.color="#0DFF62";
	document.getElementById("password").style.border = "2px solid #D2D2D2";
	document.getElementById("password").style.boxShadow = "none";
	document.getElementById("mensaje_pass").innerHTML = "Aprobado";
	return true;
}

/*==================================================================*/

function validaConfirm(){
	var pass_confirm = document.getElementById("confirm").value;
	var pass = document.getElementById("password").value;
	if((pass_confirm == null) || (pass_confirm == "")){
		document.getElementById("mensaje_confirm").style.color = "#FF3358";
		document.getElementById("mensaje_confirm").innerHTML = "Campo requerido";
		document.getElementById("confirm").style.border = "2px solid #b03535";
		document.getElementById("confirm").style.boxShadow = "0 0 5px #d45252";
		return false;
	}
	if(pass_confirm != pass){
		document.getElementById("mensaje_confirm").style.color = "#FF3358";
		document.getElementById("confirm").style.border = "2px solid #b03535";
		document.getElementById("confirm").style.boxShadow = "0 0 5px #d45252";
		document.getElementById("mensaje_confirm").innerHTML = "No coincide";
		return false;
	}
	document.getElementById("mensaje_confirm").style.color = "#0DFF62";
	document.getElementById("confirm").style.border = "2px solid #D2D2D2";
	document.getElementById("confirm").style.boxShadow = "none";
	document.getElementById("mensaje_confirm").innerHTML = "Aprobado";
	return true;
}

/*==================================================================*/

function validaTodosN(){
	if(validaNick() && validaEmail() && validaPass() && validaConfirm()){
		document.getElementById("boton").style.display = 'block';
	} else {
		document.getElementById("boton").style.display = 'none';
	}
}

function validaTodosE(){
	if(validaEmail() && validaPass() && validaConfirm() && validaNick()){
		document.getElementById("boton").style.display = 'block';
	} else {
		document.getElementById("boton").style.display = 'none';
	}
}

function validaTodosP(){
	if(validaPass() && validaConfirm() && validaNick() && validaEmail()){
		document.getElementById("boton").style.display = 'block';
	} else {
		document.getElementById("boton").style.display = 'none';
	}
}

function validaTodosC(){
	if(validaConfirm()  && validaPass() && validaNick() && validaEmail()){
		document.getElementById("boton").style.display = 'block';
	} else {
		document.getElementById("boton").style.display = 'none';
	}
}


