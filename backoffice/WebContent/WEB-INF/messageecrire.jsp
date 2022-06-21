<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="../JS/1351.js"></script>
<title>Ecrire un message</title>
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
		<form class="my-form" action="ecriremessage" method="post">

			<!-- form header -->
			<div class="form-header">
				<h1>Nouveau Message</h1>
			</div>

			<!-- form body -->
			<div class="form-body">

				<!-- Nom et Prenom -->
				<div class="horizontal-group">
					<div class="form-group left">
						<label for="nom" class="label-title">Client *</label> <select id="idclient" name="idclient" class="form-input" required="required">
							<option disabled selected value="">-- Choisir --</option>
							<c:forEach var="client" items="${clients}">
								<option value="${client.idClient}">${client.idClient} : ${client.nom} ${client.prenom}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group right">
						<svg style="width:400px; height:75px">
 							 <rect width="300" height="70" style="fill:rgba(0,0,0,0);" />
						</svg>
					</div>
				</div>
				<input type="hidden" id="temps" class="form-input" name="temps" />
				<!-- Adresse -->
				<div class="form-group">
					<br> <label for="adress" class="label-title">Message *</label>
					<textarea class="form-input" name="message" rows="8" cols="50" style="height: auto" required="required"></textarea>
				</div>
			</div>

			<!-- form-footer -->
			<div class="form-footer">
				<span>* obligatoire</span> <a href="home">Retour</a>
				<button type="submit" class="btn">Envoyer</button>
			</div>

		</form>

	</div>

	<!-- javascript -->
	<script>
		$(function() {
			$("#nav-placeholder").load("../navbar.html");
		});
		window.addEventListener('load', () => {
			  const now = new Date();
			  now.setMinutes(now.getMinutes() - now.getTimezoneOffset());
			  document.getElementById('temps').value = now.toISOString().slice(0, -8);
			});
	</script>
</body>
</html>