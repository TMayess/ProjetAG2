<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="models.Emprunt" %>
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
</head>

<body>
<%
session.setAttribute("titre", "Gestion des prolongation");
%>
    <%@ include file="header.jsp" %>
    
    <div class="container">
    <h1>Gestion des Emprunts</h1>
        <h2 >Liste des Emprunts non rendu</h2>
        <form id="searchForm" method="post" class="form-inline mb-4">
            <input id="searchInput" name="searchInput" class="form-control mr-sm-2" placeholder="Rechercher par ID...">
            <button type="submit" class="btn btn-primary">Rechercher</button>
        </form>
        <table class="table">
            <thead>
                <tr  class="thead-light">
                    <th>IdEmprunt</th>
                    <th>IdEmprunteur</th>
                    <th>ISBN</th>
                    <th>IdBibliotecaire</th>
                    <th>DateEmprunt</th>
                    <th>DateRendre</th>
                    <th>Rendu</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <% 
                List<Emprunt> emprunts = (List<Emprunt>) request.getAttribute("emprunts");
                for (Emprunt emprunt : emprunts) { %>
                    <tr>
                        <td><%= emprunt.getIdEmprunt() %></td>
                        <td><%= emprunt.getIdEmprunteur() %></td>
                        <td><%= emprunt.getISBN() %></td>
                        <td><%= emprunt.getIdBibliotecaire() %></td>
                        <td><%= emprunt.getDateEmprunt() %></td>
                        <td><%= emprunt.getDateRendre() %></td>
                        <td><%= emprunt.isRendu() %></td>
                        <td>
                            <form method="post">
                                <input type="hidden" class="addTimeEmprunt" name="addTimeEmprunt" value="<%= emprunt.getIdEmprunt() %>">
                                <button type="submit" class="btn btn-success">Prolonger</button>
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
