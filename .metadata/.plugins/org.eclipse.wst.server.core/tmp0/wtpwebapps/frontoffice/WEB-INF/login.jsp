<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style9.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <div class="face">
       <form method="get" action="Login" id="one">
       <div class="seconnecter">
       <h1> Se Connecter</h1>
       </div>
       <h3>Connectez-vous à votre compte</h3>
       
       <input type="text" placeholder="Email*" class="email" name="email" required>
       
       
       <input type="password" placeholder="Mot de passe*" name="password" class="email" required>
       
       <input type="submit" value="Se connecter" class="connect">
       <c:if test="${nb==0 }">
       
        <c:if test="${id==0 }"><span class="message">Login Fail</span></c:if></c:if>
       <div class="testa"><a href="#">Mot de passe oublier ?</a></div>
       </form>
       <form id="two">
       <h1> Créez un compte utilisateur </h1>
       <input type="submit" value="Créer" class="please">
       </form>
       </div>
</body>
</html>