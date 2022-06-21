<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <link rel="stylesheet" href="style50.css" />
        <!--  <link href="css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">-->
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
                		<li><a href="Acceuil" >Acceuil</a></li>
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
                		<li ><a href="Image" ><span class="acceuil"> Créer un Compte</span></a></li>
                		
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
            <div class="essai">
            <h1>#Ched_Darek </h1>
            
            </div>
           <!--  <div style="border-radius:10px;magin margin:30px auto; width:600px">
<form action="Register" action="Get">
   <div class="p-3 mb-2 bg-light text-dark">
    <span>${message}</span>
    </div>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Email</label>
      <input type="email" class="form-control" id="inputEmail4" name="email">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">Password</label>
      <input type="password" class="form-control" id="inputPassword4" name="pwd1">
    </div>
  </div>
  <div class="form-group">
    <label for="inputAddress">password</label>
    <input type="password" class="form-control" id="inputAddress" placeholder=" comfirmer passsword" name="pwd2">
  </div>
  <div class="form-group">
    <label for="inputAddress2">nom</label>
    <input type="text" class="form-control" id="inputAddress2" placeholder="nom" name="nom">
  </div>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputCity">Prenom</label>
      <input type="text" class="form-control" id="inputCity" name="prenom">
    </div>
    </div>
    <div class="form-row">
    <div class="form-group col-md-2">
      <label for="inputZip">phone</label>
      <input type="text" class="form-control" id="inputcity" name="num"><br>
    </div>
  </div>
  <br>
  <button type="submit" class="btn btn-primary">Sign in</button>
</form>
</div> -->
   
    <form method="post" action="Register">
      <span>
     <label for="inputEmail4">Email</label>
 </span>
    <input type="email" class="form-control" id="inputEmail4" name="email" required>


    <label for="inputPassword4">Password</label>
    <input type="password" class="form-control" id="inputPassword4" name="pwd1" require>

    <label for="inputAddress">Password</label>
    <input type="password" class="form-control" id="inputAddress" placeholder=" comfirmer passsword" name="pwd2" reqired>
    <label for="inputAddress2">Nom</label>
    <input type="text" class="form-control" id="inputAddress2" placeholder="Nom" name="nom" required>
    <label for="inputCity">Prenom</label>
    <input type="text" class="form-control" id="inputCity" name="prenom"required>
    <label for="inputZip">Phone</label>
    <input type="text" class="form-control" id="inputcity" name="num" required><br>
    <button type="submit" class="btn btn-primary">Sign In</button>
    </form> 
    
     <div id="final" style="margin-top:450px;">
            <footer>
            	    <div class="element1">
            		
            		<img src="invest-image.png" >
            		<h1> ImmobNet</h1>
            	    </div>
            		<ul>
            			<li><a href="#"> Qui sommes nous?</a></li>
            			<li><a href="#">Contactez-nous</a></li>
            			<li><a href="#">Condition d'utilisation</a></li>
            			<li><a href="#"> Protection des données</a></li>
            		</ul>
            		<div class="element2">
            		<a href="#"><img src="facebook.png"></a>
            		<a href="#"><img src="twitter.png"></a>
            		<a href="#" class="youtube"><img src="you tube.png" ></a>
            		<a href="#"><img src="instagram.jpg"></a>
            	    </div>
            </footer>
            </div>
    </div>
    </body>
</html>