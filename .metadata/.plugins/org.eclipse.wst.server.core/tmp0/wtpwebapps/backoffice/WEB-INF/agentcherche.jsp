<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="../JS/1351.js"></script>
<script src="../JS/jquery-3.4.1.js"></script>
<title>chercher un agent</title>
<link rel="stylesheet" href="../Style/MonStyle.css">
<link rel="icon" href="../Images/icon4.ico" />

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
		<form class="my-form" action="chercheragent" method="post">

			<!-- form header -->
			<div class="form-header">
				<h1>Chercher Agent</h1>
				<button type="submit" class="btn" style="display: none">Chercher</button>
			</div>
			<input type="hidden" id="regionn" value="${region}"><input type="hidden" id="sexen" value="${sexe}">

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

				<!-- sexe et region -->
				<div class="horizontal-group">
					<div class="form-group left">
						<label class="label-title">Sexe</label>
						<div class="input-group">
							<select name="sexe" id="sexe" class="form-input">
								<option selected value="">N'importe</option>
								<option value="Homme">Homme</option>
								<option value="Femme">Femme</option>
							</select>
						</div>
					</div>
					<div class="form-group right">
						<label for="region" class="label-title">Région</label> <select name="region" id="region" class="form-input">
							<option selected value="">N'importe</option>
							<option value="ariana">Ariana</option>
							<option value="béja">Béja</option>
							<option value="ben arous">Ben Arous</option>
							<option value="bizerte">Bizerte</option>
							<option value="gabés">Gabés</option>
							<option value="gafsa">Gafsa</option>
							<option value="jendouba">Jendouba</option>
							<option value="kairouan">Kairouan</option>
							<option value="el kasserine">El Kasserine</option>
							<option value="kébili">Kébili</option>
							<option value="le kef">Le Kef</option>
							<option value="mahdia">Mahdia</option>
							<option value="la manouba">La Manouba</option>
							<option value="médnine">Médnine</option>
							<option value="monastir">Monastir</option>
							<option value="nabeul">Nabeul</option>
							<option value="sfax">Sfax</option>
							<option value="sidi bouzid">Sidi Bouzid</option>
							<option value="siliana">Siliana</option>
							<option value="sousse">Sousse</option>
							<option value="tataouine">Tataouine</option>
							<option value="tozeur">Tozeur</option>
							<option value="tunis">Tunis</option>
							<option value="zaghouan">Zaghouan</option>
						</select>
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
							<th>IdAgent</th>
							<th>Nom</th>
							<th>Prenom</th>
							<th>NumTel</th>
							<th>Sexe</th>
							<th>Région</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="agent" items="${listeagent}">
							<tr>
								<td><a class="aa" style="text-align: right;" href="descriptifagent?identifiant=${agent.idAgent}">${agent.idAgent}</a></td>
								<td>${agent.nom}</td>
								<td>${agent.prenom}</td>
								<td>${agent.numTel}</td>
								<td>${agent.sexe}</td>
								<td>${agent.adress}</td>
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
	<script>
		$(function() {
			$("#nav-placeholder").load("../navbar.html");
		});
		var select = [ "region", "sexe" ];
		for (var j = 0; j < select.length; j++) {
			for (var i = 0; i < document.getElementById(select[j]).options.length; i++) {
				if (document.getElementById(select[j]).options[i].value == document
						.getElementById(select[j] + "n").value)
					document.getElementById(select[j]).options[i].selected = "true";
			}
		}
	</script>



</body>
</html>