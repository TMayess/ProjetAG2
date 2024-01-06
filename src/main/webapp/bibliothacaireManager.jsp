<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="models.Utilisateur" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Bibliothèque</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <style>
        @media print {
            body * {
                visibility: hidden;
            }
            #tableToPrint, #tableToPrint * {
                visibility: visible;
            }
            #tableToPrint {
                position: absolute;
                left: 0;
                top: 0;
            }
        }
    </style>
</head>
<body>
<%
    session.setAttribute("titre", "Gestion d'utilisateur");
%>
<%@ include file="header.jsp" %>
<div class="container">
<h1>Gestion des bibliothecaire</h1>
    <h2>Liste des Utilisateurs</h2>
    <form class="form-inline mb-3" method="post">
        <input type="number"  class="form-control mr-2" id="searchInput" name="searchInput" placeholder="Rechercher par ID...">
        <button type="submit" class="btn btn-primary">Rechercher</button>
    </form>
    <div id="tableToPrint">
        <table class="table table-bordered">
            <thead class="thead-light">
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Nom</th>
                    <th scope="col">Type Utilisateur</th>
                    <th scope="col">Mot de Passe</th>
                    <th class="print-hidden" scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
                <%
                List<Utilisateur> utilisateurs = (List<Utilisateur>) request.getAttribute("utilisateurs");
                for (Utilisateur utilisateur : utilisateurs) { %>
                    <tr>
                        <td><%= utilisateur.getIdUtilisateur() %></td>
                        <td><%= utilisateur.getNom() %></td>
                        <td><%= utilisateur.getTypeUtilisateur() %></td>
                        <td><%= utilisateur.getMotDePasse() %></td>
                        <td class="print-hidden"><a href="DeleteUtilisateur?IdUtilisateur=<%=utilisateur.getIdUtilisateur() %>" class="btn btn-danger">Supprimer</a></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>
    <a href="addBibliothecaire.jsp" class="btn btn-success">Ajouter un Utilisateur</a>
</div>
<style>
    @media print {
        .print-hidden {
            display: none;
        }
    }
</style>
</body>
</html>
