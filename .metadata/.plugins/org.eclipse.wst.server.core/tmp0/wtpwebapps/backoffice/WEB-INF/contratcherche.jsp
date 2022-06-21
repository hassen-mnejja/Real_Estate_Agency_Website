<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="../JS/1351.js"></script>
<title>Chercher un contrat</title>
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
		<form class="my-form" action="cherchercontrat" method="post">

			<!-- form header -->
			<div class="form-header">
				<h1>Chercher Contrat</h1>
				<button type="submit" class="btn" style="display: none">Chercher</button>
			</div>

			<!-- form body -->
			<div class="form-body">

				<!-- idcontrat, pmin et pmax -->
				<div class="horizontal-group">
					<div class="form-group left">
						<label for="numcontrat" class="label-title">Numero du Contrat</label> <input type="number" id="numcontrat" class="form-input" name="numcontrat" placeholder="Numero" value="${numcontrat}" />
					</div>
					<div class="form-group right" style="margin-bottom: 0">
						<div class="form-group left">
							<label for="pmin" class="label-title">Prix min</label> <input type="number" id="pmin" name="pmin" class="form-input" placeholder="en DT"  value="${pmin}" />
						</div>
						<div class="form-group right">
							<label for="pmax" class="label-title">Prix max</label> <input type="number" id="pmax" name="pmax" class="form-input" placeholder="en DT"  value="${pmax}" />
						</div>
					</div>
				</div>
				
				<!-- datemin et datemax -->
				<div class="horizontal-group">
					<div class="form-group left">
						<label for="datemin" class="label-title">Depuis</label> <input type="date" id="datemin" name="datemin" class="form-input" placeholder="en DT"  value="${datemin}" />
					</div>
					<div class="form-group right">
						<label for="datemax" class="label-title">Jusqu'à</label> <input type="date" id="datemax" name="datemax" class="form-input" placeholder="en DT"  value="${datemax}" />
					</div>
				</div>

				<!-- idbien et idclient -->
				<div class="horizontal-group">
					<div class="form-group right" style="margin-left: auto; margin-right: auto">
						<button type="submit" class="btn" style="width: 100%; margin-top: 15px">Chercher</button>
					</div>
					<div class="form-group left" style="margin-bottom: 0">
						<div class="form-group left">
							<label for="idbien" class="label-title">ID Bien</label> <input type="number" id="idbien" class="form-input" name="idbien" placeholder="ID" value="${idbien}" />
						</div>
						<div class="form-group right">
							<label for="idclient" class="label-title">ID Client</label> <input type="number" id="idclient" class="form-input" name="idclient" placeholder="ID" value="${idclient}" />
						</div>
					</div>
				</div>

				<!-- Table -->
				<table id="elements" style="cellspacing: 0">
					<thead>
						<tr>
							<th>NumContrat</th>
							<th>IdBien</th>
							<th>IdClient</th>
							<th>Prix</th>
							<th>Date</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="contrat" items="${listecontrat}">
							<tr>
								<td><a class="aa" style="text-align: right;" href="descriptifcontrat?identifiant=${contrat.numContrat}">${contrat.numContrat}</a></td>
								<td><a class="aa" style="text-align: right;" href="descriptifbien?identifiant=${contrat.bien.idBien}">${contrat.bien.idBien}</a></td>
								<td><a class="aa" style="text-align: right;" href="descriptifclient?identifiant=${contrat.client.idClient}">${contrat.client.idClient}</a></td>
								<td>${contrat.prix}</td>
								<td>${contrat.date}</td>
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