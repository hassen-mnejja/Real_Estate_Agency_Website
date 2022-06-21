<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="../JS/1351.js"></script>
<title>Chercher une visite</title>
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
		<form class="my-form" action="cherchervisite" method="post">

			<!-- form header -->
			<div class="form-header">
				<h1>Chercher Visite</h1>
				<button type="submit" class="btn" style="display: none">Chercher</button>
			</div>

			<!-- form body -->
			<div class="form-body">

				<!-- idcontrat, pmin et pmax -->
				<div class="horizontal-group">
					<div class="form-group left">
						<label for="idagent" class="label-title">ID Agent</label> <input type="number" id="idagent" class="form-input" name="idagent" placeholder="Agent" value="${idagent}" />
					</div>
					<div class="form-group right">
						<label for="idclient" class="label-title">ID Client</label> <input type="number" id="idclient" name="idclient" class="form-input" placeholder="Client"  value="${idclient}" />
					</div>
				</div>
				
				<!-- datemin et datemax -->
				<div class="horizontal-group">
					<div class="form-group left">
						<label for="datemin" class="label-title">Depuis</label> <input type="date" id="datemin" name="datemin" class="form-input" value="${datemin}" />
					</div>
					<div class="form-group right">
						<label for="datemax" class="label-title">Jusqu'à</label> <input type="date" id="datemax" name="datemax" class="form-input" value="${datemax}" />
					</div>
				</div>

				<!-- idbien et idclient -->
				<div class="horizontal-group">
					<div class="form-group right" style="margin-left: auto; margin-right: auto">
						<button type="submit" class="btn" style="width: 100%; margin-top: 15px">Chercher</button>
					</div>
					<div class="form-group left">
						<label for="idbien" class="label-title">ID Bien</label> <input type="number" id="idbien" class="form-input" name="idbien" placeholder="Bien" value="${idbien}" />
					</div>
				</div>

				<!-- Table -->
				<table id="elements" style="cellspacing: 0">
					<thead>
						<tr>
							<th>ID</th>
							<th>Agent</th>
							<th>Bien</th>
							<th>Client</th>
							<th>Date</th>
							<th>Debut</th>
							<th>Fin</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="visite" items="${listevisite}">
							<tr>
								<td><a class="aa" style="text-align: right;" href="descriptifvisite?identifiant=${visite.idVisite}">${visite.idVisite}</a></td>
								<td><a class="aa" style="text-align: right;" href="descriptifagent?identifiant=${visite.agent.idAgent}">${visite.agent.idAgent}</a></td>
								<td><a class="aa" style="text-align: right;" href="descriptifbien?identifiant=${visite.bien.idBien}">${visite.bien.idBien}</a></td>
								<td><a class="aa" style="text-align: right;" href="descriptifclient?identifiant=${visite.client.idClient}">${visite.client.idClient}</a></td>
								<td>${visite.date}</td>
								<td>${visite.heured}</td>
								<td>${visite.heuref}</td>
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