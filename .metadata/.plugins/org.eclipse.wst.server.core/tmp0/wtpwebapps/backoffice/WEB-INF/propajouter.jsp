<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="../JS/1351.js"></script>
<title>Ajouter un propriétaire</title>
<link rel="stylesheet" href="../Style/MonStyle.css">
<link rel="icon" href="../Images/icon4.ico" />
<script src="../JS/jquery-3.4.1.js"></script>
<style>
.my-form {
	width: 650px;
}

a.log {
	position: fixed;
	float: left;
	background: #222;
	border-radius: 3px 3px 3px 3px;
	height: 20px;
	top: 10px;
	right: 10px;
}
</style>
</head>
<body>

	<!-- navbar -->
	<div id="nav-placeholder"></div>

	<!-- contenu -->
	<div id="contenu">
		<form class="my-form" action="ajoutprop" method="get">

			<!-- form header -->
			<div class="form-header">
				<h1>Nouveau Propriétaire</h1>
			</div>

			<!-- form body -->
			<div class="form-body">

				<!-- Nom et Prenom -->
				<div class="horizontal-group">
					<div class="form-group left">
						<label for="nom" class="label-title">Nom *</label> <input type="text" id="nom" name="nom" class="form-input" placeholder="saisir votre nom" required="required" />
					</div>
					<div class="form-group right">
						<label for="prenom" class="label-title">Prenom *</label> <input type="text" id="prenom" name="prenom" class="form-input" placeholder="saisir votre prenom " required="required" />
					</div>
				</div>

				<!-- Num Tel -->
				<div class="horizontal-group">
					<div class="form-group left">
						<label for="numpriv" class="label-title">N° tel privé *</label> <input type="tel" id="numpriv" name="numpriv" class="form-input" placeholder="xx xxx xxx" required="required" pattern="[0-9]{2} [0-9]{3} [0-9]{3}" /> <span class="validity"></span>
					</div>
					<div class="form-group right">
						<label for="numtrav" class="label-title">N° tel de travail *</label> <input type="tel" id="numtrav" name="numtrav" class="form-input" placeholder="xx xxx xxx" required="required" pattern="[0-9]{2} [0-9]{3} [0-9]{3}" />
					</div>
				</div>

				<!-- Numero de tarvail -->
				<fieldset>
					<legend> Le numero de travail est disponible : </legend>
					<div class="horizontal-group">
						<div class="form-group left">
							<label for="debutdispo" class="label-title">De *</label> <input type="time" id="debutdispo" name="debutdispo" class="form-input" required="required">
						</div>
						<div class="form-group right">
							<label for="findispo" class="label-title">Vers *</label> <input type="time" id="findispo" name="findispo" class="form-input" required="required">
						</div>
					</div>
				</fieldset>

				<!-- Adresse -->
				<div class="form-group">
					<br> <label for="adress" class="label-title">Adresse *</label>
					<textarea class="form-input" name="adress" rows="4" cols="50" style="height: auto" required="required"></textarea>
				</div>
			</div>

			<!-- form-footer -->
			<div class="form-footer">
				<span>* obligatoire</span> <a href="home">Retour</a>
				<button type="submit" class="btn">Ajouter</button>
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