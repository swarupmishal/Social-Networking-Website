<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Messages</title>
<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/loggedin.css"/>
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
	<CENTER>
		<div class="container">
			<form name= method='post' action='reply.htm'>
			<table class="table" border="1" cellpadding="5" cellspacing="5">
					<tr>
						<td><b>Message from</b></td>
						<td><b>Message</b></td>
						<td><b>Converse?</b></td>
						<td><b>Delete Message?</b></td>
						
					</tr>
					<c:forEach var="msg" items="${messageList}">
						<tr>
							<td>${msg.sender}</td>
							<td>${msg.message}</td>
							<td>
							<form name= method='post' action='reply.htm'>
							<input type="hidden" name="replyID" value="${msg.messageID}"/>
							<input type='submit' value='Reply'>
							</form>
							</td>
							<td>
							<form name= method='post' action="deleteMessage.htm">
							<input type="hidden" name="deleteID" value="${msg.messageID}"/>
							<input type='submit' value='Delete'>
							</form>
							</td>

						</tr>
					</c:forEach>
					
				</table>
			</form>
		</div>
	</CENTER>
</body>
</html>