<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Searching for member</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/change.css" />
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
	<h3>Searching for Member:${searchedUser.userName}</h3>
	<CENTER>
	<div class="container">
	<form method='post' action='addContact.htm'>
		<table class="table" border="1" cellpadding="5" cellspacing="5">
		
			<tr>
				<td><b>Picture</b></td>
				<td><b>Username</b></td>
				<td><b>First Name</b></td>
				<td><b>Last Name</b></td>
				<td><b>Gender</b></td>
				<td><b>Email</b></td>
<!-- 				<td><b>User Profile</b></td> -->
				<td><b>Add to Contact List</b></td>

			</tr>

				<tr>
					<td><img height="150" width="150" src="${searchedUser.photoName}" /></td>
					<td>${searchedUser.userName}</td>
					<td>${searchedUser.firstName}</td>
					<td>${searchedUser.lastName}</td>
					<td>${searchedUser.gender}</td>
					<td>${searchedUser.email}</td>
<%-- 					<td><a href="details.htm?type=1&data=${searchedUser.userName}"><IMG SRC='images/detail.jpg'></a></td> --%>
					<td><input type='submit' value='Add to Contact List'></td>
				</tr>
				
		</table>
		</form>
	</div>
	</CENTER>
</body>
</html>