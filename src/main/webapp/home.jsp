<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="java.sql.*"%>
   
    
<%

String typeUser = "";
String login = "";
if(session.getAttribute("username") != null){
    
    typeUser = session.getAttribute("typeUser").toString();
    login = session.getAttribute("username").toString();
} else {
    response.sendRedirect("home.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  
    <title>Bibliotheque</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <style type="text/css">
    .old-container{
    	width: 100%;
    	height: 100vh;
    }
  .head-div {
  display: flex;
  align-items: center;
  padding-top: 40px;
  flex-direction: column;
  justify-content: center;
}

    .mycontainer{
    width: 100%;
    height: calc(100% - 300px);
    display: flex;
   gap: 50px;
   align-items: center;
  justify-content: center;
    background-image('https://fr.freepik.com/photos-gratuite/livre-bibliotheque-manuel-ouvert_3737794.htm#query=bibliotheque&position=2&from_view=keyword&track=sph&uuid=511c5be7-b585-4d01-9cb5-3f21e6a310e4?log-in=google')
    }
    
     .mycontainer div{
      width: 500px;
      height: 350px;
      box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 29px 0px;
     }
     
     .mycontainer ul{
     	list-style: none;
     	padding:0;
     	margin: 0;
     	color: black;
     }
     .mycontainer h5{
     color: white;
      padding: 15px 30px;
      background: #1C2942;
      margin: 0;
     }
     .mycontainer ul a{
     color: black;
     display: block;
     padding: 15px 30px;
     text-decoration: none;
border-bottom: 1px solid grey;
     }
     .mycontainer ul a:hover{
     color: white;
     background: #3B556D;
     }
     
     .a-logout{
     	color: white;
     	text-decoration: none;
     	padding: 10px 15px;
     	background: #1C2942;
     	border-radius: 5px;
     	border: 2px solid #1C2942;
     }
      .a-logout:hover{
     	color: red;
     	text-decoration: none;
     	background: white;
     	border: 2px solid red;
     }
    </style>
</head>


<body>

<%
session.setAttribute("titre", "Home");
%>


 
        <%
        if (typeUser.equals("gestionnaire")) {
        %>
<div class='old-container'>
  <div class='head-div'>
   <img width="100px" src="./images/imageBiblio.png" alt="">
       
    <h1>Espace pour le <%= typeUser %></h1>
     <p><%= typeUser %> connecté : <%= login %></p>
      <a class="a-logout" href="Logout"><i class="fas fa-sign-out-alt"></i>Se déconnecter</a>
     
     
  </div>

<div class="mycontainer">
    <div>
        <h5>Gestion des emprunteurs</h5>
        <ul>
            <a href="EmprunteurManager">
                <li>Afficher la liste des emprunteurs : pour effectuer une recherche et pouvoir supprimer un emprunteur</li>
            </a>
            <a href="addEmprunteur.jsp">
                <li>Ajouter un nouvel emprunteur</li>
            </a>
            <a href="SanctionManager">
                <li>Sanctionner un emprunteur : effectuer une recherche sur un emprunteur pour appliquer des sanctions</li>
            </a>
        </ul>
    </div>
    <div>
        <h5>Gestion des bibliothécaires</h5>
        <ul>
            <a href="BibliothecaireManager">
                <li>Afficher la liste des bibliothécaires : pour effectuer une recherche et pouvoir supprimer un bibliothécaire</li>
            </a>
            <a href="addBibliothecaire.jsp">
                <li>Ajouter un nouveau bibliothécaire</li>
            </a>
        </ul>
    </div>
</div>




    <%
        }
        else{
        %>
      <div class='old-container'>
  <div class='head-div'>
   <img width="100px" src="./images/imageBiblio.png" alt="">
       
    <h1>Espace pour le <%= typeUser %></h1>
     <p><%= typeUser %> connecté : <%= login %></p>
      <a class="a-logout" href="Logout"><i class="fas fa-sign-out-alt"></i>Se déconnecter</a>
  </div>
<div class="mycontainer">
    <div>
        <h5>Gestion des ouvrages</h5>
        <ul>
            <a href="OuvrageManager">
                <li><i class="fas fa-list-alt"></i>Liste des ouvrages</li>
            </a>
            <a href="addOuvrage.jsp">
                <li><i class="fas fa-plus"></i>Ajouter un nouvel ouvrage</li>
            </a>
        </ul>
    </div>
    <div>
        <h5>Gestion des Emprunts</h5>
        <ul>
            <a href="ListEmprunt">
                <li><i class="fas fa-list-alt"></i>Restitution emprunt</li>
            </a>
            <a href="EmpruntManager">
                <li><i class="fas fa-plus"></i>Ajouter un nouveau emprunt</li>
            </a>
            <a href="ProlongeManager">
                <li><i class="fas fa-plus"></i>Prolonger un emprunt</li>
            </a>
            <a href="ImprimeEmprunt">
                <li><i class="fas fa-print"></i>Imprimer la liste des emprunts</li>
            </a>
        </ul>
    </div>
</div>

  
</div>
    <%
        }
        
        %>


</body>
<style>
    .custom-container {
        margin-top: 100px;
        margin-bottom: 100px;
    }
</style>
</html>
