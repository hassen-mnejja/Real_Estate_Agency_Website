<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>${contrat.numContrat}</title>
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
		<form class="my-form" action="ajoutercontrat" method="post">

			<!-- form header -->
			<div class="form-header">
				<h1>Contrat n° ${contrat.numContrat}</h1>
			</div>

			<!-- form body -->
			<div class="form-body">
			<label for="numcontratn" class="label-title"></label> <input type="number" id="numcontratn" name="numcontratn" class="form-input" value="${contrat.numContrat}" style="display: none;" /> 
			<label for="idclientn" class="label-title"></label> <input type="number" id="idclientn" name="idclientn" class="form-input" value="${contrat.client.idClient}" style="display: none;" /> 
			<label for="idbienn" class="label-title"></label> <input type="number" id="idbienn" name="idbienn" class="form-input" value="${contrat.bien.idBien }" style="display: none;" /> 
				<!-- Nom et Prenom -->
				<div class="horizontal-group">
					<div class="form-group left" style="width:100%">
						<label for="numcontrat" class="label-title">Numero du Contrat :</label> <input type="number" id="numcontrat" name="numcontrat" class="form-input" value="${contrat.numContrat}" style="display: none;" /> 
						<label id="afnumcontrat" style="display: block; font-size: 20px;">${contrat.numContrat}</label>
					</div>
				</div>
				
				<!-- Nom et Prenom -->
				<div class="horizontal-group">
					<div class="form-group left">
						<label for="idclient" class="label-title">ID Client :</label> <select name="idclient" id="idclient" class="form-input" required="required" style="display: none">
							<c:forEach var="client" items="${clients}">
								<option value="${client.idClient}">${client.idClient} : ${client.nom} ${client.prenom}</option>
							</c:forEach>
						</select>
						<label id="afidclient" style="display: block; font-size: 20px;">${contrat.client.idClient} : ${contrat.client.nom} ${contrat.client.prenom}</label>
					</div>
					<div class="form-group right">
						<label for="idbien" class="label-title">ID Bien :</label> <select name="idbien" id="idbien" class="form-input" required="required" style="display: none">
							<option value="${contrat.bien.idBien}" selected>${contrat.bien.idBien} : ${contrat.bien.descriptif}</option>
							<c:forEach var="bien" items="${biens}">
								<option value="${bien.idBien}">${bien.idBien} : ${bien.descriptif}</option>
							</c:forEach>
						</select>
						<label id="afidbien" style="display: block; font-size: 20px;">${contrat.bien.idBien} : ${contrat.bien.descriptif}</label>
					</div>
				</div>

				<!-- Num tel -->
				<div class="horizontal-group">
					<div class="form-group left">
						<label for="date" class="label-title">Date :</label> <input type="date" id="date" name="date" class="form-input" value="${contrat.date}"  style="display: none;" />
						<label id="afdate" style="display: block; font-size: 20px;">${contrat.date}</label>
					</div>
					<div class="form-group right">
						<label for="prix" class="label-title">Prix (en DT):</label> <input type="number" id="prix" name="prix" class="form-input" value="${contrat.prix}"  style="display: none;" /> 
						<label id="afprix" style="display: block; font-size: 20px;">${contrat.prix}</label>
					</div>
				</div>
			</div>

			<!-- form-footer -->
			<div class="form-footer">
				<div style="justify-content: center; display: flex;">
					<span style="margin-left: 290px" id="espace"></span> <a href="/backoffice/prive/cherchercontrat">Retour</a>
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
		for (var i = 0; i < document.getElementById("idclient").options.length; i++) {
			if (document.getElementById("idclient").options[i].value == document.getElementById("idclientn").value)
				document.getElementById("idclient").options[i].selected = "true";
		}
		function fonction1() {
			input=["prix","date","idclient","idbien","numcontrat"];
			for (var i = 0; i < input.length; i++) {
				document.getElementById(input[i]).style.display = "block";
				document.getElementById("af" + input[i]).style.display = "none";
			}
			document.getElementById("enreg").style.display = "block";
			document.getElementById("mod").style.display = "none";
			document.getElementById("espace").style.marginLeft = "265px";
		}

		function fonction2() {
			if (confirm("Voulez-vous vraiment supprimer ce contrat?")) {
				window.alert("Ce contrat a été supprimé avec succès.");
				location.href = "/backoffice/prive/supprimecontrat?numcontrat=${contrat.numContrat}";
			}
		}
	</script>
</body>
</html>