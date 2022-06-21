<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>${client.prenom} ${client.nom}</title>
<link rel="stylesheet" type="text/css" href="../Style/MonStyle.css">
<link rel="icon" href="../Images/icon4.ico" />
<script src="../JS/1351.js"></script>
<script src="../JS/jquery-3.4.1.js"></script>
<style>
.my-form {
	width: 650px;
	margin-bottom: 100px;
}

.profile {
	width: 130px;
	height: 130px;
	border-radius: 50%;
	-webkit-border-radius: 50%;
	margin-bottom: 20px;
	margin-left: 215px;
	border: 5px solid #00ACEE;
}
</style>
</head>
<body>
<body style="background: linear-gradient(to right, #5b7380 0%, #28829e 50%, #5b7380 99%);">

	<!-- navbar -->
	<div id="nav-placeholder"></div>

	<!-- contenu -->
	<div id="contenu">

		<form class="my-form" action="modifieclient" method="get">

			<!-- form header -->
			<div class="form-header">
				<h1>${client.prenom} ${client.nom} (ID=${client.idClient})</h1> 
			</div>

			<!-- form body -->
			<div class="form-body">

				<img src="../Images/Client/${client.idClient}/${client.idClient}-1.jpg" alt="Pas de photo" class="profile">
				<div class="horizontal-group">
				<div class="form-group left" style="width:100%">
					<span style="margin-left: 230px" id="espace"></span> <a  href="/backoffice/prive/conversation?identifiant=${client.idClient}" style="background-color: #999">Contacter</a>
				</div>
				</div>
				<!-- Nom et Prenom -->
				<div class="horizontal-group">
					<div class="form-group left">
						<label for="nom" class="label-title">Nom :</label> <input type="text" id="nom" name="nom" class="form-input" value="${client.nom}" style="display: none;" /> 
						<label id="afnom" style="display: block; font-size: 20px; text-align: center;">${client.nom}</label>
					</div>
					<div class="form-group right">
						<label for="prenom" class="label-title">Prenom :</label> <input type="text" id="prenom" name="prenom" class="form-input" value="${client.prenom}" style="display: none;" /> 
						<label id="afprenom" style="display: block; font-size: 20px; text-align: center;">${client.prenom}</label>
					</div>
				</div>

				<!-- Num tel -->
				<div class="horizontal-group">
					<div class="form-group right">
						<label for="numtel" class="label-title">N° téléphone:</label> <input type="tel" id="numtel" name="numtel" class="form-input" value="${client.numtel}" pattern="[0-9]{2} [0-9]{3} [0-9]{3}" style="display: none;" /> <span class="validity"></span>
						<label id="afnumtel" style="display: block; font-size: 20px; text-align: center;">${client.numtel}</label>
					</div>
					<div class="form-group left">
						<label for="email" class="label-title">Email :</label> <input type="text" id="email" name="email" class="form-input" value="${client.email}" style="display: none;" /> 
						<label id="afemail" style="display: block; font-size: 20px; text-align: center;">${client.email}</label>
					</div>
				</div>

				<!-- Identifiant -->
				<div>
					<input type="hidden" name="idclient" value="${client.idClient}"><br>
				</div>

				<!-- Liste des visites -->
				<div class="form-group">
					<label for="mod5" class="label-title">Liste des favoris :</label>
					<table id="elements">
						<thead>
							<tr>
								<th>IdBien</th>
								<th>Descriptif</th>
								<th>Type</th>
								<th>Mode</th>
							</tr>
						<thead>
						<tbody>
							<c:forEach var="bien" items="${client.favoris}">
								<tr>
									<td><a class="aa" style="text-align: right;" href="descriptifbien?identifiant=${bien.idBien}">${bien.idBien}</a></td>
									<td>${bien.descriptif}</td>
									<td>${bien.typeBien}</td>
									<td>${bien.modeOffre}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

			<!-- form-footer -->
			<div class="form-footer">
				<div style="justify-content: left; display: flex;">
					<span style="margin-left: 240px" id="espace"></span> <a href="/backoffice/prive/chercherclient">Retour</a>
					<button type="submit" class="btn" style="display: none; margin: 0 10px;" id="enreg">Enregistrer</button>
					<button type="button" onclick="fonction1()" class="btn" style="display: block; margin: 0 10px;" id="mod">Modifier</button>
					<button type="button" onclick="fonction2()" class="btn">Supprimer</button>
				</div>
			</div>

		</form>
	</div>

	<!-- JavaScript -->
	<script>
		$(function() {
			$("#nav-placeholder").load("../navbar.html");
		});
		function fonction1() {
			input =["nom","prenom","numtel","email"];
			for (var i = 0; i < input.length; i++) {
				document.getElementById(input[i]).style.display = "block";
				document.getElementById("af" + input[i]).style.display = "none";
			}
			document.getElementById("enreg").style.display = "block";
			document.getElementById("mod").style.display = "none";
			document.getElementById("espace").style.marginLeft = "215px";
		}

		function fonction2() {
			if (confirm("Voulez-vous vraiment supprimer ce client?")) {
				window.alert("Ce client a été supprimé avec succès.");
				location.href = "/backoffice/prive/supprimeclient?idclient=${client.idClient}";
			}
		}
	</script>
</body>
</html>