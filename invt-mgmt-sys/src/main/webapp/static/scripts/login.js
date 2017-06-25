//TODO: this file need to be removed from the system when spring security is implemented..

var validateLogin = function() {
	var form = $("#loginForm");
	var username = $("#username").val();
	var password = $("#password").val();
	if(username && password) {
		$(form).attr('action', 'login');
		$(form).submit();
	} else {
		alert("Please provide username and password...");
	}
};

$( "#loginButton").on( "click", validateLogin);

/*function validateLogin() {
	alert("login clicked...");
	var form = $("#loginForm");
	var username = $("#username").val();
	var password = $("#password").val();
	if(username && password) {
		$(form).attr('action', 'login');
		$(form).submit();
	} else {
		alert("Please provide username and password...");
	}
}*/