<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <link rel="stylesheet" href="style30.css" />
        <title>Photo</title>
    </head>
    <body>
   
   
    <div id="bloc_page">
    <div id="premier">
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
                        <li><a href="Image"><span class="chercherbien"> Chercher un Bien</span></a></li>
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
            <div class="avant">
            <c:choose>
            <c:when test="${entrer==3 }">
            <a href="Listefavoris" style="margin-left:100px">Précédent</a>
            </c:when>
            <c:when test="${entrer==4 }">
            <a href="Favoris1?auto=1" style="margin-left:100px">Précédent</a>
            </c:when>
            <c:otherwise>
                    <a href="Favoris" style="margin-left:100px">Précédent</a>
            </c:otherwise>
            </c:choose>
            </div>
            
            </div>
    <section>
        <nav class="connecterr">
      
       
        <c:choose>
       <c:when test="${id==0 }">
       
       <form method="post" action="Test" id="one">
       <div class="seconnecter">
       <h1> Se Connecter</h1>
       </div>
       <h3>Connectez-vous à votre compte</h3>
       
       <input type="text" placeholder="Email*" class="email" name="email" required>
       
       
       <input type="password" placeholder="Mot de passe*" name="password" class="email" required>
       
       <input type="submit" value="Se connecter" id="submit" class="connect">
       
       <c:if test="${nb==0 }">
       
        <c:if test="${id==0 }"><span class="message">Login Fail</span></c:if></c:if>
       <div class="testa"><a href="#">Mot de passe oublier ?</a></div>
       
       
       
       </form>
       <form id="two">
       <h1> Créez un compte utilisateur </h1>
       <input type="submit" value="Créer" class="please">
       </form>
       </c:when>
       <c:otherwise>
       <div id="profil">
            
            <img src="http://localhost:8080/backoffice/Images/Client/${id }/${id }-1.jpg" class="pdp">
            <h1>Bienvenue !</h1>
            <h2>${prenom }</h2>
            <div class="dessous">
            <a href="#"><div class="un">Contacter-nous</div></a>
            <form action="ControleurMessageServlet" method="get">
                  <textarea rows="5" cols="35" class="texte" name="mesg"></textarea>
                  <input type="hidden" id="temps" class="form-input" name="temps"  />
                  <button name="action" value="envoyer">Envoyer</button>
            </form>
            
           
            <a href="Listefavoris"> <div class="deux">Liste de souhait ? </div></a>
            
            </div>
      </div>
       </c:otherwise>
       </c:choose>
       </nav>
     <div>
    <div class="main">
    
    <c:if test="${b==0 }">
    <a href="User1"><img src="hearts.png" title="ajouter aux favoris"></a>
    </c:if>
    <c:if test="${r==0 }">
    <a href="User2"><img src="coeur-r.png" title="enlever de favoris"></a> 
    </c:if>
   
    <div class="slidershow middle">
    <div class="slides">
      <c:forEach var="i" begin="1" end="${sessionScope.nombree }" step="1">
    	<input type="radio" name="r" id="r${i }">
    </c:forEach>
    	<c:forEach var="i" begin="1" end="${sessionScope.nombree }" step="1">
    	<div class="slide s${i }">
    		<img src="http://localhost:8080/backoffice/Images/Bien/${cliqued}/${cliqued }-${i}.jpg">
    	</div>
    	</c:forEach>
    	
    </div>
    	<div class="navigation">
    	<c:forEach var="i" begin="1" end="${sessionScope.nombree }" step="1">
    		<label for="r${i }" class="bar" ></label>
    	</c:forEach>

    	</div>
    </div>
    </div>
    <div id="contient">
    <!--<c:choose>
    <c:when test="${id==0}}">-->
     <!--  <div class="vide" >
     </div>-->
    <!--   </c:when>
     <c:otherwise>
     <div class="vide1"></div>
     </c:otherwise>
     </c:choose>-->
     
     <div class="paragraphe">
     <div class="tete">
        <p> Description </p>
     </div>
     <!--  <h1> Résidence Latifa - Appartement S+3 A02- Rez-De-Chaussée</h1>-->
     <div class="photo">
    <!-- <img src="bain.png" title="salle de bain" id="bain" >
     
     <img src="lit.png" title ="lit">-->
     </div> 
      
      <div class="describe"> 
        <!--  <div class="flex">
        <p>propriété pour ......<span class="espace"> Habitation</span></p> 
        <p>Salle de bain .....<span class="espace"> 2</span></p> 
        <p>Année de livraison ....<span class="espace"> 2020</span></p>
        
        </div>
        <div class="flex1" >
        <p class="marge"> Piéce ..... 4 </p>
        <p class="marge" >Superficie .... 100</p>
        <p class="marge">Place de Parking.....Non </p> 
        </div>-->
        <p>${sessionScope.description }</p>
      </div> 
     
      <input type="radio" name="c" id="c1">
      <input type="radio" name="c" id="c2">
      
      <label for="c1" class="barr"><img src="frb.jpg"><span  class="eb3ed"> Emplacement</span></label> 
      <label for="c2" class="barr1" ><img src="frh.jpg" class="riguel"><span  class="eb3ed"> Emplacement</span></label>
     
      
      <div class="absent">
        
        <div>
        <!-- <p>Pays .......... Tunisie </p>-->
        <p>Etat/Region/Province ...... Gouvernorat de ${sessionScope.region } </p>
        <p>Ville ....... ${sessionScope.region }</p>
        <p>Quartier ....... ${numero} Rue ${rue} ${sessionScope.adresse }</p>
        <p>Indicatif régional ...... ${sessionScope.code}</p>
        </div>
      </div>
      <div class="titre">
       <input type="radio" name="cp" id="c3">
       <input type="radio" name="cp" id="c4" >
     
     <label for="c3" class="barr2"><img src="frb.jpg" class="riguel" ><span class="eb3ed"> Information Additionnelle</span></label> 
     <label for="c4" class="barr3" ><img src="frh.jpg" class="riguel"><span class="eb3ed"> Information Additionnelle</span></label>
    <div class="absent1" >
    <div>
       <p>
        <p><span class="caract">Prix</span> :<c:if test="${modeoffre=='A Vendre' }"> ${prix }DT</c:if><c:if test="${modeoffre=='A Louer' }">${loyer }DT/mois</c:if> </p>
        <p><span class="caract"> Charges</span> : ${charges }DT/Trimestre</p>
        <p><span class="caract"> Date de disposition</span> : ${date }</p>
        <p><span class="caract"> Caution</span> : ${caution }DT/Trimestre </p>
        <c:if test="${empty condition }"><c:if test="${modeoffre=='A Louer' }"><p><span class="caract"> Etat</span> : ${etat } </p></c:if></c:if>
        <c:if test="${empty condition }"><c:if test="${modeoffre=='A Louer' }"><p><span class="caract"> Meublé</span> : ${meuble} </p></c:if></c:if>
        <c:if test="${empty condition} "><c:if test="${modeoffre=='A Louer' }"><p><span class="caract"> Type bail</span> : ${typebail }</p></c:if></c:if>
        <span class="caract"> Caractéristiques :</span>
           <c:if test="${sessionScope.typebien=='Maison'}">
            <div class="ligne"> 
            <img src="tick.png" >  Nombre de chambre :${sessionScope.more[0] }
            <br/><img src="tick.png" >   Nombre de Garages:${sessionScope.more[1] }
            <br/><img src="tick.png" > Nombre d'étages:${sessionScope.more[2] }
            <br/><img src="tick.png" > Superficie :${sessionScope.more[3] }m²
            <c:if test="${sessionScope.more[4]!=0}"><br/><img src="tick.png" > Superficie Jardin :${sessionScope.more[4] }m²</c:if>
            </div>
            </c:if>
            <c:if test="${sessionScope.typebien=='Appartement'}">
            <div class="ligne"> 
            <img src="tick.png" >  Nombre de chambre :${sessionScope.more[2] }
            <c:if test="${sessionScope.more[0]!=0 }"><br/><img src="tick.png" >   Nombre de Garages:${sessionScope.more[0] }</c:if>
            <br/><img src="tick.png" > Nombre d'étages:${sessionScope.more[4] }
            <br/><img src="tick.png" > Ascenceur :${sessionScope.more[1] }
            <br/><img src="tick.png" > Superficie :${sessionScope.more[3] }m²
            </div>
            </c:if>
            <c:if test="${sessionScope.typebien=='Emplacement'}">
            <div class="ligne"> 
            <img src="tick.png" >  Nombre de pieces :${sessionScope.more[1] }
            <br/><img src="tick.png" > Superficie :${sessionScope.more[0] }m²
            </div>
            </c:if>
            <c:if test="${sessionScope.typebien=='Entrepot'}">
            <div class="ligne"> 
            <img src="tick.png" >  Equipement :<c:forEach var="chaine" items="${equipement }"> <img src="tick.png" > ${chaine }</c:forEach>
            <br/><img src="tick.png" > Superficie :${sessionScope.more[0] }m²
            </div>
            </c:if>
            <c:if test="${sessionScope.typebien=='Studio'}">
            <div class="ligne"> 
            <img src="tick.png" >  Nombre d'étage :${sessionScope.more[0] }
            <br/><img src="tick.png" > Ascenseur :${sessionScope.more[1] }
            <br/><img src="tick.png" > Superficie :${sessionScope.more[2] }m²
            </div>
            </c:if>
            <c:if test="${sessionScope.typebien=='Terrain'}">
            <div class="ligne"> 
            <img src="tick.png" >  Affectation :${sessionScope.more[1] }
            <br/><img src="tick.png" > Superficie :${sessionScope.more[0] }m²
            </div>
            </c:if>
            <span class="caract"> Autres Caractéristiques :</span>
            <div><c:forEach var="listee" items="${ carac }">
            <br/><img src="tick.png" > ${listee } 
            </c:forEach>
            </div>
        </p>
    </div>
    </div>
   </div>
    </div>
    </div>
    </div>
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
     <script>
		      window.addEventListener('load', () => {
			  const now = new Date();
			  now.setMinutes(now.getMinutes() - now.getTimezoneOffset());
			  document.getElementById('temps').value = now.toISOString().slice(0, -1);
			});
	              </script>
    </body>
 </html>