<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Meetthymate.com</title>
<link rel="stylesheet" type="text/css" href="css/index.css" />
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script>
	$(document)
			.ready(
					function() {
						$("#login")
								.click(
										function() {

											var user = $("#user").val();
											var password = $("#password").val();
											// 			alert(user);
											// 			alert(password);
											$
													.ajax({
														type : "POST",
														url : "login.htm",
														data : {
															user : user,
															password : password
														},
														success : function(
																response) {
															if (response == "Wrong credentials! Please login with proper credentials!!!") {
																$("#result1")
																		.html(
																				response);
															} else {
																window.location.href = "userLoggedIn.htm";
															}

														}
													});
										});
					});

	$(document).ready(function() {
		$("#toggle").click(function() {
			$("#myCarousel").slideToggle();
		});
	});
</script>
</head>

<body>



	<div class="container">
		<div class="jumbotron">
			<h1>Meet thy Mate</h1>
			<p>If you are searching for your true soulmate, you are in the
				right place!!</p>
			<button id="toggle" class="btn btn-primary btn-block">See
				people who's lives changed after meeting up at meetthymate.com</button>
			<div id="myCarousel" class="carousel slide" data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
					<li data-target="#myCarousel" data-slide-to="3"></li>
				</ol>
				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<img src="images/car1.jpg" alt="Chania" width="100%" height="auto">
						<div class="carousel-caption">
							<h3>Many people have met each other because of our website!!</h3>
						</div>
					</div>

					<div class="item">
						<img src="images/car2.jpg" alt="Chania" width="100%" height="auto">
						<div class="carousel-caption">
							<h3>Many more meeting each day!!</h3>

						</div>
					</div>

					<div class="item">
						<img src="images/car3.jpg" alt="Flower" width="100%" height="auto">
						<div class="carousel-caption">
							<h3>Finding your partner is no more difficult now!!</h3>

						</div>
					</div>

					<div class="item">
						<img src="images/car4.jpg" alt="Flower" width="100%" height="auto">
						<div class="carousel-caption">
							<h3>Beautiful people with their beautiful lives!!</h3>

						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4">
			
			<c:choose>
            <c:when test="${!empty sessionScope.user}">
                <c:redirect url="userLoggedIn.htm"></c:redirect>                    
            </c:when>
            <c:otherwise>
				<form method='POST' action='login.htm'>
					<div class="font">User Name:</div>
					<input id="user" type=text name="user" size="20" tabindex="1"
						class="form-control" required><br>
					<div class="font">Password:&nbsp;&nbsp;</div>
					<input id="password" type=password name="password" size="20"
						tabindex="2" class="form-control" required><br> <span
						id="result1"></span><br> 
					<br />
					<div class="button">
						<input type="button" id="login" value="Login" size="20"
							tabindex="3" class="btn btn-info"> <br>
						<br>
						<br>
					</div>
				</form>
				</c:otherwise>
        </c:choose>

				<div class="font">
					Coming here for the first time?<br>
				</div>
				<div class="font">
					Signing up takes two minutes and is totally free.<br>
				</div>
				<a class="btn btn-primary" href="register.htm">Sign Up</a>


			</div>

		</div>
	</div>


</body>
</html>