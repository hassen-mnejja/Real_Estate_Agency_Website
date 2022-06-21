<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="../JS/1351.js"></script>
<title>Boite de Message</title>
<link rel="stylesheet" href="../Style/MonStyle.css">
<link rel="icon" href="../Images/icon4.ico" />
<script src="../JS/jquery-3.4.1.js"></script>

<style>
.my-form {
	width: 650px;
	margin-bottom: 100px;
}
</style>
</head>
<body>

	<!-- navbar -->
	<div id="nav-placeholder"></div>

	<!-- contenu -->
	<div id="contenu">
		<form class="my-form" action="boitemessage" method="post">

			<!-- form header -->
			<div class="form-header">
				<h1>Boite Message</h1>
				<button type="submit" class="btn" style="display: none">Chercher</button>
			</div>

			<!-- form body -->
			<div class="form-body">

				<!-- nom et prenom -->
				<div class="horizontal-group">
					<div class="form-group left">
						<label for="nom" class="label-title">Nom</label> <input type="text" id="nom" class="form-input" name="nom" placeholder="saisir le nom" value="${nom}" />
					</div>
					<div class="form-group right">
						<label for="prenom" class="label-title">Prenom</label> <input type="text" id="prenom" class="form-input" name="prenom" placeholder="saisir le prenom " value="${prenom}" />
					</div>
				</div>
				
				<!-- nom et prenom -->
				<div class="horizontal-group">
					<div class="form-group left">
						<label for="datemin" class="label-title">Depuis</label> <input type="datetime-local" id="datemin" class="form-input" name="datemin" placeholder="saisir le nom" value="${nom}" />
					</div>
					<div class="form-group right">
						<label for="datemax" class="label-title">Jusqu'à</label> <input type="datetime-local" id="datemax" class="form-input" name="datemax" placeholder="saisir le prenom " value="${prenom}" />
					</div>
				</div>

				<!-- identifiant -->
				<div class="horizontal-group">
					<div class="form-group right" style="margin-left: auto; margin-right: auto">
						<button type="submit" class="btn" style="width: 100%; margin-top: 15px">Chercher</button>
					</div>
					<div class="form-group left">
						<label for="idclient" class="label-title">Identifiant</label> <input type="number" id="idclient" name="idclient" class="form-input" placeholder="ID" value="${idclient}" />
					</div>
				</div>

				<!-- Table -->
				<table id="elements" style="cellspacing: 0">
					<thead>
						<tr>
							<th>ID</th>
							<th>Nom</th>
							<th>Prenom</th>
							<th >Message</th>
							<th>Date</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="message" items="${listemessage}">
							<tr>
								<td><a class="aa" style="text-align: right;" href="conversation?identifiant=${message.idEnv}">${message.idEnv}</a></td>
								<td style="white-space: nowrap;"><a class="aa" style="text-align: right;" href="conversation?identifiant=${message.idEnv}">${message.client.nom}</a></td>
								<td style="white-space: nowrap;"><a class="aa" style="text-align: right;" href="conversation?identifiant=${message.idEnv}">${message.client.prenom}</a></td>
								<c:if test="${message.mess.length()>25}">
									<td style="white-space: nowrap;">${message.mess.substring(0,25)}...</td>
								</c:if>
								<c:if test="${message.mess.length()<=25}">
									<td style="white-space: nowrap;">${message.mess}</td>
								</c:if>
								<td style="white-space: nowrap;">${message.temps.substring(0,16)}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<!-- form-footer -->
			<div class="form-footer">
				<a href="home">Retour</a>

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