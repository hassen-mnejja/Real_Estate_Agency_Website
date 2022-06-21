<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>${fbien.bien.descriptif}</title>
<link rel="stylesheet" type="text/css" href="../Style/MonStyle.css">
<link rel="stylesheet" type="text/css" href="../Style/slideshow.css">
<link rel="icon" href="../Images/icon4.ico" />
<script src="../JS/jquery-3.4.1.js"></script>
<script src="../JS/slideshow.js"></script>
<script src="../JS/1351.js"></script>
<script src="../JS/ville.js"></script>
<style>
.my-form {
	width: 650px;
	margin-bottom: 100px;
}

.image{
	cursor : pointer
}
</style>
</head>
<body>

	<!-- navbar -->
	<div id="nav-placeholder"></div>
	
	<!-- contenu -->
	<div id="contenu">
		<form class="my-form" action="modifiebien" method="get">
			<!-- form header -->
			<div class="form-header">
				<h1 style="font-size: 20px">${fbien.bien.descriptif}(ID=${fbien.bien.idBien})</h1>
			</div>
			
			<!-- form body -->
			<div class="form-body">
			
				<!-- Initialisation -->
				<input type="hidden" id="regionn" value="${fbien.bien.region}"> <input type="hidden" id="delegationn" value="${fbien.bien.delegation}"> <input type="hidden" id="idpropn" value="${fbien.bien.idProp}"> 
				<input type="hidden" id="typebienn" value="${fbien.bien.typeBien}"><input type="hidden" id="modeoffren" value="${fbien.bien.modeOffre}">
				<!-- Terrain -->
				<c:if test="${fbien.bien.typeBien=='Terrain'}">
					<input type="hidden" id="tstotalen" value="${fbien.sTotale}"><input type="hidden" id="affectationn" value="${fbien.affectation}">
				</c:if>
				<!-- Maison -->
				<c:if test="${fbien.bien.typeBien=='Maison'}">
					<input type="hidden" id="mnbchambresn" value="${fbien.nbChambres}"><input type="hidden" id="mnbgaragesn" value="${fbien.nbGarages}">
					<input type="hidden" id="nbetagesn" value="${fbien.nbEtages}"><input type="hidden" id="mstotalen" value="${fbien.sTotale}">
					<input type="hidden" id="msjardinn" value="${fbien.sJardin}">
				</c:if>
				<!-- Appartement -->
				<c:if test="${fbien.bien.typeBien=='Appartement'}">
					<input type="hidden" id="anbchambresn" value="${fbien.nbChambres}"><input type="hidden" id="anbgaragesn" value="${fbien.nbGarages}">
					<input type="hidden" id="anetagen" value="${fbien.etage}"><input type="hidden" id="astotalen" value="${fbien.sTotale}">
					<input type="hidden" id="asjardinn" value="${fbien.sJardin}"><input type="hidden" id="aascenseurn" value="${fbien.ascenseur}">
				</c:if>
				<!-- Studio -->
				<c:if test="${fbien.bien.typeBien=='Studio'}">
					<input type="hidden" id="snetagen" value="${fbien.etage}"><input type="hidden" id="sstotalen" value="${fbien.sTotale}">
					<input type="hidden" id="sascenseurn" value="${fbien.ascenseur}">
				</c:if>
				<!-- Emplacement -->
				<c:if test="${fbien.bien.typeBien=='Emplacement'}">
					<input type="hidden" id="nbpiecesn" value="${fbien.nbPieces}"><input type="hidden" id="emstotalen" value="${fbien.sTotale}">
				</c:if>
				<!-- Entrepot -->
				<c:if test="${fbien.bien.typeBien=='Entrepot'}">
					<input type="hidden" id="enstotalen" value="${fbien.sTotale}">
					<input type="hidden" id="nbequips" value="${nbequips}">
					<c:forEach var="j" begin="1" end="${nbequips}" step="1">
						<input type="hidden" id="e${j}" value="${fbien.equip[j-1]}">
					</c:forEach>
				</c:if>
				<!-- A Vendre -->
				<input type="hidden" id="prixdemanden" value="${fbien.bien.prixDemande}"><input type="hidden" id="etatn" value="${fbien.bien.etat}">
				<!-- A Louer -->
				<input type="hidden" id="cautionn" value="${fbien.bien.caution}"><input type="hidden" id="loyern" value="${fbien.bien.loyer}">
				<input type="hidden" id="chargesn" value="${fbien.bien.charges}"><input type="hidden" id="typebailn" value="${fbien.bien.typeBail}">
				<input type="hidden" id="meublen" value="${fbien.bien.meuble}">
				<!-- Identifiant -->
				<div>
					<input type="hidden" name="idbien" value="${fbien.bien.idBien}"><br>
					<input type="hidden" id="nbcaracs" value="${nbcaracs}">
					<c:forEach var="j" begin="1" end="${nbcaracs}" step="1">
						<input type="hidden" id="c${j}" value="${fbien.bien.caracs[j-1]}">
					</c:forEach>
				</div>
				<!-- Images -->
				<div class="slideshow-container">
					<c:forEach var="i" begin="1" end="${fbien.bien.nbImages}" step="1">
						<div class="mySlides fade">
							<div class="numbertext">${ i }/${ fbien.bien.nbImages }</div>
							<img src="../Images/Bien/${ fbien.bien.idBien }/${ fbien.bien.idBien }-${ i }.jpg" style="width: 100%" class="image">
							<div class="text">${ fbien.bien.descriptif }</div>
						</div>
					</c:forEach>
					<a class="prev" onclick="plusSlides(-1)">&#10094;</a> <a class="next" onclick="plusSlides(1)">&#10095;</a>
				</div>
				<br>
				<div style="text-align: center">
					<c:forEach var="i" begin="1" end="${fbien.bien.nbImages}" step="1">
						<span class="dot" onclick="currentSlide(${i})"> </span>
					</c:forEach>
				</div>

				<!-- Descriptif et idprop -->
				<div class="horizontal-group">
					<div class="form-group left" style="width: 84%">
						<label for="mod1" class="label-title">Descriptif :</label> <input type="text" id="descriptif" name="descriptif" class="form-input" value="${fbien.bien.descriptif}" style="display: none;" /> <label id="afdescriptif"
							style="display: block; font-size: 17px; text-align: center;"
						>${fbien.bien.descriptif}</label>
					</div>
					<div class="form-group right" style="width: 14%">
						<label for="idprop" class="label-title">ID Prop</label><label id="afidprop" style="display: block; font-size: 17px; text-align: center;">${fbien.bien.idProp}</label><select id="idprop" name="idprop" class="form-input" required="required"
							style="display: none;"
						>
							<option disabled selected value="">-- Choisir --</option>
							<c:forEach var="id" items="${ids}">
								<option value="${id}">${id}</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<!-- Adresse -->
				<div class="horizontal-group">
					<fieldset>
						<legend> Adresse : </legend>
						<div class="form-group left" style="margin-bottom: 0">
							<div class="form-group left" style="width: 74%">
								<label for="rue" class="label-title">Rue *</label> <input type="text" id="rue" name="rue" class="form-input" value="${fbien.bien.rue}" required="required" style="display: none;" /><label id="afrue"
									style="display: block; font-size: 20px; text-align: center;"
								>${fbien.bien.rue}</label>
							</div>
							<div class="form-group right" style="width: 24%">
								<label for="numero" class="label-title">N° *</label> <input type="number" id="numero" name="numero" class="form-input" value="${fbien.bien.numero}" required="required" style="display: none;" /><label id="afnumero"
									style="display: block; font-size: 20px; text-align: center;"
								>${fbien.bien.numero}</label>
							</div>
						</div>
						<div class="form-group right">
							<label for="codepostal" class="label-title">Code Postal *</label> <input type="number" id="codepostal" name="codepostal" class="form-input" placeholder="Code Postal" pattern="[0-9]{4}" value="${fbien.bien.codePostal}" required="required"
								style="display: none;"
							/><label id="afcodepostal" style="display: block; font-size: 20px; text-align: center;">${fbien.bien.codePostal}</label>
						</div>
						<div class="horizontal-group">
							<div class="form-group left">
								<label for="region" class="label-title">Région *</label> <label id="afregion" style="display: block; font-size: 20px; text-align: center;">${fbien.bien.region}</label> <select name="region" id="region" class="form-input" required="required"
									onchange="gov(0)" style="display: none;"
								>
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
								<label for="delegation" class="label-title">Délégation *</label><label id="afdelegation" style="display: block; font-size: 20px; text-align: center;">${fbien.bien.delegation}</label> <select name="delegation" id="delegation"
									class="form-input" required="required" style="display: none;"
								>
									<option disabled selected value="">-- Choisir une délégation --</option>
								</select>
							</div>
						</div>
					</fieldset>
					<br>
				</div>

				<!-- Dates -->
				<div class="horizontal-group">
					<div class="horizontal-group">
						<div class="form-group left">
							<label for="soumission" class="label-title">Date de soumission *</label> <label id="afsoumission" style="display: block; font-size: 20px; text-align: center;">${fbien.bien.soumission}</label><input type="date" id="soumission" name="soumission"
								class="form-input" required="required" value="${fbien.bien.soumission}" style="display: none;"
							/>
						</div>
						<div class="form-group right">
							<label for="disposition" class="label-title">Date de disposition *</label> <label id="afdisposition" style="display: block; font-size: 20px; text-align: center;">${fbien.bien.disposition}</label><input type="date" id="disposition"
								name="disposition" class="form-input" required="required" value="${fbien.bien.disposition}" style="display: none;"
							/>
						</div>
					</div>
				</div>
				
				<!-- Type de bien -->
				<div class="horizontal-group">
					<div class="form-group">
						<label for="typebien" class="label-title">Type de bien *</label> <label id="aftypebien" style="display: block; font-size: 20px; text-align: center;">${fbien.bien.typeBien}</label><select id="typebien" name="typebien" onchange="typeBien(value);" class="form-input" required="required" style="display: none;">
							<option disabled selected value="">-- Choisir un type --</option>
							<option value="Appartement">Appartement</option>
							<option value="Emplacement">Emplacement</option>
							<option value="Entrepot">Entrepot</option>
							<option value="Maison">Maison</option>
							<option value="Studio">Studio</option>
							<option value="Terrain">Terrain</option>
						</select>
					</div>
				</div>
				
				<!-- Appartement -->
				<div id="Appartement" style="display: none">
					<fieldset>
						<legend> Appartement : </legend>
						<div class="horizontal-group">
							<div class="form-group left" style="margin-bottom: 0">
								<div class="form-group left">
									<label for="anbchambres" class="label-title">Nb Chambres *</label> <input type="number" id="anbchambres" name="anbchambres" class="form-input" placeholder="Nb Chambres"  value="0" style="display: none;"/>
									<c:if test="${fbien.bien.typeBien=='Appartement'}">
										<label id="afanbchambres" style="display: block; font-size: 17px; text-align: center;" >${fbien.nbChambres}</label>
									</c:if>
								</div>
								<div class="form-group right">
									<label for="anbgarages" class="label-title">Nb Garages *</label> <input type="number" id="anbgarages" name="anbgarages" class="form-input" placeholder="Nb Garages"  value="0" style="display: none;"/>
									<c:if test="${fbien.bien.typeBien=='Appartement'}">
										<label id="afanbgarages" style="display: block; font-size: 17px; text-align: center;" >${fbien.nbGarages}</label>
									</c:if>
								</div>
							</div>
							<div class="form-group right" style="margin-bottom: 0">
								<div class="form-group right">
									<label for="aascenseur" class="label-title">Ascenseur ? *</label> <select id="aascenseur" name="aascenseur" class="form-input" style="display: none;">
										<option disabled selected value="">Oui / Non</option>
										<option value="oui">Oui</option>
										<option value="non">Non</option>
									</select>
									<c:if test="${fbien.bien.typeBien=='Appartement'}">
										<label id="afaascenseur" style="display: block; font-size: 17px; text-align: center;" >${fbien.ascenseur}</label>
									</c:if>
								</div>
								<div class="form-group left">
									<label for="anetage" class="label-title">N° étage *</label> <input type="number" id="anetage" name="anetage" class="form-input" placeholder="N° étage"  value="0" style="display: none;"/>
									<c:if test="${fbien.bien.typeBien=='Appartement'}">
										<label id="afanetage" style="display: block; font-size: 17px; text-align: center;" >${fbien.etage}</label>
									</c:if>
								</div>

							</div>
						</div>
						<div class="horizontal-group">
							<div class="form-group right">
								<label for="asjardin" class="label-title">Superficie du jardin (m²) *</label> <input type="number" id="asjardin" name="asjardin" class="form-input" placeholder="Superficie du jardin" value="0" style="display: none;"/>
								<c:if test="${fbien.bien.typeBien=='Appartement'}">
									<label id="afasjardin" style="display: block; font-size: 17px; text-align: center;" >${fbien.sJardin}</label>
								</c:if>
							</div>
							<div class="form-group left">
								<label for="astotale" class="label-title">Superficie totale (m²) *</label> <input type="number" id="astotale" name="astotale" class="form-input" placeholder="Superficie totale" value="0" style="display: none;"/>
								<c:if test="${fbien.bien.typeBien=='Appartement'}">
									<label id="afastotale" style="display: block; font-size: 17px; text-align: center;" >${fbien.sTotale}</label>
								</c:if>
							</div>
						</div>
					</fieldset>
					<br>
				</div>
				
				<!-- Maison -->
				<div id="Maison" style="display: none">
					<fieldset>
						<legend> Maison : </legend>
						<div class="horizontal-group">
							<div class="form-group left" style="width:32%; padding-right:10px">
								<label for="mnbchambres" class="label-title">Nb Chambres *</label> <input type="number" id="mnbchambres" name="mnbchambres" class="form-input" placeholder="Nb Chambres" value="0" style="display: none;"/>
								<c:if test="${fbien.bien.typeBien=='Maison'}">
									<label id="afmnbchambres" style="display: block; font-size: 17px; text-align: center;" >${fbien.nbChambres}</label>
								</c:if>
							</div>
							<div class="form-group left" style="width:32%; padding-right:10px">
								<label for="mnbgarages" class="label-title">Nb Garages *</label> <input type="number" id="mnbgarages" name="mnbgarages" class="form-input" placeholder="Nb Garages" value="0" style="display: none;"/>
								<c:if test="${fbien.bien.typeBien=='Maison'}">
									<label id="afmnbgarages" style="display: block; font-size: 17px; text-align: center;" >${fbien.nbGarages}</label>
								</c:if>
							</div>
							<div class="form-group left" style="width:32%">
								<label for="nbetages" class="label-title">Nb étages *</label> <input type="number" id="nbetages" name="nbetages" class="form-input" placeholder="Nb étages"  value="0" style="display: none;"/>
								<c:if test="${fbien.bien.typeBien=='Maison'}">
									<label id="afnbetages" style="display: block; font-size: 17px; text-align: center;" >${fbien.nbEtages}</label>
								</c:if>
							</div>
						</div>
						<div class="horizontal-group">
							<div class="form-group right">
								<label for="msjardin" class="label-title">Superficie du jardin (m²) *</label> <input type="number" id="msjardin" name="msjardin" class="form-input" placeholder="Superficie du jardin"  value="0" style="display: none;"/>
								<c:if test="${fbien.bien.typeBien=='Maison'}">
									<label id="afmsjardin" style="display: block; font-size: 17px; text-align: center;" >${fbien.sJardin}</label>
								</c:if>
							</div>
							<div class="form-group left">
								<label for="mstotale" class="label-title">Superficie totale (m²) *</label> <input type="number" id="mstotale" name="mstotale" class="form-input" placeholder="Superficie totale" value="0" style="display: none;"/>
								<c:if test="${fbien.bien.typeBien=='Maison'}">
									<label id="afmstotale" style="display: block; font-size: 17px; text-align: center;" >${fbien.sTotale}</label>
								</c:if>
							</div>
						</div>
					</fieldset>
					<br>
				</div>
				
				<!-- Studio -->
				<div class="horizontal-group" id="Studio" style="display: none">
					<fieldset>
						<legend> Studio : </legend>
						<div class="form-group left">
							<label for="sstotale" class="label-title">Superficie totale (m²) *</label> <input type="number" id="sstotale" name="sstotale" class="form-input" placeholder="Superficie totale"  value="0" style="display: none;"/>
							<c:if test="${fbien.bien.typeBien=='Studio'}">
								<label id="afsstotale" style="display: block; font-size: 17px; text-align: center;" >${fbien.sTotale}</label>
							</c:if>
						</div>
						<div class="form-group right" style="margin-bottom: 0">
							<div class="form-group right">
								<label for="sascenseur" class="label-title">Ascenseur ? *</label> <select id="sascenseur" name="sascenseur" class="form-input" style="display: none;">
									<option disabled selected value="">Oui / Non</option>
									<option value="oui">Oui</option>
									<option value="non">Non</option>
								</select>
								<c:if test="${fbien.bien.typeBien=='Studio'}">
									<label id="afsascenseur" style="display: block; font-size: 17px; text-align: center;" >${fbien.ascenseur}</label>
								</c:if>
							</div>
							<div class="form-group left">
								<label for="snetage" class="label-title">N° étage *</label> <input type="number" id="snetage" name="snetage" class="form-input" placeholder="N° étage" value="0" style="display: none;"/>
								<c:if test="${fbien.bien.typeBien=='Studio'}">
									<label id="afsnetage" style="display: block; font-size: 17px; text-align: center;" >${fbien.etage}</label>
								</c:if>
							</div>
						</div>
					</fieldset>
					<br>
				</div>

				<!-- Emplacement -->
				<div class="horizontal-group" id="Emplacement" style="display: none">
					<fieldset>
						<legend> Emplacement : </legend>
						<div class="form-group left">
							<label for="emstotale" class="label-title">Superficie totale (m²) *</label> <input type="number" id="emstotale" name="emstotale" class="form-input" placeholder="Superficie totale" value="0" style="display: none;"/>
							<c:if test="${fbien.bien.typeBien=='Emplacement'}">
								<label id="afemstotale" style="display: block; font-size: 17px; text-align: center;" >${fbien.sTotale}</label>
							</c:if>
						</div>
						<div class="form-group right">
							<label for="nbpieces" class="label-title">Nb Piéces *</label> <input type="number" id="nbpieces" name="nbpieces" class="form-input" placeholder="Nb Piéces" value="0" style="display: none;"/>
							<c:if test="${fbien.bien.typeBien=='Emplacement'}">
								<label id="afnbpieces" style="display: block; font-size: 17px; text-align: center;" >${fbien.nbPieces}</label>
							</c:if>
						</div>
					</fieldset>
					<br>
				</div>

				<!-- Terrain -->
				<div class="horizontal-group" id="Terrain" style="display: none">
					<fieldset>
						<legend> Terrain : </legend>
						<div class="form-group left">
							<label for="tstotale" class="label-title">Superficie totale (m²) *</label> <input type="number" id="tstotale" name="tstotale" class="form-input" placeholder="Superficie totale" value="0" style="display: none;"/>
							<c:if test="${fbien.bien.typeBien=='Terrain'}">
								<label id="aftstotale" style="display: block; font-size: 17px; text-align: center;" >${fbien.sTotale}</label>
							</c:if>
						</div>
						<div class="form-group right">
							<label for="affectation" class="label-title">Type d'affectation *</label> <select id="affectation" name="affectation" class="form-input" style="display: none;">
								<option disabled selected value="">-- Choisir un type --</option>
								<option value="Agricole">Agricole</option>
								<option value="Industriel">Industriel</option>
								<option value="Urban">Urban</option>
							</select>
							<c:if test="${fbien.bien.typeBien=='Terrain'}">
								<label id="afaffectation" style="display: block; font-size: 17px; text-align: center;" >${fbien.affectation}</label>
							</c:if>
						</div>
					</fieldset>
					<br>
				</div>

				<!-- Entrepot -->
				<div class="horizontal-group" id="Entrepot" style="display: none">
					<fieldset>
						<legend> Entrepot : </legend>
						<div class="form-group left">
							<label for="enstotale" class="label-title">Superficie totale (m²) *</label> <input type="number" id="enstotale" name="enstotale" class="form-input" placeholder="Superficie totale" value="0" style="display: none;"/>
							<c:if test="${fbien.bien.typeBien=='Entrepot'}">
								<label id="afenstotale" style="display: block; font-size: 17px; text-align: center;" >${fbien.sTotale}</label>
							</c:if>
						</div>
						<div class="form-group right">
							<label for="equip" class="label-title">Equipé de :</label><br> 
							<div id="equip" style="display: none;">
								<input type="checkbox" id="equip1" name="equip1" value="Bloc saniatire"> <label for="equip1">Bloc saniatire</label><br> 
								<input type="checkbox" id="equip2" name="equip2" value="Bloc administrative"> <label for="equip2"> Bloc administrative</label><br>
								<input type="checkbox" id="equip3" name="equip3" value="Loge gardien"> <label for="equip3">Loge gardien</label>
							</div>
							<c:if test="${fbien.bien.typeBien=='Entrepot'}">
								<div id="afequip">
									<c:forEach var="equip" items="${fbien.equip}">
										<label style="display: block; font-size: 18px;">+ ${equip}</label>
									</c:forEach>
								</div>
							</c:if>
						</div>
					</fieldset>
					<br>
				</div>
				
				<!-- Mode d'offre -->
				<div class="horizontal-group">
					<div class="form-group">
						<label for="modeoffre" class="label-title">Mode d'offre *</label><label id="afmodeoffre" style="display: block; font-size: 20px; text-align: center;">${fbien.bien.modeOffre}</label><select id="modeoffre" name="modeoffre" onchange="modeOffre(value);" class="form-input" required="required" style="display: none;">
							<option disabled selected value="">-- Choisir un mode --</option>
							<option value="A Vendre">A Vendre</option>
							<option value="A Louer">A Louer</option>
						</select>
					</div>
				</div>
				
				<!-- A Vendre -->
				<div class="horizontal-group" id="A Vendre" style="display: none">
					<fieldset>
						<legend> A Vendre : </legend>
							<div class="form-group left">
								<label for="prixdemande" class="label-title">Prix Demandé (DT) *</label> <input type="number" id="prixdemande" name="prixdemande" class="form-input" placeholder="Prix Demandé" value="0" style="display: none;"/>
								<c:if test="${fbien.bien.modeOffre=='A Vendre'}">
									<label id="afprixdemande" style="display: block; font-size: 17px; text-align: center;" >${fbien.bien.prixDemande}</label>
								</c:if>
							</div>
							<div class="form-group right">
								<label for="etat" class="label-title">Etat *</label> <select id="etat" name="etat" class="form-input" style="display: none;">
									<option disabled selected value="">-- Choisir un état --</option>
									<option value="Impeccable">Impeccable</option>
									<option value="Correct">Correct</option>
									<option value="A Restaurer">A Restaurer</option>
								</select>
								<c:if test="${fbien.bien.modeOffre=='A Vendre'}">
									<label id="afetat" style="display: block; font-size: 17px; text-align: center;" >${fbien.bien.etat}</label>
								</c:if>
							</div>
					</fieldset>
					<br>
				</div>
				
				<!-- A Louer -->
				<div class="horizontal-group" id="A Louer" style="display: none">
					<fieldset>
						<legend> A Louer : </legend>
						<div class="form-group left">
							<label for="caution" class="label-title">Montant de la caution (DT) *</label> <input type="number" id="caution" name="caution" class="form-input" placeholder="Montant de la caution" value="0" style="display: none;"/>
							<c:if test="${fbien.bien.modeOffre=='A Louer'}">
								<label id="afcaution" style="display: block; font-size: 17px; text-align: center;" >${fbien.bien.caution}</label>
							</c:if>
						</div>
						<div class="form-group right">
							<label for="loyer" class="label-title">Loyer Mensuel (DT) *</label> <input type="number" id="loyer" name="loyer" class="form-input" placeholder="Loyer Mensuel" value="0" style="display: none;"/>
							<c:if test="${fbien.bien.modeOffre=='A Louer'}">
								<label id="afloyer" style="display: block; font-size: 17px; text-align: center;" >${fbien.bien.loyer}</label>
							</c:if>
						</div>
						<div class="horizontal-group">
							<div class="form-group left">
								<label for="charges" class="label-title">Charges Mensuels (DT) *</label> <input type="number" id="charges" name="charges" class="form-input" placeholder="Charges Mensuels" value="0" style="display: none;"/>
								<c:if test="${fbien.bien.modeOffre=='A Louer'}">
									<label id="afcharges" style="display: block; font-size: 17px; text-align: center;" >${fbien.bien.charges}</label>
								</c:if>
							</div>
							<div class="form-group right" style="margin-bottom: 0">
								<div class="form-group left" style="width:55%">
									<label for="typebail" class="label-title">Type de Bail *</label> <select id="typebail" name="typebail" class="form-input" style="display: none;">
									<option disabled selected value="">Choisir</option>
									<option value="Mixte">Mixte</option>
									<option value="Commercial">Commercial</option>
									<option value="Professionnel">Professionnel</option>
								</select>
								<c:if test="${fbien.bien.modeOffre=='A Louer'}">
									<label id="aftypebail" style="display: block; font-size: 17px; text-align: center;" >${fbien.bien.typeBail}</label>
								</c:if>
								</div>
								<div class="form-group right" style="width:43%">
									<label for="meuble" class="label-title">Meublé ? *</label> <select id="meuble" name="meuble" class="form-input" style="display: none;">
										<option disabled selected value="">Oui / Non</option>
										<option value="Oui">Oui</option>
										<option value="Non">Non</option>
									</select>
									<c:if test="${fbien.bien.modeOffre=='A Louer'}">
										<label id="afmeuble" style="display: block; font-size: 17px; text-align: center;" >${fbien.bien.meuble}</label>
									</c:if>
								</div>
							</div>
						</div>
					</fieldset>
					<br>
				</div>

				<!-- Caractéristiques -->
				<div class="horizontal-group">
					<div id="carac" style="display: none;">
						<div class="form-group left">
							<label for="nom" class="label-title">Caractéristiques :</label><br> <input type="checkbox" id="carac1" name="carac1" value="Chauffage central" > <label for="carac1">Chauffage central</label><br> <input type="checkbox"
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
					<div id="afcarac" style="display: block;">
						<div class="form-group">
							<label for="nom" class="label-title">Caractéristiques :</label><br>
							<c:forEach var="carac" items="${fbien.bien.caracs}">
								<label style="display: block; font-size: 18px;">+ ${carac}</label>
							</c:forEach>
						</div>
					</div>
				</div>


			</div>

			<!-- form-footer -->
			<div class="form-footer">
				<div style="justify-content: left; display: flex;">
					<span style="margin-left: 240px" id="espace"></span> <a href="/backoffice/prive/chercherbien">Retour</a>
					<button type="submit" class="btn" style="display: none; margin: 0 10px;" id="enreg">Enregistrer</button>
					<button type="button" onclick="fonction1()" class="btn" style="display: block; margin: 0 10px;" id="mod">Modifier</button>
					<button type="button" onclick="fonction2()" class="btn">Supprimer</button>
				</div>
			</div>

		</form>
	</div>
	
	

	<!-- JavaScript -->
	<script>
		$(function(){
		  	$("#nav-placeholder").load("../navbar.html");
		});
		showSlides(1);
		var select = [ "region","idprop","typebien","modeoffre"];
		for (var j = 0; j < select.length; j++) {
			for (var i = 0; i < document.getElementById(select[j]).options.length; i++) {
				if (document.getElementById(select[j]).options[i].value == document.getElementById(select[j] + "n").value)
					document.getElementById(select[j]).options[i].selected = "true";
			}
		}	
		gov(0);
		var nbcaracs = document.getElementById("nbcaracs").value;
		for (var i = 1; i<11; i++) {
			for (var j = 1; j-1<nbcaracs; j++) {
				if (document.getElementById("carac"+i).value == document.getElementById("c"+j).value)
					document.getElementById("carac"+i).checked = true;
			}
		}
		var typebien = [ "Appartement","Emplacement","Entrepot","Maison","Studio","Terrain"];
		function typeBien(value) {
			for (var i = 0; i < typebien.length; i++) {
				if (typebien[i].localeCompare(value)!=0){
					document.getElementById(typebien[i]).style.display = "none";
					$("#"+typebien[i]+" input").each(function(){$(this).removeAttr('required');});
					$("#"+typebien[i]+" select").each(function(){$(this).removeAttr('required');});
				}
			}
			document.getElementById(value).style.display = "block";
			$("#"+value+" input").each(function(){$(this).show();});
			$("#"+value+" select").each(function(){$(this).show();});
			$("#"+value+" input").each(function(){$(this).attr('required', '');});
			$("#"+value+" select").each(function(){$(this).attr('required', '');});
			document.getElementById('equip1').removeAttribute('required');
			document.getElementById('equip2').removeAttribute('required');
			document.getElementById('equip3').removeAttribute('required');
		}
		type = document.getElementById('typebienn').value;
		typeBien(type);
		//par defaut
		switch (type){
		case "Terrain" :
			$("#Terrain input").each(function(){$(this).hide();});
			$("#Terrain select").each(function(){$(this).hide();});
			for (var i = 0; i < document.getElementById("affectation").options.length; i++) {
				if (document.getElementById("affectation").options[i].value == document.getElementById("affectationn").value)
					document.getElementById("affectation").options[i].selected = "true";
			}
			document.getElementById("tstotale").value=document.getElementById("tstotalen").value;
			break;
		case "Maison" :
			$("#Maison input").each(function(){$(this).hide();});
			$("#Maison select").each(function(){$(this).hide();});
			document.getElementById("mstotale").value=document.getElementById("mstotalen").value;
			document.getElementById("msjardin").value=document.getElementById("msjardinn").value;
			document.getElementById("mnbgarages").value=document.getElementById("mnbgaragesn").value;
			document.getElementById("mnbchambres").value=document.getElementById("mnbchambresn").value;
			document.getElementById("nbetages").value=document.getElementById("nbetagesn").value;
			break;
		case "Appartement" :
			$("#Appartement input").each(function(){$(this).hide();});
			$("#Appartement select").each(function(){$(this).hide();});
			document.getElementById("astotale").value=document.getElementById("astotalen").value;
			document.getElementById("asjardin").value=document.getElementById("asjardinn").value;
			document.getElementById("anbgarages").value=document.getElementById("anbgaragesn").value;
			document.getElementById("anbchambres").value=document.getElementById("anbchambresn").value;
			document.getElementById("anetage").value=document.getElementById("anetagen").value;
			for (var i = 0; i < document.getElementById("aascenseur").options.length; i++) {
				if (document.getElementById("aascenseur").options[i].value == document.getElementById("aascenseurn").value)
					document.getElementById("aascenseur").options[i].selected = "true";
			}
			break;
		case "Studio" :
			$("#Studio input").each(function(){$(this).hide();});
			$("#Studio select").each(function(){$(this).hide();});
			document.getElementById("sstotale").value=document.getElementById("sstotalen").value;
			document.getElementById("snetage").value=document.getElementById("snetagen").value;
			for (var i = 0; i < document.getElementById("sascenseur").options.length; i++) {
				if (document.getElementById("sascenseur").options[i].value == document.getElementById("sascenseurn").value)
					document.getElementById("sascenseur").options[i].selected = "true";
			}
			break;
		case "Emplacement" :
			$("#Emplacement input").each(function(){$(this).hide();});
			$("#Emplacement select").each(function(){$(this).hide();});
			document.getElementById("emstotale").value=document.getElementById("emstotalen").value;
			document.getElementById("nbpieces").value=document.getElementById("nbpiecesn").value;
			break;
		case "Entrepot" :
			$("#Entrepot input").each(function(){$(this).hide();});
			$("#Entrepot select").each(function(){$(this).hide();});
			document.getElementById("enstotale").value=document.getElementById("enstotalen").value;
			var nbequips = document.getElementById("nbequips").value;
			for (var i = 1; i<4; i++) {
				for (var j = 1; j-1<nbequips; j++) {
					if (document.getElementById("equip"+i).value == document.getElementById("e"+j).value)
						document.getElementById("equip"+i).checked = true;
				}
			}
			break;
		}
		
		var modeoffre = [ "A Vendre","A Louer"];
		function modeOffre(value) {
			for (var i = 0; i < modeoffre.length; i++) {
				if (modeoffre[i].localeCompare(value)!=0){
					document.getElementById(modeoffre[i]).style.display = "none";
					$("#"+modeoffre[i]+" input").each(function(){$(this).removeAttr('required');});
					$("#"+modeoffre[i]+" select").each(function(){$(this).removeAttr('required');});
				}
			}
			document.getElementById(value).style.display = "block";
			$("#"+value+" input").each(function(){$(this).show();});
			$("#"+value+" select").each(function(){$(this).show();});
			$("#"+value+" input").each(function(){$(this).attr('required', '');});
			$("#"+value+" select").each(function(){$(this).attr('required', '');});
		}
		mode = document.getElementById('modeoffre').value;
		modeOffre(mode);
		switch (mode){
		case "A Vendre" : 
			for (var i = 0; i < document.getElementById("etat").options.length; i++) {
				if (document.getElementById("etat").options[i].value == document.getElementById("etatn").value)
					document.getElementById("etat").options[i].selected = "true";
			}
			document.getElementById("prixdemande").value=document.getElementById("prixdemanden").value;
			break;
		case "A Louer" : 
			for (var i = 0; i < document.getElementById("meuble").options.length; i++) {
				if (document.getElementById("meuble").options[i].value == document.getElementById("meublen").value)
					document.getElementById("meuble").options[i].selected = "true";
			}
			for (var i = 0; i < document.getElementById("typebail").options.length; i++) {
				if (document.getElementById("typebail").options[i].value == document.getElementById("typebailn").value)
					document.getElementById("typebail").options[i].selected = "true";
			}
			document.getElementById("caution").value=document.getElementById("cautionn").value;
			document.getElementById("loyer").value=document.getElementById("loyern").value;
			document.getElementById("charges").value=document.getElementById("chargesn").value;
			break;
		}
		$("#"+mode+" input").each(function(){$(this).hide();});
		$("#"+mode+" select").each(function(){$(this).hide();});
		
		function fonction1() {
			var input = [ "delegation","idprop","region","soumission","disposition","descriptif","rue","numero","codepostal","carac","typebien","modeoffre"];
			for (var j = 0; j < input.length; j++) {
				document.getElementById(input[j]).style.display = "block";
				document.getElementById("af"+input[j]).style.display = "none";
			}
			switch (document.getElementById('typebienn').value){
			case "Terrain" : 
				input1 = [ "affectation","tstotale"];
				break;
			case "Emplacement" :
				input1 = [ "nbpieces","emstotale"];
				break;
			case "Entrepot" :
				input1 = [ "equip","enstotale"];
				break;
			case "Studio" :
				input1 = [ "snetage","sstotale","sascenseur"];
				break;
			case "Maison" :
				input1 = [ "nbetages","mstotale","msjardin","mnbgarages","mnbchambres"];
				break;
			case "Appartement" :
				input1 = [ "anetage","astotale","asjardin","anbgarages","anbchambres","aascenseur"];
				break;
			}
			for (var j = 0; j < input1.length; j++) {
				document.getElementById(input1[j]).style.display = "block";
				document.getElementById("af"+input1[j]).style.display = "none";
			}
			switch (document.getElementById('modeoffren').value){
			case "A vendre" :
				input = [ "prixdemande","etat"];
				break;
			case "A Louer" :
				input = [ "caution","charges","meuble","typebail","loyer"];
				break;
			}
			for (var i = 0; i < input.length(); i++) {
				document.getElementById(input[i]).style.display = "block";
				document.getElementById("af"+input[i]).style.display = "none";
			}
			document.getElementById("enreg").style.display = "block";
			document.getElementById("mod").style.display = "none";
			document.getElementById("espace").style.marginLeft = "215px";
		}

		function fonction2() {
			if (confirm("Voulez-vous vraiment supprimer ce bien?")) {
				window.alert("Ce bien a été supprimé avec succès.");
				location.href = "/backoffice/prive/supprimebien?idbien=${fbien.bien.idBien}";
			}
		}
		$(document).ready(function(){
			$('img.image').click(function(){
				window.open($(this)[0].src, '_blank')
			});
		});
		
	</script>
</body>


</html>