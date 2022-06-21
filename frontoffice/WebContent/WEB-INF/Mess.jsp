<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
         <link rel="stylesheet" href="css/bootstrap.css" />
         <link rel="stylesheet" href="css/bootstrap.min.css" />
         <link rel="stylesheet" href="style42.css" />
        <title>messagerire</title>
<script type="text/javascript">
	function confirmer(url) {
		var rep = confirm("Etes vous sûr de vouloir supprimer ?");
		if (rep == true) {
			document.location = url;
		}
	}
</script>
    </head>
    <body>
<div id="bloc_page">
        	<header>
        
        		<div id="logo">
        	    <img src="http://localhost:8080/backoffice/Images/Client/${id}/${id }-1.jpg" title="Photo de profil">
        	    <h1>${nom }</h1>
        	    </div>
                 <nav>
                	<ul>
                	    <li><a href="Acceuil" ><span class="acceuil">Accueil</span></a></li>
                		<li><a href="ControleurMessageServlet" ><span class="acceuil">Courier</span></a></li>
                	<!--  <li><a href="http://localhost:8080/agence_immobilier/Personnel"> Information Personnelle</a></li>-->
                		<li><a href="Image"> Chercher un Bien</a></li>
                		<li><a href="Image"> Mes Favoris</a></li>
                		<li class="blanc"><a href="Deconnexion" class="couleur"> SE Déconnecter</a></li>
                		
                		
                		
                    </ul>
                </nav>
            </header>
<div style="border-radius:10px blue groove;magin:30px auto; width:700px">
<div class="container" style="position : relative; left : 40%; margin-top : 50px">

  <form action="ControleurMessageServlet" method="get">
	   <div class="row">
               
            <div class="col-sm-8">
                  <div class="chatbody">
                  <div class="panel panel-primary">
                <div class="panel-heading top-bar">
                    <div class="col-md-8 col-xs-8">
                        <h3 class="panel-title"><span class="glyphicon glyphicon-comment"></span> Chat </h3>
                        
                    </div>
                </div>
                 
                <c:forEach  var="m" items="${model.getMsgs()}">
                                
                              <c:if test="${m.getMessFromId()==0 }">  
                                <div class="media">
                                    <img src="http://localhost:8080/backoffice/Images/Client/0/0-1.jpg"  alt="..." class="rounded-sm" style="border-radius:50%; width:63px; height:63px"><!-- imagess user chemin -->
                                    <div class="media-body">
                                    <div class="shadow-sm p-3 mb-5 bg-white rounded">
                                   <h5 class="mt-0">Systeme</h5>
                                   </div>
                                   <div class="shadow p-3 mb-5 bg-white rounded">
                                 <p>  ${m.getMessText()}</p>
                                 </div>
                                   <p class="mb-0"> ${m.getSendDate()}</p>
                                   
                                   <a href="javascript:confirmer('ControleurMessageServlet?action=supprimer&MessId=${ m.getMessId() }')">Supprimer</a> 
                                   </div>
                                </div>
                             </c:if> 
                             <c:if test="${m.getMessFromId()!=0 }">
                              <div class="media">
                                    <div class="media-body">
                                    <div class="shadow-sm p-3 mb-5 bg-white rounded">
                                    <h5 class="mt-0 mb-1">${nom }</h5>
                                    </div>
                                    <div class="shadow p-3 mb-5 bg-white rounded">
                                    <p>${m.getMessText()}</p> 
                                    </div>
                                    <p> ${m.getSendDate()}</p>  
                                    <a href="javascript:confirmer('ControleurMessageServlet?action=supprimer&MessId=${ m.getMessId() }')"><p class="font-italic">Supprimer ce message</p></a>  
                                      </div>
                                     <img src="http://localhost:8080/backoffice/Images/Client/${id }/${id }-1.jpg"  alt="..." class="rounded-sm" style="border-radius:50%;width:63px; height:63px">
                                    </div>
                              </c:if>
                            </c:forEach>
                     
                              
         
                        <input id="btn-input" type="text" class="form-control input-sm chat_input" placeholder="Write your message here..."  name="mesg"/>
                        <div class="p-3 mb-2 bg-light text-dark">
                        <p class="font-italic">${message}</p>
                        </div>
                        <input type="hidden" id="temps" class="form-input" name="temps" />
                        
                      
                        <input type="submit" class="btn btn-primary btn-sm" id="btn-chat" name="action" value="envoyer"/>
                        <input type="submit" class="btn btn-primary btn-sm" id="btn-chat" name="action" value="boite du discussion"/>
                        </div>
                        </div>
                        </div>
                        
                        </div>
                        </form>
                        
                      </div> 
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