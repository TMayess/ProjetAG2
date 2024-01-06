<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="models.Emprunteur" %>
<%@ page import="models.Emprunt" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Bibliotheque</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
<%
session.setAttribute("titre", "Gestion d'emprunt");
%>
    <%@ include file="header.jsp" %>
    <div class="container">
    <h1>Gestion des Emprunts</h1>
        <h2>Liste des Emprunts</h2>
        <form class="form-inline mb-3" method="post">
            <input type="number" class="form-control mr-2" id="searchInput" name="searchInput" placeholder="Rechercher par ID...">
            <button type="submit" class="btn btn-primary">Rechercher</button>
        </form>
        <table class="table ">
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
                
                session.setAttribute("titre", "Gestion des emprunt");

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
                        <%
                        if (!emprunt.isRendu()) {   
                        %>
                        <form method="post">
                            <input type="hidden" class="rendreEmpruntId" name="rendreEmpruntId" value="<%= emprunt.getIdEmprunt() %>">
                            <button class="btn btn-primary" type="submit">Rendre </button>
                        </form>
                        <%
                        }
                        %>
                        </td>
                    </tr>
                <% } %>
            </tbody>
        </table>


    </div>
</body>
</html>
