<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register User</title>
<script language="JavaScript" src="javascript/matchnet.js"></script>
	<script language="JavaScript" src="javascript/region3.js"></script>
	<script language="JavaScript" src="im/im.js"></script>
	<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/register_01.css"/>
	<link rel="stylesheet" type="text/css" href="lib/css/as.css">
</head>
<body>
<div class="container">
<br><br><br>
<a href="goToIndex.htm" style="color: white">Want to Login instead?</a>
<form:form action="register02.htm" commandName="user" method="post" enctype="multipart/form-data">
<table class="table">
<tr>
    <td>First Name:</td>
    <td><form:input path="firstName" size="30" /> <font color="red"><form:errors path="firstName"/></font></td>
</tr>
<tr>
    <td>Last Name:</td>
    <td><form:input path="lastName" size="30" /> <font color="red"><form:errors path="lastName"/></font></td>
</tr>


<tr>
    <td>User Name:</td>
    <td><form:input path="userName" size="30" /> <font color="red"><form:errors path="userName"/></font></td>
</tr>

<tr>
 <td>Gender:</td>
 <td>
 <form:radiobutton path="gender" value="Male" label="Male"/>
 <form:radiobutton path="gender" value="Female" label="Female"/>
 </td>
</tr>

<tr>
    <td>Password:</td>
    <td><form:password path="userPassword" size="30" /> <font color="red"><form:errors path="userPassword"/></font></td>
</tr>

 <tr>
    <td>Email Id:</td>
    <td><form:input path="email" size="30" /> <font color="red"><form:errors path="email"/></font></td>
</tr> 

<tr>
    <td>Phone Number:</td>
    <td><form:input path="phone" size="30" /> <font color="red"><form:errors path="phone"/></font></td>
</tr>

<tr>
    <td>Street Name:</td>
    <td><form:input path="address.street" size="30" /> <font color="red"><form:errors path="address.street"/></font></td>
</tr>
<tr>
    <td>Apartment Number:</td>
    <td><form:input path="address.aptNo" size="30" /> <font color="red"><form:errors path="address.aptNo"/></font></td>
</tr>


<tr>
    <td>City:</td>
    <td><form:input path="address.city" size="30" /> <font color="red"><form:errors path="address.city"/></font></td>
</tr>

<tr>
    <td>State:</td>
    <td><form:input path="address.state" size="30" /> <font color="red"><form:errors path="address.state"/></font></td>
</tr>

 <tr>
    <td>Country:</td>
    <td><form:input path="address.country" size="30" /> <font color="red"><form:errors path="address.country"/></font></td>
</tr> 

 <tr>
    <td>Zip:</td>
    <td><form:input path="address.zip" size="30" /> <font color="red"><form:errors path="address.zip"/></font></td>
</tr> 

  
<!-- <tr> -->
<!--  <td>Role:</td> -->
<!--  <td> -->
<%--  <form:radiobutton path="role" value="User" label="User"/> --%>
<%--  <form:radiobutton path="role" value="Admin" label="Admin"/> --%>
<!--  </td> -->
<!-- </tr> -->

<tr>
    <td>Profile Photo:</td>
    <td><form:input path="profilePic" type="file" /> <font color="red"><form:errors path="profilePic"/></font></td>
</tr>

<tr>
    <td colspan="2"><input type="submit" value="Sign Up" /></td>
</tr>
</table>
</form:form>


</div>
</body>
</html>