<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="../JS/1351.js"></script>
<script src="../JS/jquery-3.4.1.js"></script>
<title>Ajouter un client</title>
<link rel="stylesheet" href="../Style/MonStyle.css">
<link rel="icon" href="../Images/icon4.ico" />
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
	
	<div id="contenu">
		<form class="my-form" action="ajouterclient" method="post" enctype="multipart/form-data">

			<!-- form header -->
			<div class="form-header">
				<h1>Nouveau Client</h1>
			</div>

			<!-- form body -->
			<div class="form-body">

				<!-- nom et prenom -->
				<div class="horizontal-group">
					<div class="form-group left">
						<label for="nom" class="label-title">Nom *</label> <input type="text" id="nom" class="form-input" name="nom" placeholder="nom" required="required" />
					</div>
					<div class="form-group right">
						<label for="prenom" class="label-title">Prenom *</label> <input type="text" id="prenom" class="form-input" name="prenom" placeholder="prenom " required="required" />
					</div>
				</div>

				<!-- tel et sex -->
				<div class="horizontal-group">
					<div class="form-group right">
						<label for="password" class="label-title">Mot de passe *</label> <input type="password" id="password" class="form-input" name="password" required="required" />
					</div>
					<div class="form-group left">
						<label for="email" class="label-title">Email *</label> <input type="text" id="email" class="form-input" name="email" placeholder="email" required="required" /><span class="validity"></span>
					</div>
				</div>
				<!-- Sexe et Photo -->
				<div class="horizontal-group">
					<div class="form-group left">
						<label for="numtel" class="label-title">N° téléphone *</label> <input type="text" id="numtel" class="form-input" name="numtel" placeholder="xx xxx xxx" required="required" pattern="[0-9]{2} [0-9]{3} [0-9]{3}"/>
					</div>
					<div class="form-group right">
						<label for="adress" class="label-title">Photo *</label> <br> <input type="file" name="file2" accept="image/*" />
					</div>
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
	$(function(){
		  $("#nav-placeholder").load("../navbar.html");
	});
	</script>
</body>
</html>