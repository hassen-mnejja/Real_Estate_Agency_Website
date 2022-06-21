<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="../JS/1351.js"></script>
<title>Programmer une visite</title>
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
		<form class="my-form" action="ajoutervisite" method="post">

			<!-- form header -->
			<div class="form-header">
				<h1>Programmer une visite</h1>
			</div>

			<!-- form body -->
			<div class="form-body">
				<!-- idbien et idclient -->
				<div class="horizontal-group">
					<div class="form-group left">
						<label for="idbien" class="label-title">ID Bien *</label> <select id="idbien" name="idbien" class="form-input" required="required">
							<option disabled selected value="">-- Choisir --</option>
							<c:forEach var="bien" items="${biens}">
								<option value="${bien.idBien}">${bien.idBien} : ${bien.descriptif}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group right">
						<label for="idclient" class="label-title">ID Client *</label> <select id="idclient" name="idclient" class="form-input" required="required">
							<option disabled selected value="">-- Choisir --</option>
							<c:forEach var="client" items="${clients}">
								<option value="${client.idClient}">${client.idClient} : ${client.nom} ${client.prenom}</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<!-- Date et Prix -->
				<div class="horizontal-group">
					<div class="form-group left">
						<label for="numpriv" class="label-title">Date *</label> <input type="date" id="date" name="date" class="form-input" required="required"/>
					</div>
					<div class="form-group right">
						<div class="form-group left">
							<label for="heured" class="label-title">Debut *</label> <input type="time" id="heured" name="heured" class="form-input" required="required"/>
						</div>
						<div class="form-group right">
							<label for="heuref" class="label-title">Fin *</label> <input type="time" id="heuref" name="heuref" class="form-input" required="required"/>
						</div>
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
		$(function() {
			$("#nav-placeholder").load("../navbar.html");
		});
	</script>
</body>
</html>