<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="../JS/1351.js"></script>
<title>Chercher un client</title>
<link rel="stylesheet" href="../Style/MonStyle.css">
<link rel="icon" href="../Images/icon4.ico" />
<script src="../JS/jquery-3.4.1.js"></script>

<style>
.my-form {
	width: 650px;
}
</style>
</head>
<body>

	<!-- navbar -->
	<div id="nav-placeholder"></div>

	<!-- contenu -->
	<div id="contenu">
		<form class="my-form" action="chercherclient" method="post">

			<!-- form header -->
			<div class="form-header">
				<h1>Chercher Client</h1>
				<button type="submit" class="btn" style="display: none">Chercher</button>
			</div>

			<!-- form body -->
			<div class="form-body">

				<!-- nom et prenom -->
				<div class="horizontal-group">
					<div class="form-group left">
						<label for="nom" class="label-title">Nom</label> <input type="text" id="nom" class="form-input" name="nom" placeholder="nom" value="${nom}" />
					</div>
					<div class="form-group right">
						<label for="prenom" class="label-title">Prenom</label> <input type="text" id="prenom" class="form-input" name="prenom" placeholder="prenom " value="${prenom}" />
					</div>
				</div>

				<!-- Numpriv et Numtrav -->
				<div class="horizontal-group">
					<div class="form-group left">
						<label for="numtel" class="label-title">N° téléphone </label> <input type="tel" id="numtel" name="numtel" class="form-input" placeholder="numtel" value="${numtel}" /> 
					</div>
					<div class="form-group right">
						<label for="email" class="label-title">Email </label> <input type="tel" id="email" name="email" class="form-input" placeholder="email" value="${email}" />
					</div>
				</div>

				<!-- identifiant -->
				<div class="horizontal-group">
					<div class="form-group right" style="margin-left: auto; margin-right: auto">
						<button type="submit" class="btn" style="width: 100%; margin-top: 15px">Chercher</button>
					</div>
					<div class="form-group left">
						<div class="form-group left">
							<label for="de" class="label-title">Identifiant</label> <input type="text" id="de" name="de" class="form-input" placeholder="de" value="${de}" />
						</div>
						<div class="form-group right">
							<label for="vers" class="label-title" style="visibility: hidden;">id</label> <input type="text" id="vers" name="vers" class="form-input" placeholder="à" value="${vers}" />
						</div>
					</div>
				</div>

				<!-- Table -->
				<table id="elements" style="cellspacing: 0">
					<thead>
						<tr>
							<th>Id</th>
							<th>Nom</th>
							<th>Prenom</th>
							<th>Numtel</th>
							<th>Email</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="client" items="${listeclient}">
							<tr>
								<td><a class="aa" style="text-align: right;" href="descriptifclient?identifiant=${client.idClient}">${client.idClient}</a></td>
								<td style="white-space: nowrap;">${client.nom}</td>
								<td style="white-space: nowrap;">${client.prenom}</td>
								<td style="white-space: nowrap;">${client.numtel}</td>
								<td style="white-space: nowrap;">${client.email}</td>
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