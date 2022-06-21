<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="../JS/1351.js"></script>
<title>Programmer une visite</title>
<link rel="stylesheet" href="../Style/MonStyle.css">
<link rel="icon" href="../Images/icon4.ico" />
<script src="../JS/jquery-3.4.1.js"></script>
<style>
.my-form {
	width: 650px;
}

a.log {
	position: fixed;
	float: left;
	background: #222;
	border-radius: 3px 3px 3px 3px;
	height: 20px;
	top: 10px;
	right: 10px;
}
</style>
</head>
<body>

	<!-- navbar -->
	<div id="nav-placeholder"></div>

	<!-- contenu -->
	<div id="contenu">
		<form class="my-form">

			<!-- form header -->
			<div class="form-header">
				<h1>Programmer une visite</h1>
			</div>

			<!-- form body -->
			<div class="form-body" style="margin-bottom : 20px">
				<c:if test="${test=='faux'}">
					<label id="message" style="display: block; font-size: 19px; text-align: center;" >${message}</label>
					<label id="message0" style="display: block; font-size: 19px; text-align: center;" >${message0}</label>
				</c:if>
				<c:if test="${test=='vrai'}">
					<label id="message1" style="display: block; font-size: 19px; text-align: center;" >${message1}</label>
					<label id="message2" style="display: block; font-size: 19px; text-align: center;" >${message2}</label>
					<label id="message3" style="display: block; font-size: 19px; text-align: center;" >${message3}</label>
				</c:if>
			</div>
			<!-- form-footer -->
			<div class="form-footer">
				<a href="home">Retour</a>
				<c:if test="${test=='faux'}">
					<a href="ajoutervisite" style="background-color: rgb(7, 145, 255);">Ressayer</a>
				</c:if>
			</div>

		</form>

	</div>

	<!-- javascript -->
	<script>
		$(function() {
			$("#nav-placeholder").load("../navbar.html");
		});
	</script>
</body>
</html>