<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>${prop.prenom}${prop.nom}</title>
<link rel="stylesheet" type="text/css" href="../Style/MonStyle.css">
<link rel="icon" href="../Images/icon4.ico" />
<script src="../JS/1351.js"></script>
<script src="../JS/jquery-3.4.1.js"></script>
<style>
.my-form {
	width: 700px;
	margin-bottom: 100px;
}
</style>
</head>
<body>
<body>

	<!-- navbar -->
	<div id="nav-placeholder"></div>

	<!-- contenu -->
	<div id="contenu">
		<form class="my-form" action="modifieprop" method="get">

			<!-- form header -->
			<div class="form-header">
				<h1>${prop.prenom}${prop.nom} (ID=${prop.idProp})</h1>
			</div>

			<!-- form body -->
			<div class="form-body">

				<!-- Nom et Prenom -->
				<div class="horizontal-group">
					<div class="form-group left">
						<label for="mod1" class="label-title">Nom :</label> <input type="text" id="mod1" name="nom" class="form-input" value="${prop.nom}" style="display: none;" /> <label id="af1" style="display: block; font-size: 20px;">${prop.nom}</label>
					</div>
					<div class="form-group right">
						<label for="mod2" class="label-title">Prenom :</label> <input type="text" id="mod2" name="prenom" class="form-input" value="${prop.prenom}" style="display: none;" /> <label id="af2" style="display: block; font-size: 20px;">${prop.prenom}</label>
					</div>
				</div>

				<!-- Num tel -->
				<div class="horizontal-group">
					<div class="form-group left">
						<label for="mod3" class="label-title">N° tel privé :</label> <input type="tel" id="mod3" name="numpriv" class="form-input" value="${prop.numPriv}" pattern="[0-9]{2} [0-9]{3} [0-9]{3}" style="display: none;" /> <span class="validity"></span>
						<label id="af3" style="display: block; font-size: 20px;">${prop.numPriv}</label>
					</div>
					<div class="form-group right">
						<label for="mod4" class="label-title">N° tel de travail :</label> <input type="tel" id="mod4" name="numtrav" class="form-input" value="${prop.numTrav}" pattern="[0-9]{2} [0-9]{3} [0-9]{3}" style="display: none;" /> <span
							class="validity"
						></span> <label id="af4" style="display: block; font-size: 20px;">${prop.numTrav}</label>
					</div>
				</div>

				<!-- Numero de tarvail -->
				<fieldset>
					<legend style="font-size: 17px; font-weight: bold;"> Le numéro de travail est disponible : </legend>
					<div class="horizontal-group">
						<div class="form-group left">
							<label for="mod5" class="label-title">De :</label> <input type="time" id="mod5" name="debutdispo" class="form-input" value="${prop.debutDispo}" style="display: none;"> <label id="af5" style="display: block; font-size: 20px;">${prop.debutDispo}</label>
						</div>
						<div class="form-group right">
							<label for="mod6" class="label-title">Vers :</label> <input type="time" id="mod6" name="findispo" class="form-input" value="${prop.finDispo}" style="display: none;"> <label id="af6" style="display: block; font-size: 20px;">${prop.finDispo}</label>
						</div>
					</div>
				</fieldset>

				<!-- Identifiant -->
				<div>
					<input type="hidden" name="idprop" value="${prop.idProp}"><br>
				</div>

				<!-- Adresse -->
				<div class="form-group">
					<div class="horizontal-group">
						<label for="mod7" class="label-title">Adresse :</label>
						<textarea class="form-input" id="mod7" name="adress" rows="4" cols="25" style="height: auto; display: none;">${prop.adress}</textarea>
						<label id="af7" style="display: block; font-size: 20px;">${prop.adress}</label>
					</div>
				</div>

				<!-- Liste des biens -->
				<div class="form-group">
					<label for="mod5" class="label-title">Liste des biens qu'il possède :</label>
					<table id="elements">
						<thead>
							<tr>
								<th>Id</th>
								<th>ModeOffre</th>
								<th>TypeBien</th>
								<th>Region</th>
								<th>Délégation</th>
								<th>Statut</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="bien" items="${listebien}">
								<tr>
									<td><a class="aa" style="text-align: right;" href="descriptifbien?identifiant=${bien.idBien}">${bien.idBien}</a></td>
									<td>${bien.modeOffre}</td>
									<td>${bien.typeBien}</td>
									<td>${bien.region}</td>
									<td>${bien.delegation}</td>
									<td>${bien.statut}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

			<!-- form-footer -->
			<div class="form-footer">
				<div style="justify-content: center; display: flex;">
					<span style="margin-left: 290px" id="espace"></span> <a href="/backoffice/prive/chercherprop">Retour</a>
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
			for (var i = 1; i < 8; i++) {
				document.getElementById("mod" + i).style.display = "block";
				document.getElementById("af" + i).style.display = "none";
			}
			document.getElementById("enreg").style.display = "block";
			document.getElementById("mod").style.display = "none";
			document.getElementById("espace").style.marginLeft = "265px";
		}

		function fonction2() {
			if (confirm("Voulez-vous vraiment supprimer ce propriètaire?")) {
				window.alert("Ce propriètaire a été supprimé avec succès.");
				location.href = "/backoffice/prive/supprimeproprietaire?idprop=${prop.idProp}";
			}
		}
	</script>
</body>
</html>