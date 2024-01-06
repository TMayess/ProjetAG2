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
        <h2>Liste emprunteur</h2>
        <form class="form-inline mb-3" method="post">
            <input type="number" class="form-control mr-2" id="searchInput" name="searchInput" placeholder="Rechercher par ID...">
            <button type="submit" class="btn btn-primary">Rechercher</button>
        </form>
        <table class="table table-bordered">
            <tr  class="thead-light">
                <th>Id</th>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Date de Naissance</th>
                <th>Adresse</th>
                <th>Mobile</th>
                <th>Email</th>
                <th>Action</th>
            </tr>
            <%
            List<Emprunteur> emprunteurs = (List<Emprunteur>) request.getAttribute("emprunteurs");
            for (Emprunteur emprunteur : emprunteurs) { %>
                <tr>
                    <td><%= emprunteur.getIdEmprunteur() %></td>
                    <td><%= emprunteur.getNom() %></td>
                    <td><%= emprunteur.getPrenom() %></td>
                    <td><%= emprunteur.getDateNaissance() %></td>
                    <td><%= emprunteur.getAdresse() %></td>
                    <td><%= emprunteur.getMobile() %></td>
                    <td><%= emprunteur.getEmail() %></td>
                    <td><a href="AddEmprunt?IdEmprunteur=<%=emprunteur.getIdEmprunteur() %>" class="btn btn-primary">Emprunter</a></td>
                </tr>
            <% } %>
        </table>
    </div>
</body>
</html>
