alert('hello')

$("#login-form").submit(function(e){
    
    e.preventDefault(e);
    login();
});

function login() {
    console.info("Attempting to authenticate");
 	$("#loginErr").hide();
 	showLoader();
    $.ajax({
        type: 'POST',
        url: '/login',
        data: $('#login-form').serialize(),
        cache: false,
        dataType: "json",
        crossDomain: false,
        success: function (data) {
        	hideLoader();
            var response = data;
            if (response.success == true) {
                console.info("Authentication Success!");
                window.location.href="/mi-cuenta";
            }
            else {
            	if(data.type==1)
           	 	$("#loginErr").show();
            	else
            		$("#loginErr2").show();
               
            }
        },
        error: function (data) {
        	hideLoader();
        	var resp=data.responseJSON;
            console.error("Login failure");
            if(resp.type==1)
           	 	$("#loginErr").show();
            	else
            		$("#loginErr2").show();
        }
    });
    return false;
}