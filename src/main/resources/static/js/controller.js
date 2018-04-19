

console.log("1")

$("#login-form").submit(function(e){
    console.log("entrando al form login")
    e.preventDefault(e);
    login();
});

$("#newEnterprise-form").submit(function(e){
	e.preventDefault(e);
	console.log("btnEmpresaEnviarSolicitud")
	newEnterprise()
	
});

$("#newUser-form").submit(function(e){
	e.preventDefault(e);
	console.log("btnUserEnviar")
	newUser()
	
});

$("#newClient-form").submit(function(e){
	e.preventDefault(e);
	console.log("btnClientEnviar")
	newClient()
	
});

$("#btnTraeHorarios").click(function(e){
	e.preventDefault(e);
	console.log("btnTraeHorarios")
	//newClient()
	
});




$("#newHorario-form").submit(function(e){
	e.preventDefault(e);
	console.log("btnHorarioEnviar")
newHorario()
	
});


function login() {
    console.info("Attempting to authenticate");
 	//$("#loginErr").hide();
 	//showLoader();
    
    console.log("start login")
    $.ajax({
        type: 'POST',
        url: '/login',
        data: $('#login-form').serialize(),
        cache: false,
        dataType: "json",
        crossDomain: false,
        success: function (data) {
        	console.log("success login")
        	//hideLoader();
            var response = data;
            if (response.success == true) {
                console.info("Authentication Success!");
                window.location.href="/menu";
            }
            else {
            	console.log("errror not true on success")
            	$('#modalErrorLogin').modal('show');
               
            }
        },
        error: function (data) {
        	//hideLoader();
        	var resp=data.responseJSON;
            console.log("Login failure");
            $('#modalErrorLogin').modal('show');
            
            
        }
    });
    return false;
}


function newEnterprise() {
    console.info("Attempting to new Enterprise");
 	//$("#loginErr").hide();
 	//showLoader();
    
    
    $.ajax({
        type: 'POST',
        url: '/empresa/newEnterprise',
        data: $('#newEnterprise-form').serialize(),
        cache: false,
        dataType: "json",
        crossDomain: false,
        success: function (data) {
        	console.log("success new enterprise")
        	//hideLoader();
            var response = data;
        	
        	console.log(data)
            
                console.info("new enterprice Success!");
        		//window.location.href="/menu";
                $('#modalRespuesta').modal('show');
                $('#modalRespuestaMensaje').text(data.message)
                
        
            
        },
        error: function (data) {
        	//hideLoader();
        	console.log(data)
        	var resp=data.responseJSON;
            console.log("Login failure");
            $('#modalRespuesta').modal('show');
            $('#modalRespuestaMensaje').text(resp.message)
            
            
        }
    });
    return false;
}



function newUser() {
    console.info("Attempting to new User");
 	//$("#loginErr").hide();
 	//showLoader();
    
    
    $.ajax({
        type: 'POST',
        url: '/usuario/newUser',
        data: $('#newUser-form').serialize(),
        cache: false,
        dataType: "json",
        crossDomain: false,
        success: function (data) {
        	console.log("success new user")
        	//hideLoader();
            var response = data;
        	
        	console.log(data)
            
                console.info("new user Success!");
        		//window.location.href="/menu";
                $('#modalRespuesta').modal('show');
                $('#modalRespuestaMensaje').text(data.message)
                
        
            
        },
        error: function (data) {
        	//hideLoader();
        	console.log(data)
        	var resp=data.responseJSON;
            console.log("Login failure");
            $('#modalRespuesta').modal('show');
            $('#modalRespuestaMensaje').text(resp.message)
            
            
        }
    });
    return false;
}




function newClient() {
    console.info("Attempting to new Client");
 	//$("#loginErr").hide();
 	//showLoader();
    
    
    $.ajax({
        type: 'POST',
        url: '/cliente/newClient',
        data: $('#newClient-form').serialize(),
        cache: false,
        dataType: "json",
        crossDomain: false,
        success: function (data) {
        	console.log("success new client")
        	//hideLoader();
            var response = data;
        	
        	console.log(data)
            
                console.info("new client Success!");
        		//window.location.href="/menu";
                $('#modalRespuesta').modal('show');
                $('#modalRespuestaMensaje').text(data.message)
                
        
            
        },
        error: function (data) {
        	//hideLoader();
        	console.log(data)
        	var resp=data.responseJSON;
            console.log("Login failure");
            $('#modalRespuesta').modal('show');
            $('#modalRespuestaMensaje').text(resp.message)
            
            
        }
    });
    return false;
}



function newHorario() {
    console.info("Attempting to new Horario");
 	//$("#loginErr").hide();
 	//showLoader();
    
    
    $.ajax({
        type: 'POST',
        url: '/horario/newHorario',
        data: $('#newHorario-form').serialize(),
        cache: false,
        dataType: "json",
        crossDomain: false,
        success: function (data) {
        	console.log("success new horario")
        	//hideLoader();
            var response = data;
        	
        	console.log(data)
            
                console.info("new horario Success!");
        		//window.location.href="/menu";
                $('#modalRespuesta').modal('show');
                $('#modalRespuestaMensaje').text(data.message)
                
        
            
        },
        error: function (data) {
        	//hideLoader();
        	console.log(data)
        	var resp=data.responseJSON;
            console.log("Horario failure");
            $('#modalRespuesta').modal('show');
            $('#modalRespuestaMensaje').text(resp.message)
            
            
        }
    });
    return false;
}

