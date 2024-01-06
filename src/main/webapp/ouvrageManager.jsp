<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ page import="models.Ouvrage" %>
  <%@ page import="java.util.List" %>
   <%@ page import="java.sql.*"%>
    


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Bibliotheque</title>
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
  <style>
        .container {
            margin: 10px;
            margin-left: 250px;
            float: right;
            width: calc(100% - 350px);
        }

    </style>
</head>
<body>
<%
session.setAttribute("titre", "Gestion des ouvrage");
%>
   <%@ include file="header.jsp" %>
<div class="container">
  <h1>Gestion des ouvrages</h1>
    <h2>Liste des Ouvrages</h2>

    	 <form class="form-inline mb-3" method="post">
            <input class="form-control mr-2" id="searchInput" name="searchInput" placeholder="Rechercher par ID...">
            <button type="submit" class="btn btn-primary">Rechercher</button>
        </form>
		
		<form id="selectedBooksForm" method="post">
		<div id="tableToPrint">
		    <table class="table table-bordered">
		        <tr  class="thead-light">
		            <th>ID</th>
		            <th>Nom</th>
		            <th>Prénom</th>
		            <th>Date de Naissance</th>
		            <th>Adresse</th>
		            <th>Mobile</th>
		            <th>Email</th>
		            <th>Sélectionner</th>
		        </tr>
		        <%
		       
		            List<Ouvrage> ouvrages = (List<Ouvrage>) request.getAttribute("ouvrages");
		            for (Ouvrage ouvrage : ouvrages) {
		        %>
		            <tr>
		                <td><%= ouvrage.getISBN() %></td>
		                <td><%= ouvrage.getTitre() %></td>
		                <td><%= ouvrage.getAnnee() %></td>
		                <td><%= ouvrage.getType() %></td>
		                <td><%= ouvrage.getEditeur() %></td>
		                <td><%= ouvrage.getNbExemplaire() %></td>
		                <td><%= ouvrage.getAuteur() %></td>
		                <td><a href="DeleteOuvrage?ISBN=<%= ouvrage.getISBN() %>" class="btn btn-danger">Supprimer</a></td>
		            </tr>
		        <%
		            }
		        %>
		    </table>
		    </div>
    
    <a href="addOuvrage.jsp" class="btn btn-success">Ajouter un Ouvrage</a>

    
    </form>
    

    
    
    
</div>
</body>
</html>

</body>
</html>