<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="../JS/1351.js"></script>
<title>Chercher un propriétaire</title>
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
		<form class="my-form" action="chercherprop" method="post">

			<!-- form header -->
			<div class="form-header">
				<h1>Chercher Propriétaire</h1>
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

				<!-- Numpriv et Numtrav -->
				<div class="horizontal-group">
					<div class="form-group left">
						<label for="numpriv" class="label-title">N° tel privé</label> <input type="tel" id="numpriv" name="numpriv" class="form-input" placeholder="xx xxx xxx" pattern="[0-9]{2} [0-9]{3} [0-9]{3}" value="${numpriv}" /> <span class="validity"></span>
					</div>
					<div class="form-group right">
						<label for="numtrav" class="label-title">N° tel de travail</label> <input type="tel" id="numtrav" name="numtrav" class="form-input" placeholder="xx xxx xxx" pattern="[0-9]{2} [0-9]{3} [0-9]{3}" value="${numtrav}" />
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
							<th>NumPriv</th>
							<th>NumTrav</th>
							<th>Adress</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="prop" items="${listeprop}">
							<tr>
								<td><a class="aa" style="text-align: right;" href="descriptifprop?identifiant=${prop.idProp}">${prop.idProp}</a></td>
								<td style="white-space: nowrap;">${prop.nom}</td>
								<td style="white-space: nowrap;">${prop.prenom}</td>
								<td style="white-space: nowrap;">${prop.numPriv}</td>
								<td style="white-space: nowrap;">${prop.numTrav}</td>
								<td>${prop.adress}</td>
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