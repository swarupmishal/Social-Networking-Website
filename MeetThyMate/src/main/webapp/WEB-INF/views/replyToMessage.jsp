<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/loggedin.css" />
</head>
<body>
This page will be shown when user logs in!! Welcome ${user.userName}
	<H3>Meetthymate.com</H3>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<!--       <a class="navbar-brand" href="loggedin.jsp">Home</a> -->
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
	<form action="replyMessageTo.htm?sender=${sender}&receiver=${receiver}" method="post">
			<table class="table">
				<tr>
					<td>Reply to ${receiver}</td>
					
				</tr>
				<tr>
					<td>
						<textarea name="message" rows="10" cols="100" ></textarea>
					</td>
				</tr>

			</table>
			<input type="submit" value="Reply">
		</form>
		</div>
</body>
</html>