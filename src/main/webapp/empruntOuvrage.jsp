<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="models.Ouvrage" %>
<%@ page import="models.Emprunteur" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Bibliotheque</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
    <%@ include file="header.jsp" %>
    <div class="container ">
    
    <%
        Emprunteur emprunteur = (Emprunteur) request.getAttribute("emprunteur") ;
        List<Ouvrage> ouvrageSelectedList = (List<Ouvrage>) session.getAttribute("ouvrageSelectedList");
    %>
    <h2 class="mt-4">Emprunteur c'est :</h2>
    <ul class="list-group">
        <li class="list-group-item">ID : <%= emprunteur.getIdEmprunteur() %></li>
        <li class="list-group-item">Nom : <%= emprunteur.getNom() %></li>
        <li class="list-group-item">Prénom : <%= emprunteur.getPrenom() %></li>
        <li class="list-group-item">Date de naissance : <%= emprunteur.getDateNaissance() %></li>
        <li class="list-group-item">Adresse : <%= emprunteur.getAdresse() %></li>
        <li class="list-group-item">Mobile : <%= emprunteur.getMobile() %></li>
        <li class="list-group-item">Email : <%= emprunteur.getEmail() %></li>
    </ul>
    
    <h2 class="mt-4">Listes d'ouvrages disponibles</h2>
    <form id="searchForm" method="post" class="form-inline mb-4">
        <input id="searchInput" name="searchInput" class="form-control mr-sm-2" placeholder="Rechercher par ISBN...">
        <button type="submit" class="btn btn-primary">Rechercher</button>
    </form>
    
    <table class="table table-bordered">
        <thead class="thead-light">
            <tr>
                <th>ISBN</th>
                <th>Titre</th>
                <th>annee</th>
                <th>Type</th>
                <th>Edition</th>
                <th>NbExmplaire</th>
                <th>auteur</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
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
                    <td>
                        <form method="post">
                            <input type="hidden" class="selectedBookISBN" name="selectedBookISBN" value="<%= ouvrage.getISBN() %>">
                            <button type="submit" class="btn btn-success">Ajouter au panier</button>
                        </form>
                    </td>
                </tr>
            <%
                }
            %>
        </tbody>
    </table>
    
    <table class="table table-bordered">
        <thead class="thead-light">
             <tr>
                <th>ISBN</th>
                <th>Titre</th>
                <th>annee</th>
                <th>Type</th>
                <th>Edition</th>
                <th>NbExmplaire</th>
                <th>auteur</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <%
                if (ouvrageSelectedList != null) {
                    for (Ouvrage ouvrage : ouvrageSelectedList) {
            %>
                <tr>
                    <td><%= ouvrage.getISBN() %></td>
                    <td><%= ouvrage.getTitre() %></td>
                    <td><%= ouvrage.getAnnee() %></td>
                    <td><%= ouvrage.getType() %></td>
                    <td><%= ouvrage.getEditeur() %></td>
                    <td><%= ouvrage.getNbExemplaire() %></td>
                    <td><%= ouvrage.getAuteur() %></td>
                    <td>
                        <form method="post">
                            <input type="hidden" name="isbnToRemove" value="<%= ouvrage.getISBN() %>">
                            <button type="submit" class="btn btn-danger">Supprimer</button>
                        </form>
                    </td>
                </tr>
            
            <%
                    }
                }
            %>
        </tbody>
    </table>
    
    <form method="post" action="ValideEmprunt">
        <input type="hidden" class="IdEmprunteur" name="IdEmprunteur" value="<%= emprunteur.getIdEmprunteur() %>">
        <button type="submit" class="btn btn-primary">Valider l'emprunt</button>
    </form>
    
    </div>
    
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgydCEOpk1TIzk5VXsSczP9I6L6wDQj4mD7dF6e6IZb6a6RNRNyGjy1q13Pi" crossorigin="anonymous"></script>
</body>
</html>
