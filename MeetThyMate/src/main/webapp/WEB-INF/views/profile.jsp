<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; CHARSET=windows-1252">
	<script language="JavaScript" src="javascript/matchnet.js"></script>
	<script language="JavaScript" src="javascript/region3.js"></script>
	<script language="JavaScript" src="im/im.js"></script>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="lib/css/as.css">
	
	<link rel="stylesheet" type="text/css" href="css/details.css"/>
</head>
<body>
<H3>Meetthymate.com</H3>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
<!-- 	  <a class="navbar-brand" href="loggedin.jsp">Home</a> -->
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
			<tr>
				<td>Username:</td>
				<td>${user.userName}</td>
			</tr>
			<tr>
				<td>Profile Picture:</td>
				<td><img height="150" width="150" src="${user.photoName}"></td>
			</tr>
			<tr>
				<td>First Name:</td>
				<td>${user.firstName}</td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td>${user.lastName}</td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td>${user.gender}</td>
			</tr>
			<tr>
				<td>Email:</td>
				<td>${user.email}</td>
			</tr>
			<tr>
				<td>Role:</td>
				<td>${user.role}</td>
			</tr>
			<tr>
				<td>Apartment Number:</td>
				<td>${user.address.aptNo}</td>
			</tr>
			<tr>
				<td>Street:</td>
				<td>${user.address.street}</td>
			</tr>
			<tr>
				<td>City:</td>
				<td>${user.address.city}</td>
			</tr>
			<tr>
				<td>State:</td>
				<td>${user.address.state}</td>
			</tr>
			<tr>
				<td>Country:</td>
				<td>${user.address.country}</td>
			</tr>
			<tr>
				<td>Zipcode:</td>
				<td>${user.address.zip}</td>
			</tr>
		</table>
	</div>

</body>
</html>