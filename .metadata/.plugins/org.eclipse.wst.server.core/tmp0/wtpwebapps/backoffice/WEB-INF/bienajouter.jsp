<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="../JS/1351.js"></script>
<script src="../JS/ville.js"></script>
<script src="../JS/jquery-3.4.1.js"></script>
<title>Ajouter un bien</title>
<link rel="stylesheet" href="../Style/MonStyle.css">
<link rel="icon" href="../Images/icon4.ico" />
<style>
.my-form {
	width: 650px;
	margin-bottom: 100px;
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

#erreur {
	padding: 10px;
	margin-bottom: 30px;
	width: 100%;
	color: red
}
</style>
</head>
<body>

	<!-- navbar -->
	<div id="nav-placeholder"></div>

	<!-- contenu -->
	<div id="contenu">
		<form class="my-form" action="ajouterbien" method="post" enctype="multipart/form-data" autocomplete="off">

			<!-- form header -->
			<div class="form-header">
				<h1>Nouveau Bien</h1>
				<input type="hidden" id="delegationn" value="">
			</div>
			<!-- form body -->
			<div class="form-body">
				<span id="erreur">${erreur}</span>
				<!-- infos générales -->
				<div class="horizontal-group">
					<div class="form-group left" style="width: 74%">
						<label for="descriptif" class="label-title">Descriptif *</label> <input type="text" id="descriptif" name="descriptif" class="form-input" placeholder="Court descriptif" required="required" />
					</div>
					<div class="form-group right" style="width: 24%">
						<label for="idprop" class="label-title">ID Propriétaire *</label><select id="idprop" name="idprop" class="form-input" required="required">
							<option disabled selected value="">-- Choisir --</option>
							<c:forEach var="id" items="${ids}">
								<option value="${id}">${id}</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<div class="horizontal-group">
					<fieldset>
						<legend> Adresse : </legend>
						<div class="form-group left" style="margin-bottom: 0">
							<div class="form-group left" style="width: 74%">
								<label for="rue" class="label-title">Rue *</label> <input type="text" id="rue" name="rue" class="form-input" placeholder="Rue" required="required" />
							</div>
							<div class="form-group right" style="width: 24%">
								<label for="numero" class="label-title">N° *</label> <input type="number" id="numero" name="numero" class="form-input" placeholder="N°" required="required" />
							</div>
						</div>
						<div class="form-group right">
							<label for="codepostal" class="label-title">Code Postal *</label> <input type="number" id="codepostal" name="codepostal" class="form-input" placeholder="Code Postal" pattern="[0-9]{4}" required="required" />
						</div>
						<div class="horizontal-group">
							<div class="form-group left">
								<label for="region" class="label-title">Région *</label> <select name="region" id="region" class="form-input" required="required" onchange="gov(0)">
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
								<label for="delegation" class="label-title">Délégation *</label> <select name="delegation" id="delegation" class="form-input" required="required">
									<option disabled selected value="">-- Choisir une délégation --</option>
								</select>
							</div>
						</div>
					</fieldset>
					<br>
				</div>
				
				<div class="horizontal-group">
					<div class="form-group left" style="width:100%">
						<label for="superficie" class="label-title">Superficie (m²) *</label> <input type="number" id="superficie" name="superficie" class="form-input" required="required" />
					</div>
				</div>

				<div class="horizontal-group">
					<div class="form-group left">
						<label for="soumission" class="label-title">Date de soumission *</label> <input type="date" id="soumission" name="soumission" class="form-input" required="required" />
					</div>
					<div class="form-group right">
						<label for="disposition" class="label-title">Date de disposition *</label> <input type="date" id="disposition" name="disposition" class="form-input" required="required" />
					</div>
				</div>



				<!-- Type de bien -->
				<div class="horizontal-group">
					<div class="form-group">
						<label for="typebien" class="label-title">Type de bien *</label> <select id="typebien" name="typebien" onchange="typeBien(value);" class="form-input" required="required">
							<option disabled selected value="">-- Choisir un type --</option>
							<option value="t1">Appartement</option>
							<option value="t2">Emplacement</option>
							<option value="t6">Entrepot</option>
							<option value="t3">Maison</option>
							<option value="t4">Studio</option>
							<option value="t5">Terrain</option>
						</select>
					</div>
				</div>

				<!-- Appartement -->
				<div id="t1" style="display: none">
					<fieldset>
						<legend> Appartement : </legend>
						<div class="horizontal-group">
							<div class="form-group left" style="margin-bottom: 0">
								<div class="form-group left">
									<label for="anbchambres" class="label-title">Nb Chambres *</label> <input type="number" id="anbchambres" name="anbchambres" class="form-input" placeholder="Nb Chambres" value="0" />
								</div>
								<div class="form-group right">
									<label for="anbgarages" class="label-title">Nb Garages *</label> <input type="number" id="anbgarages" name="anbgarages" class="form-input" placeholder="Nb Garages" value="0" />
								</div>
							</div>
							<div class="form-group right" style="margin-bottom: 0">
								<div class="form-group right">
									<label for="aascenseur" class="label-title">Ascenseur ? *</label> <select id="aascenseur" name="aascenseur" class="form-input">
										<option disabled selected value="">Oui / Non</option>
										<option value="oui">Oui</option>
										<option value="non">Non</option>
									</select>
								</div>
								<div class="form-group left">
									<label for="anetage" class="label-title">N° étage *</label> <input type="number" id="anetage" name="anetage" class="form-input" placeholder="N° étage" value="0" />
								</div>

							</div>
						</div>
						<div class="horizontal-group">
							<div class="form-group right">
								<label for="asjardin" class="label-title">Superficie du jardin (m²) *</label> <input type="number" id="asjardin" name="asjardin" class="form-input" placeholder="Superficie du jardin" value="0" />
							</div>
							<div class="form-group left">
								<label for="astotale" class="label-title">Superficie totale (m²) *</label> <input type="number" id="astotale" name="astotale" class="form-input" placeholder="Superficie totale" value="0" />
							</div>
						</div>
					</fieldset>
					<br>
				</div>

				<!-- Maison -->
				<div id="t3" style="display: none">
					<fieldset>
						<legend> Maison : </legend>
						<div class="horizontal-group">
							<div class="form-group left" style="width: 32%; padding-right: 10px">
								<label for="mnbchambres" class="label-title">Nb Chambres *</label> <input type="number" id="mnbchambres" name="mnbchambres" class="form-input" placeholder="Nb Chambres" value="0" />
							</div>
							<div class="form-group left" style="width: 32%; padding-right: 10px">
								<label for="mnbgarages" class="label-title">Nb Garages *</label> <input type="number" id="mnbgarages" name="mnbgarages" class="form-input" placeholder="Nb Garages" value="0" />
							</div>
							<div class="form-group left" style="width: 32%">
								<label for="nbetages" class="label-title">Nb étages *</label> <input type="number" id="nbetages" name="nbetages" class="form-input" placeholder="Nb étages" value="0" />
							</div>
						</div>
						<div class="horizontal-group">
							<div class="form-group right">
								<label for="msjardin" class="label-title">Superficie du jardin (m²) *</label> <input type="number" id="msjardin" name="msjardin" class="form-input" placeholder="Superficie du jardin" value="0" />
							</div>
							<div class="form-group left">
								<label for="mstotale" class="label-title">Superficie totale (m²) *</label> <input type="number" id="mstotale" name="mstotale" class="form-input" placeholder="Superficie totale" value="0" />
							</div>
						</div>
					</fieldset>
					<br>
				</div>

				<!-- Studio -->
				<div class="horizontal-group" id="t4" style="display: none">
					<fieldset>
						<legend> Studio : </legend>
						<div class="form-group left">
							<label for="sstotale" class="label-title">Superficie totale (m²) *</label> <input type="number" id="sstotale" name="sstotale" class="form-input" placeholder="Superficie totale" value="0" />
						</div>
						<div class="form-group right" style="margin-bottom: 0">
							<div class="form-group right">
								<label for="sascenseur" class="label-title">Ascenseur ? *</label> <select id="sascenseur" name="sascenseur" class="form-input">
									<option disabled selected value="">Oui / Non</option>
									<option value="oui">Oui</option>
									<option value="non">Non</option>
								</select>
							</div>
							<div class="form-group left">
								<label for="snetage" class="label-title">N° étage *</label> <input type="number" id="snetage" name="snetage" class="form-input" placeholder="N° étage" value="0" />
							</div>
						</div>
					</fieldset>
					<br>
				</div>

				<!-- Emplacement -->
				<div class="horizontal-group" id="t2" style="display: none">
					<fieldset>
						<legend> Emplacement : </legend>
						<div class="form-group left">
							<label for="emstotale" class="label-title">Superficie totale (m²) *</label> <input type="number" id="emstotale" name="emstotale" class="form-input" placeholder="Superficie totale" value="0" />
						</div>
						<div class="form-group right">
							<label for="nbpieces" class="label-title">Nb Piéces *</label> <input type="number" id="nbpieces" name="nbpieces" class="form-input" placeholder="Nb Piéces" value="0" />
						</div>
					</fieldset>
					<br>
				</div>

				<!-- Terrain -->
				<div class="horizontal-group" id="t5" style="display: none">
					<fieldset>
						<legend> Terrain : </legend>
						<div class="form-group left">
							<label for="tstotale" class="label-title">Superficie totale (m²) *</label> <input type="number" id="tstotale" name="tstotale" class="form-input" placeholder="Superficie totale" value="0" />
						</div>
						<div class="form-group right">
							<label for="affectation" class="label-title">Type d'affectation *</label> <select id="affectation" name="affectation" class="form-input">
								<option disabled selected value="">-- Choisir un type --</option>
								<option value="Agricole">Agricole</option>
								<option value="Industriel">Industriel</option>
								<option value="Urban">Urban</option>
							</select>
						</div>
					</fieldset>
					<br>
				</div>

				<!-- Entrepot -->
				<div class="horizontal-group" id="t6" style="display: none">
					<fieldset>
						<legend> Entrepot : </legend>
						<div class="form-group left">
							<label for="enstotale" class="label-title">Superficie totale (m²) *</label> <input type="number" id="enstotale" name="enstotale" class="form-input" placeholder="Superficie totale" value="0" />
						</div>
						<div class="form-group right">
							<label for="equip" class="label-title">Equipé de :</label><br> <input type="checkbox" id="equip1" name="equip1" value="Bloc saniatire"> <label for="equip1">Bloc saniatire</label><br> <input type="checkbox" id="equip2"
								name="equip2" value="Bloc administrative"
							> <label for="equip2"> Bloc administrative</label><br> <input type="checkbox" id="equip3" name="equip3" value="Loge gardien"> <label for="equip3">Loge gardien</label>
						</div>
					</fieldset>
					<br>
				</div>

				<!-- Mode d'offre -->
				<div class="horizontal-group">
					<div class="form-group">
						<label for="modeoffre" class="label-title">Mode d'offre *</label><select id="modeoffre" name="modeoffre" onchange="modeOffre(value);" class="form-input" required="required">
							<option disabled selected value="">-- Choisir un mode --</option>
							<option value="m1">A Vendre</option>
							<option value="m2">A Louer</option>
						</select>
					</div>
				</div>

				<!-- A Vendre -->
				<div class="horizontal-group" id="m1" style="display: none">
					<fieldset>
						<legend> A Vendre : </legend>
						<div class="form-group left">
							<label for="prixdemande" class="label-title">Prix Demandé (DT) *</label> <input type="number" id="prixdemande" name="prixdemande" class="form-input" placeholder="Prix Demandé" value="0" />
						</div>
						<div class="form-group right">
							<label for="etat" class="label-title">Etat *</label> <select id="etat" name="etat" class="form-input">
								<option disabled selected value="">-- Choisir un état --</option>
								<option value="Impeccable">Impeccable</option>
								<option value="Correct">Correct</option>
								<option value="A Restaurer">A Restaurer</option>
							</select>
						</div>
					</fieldset>
					<br>
				</div>

				<!-- A Louer -->
				<div class="horizontal-group" id="m2" style="display: none">
					<fieldset>
						<legend> A Louer : </legend>
						<div class="form-group left">
							<label for="caution" class="label-title">Montant de la caution (DT) *</label> <input type="number" id="caution" name="caution" class="form-input" placeholder="Montant de la caution" value="0" />
						</div>
						<div class="form-group right">
							<label for="loyer" class="label-title">Loyer Mensuel (DT) *</label> <input type="number" id="loyer" name="loyer" class="form-input" placeholder="Loyer Mensuel" value="0" />
						</div>
						<div class="horizontal-group">
							<div class="form-group left">
								<label for="charges" class="label-title">Charges Mensuels (DT) *</label> <input type="number" id="charges" name="charges" class="form-input" placeholder="Charges Mensuels" value="0" />
							</div>
							<div class="form-group right" style="margin-bottom: 0">
								<div class="form-group left" style="width: 55%">
									<label for="typebail" class="label-title">Type de Bail *</label> <select id="typebail" name="typebail" class="form-input">
										<option disabled selected value="">Choisir</option>
										<option value="Mixte">Mixte</option>
										<option value="Commercial">Commercial</option>
										<option value="Professionnel">Professionnel</option>
									</select>
								</div>
								<div class="form-group right" style="width: 43%">
									<label for="meuble" class="label-title">Meublé ? *</label> <select id="meuble" name="meuble" class="form-input">
										<option disabled selected value="">Oui / Non</option>
										<option value="Oui">Oui</option>
										<option value="Non">Non</option>
									</select>
								</div>
							</div>
						</div>
					</fieldset>
					<br>
				</div>


				<!-- Autres -->
				<div class="horizontal-group">
					<div class="form-group left">
						<label for="nom" class="label-title">Caractéristiques :</label><br> <input type="checkbox" id="carac1" name="carac1" value="Chauffage central"> <label for="carac1">Chauffage central</label><br> <input type="checkbox"
							id="carac2" name="carac2" value="Systeme de securite"
						> <label for="carac2">Système de sécurité</label><br> <input type="checkbox" id="carac3" name="carac3" value="Piscine"> <label for="carac3">Piscine</label><br> <input type="checkbox" id="carac4" name="carac4"
							value="Climatisation"
						> <label for="carac4">Climatisation</label><br> <input type="checkbox" id="carac5" name="carac5" value="Vue sur mer"> <label for="carac5">Vue sur mer</label>
					</div>
					<div class="form-group right">
						<label style="visibility: hidden">vide</label><br> <input type="checkbox" id="carac6" name="carac6" value="Suite parentale"> <label for="carac6">Suite parentale</label><br> <input type="checkbox" id="carac7" name="carac7"
							value="Sous-sol"
						> <label for="carac7">Sous-sol</label><br> <input type="checkbox" id="carac8" name="carac8" value="Cuisine equipe"> <label for="carac8">Cuisine équipé</label><br> <input type="checkbox" id="carac9" name="carac9"
							value="Maison intelligente"
						> <label for="carac9">Maison intelligente</label><br> <input type="checkbox" id="carac10" name="carac10" value="Terrasse"> <label for="carac10">Terrasse</label><br> <label style="visibility: hidden">vide</label>
					</div>
				</div>

				<!-- Photos -->
				<div class="horizontal-group">
					<div class="form-group left">
						<label for="photos" class="label-title">Photo *</label> <br> <input type="file" id="photos" name="photos" accept="image/*" multiple />
					</div>
				</div>
			</div>
			<!-- form-footer -->
			<div class="form-footer">
				<span>* obligatoire</span> <a href="../home">Retour</a>
				<button type="submit" class="btn">Ajouter</button>
			</div>

		</form>
	</div>

	<!-- javascript -->
	<script>
		$(function() {
			$("#nav-placeholder").load("../navbar.html");
		});
		document.getElementById('soumission').valueAsDate = new Date();
		function typeBien(value) {
			for (i = 1; i < 7; i++) {
				if ("t" + i != value) {
					document.getElementById("t" + i).style.display = "none";
					$("#t" + i + " input").each(function() {
						$(this).removeAttr('required');
					});
					$("#t" + i + " select").each(function() {
						$(this).removeAttr('required');
					});
				}
			}
			document.getElementById(value).style.display = "block";
			$("#" + value + " input").each(function() {
				$(this).attr('required', '');
			});
			$("#" + value + " select").each(function() {
				$(this).attr('required', '');
			});
			document.getElementById('equip1').removeAttribute('required');
			document.getElementById('equip2').removeAttribute('required');
			document.getElementById('equip3').removeAttribute('required');
		}
		function modeOffre(value) {
			for (i = 1; i < 3; i++) {
				if ("m" + i != value) {
					document.getElementById("m" + i).style.display = "none";
					$("#m" + i + " input").each(function() {
						$(this).removeAttr('required');
					});
					$("#m" + i + " select").each(function() {
						$(this).removeAttr('required');
					});
				}
			}
			document.getElementById(value).style.display = "block";
			$("#" + value + " input").each(function() {
				$(this).attr('required', '');
			});
			$("#" + value + " select").each(function() {
				$(this).attr('required', '');
			});
		}
	</script>
</body>
</html>