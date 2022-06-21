<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="../JS/1351.js"></script>
<script src="../JS/jquery-3.4.1.js"></script>
<title>Ajouter un agent</title>
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
		<form class="my-form" action="ajoutagent" method="post" enctype="multipart/form-data">

			<!-- form header -->
			<div class="form-header">
				<h1>Nouveau Agent</h1>
			</div>

			<!-- form body -->
			<div class="form-body">

				<!-- nom et prenom -->
				<div class="horizontal-group">
					<div class="form-group left">
						<label for="nom" class="label-title">Nom *</label> <input type="text" id="nom" class="form-input" name="nom" placeholder="saisir votre nom" required="required" />
					</div>
					<div class="form-group right">
						<label for="prenom" class="label-title">Prenom *</label> <input type="text" id="prenom" class="form-input" name="prenom" placeholder="saisir votre prenom " required="required" />
					</div>
				</div>

				<!-- tel et sex -->
				<div class="horizontal-group">
					<div class="form-group right">
						<label for="numpriv" class="label-title">N° téléphone *</label> <input type="text" id="numpriv" class="form-input" name="numtel" placeholder="xx xxx xxx" required="required"
							pattern="[0-9]{2} [0-9]{3} [0-9]{3}"
						/>
					</div>
					<div class="form-group left">
						<label for="adress" class="label-title">Région *</label> <select name="region" id="adress" class="form-input" required="required">
							<option disabled selected value="">-- Choisir une région --</option>
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
						</select>
					</div>
				</div>
				<!-- Sexe et Photo -->
				<div class="horizontal-group">
					<div class="form-group left">
						<label class="label-title">Sexe *</label>
						<div class="input-group">
							<select name="sexe" id="sexe" class="form-input" required="required">
								<option disabled selected value="">-- Choisir le sexe --</option>
								<option value="Homme">Homme</option>
								<option value="Femme">Femme</option>
							</select>
						</div>
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