<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <link rel="stylesheet" href="style22.css" />
       
        
        
        <title>Appartement à vendre Tunisie</title>
    </head>
    <body>
      <div id="bloc_page">
      
        	<c:if test="${empty compte }">
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
                              <li><a href="#">Maison</a></li>
                              <li><a href="#">Appartement</a></li>
                              <li><a href="#">Studio</a></li>
                            <li><a href="#">Emplacement</a></li>
                        </ul></li>
                        <li><a href="#"><span class="chercherbien"> Chercher un Bien</span></a></li>
                        
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
                </c:if>
                <c:if test="${! empty compte }">
                <div class="header1">
                <div id="logo1">
        	    <img src="http://localhost:8080/backoffice/Images/Client/${id }/${id }-1.jpg" title="Photo de profil">
        	    <h1>${nom }</h1>
        	    
        	    </div>
                 <nav>
                	<ul>
                	    <li><a href="Acceuil" ><span class="acceuil">Accueil</span></a></li>
                		<li><a href="#" ><span class="acceuil">Courier</span></a></li>
                	
                		<li><a href="#"> Information Personnelle</a></li>
                		<li><a href="Listefavoris"> Mes Favoris</a></li>
                		<li class="blanc"><a href="Deconnexion" class="couleur"> SE Déconnecter</a></li>
                		
                		
                		
                    </ul>
                </nav>
                </div>
                <div class="essai">
            <h1>#Bienvenue </h1>
            
            </div>
                </c:if>
            
       <section>
       <nav>
                <c:if test="${empty compte}">
         		<form method="post" action="Image" class="form1">
         			<label for="région"class="element">Région<br /></label>
                        <select name="region" id="région"  class="region" required>
                        <c:forEach var="chaine" items="${sessionScope.lieu }">
                                <option value="${chaine }"<c:if test="${sessionScope.region==chaine }">selected</c:if> >${chaine }</option> 
                         </c:forEach>
                        </select>
                        <label class="element"><br/><br/>Type de bien <br/></label>
                        <div class="bien">
                        <c:forEach var="chaine" items="${sessionScope.type }">
                              <input type="checkbox" name="bien" id="${chaine }" value="${chaine }" <c:if test="${sessionScope.type1==chaine}">checked</c:if> /><label for="${chaine }">${chaine } <br /></label>
                        </c:forEach>
                       
                      </div>
                      <c:set var="m" value="${sessionScope.budgetmin }" />
                       
                      <label for="budget" class="element" ><br/> Budget <br /></label>
                        <c:choose>
                        
                        <c:when test="${empty m}">-->
                        
                        <input type="text" placeholder="minimum" name="minimum" class="budget" required>
                        <input type="text" placeholder="maximum" name="maximum" class="budget" required>
                        </c:when>
                        <c:otherwise>
                        <input type="text"  name="minimum" class="budget" required value="${sessionScope.budgetmin }">
                        <input type="text"  name="maximum" class="budget" required value="${sessionScope.budgetmax }" >
                        </c:otherwise>
                        </c:choose>
                        <c:set var="n" value="${sessionScope.supmax }" />
                        <label for="Superficie" class="element" ><br/> <br/>Superficie<br/> </label>
                        <c:choose>
                       
                        <c:when test="${empty n }">
                        <input type="text" placeholder="minimum" name="minsup" class="budget" required>
                        <input type="text" placeholder="maximum" name="maxsup" class="budget" required>
                        </c:when>
                        <c:otherwise>
                        <input type="text"  name="minsup" class="budget" required value="${sessionScope.supmin }" >
                        <input type="text"  name="maxsup" class="budget" required value="${sessionScope.supmax}">
                        </c:otherwise>
                        </c:choose>
                        
                        <div class="mode">Mode d'Offre</div> 
                        
                        <div class="type">
                           <input type="radio" id="type1" name="type" value="A Vendre" <c:if test="${sessionScope.mode=='A Vendre' }">checked</c:if>><label for="type1">Vente</label>
                           <input type="radio" id="type2" name="type" value="A Louer"<c:if test="${sessionScope.mode=='A Louer' }">checked</c:if>><label for="type2">Location</label>
                        </div>
         		
                     <input type="submit" value="Chercher" class="chercher">




         		</form>
         		</c:if>
         		<c:if test="${!empty compte}">
         		<form method="get" action="Favoris1" class="form1">
         			<label for="région"class="element">Région<br /></label>
                        <select name="region" id="région"  class="region" required>
                        <c:forEach var="chaine" items="${sessionScope.lieu }">
                                <option value="${chaine }"<c:if test="${sessionScope.region==chaine }">selected</c:if> >${chaine }</option> 
                         </c:forEach>
                        </select>
                        <label class="element"><br/><br/>Type de bien <br/></label>
                        <div class="bien">
                        <c:forEach var="chaine" items="${sessionScope.type }">
                              <input type="checkbox" name="bien" id="${chaine }" value="${chaine }" <c:if test="${sessionScope.type1==chaine}">checked</c:if> /><label for="${chaine }">${chaine } <br /></label>
                        </c:forEach>
                       
                      </div>
                      <c:set var="m" value="${sessionScope.budgetmin }" />
                       
                      <label for="budget" class="element" ><br/> Budget <br /></label>
                        <c:choose>
                        
                        <c:when test="${empty m}">-->
                        
                        <input type="text" placeholder="minimum" name="minimum" class="budget" required>
                        <input type="text" placeholder="maximum" name="maximum" class="budget" required>
                        </c:when>
                        <c:otherwise>
                        <input type="text"  name="minimum" class="budget" required value="${sessionScope.budgetmin }">
                        <input type="text"  name="maximum" class="budget" required value="${sessionScope.budgetmax }" >
                        </c:otherwise>
                        </c:choose>
                        <c:set var="n" value="${sessionScope.supmax }" />
                        <label for="Superficie" class="element" ><br/> <br/>Superficie<br/> </label>
                        <c:choose>
                       
                        <c:when test="${empty n }">
                        <input type="text" placeholder="minimum" name="minsup" class="budget" required>
                        <input type="text" placeholder="maximum" name="maxsup" class="budget" required>
                        </c:when>
                        <c:otherwise>
                        <input type="text"  name="minsup" class="budget" required value="${sessionScope.supmin }" >
                        <input type="text"  name="maxsup" class="budget" required value="${sessionScope.supmax}">
                        </c:otherwise>
                        </c:choose>
                        
                        <div class="mode">Mode d'Offre</div> 
                        
                        <div class="type">
                           <input type="radio" id="type1" name="type" value="A Vendre" <c:if test="${sessionScope.mode=='A Vendre' }">checked</c:if>><label for="type1">Vente</label>
                           <input type="radio" id="type2" name="type" value="A Louer"<c:if test="${sessionScope.mode=='A Louer' }">checked</c:if>><label for="type2">Location</label>
                        </div>
         		
                     <input type="submit" value="Chercher" class="chercher">




         		</form>
         		</c:if>
         	</nav>
         	
       <div class="annonces">
       
       <c:forEach var="list" items="${ sessionScope.Selection }">
            <div class="annonce">
         		<div class="image1">
         		<img src="http://localhost:8080/backoffice/Images/Bien/${list[0] }/${list[0] }-1.jpg">
         	    </div>
         		<div class="description">
         		
         		<h1> ${list[4]}</h1>
         		
         		<c:if test="${list[7]=='A Louer' }">
         			<h3> <span class="gmara">${list[14]}DT/mois</span></h3>
         		</c:if>
         		<c:if test="${list[7]=='A Vendre' }">
         			<h3> <span class="gmara"> ${list[3]} DT</span></h3>
         		</c:if>
         			<p class="paragraphe1"> ${list[2]} m²</p>
         			
         			<img src="local.png" class="testtt"> <p style="height:10px">  ${list[1] }</p>
         		<div class="position">
         		<c:if test="${empty compte}">
         		<form method="get" action="Test" class="clique" >
         		    
         			<button name="clique" value="${ list[0]}">Plus d'Inform</button>
         			
         		</form>
         		</c:if>
         		<c:if test="${! empty compte}">
         		<form method="get" action="Test4" class="clique" >
         		    
         			<button name="clique" value="${ list[0]}">Plus d'Inform</button>
         			
         		</form>
         		</c:if>
         		</div>
         		
         	</div>
         	</div>
        </c:forEach>
        </div>
        <c:if test="${empty Selection}">
        <p> Aucun bien touvé satisfaisant vos conditions</p>
        </c:if>
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
    </body>
    </html>