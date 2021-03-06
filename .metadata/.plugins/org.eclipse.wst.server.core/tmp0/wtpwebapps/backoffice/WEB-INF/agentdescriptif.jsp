<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>${agent.prenom}${agent.nom}</title>
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

		<form class="my-form" action="modifieagent" method="get">

			<!-- form header -->
			<div class="form-header">
				<h1>${agent.prenom}${agent.nom} (ID=${agent.idAgent})</h1>
			</div>

			<!-- form body -->
			<div class="form-body">

				<img src="../Images/Agent/${agent.idAgent}/${agent.idAgent}-1.jpg" alt="Pas de photo" class="profile">

				<!-- Nom et Prenom -->
				<div class="horizontal-group">
					<div class="form-group left">
						<label for="mod1" class="label-title">Nom :</label> <input type="text" id="mod1" name="nom" class="form-input" value="${agent.nom}" style="display: none;" /> <label id="af1" style="display: block; font-size: 20px; text-align: center;">${agent.nom}</label>
					</div>
					<div class="form-group right">
						<label for="mod2" class="label-title">Prenom :</label> <input type="text" id="mod2" name="prenom" class="form-input" value="${agent.prenom}" style="display: none;" /> <label id="af2" style="display: block; font-size: 20px; text-align: center;">${agent.prenom}</label>
					</div>
				</div>

				<!-- Num tel -->
				<div class="horizontal-group">
					<div class="form-group right">
						<label for="mod3" class="label-title">N° téléphone:</label> <input type="tel" id="mod3" name="numtel" class="form-input" value="${agent.numTel}" pattern="[0-9]{2} [0-9]{3} [0-9]{3}" style="display: none;" /> <span class="validity"></span>
						<label id="af3" style="display: block; font-size: 20px; text-align: center;">${agent.numTel}</label>
					</div>
					<div class="form-group left">
						<label for="mod4" class="label-title">Région :</label> <select name="region" id="mod4" class="form-input" required="required" style="display: none">
							<option value="${agent.adress}" selected>${agent.adress}</option>
							<option value="Ariana">Ariana</option>
							<option value="Beja">Béja</option>
							<option value="Ben Arous">Ben Arous</option>
							<option value="Bizerte">Bizerte</option>
							<option value="Gabes">Gabés</option>
							<option value="Gafsa">Gafsa</option>
							<option value="Jendouba">Jendouba</option>
							<option value="Kairouan">Kairouan</option>
							<option value="El Kasserine">El Kasserine</option>
							<option value="Kebili">Kébili</option>
							<option value="Le Kef">Le Kef</option>
							<option value="Mahdia">Mahdia</option>
							<option value="La Manouba">La Manouba</option>
							<option value="Mednine">Médnine</option>
							<option value="Monastir">Monastir</option>
							<option value="Nabeul">Nabeul</option>
							<option value="Sfax">Sfax</option>
							<option value="Sidi Bouzid">Sidi Bouzid</option>
							<option value="Siliana">Siliana</option>
							<option value="Sousse">Sousse</option>
							<option value="Tataouine">Tataouine</option>
							<option value="Tozeur">Tozeur</option>
							<option value="Tunis">Tunis</option>
							<option value="Zaghouan">Zaghouan</option>
						</select> <span class="validity"></span> <label id="af4" style="display: block; font-size: 20px; text-align: center;">${agent.adress}</label>
					</div>
				</div>

				<!-- Identifiant -->
				<div>
					<input type="hidden" name="idagent" value="${agent.idAgent}"><br>
				</div>

				<!-- Liste des visites -->
				<div class="form-group">
					<label for="mod5" class="label-title">Liste des visites programmés :</label>
					<table id="elements">
						<thead>
							<tr>
								<th>IdVisite</th>
								<th>IdBien</th>
								<th>IdClient</th>
								<th>Date</th>
								<th>Debut</th>
								<th>Fin</th>
							</tr>
						<thead>
						<tbody>
							<c:forEach var="visite" items="${listevisite}">
								<tr>
									<td><a class="aa" style="text-align: right;" href="descriptifvisite?identifiant=${visite.idVisite}">${visite.idVisite}</a></td>
									<td><a class="aa" style="text-align: right;" href="descriptifbien?identifiant=${visite.bien.idBien}">${visite.bien.idBien}</td>
									<td><a class="aa" style="text-align: right;" href="descriptifclient?identifiant=${visite.client.idClient}">${visite.client.idClient}</td>
									<td>${visite.date}</td>
									<td>${visite.heured}</td>
									<td>${visite.heuref}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

			<!-- form-footer -->
			<div class="form-footer">
				<div style="justify-content: left; display: flex;">
					<span style="margin-left: 240px" id="espace"></span> <a href="/backoffice/prive/chercheragent">Retour</a>
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
			for (var i = 1; i < 5; i++) {
				document.getElementById("mod" + i).style.display = "block";
				document.getElementById("af" + i).style.display = "none";
			}
			document.getElementById("enreg").style.display = "block";
			document.getElementById("mod").style.display = "none";
			document.getElementById("espace").style.marginLeft = "215px";
		}

		function fonction2() {
			if (confirm("Voulez-vous vraiment supprimer cet agent?")) {
				window.alert("Cet agent a été supprimé avec succès.");
				location.href = "/backoffice/prive/supprimeagent?idagent=${agent.idAgent}";
			}
		}
	</script>
</body>
</html>