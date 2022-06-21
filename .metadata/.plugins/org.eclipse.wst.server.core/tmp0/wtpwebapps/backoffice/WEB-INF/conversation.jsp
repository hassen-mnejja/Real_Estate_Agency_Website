<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>${client.nom} ${client.prenom}</title>
<link rel="stylesheet" type="text/css" href="../Style/MonStyle.css">
<link rel="icon" href="../Images/icon4.ico" />
<script src="../JS/1351.js"></script>
<script src="../JS/jquery-3.4.1.js"></script>
<style>
.my-form {
	width: 700px;
	margin-bottom: 100px;
}

body {
  margin: 0 auto;
  max-width: 800px;
  padding: 0 20px;
}

.container {
  border: 2px solid #dedede;
  background-color: #f1f1f1;
  border-radius: 5px;
  padding: 10px;
  margin: 5px 0;
}

.darker {
  border-color: #ccc;
  background-color: #ddd;
}

.container::after {
  content: "";
  clear: both;
  display: table;
}

.container img {
  float: left;
  max-width: 60px;
  width: 100%;
  margin-right: 20px;
  border-radius: 50%;
}

.container img.right {
  float: right;
  margin-left: 20px;
  margin-right:0;
}

.time-right {
  float: right;
  color: #aaa;
}

.time-left {
  float: left;
  color: #999;
}
</style>
</head>
<body>
<body>

	<!-- navbar -->
	<div id="nav-placeholder"></div>

	<!-- contenu -->
	<div id="contenu">
		<form class="my-form" action="ecriremessage" method="post">

			<!-- form header -->
			<div class="form-header">
				<h1>${client.nom} ${client.prenom}</h1>
			</div>

			<!-- form body -->
			<div class="form-body">
			
				<!-- client et bien -->
				<div class="horizontal-group">
					<div class="form-group left" style="width:75%">
						
						<textarea class="form-input" name="message" rows="4" cols="50" style="height: auto" required="required"></textarea>
					</div>
					<input type="hidden" name="idclient" value="${client.idClient }">
					<input type="hidden" id="temps" class="form-input" name="temps" />
					<div class="form-group right" style="width:22%">
						<svg style="width:400px; height:42px">
 							 <rect width="300" height="42" style="fill:rgba(0,0,0,0);" />
						</svg>
						<button type="submit" class="btn">Envoyer</button>
					</div>
				</div>
				
				<c:forEach var="message" items="${listemessage}">
					<c:if test="${message.idEnv==0}">
					<div class="horizontal-group">
					<div class="form-group left" style="width:100%">
						<div class="container">
  							<img src="../Images/Client/0/0-1.jpg" alt="Avatar" style="width:100%;">
  							<p>${message.mess}</p>
  							<span class="time-right">${message.temps}</span>
						</div>
						</div>
						</div>
					</c:if>
					<c:if test="${message.idRec==0}">
					<div class="horizontal-group">
					<div class="form-group left" style="width:100%">
						<div class="container darker">
  							<img src="../Images/Client/${client.idClient}/${client.idClient}-1.jpg" alt="Avatar" class="right" style="width:100%;">
  							<p>${message.mess}</p>
  							<span class="time-left">${message.temps}</span>
						</div>
						</div>
						</div>
					</c:if>
				</c:forEach>
				
			</div>
			<!-- form-footer -->
			<div class="form-footer">
				<div >
					<a href="/backoffice/prive/boitemessage">Retour</a>
				</div>
			</div>

		</form>

	</div>


	<!-- JavaScript -->
	<script>
		$(function() {
			$("#nav-placeholder").load("../navbar.html");
		});
		window.addEventListener('load', () => {
			  const now = new Date();
			  now.setMinutes(now.getMinutes() - now.getTimezoneOffset());
			  document.getElementById('temps').value = now.toISOString().slice(0, -8);
			});
	</script>
</body>
</html>