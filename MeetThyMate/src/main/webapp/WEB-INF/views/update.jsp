<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Updating Information for ${user.userName}</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/update.css" />
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
		<form action="updateUser.htm" method="post">
			<table class="table">
				<tr>
					<td>Username:</td>
					<td>${user.userName}</td>
				</tr>
				<tr>
					<td>Role:</td>
					<td>${user.role}</td>
				</tr>
				<tr>
					<td>Gender:</td>
					<td>
					<input type="radio" name="gender" value="Male" checked>Male 
					<input type="radio" name="gender" value="Female">Female
					</td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="email" name="email" required placeholder="Enter a valid email address"></td>
				</tr>
				<tr>
					<td>Phone:</td>
					<td><input type="number" name="phone" required></td>
				</tr>
				<tr>
					<td>Apartment Number:</td>
					<td><input type="number" name="aptNo" required></td>
				</tr>
				<tr>
					<td>Street:</td>
					<td><input type="text" name="street" required></td>
				</tr>
				<tr>
					<td>City:</td>
					<td><input type="text" name="city" required></td>
				</tr>
				<tr>
					<td>State:</td>
					<td><input type="text" name="state" required></td>
				</tr>
				<tr>
					<td>Country:</td>
					<td><input type="text" name="country" required></td>
				</tr>
				<tr>
					<td>Zipcode:</td>
					<td><input type="number" name="zip" required></td>
				</tr>
			</table>
			<input type="submit" value="Update">
		</form>

	</div>

</body>
</html>