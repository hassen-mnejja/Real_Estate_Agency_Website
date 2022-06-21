<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>${visite.idVisite}</title>
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
		<form class="my-form" >

			<!-- form header -->
			<div class="form-header">
				<h1>ID Visite = ${visite.idVisite}</h1>
			</div>

			<!-- form body -->
			<div class="form-body">
			
				<!-- client et bien -->
				<div class="horizontal-group">
					<div class="form-group left">
						<label for="idclient" class="label-title">Client :</label> 
						<label id="afidclient" style="display: block; font-size: 20px;">${visite.client.idClient} : ${visite.client.nom} ${visite.client.prenom}</label>
					
					</div>
					<div class="form-group right">
						<label for="idbien" class="label-title">Bien :</label> 
						<label id="afidbien" style="display: block; font-size: 20px;">${visite.bien.idBien} : ${visite.bien.descriptif}</label>
					</div>
				</div>
				
				<!-- agent et date -->
				<div class="horizontal-group">
					<div class="form-group left">
						<label for="numcontrat" class="label-title">Agent :</label>  
						<label id="afnumcontrat" style="display: block; font-size: 20px;">${visite.agent.idAgent} : ${visite.agent.nom} ${visite.agent.prenom}</label>
					</div>
					<div class="form-group right">
						<label for="numcontrat" class="label-title">Date :</label>  
						<label id="afnumcontrat" style="display: block; font-size: 20px;">${visite.date}</label>
					</div>
				</div>

				<!-- Num tel -->
				<div class="horizontal-group">
					<div class="form-group left">
						<label for="date" class="label-title">Début :</label> 
						<label id="afdate" style="display: block; font-size: 20px;">${visite.heured}</label>
					</div>
					<div class="form-group right">
						<label for="prix" class="label-title">Fin :</label> 
						<label id="afprix" style="display: block; font-size: 20px;">${visite.heuref}</label>
					</div>
				</div>
			</div>

			<!-- form-footer -->
			<div class="form-footer">
				<div style="justify-content: left; display: flex;">
					<span style="margin-left: 240px" id="espace"></span> <a href="/backoffice/prive/cherchervisite">Retour</a>
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
			if (confirm("Voulez-vous vraiment annuler cette visite et programmer une autre?")) {
				location.href = "/backoffice/prive/modifievisite?idvisite=${visite.idVisite}";
			}
		}
		
		function fonction2() {
			if (confirm("Voulez-vous vraiment annuler cette visite?")) {
				window.alert("Cette visite a été annulée avec succès.");
				location.href = "/backoffice/prive/supprimevisite?idvisite=${visite.idVisite}";
			}
		}
	</script>
</body>
</html>