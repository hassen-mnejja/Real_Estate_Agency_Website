<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <link rel="stylesheet" href="style50.css" />
        <title>Acceuil</title>
    </head>
    <body>
    
         <div id="bloc_page">
        	<header>
        		<div id="logo">
        	    <img src="invest-image.png" title="Avec ImmobNet Trouvez ce que vous conviendrez" >
        	    <h1>ImmobNet</h1>
        	    <p>Facilte votre vie!</p>
        	    </div>
                <nav>
                	<ul>
                		<li><a href="Acceuil" ><span class="acceuil">Acceuil</span></a></li>
                		<li><a href="#">Nos Biens </a>
                		<ul class="down">
                			<li><a href="Image?nombre=2">Maison</a></li>
                			<li><a href="Image?nombre=1">Appartement</a></li>
                			<li><a href="Image?nombre=3">Studio</a></li>
                            <li><a href="Image?nombre=4">Emplacement</a></li>
                        </ul></li>
                		<li><a href="Image"> Chercher un Bien</a></li>
                		
                		<c:choose>
                		<c:when test="${id==0 }">
                		<li ><a href="Image" > Créer un Compte</a></li>
                		
                		<li class="blanc"><a href="User" class="couleur"> SE CONNECTER</a></li>
                		</c:when>
                		
                		<c:otherwise>
                		
                		<li><a href="Visite"> Visiter Mon compte</a></li>
                		 <li class="blanc"><a href="Deconnexion" class="couleur"> SE Déconnecter</a></li>
                		 
                		
                		</c:otherwise>
                		</c:choose>
                		
                		
                    </ul>
                </nav>
            </header>
            
   
    <form method="post" action="Personnel">
      
    <span>
     <label for="inputEmail4">Email</label>
 </span>
    <input type="email" class="form-control" id="inputEmail4" name="email" value="${email }" required>


    <label for="inputPassword4">Password</label>
    <input type="password" class="form-control" id="inputPassword4" name="pwd1" value="${pwd1 }" required>
    <label for="inputAddress2">Nom</label>
    <input type="text" class="form-control" id="inputAddress2" placeholder="Nom" name="nom" value="${nom }" required>
    <label for="inputCity">Prenom</label>
    <input type="text" class="form-control" id="inputCity" name="prenom" value="${prenom }" required>
    <label for="inputZip">Phone</label>
    <input type="text" class="form-control" id="inputcity" name="num" value="${numtel}" required><br>
    <p>${message }</p>
    <button type="submit" class="btn btn-primary" style="width:150px; margin-left:-35px;">Mise à jour</button>
    </form>
    </div>
    </body>
</html>