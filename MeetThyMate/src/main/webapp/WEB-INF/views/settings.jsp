<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change your Settings</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/change.css" />
<script type="text/javascript">
// var xmlHttp;
// xmlHttp = GetXmlHttpObject();
// function saveUser() {
//     //alert("hello1");

//     if (xmlHttp == null)
//     {
//         alert("Your browser does not support AJAX!");
//         return;
//     }
//     var password=document.getElementById("password").value;
// }

// var query="changePassword.htm?password="+password;
	$(document).ready(function(){
		$("#changePassword").click(function(){
			var password=$("#password").val();
// 			alert(password);
			// Checking for blank fields.
			$.ajax({
			type: "POST",
			url: "changePassword.htm",
			data: {password:password},
			success: function(response){
				$("#result1").html(response);			
			}
		});
	});
	});


</script>
</head>
<body>
	<H3>Meetthymate.com</H3>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
<!-- 			<a class="navbar-brand" href="loggedin.jsp">Home</a> -->
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
			<li><a href="loggedin.htm?data=${user.userName }">Home</a></li>
				<li><a href="profile.htm?type=2&data=${user.userName }">Profile</a></li>
				<li><a href="update.htm?data=${user.userName }">Edit
						profile</a></li>
				<li><a href="message.htm?data=${user.userName }">Messages</a></li>
				<li><a href="viewContacts.htm?data=${user.userName }">Friends</a></li>
				<li><a href="change.htm?data=${user.userName }">Settings</a></li>
				<li><a href="logout.htm">Logout</a></li>
			</ul>
		</div>
	</div>
	</nav>
	<div class="container">
		<table class="table">
		
		   
		<TR>
		<form action="changePassword.htm" method='post'>
		<TD>Enter NEW password:</TD>
		<TD><input id="password" type='password' name='newpass' required></TD>
		<TD ALIGN='center'><input type='button' id="changePassword" value='Update Password'></TD>
		</form>
		</TR>
		<tr><td><div id="result1"></div></td></tr>
		
		
		   
<!-- 		<TR> -->
<!-- 		<form action="deleteAccount.htm" method='post'>		 -->
<!-- 		<TD>Do you want to delete account?</TD> -->
<!-- 		<TD><input type='submit' value='Delete'></TD> -->
<!-- 		</form> -->
<!-- 		</TR> -->
		
        
		   
		</table>
	</div>

</body>
</html>