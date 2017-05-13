<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Page</title>
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
				<li><a href="adminPage.htm?data=${user.userName }">Home</a></li>
				<li><a href="logout.htm">Logout</a></li>
			</ul>
    </div>
  </div>
	</nav>
	<div class="container">
			<form name='deleteAccounts' method='post'
				action='deleteAccounts.htm'>
				<table class="table" border="1" cellpadding="5" cellspacing="5">
					<tr>
						<td><b>Username</b></td>
						<td><b>Delete Account?</b></td>
						
					</tr>
					<c:forEach var="acc" items="${accountList}">
						<tr>
							<td>${acc.userName}</td>
							<td><input type='checkbox' name='username'
								value='${acc.userName}'> Delete</td>

						</tr>
					</c:forEach>
					<TR>
						<TD COLSPAN='6' ALIGN='center'><input type='submit'
							value='Delete Selected Accounts'></TD>
					</TR>
				</table>

			</form>
		</div>

</body>
</html>