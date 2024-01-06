<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="models.Emprunt" %>
<%@ page import="models.Emprunteur" %>
<%@ page import="java.util.Map.Entry" %>
<%@ page import="java.util.List" %>
   
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Bibliotheque</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">


	<style>
	.a{
	background-color: #ff3333;
	}
	
	</style>
</head>

<body>

<%
session.setAttribute("titre", "Gestion des sanction");
%>
    <%@ include file="header.jsp" %>
    
    <div class="container">
    <h1 class="mt-4">Gestion des emprunteurs</h1>
        <h2 class="mt-4">Sanctionner un emprunteur</h2>

        <form id="searchForm" method="post" class="form-inline mb-4">
            <input id="searchInput" name="searchInput" class="form-control mr-sm-2" placeholder="Rechercher par ID...">
            <button type="submit" class="btn btn-primary">Rechercher</button>
        </form>

        <table class="table table-bordered">
            <thead class="thead-light">
                <tr>
                    <th>IdEmprunt</th>
                    <th>IdEmprunteur</th>
                    <th>Nom</th>
                    <th>Prenom</th>
                    <th>ISBN</th>
                    <th>DateEmprunt</th>
                    <th>DateRendre</th>
                    <th>Rendu</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <% 
                List<Entry<Emprunt, Emprunteur>> empruntEmprunteurPairs = (List<Entry<Emprunt, Emprunteur>>) request.getAttribute("emprunts");

                for (Entry<Emprunt, Emprunteur> entry : empruntEmprunteurPairs) {
                    Emprunt emprunt = entry.getKey();
                    Emprunteur emprunteur = entry.getValue();
                %>
               <% if (emprunt.getDateEmprunt().compareTo(emprunt.getDateRendre()) > 0) { %>
    <tr class="a">
<% } else { %>
    <tr>
<% } %>
                        <td><%= emprunt.getIdEmprunt() %></td>
                        <td><%= emprunt.getIdEmprunteur() %></td>
                        <td><%= emprunteur.getNom() %></td>
                        <td><%= emprunteur.getPrenom() %></td>
                        <td><%= emprunt.getISBN() %></td>
                        <td><%= emprunt.getDateEmprunt() %></td>
                        <td><%= emprunt.getDateRendre() %></td>
                        <td><%= emprunt.isRendu() %></td>
                        <td>
                            <form method="post">
                                <input type="hidden" name="sanctionId" value="<%= emprunt.getIdEmprunteur() %>">
                                <button type="submit" class="btn btn-warning">Sanctionner</button>
                            </form>
                        </td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgydCEOpk1TIzk5VXsSczP9I6L6wDQj4mD7dF6e6IZb6a6RNRNyGjy1q13Pi" crossorigin="anonymous"></script>
</body>
</html>
