<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <link rel="stylesheet" href="style40.css" />
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
                		<li ><a href="Register" > Créer un Compte</a></li>
                		
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
            <img src="dmg.jpg" class="image">
            
            <section>
            	<article>
            	  <div>
            		
            	    <a href="#"><div class="immobilier_neuf"><h1 id="div1">Immobilier Neuf</h1></div></a>
            	  </div>
            	  <div id="conteneur" >
            		<a href="Image?nombre1=1"><div class="Vente"><h1 id="div2">Vente</h1></div></a>
            		<a href="Image?nombre1=2"><div class="Location"><h1 id="div3">Location</h1></div></a>
            	  </div>
                </article>
            </section>
            <div id="final">
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
            			<li><a href="http://localhost:8080/backoffice/"> Admin</a></li>
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