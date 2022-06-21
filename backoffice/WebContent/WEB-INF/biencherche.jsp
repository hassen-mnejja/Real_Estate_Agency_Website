<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="../JS/1351.js"></script>
<script src="../JS/ville.js"></script>
<script src="../JS/jquery-3.4.1.js"></script>
<title>Chercher un bien</title>
<link rel="stylesheet" href="../Style/MonStyle.css">
<link rel="icon" href="../Images/icon4.ico" />
<style>
.my-form {
	width: 750px;
}
</style>
</head>
<body>

	<!-- navbar -->
	<div id="nav-placeholder"></div>

	<!-- contenu -->
	<div id="contenu">
		<form class="my-form" action="chercherbien" method="post">

			<!-- form header -->
			<div class="form-header">
				<h1>Chercher Bien</h1>
				<button type="submit" class="btn" style="display: none">Chercher</button>
			</div>
			<input type="hidden" id="regionn" value="${region}"> <input type="hidden" id="delegationn" value="${delegation}"><input type="hidden" id="statutn" value="${statut}"><input type="hidden" id="modeoffren" value="${modeoffre}"><input
				type="hidden" id="typebienn" value="${typebien}"
			>
			<!-- form body -->
			<div class="form-body">
				<!-- nom et prenom -->
				<div class="horizontal-group">
					<div class="form-group left">
						<label for="typebien" class="label-title">Type de bien</label> <select id="typebien" name="typebien" onchange="typeBien(value);" class="form-input">
							<option selected value="">N'importe</option>
							<option value="Appartement">Appartement</option>
							<option value="Emplacement">Emplacement</option>
							<option value="Entrepot">Entrepot</option>
							<option value="Maison">Maison</option>
							<option value="Studio">Studio</option>
							<option value="Terrain">Terrain</option>
						</select>
					</div>
					<div class="form-group right">
						<label for="modeoffre" class="label-title">Mode d'offre</label><select id="modeoffre" name="modeoffre" onchange="modeOffre(value);" class="form-input">
							<option selected value="">N'importe</option>
							<option value="A Vendre">A Vendre</option>
							<option value="A Louer">A Louer</option>
						</select>
					</div>
				</div>
				<div class="horizontal-group">
					<div class="form-group left">
						<label for="modeoffre" class="label-title">Statut</label><select id="statut" name="statut" class="form-input">
							<option selected value="">N'importe</option>
							<option value="Disponible">Disponible</option>
							<option value="Vendu">Vendu</option>
							<option value="Loué">Loué</option>
						</select>
					</div>
					<div class="form-group right" style="margin-bottom: 0">
						<div class="form-group left">
							<label for="pde" class="label-title">Prix (DT)</label> <input type="text" id="pde" name="pde" class="form-input" placeholder="de" value="${pde}" />
						</div>
						<div class="form-group right">
							<label for="pvers" class="label-title" style="visibility: hidden;">Prix</label> <input type="text" id="pvers" name="pvers" class="form-input" placeholder="à" value="${pvers}" />
						</div>
					</div>
				</div>

				<!-- sexe et region -->
				<div class="horizontal-group">
					<div class="form-group left">
						<label for="region" class="label-title">Région</label> <select name="region" id="region" class="form-input" onchange="gov(1)">
							<option selected value="">N'importe</option>
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
							<option value="Medenine">Médenine</option>
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
					<div class="form-group right">
						<label for="delegation" class="label-title">Délégation</label> <select name="delegation" id="delegation" class="form-input">
							<option selected value="">N'importe</option>
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
							<th>Id</th>
							<th>Mode</th>
							<th>Type</th>
							<th>Prix</th>
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
								<td>${bien.prix}</td>
								<td>${bien.region}</td>
								<td>${bien.delegation}</td>
								<td>${bien.statut}</td>
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
		var select = [ "region", "statut", "typebien", "modeoffre" ];
		for (var j = 0; j < select.length; j++) {
			for (var i = 0; i < document.getElementById(select[j]).options.length; i++) {
				if (document.getElementById(select[j]).options[i].value == document
						.getElementById(select[j] + "n").value)
					document.getElementById(select[j]).options[i].selected = "true";
			}
		}
		if (document.getElementById("region").options[document
				.getElementById("region").selectedIndex].value != "") {
			gov(1);
		}
	</script>
	
</body>
</html>