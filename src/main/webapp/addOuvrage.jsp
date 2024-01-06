
<%@ page language="java"%>
<%@ page import="java.sql.*"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bibliotheque</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
          
    <!-- Intégration de Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
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
    <%@ include file="header.jsp" %>
    <div class="container">
        <% 
            String errorMessage = (String) request.getAttribute("errorMessage");
            if (errorMessage != null && !errorMessage.isEmpty()) {
        %>
            <div class="alert alert-danger" role="alert">
                <%= errorMessage %>
            </div>
        <% } %>
        
        <!-- Formulaire avec icônes -->
        <h1 >Gestion des ouvrages</h1>
        <h2 >Ajouter un Ouvrage</h2>

        <form method="POST" action="AddOuvrage">
            <table class="table table-bordered">
                <tr>
                    <td><i class="fas fa-barcode"></i> ISBN</td>
                    <td><input type="text" name="ISBN" class="form-control" required></td>
                </tr>
                <tr>
                    <td><i class="fas fa-heading"></i> Titre</td>
                    <td><input type="text" name="Titre" class="form-control" required></td>
                </tr>
                <tr>
                    <td><i class="fas fa-calendar-alt"></i> Année</td>
                    <td><input type="text" name="Année" class="form-control" required></td>
                </tr>
                <tr>
                    <td><i class="fas fa-book-open"></i> Type</td>
                    <td><input type="text" name="Type" class="form-control" required></td>
                </tr>
                <tr>
                    <td><i class="fas fa-bookmark"></i> Editeur</td>
                    <td><input type="text" name="Editeur" class="form-control" required></td>
                </tr>
                <tr>
                    <td><i class="fas fa-user"></i> Auteur</td>
                    <td><input type="text" name="Auteur" class="form-control" required></td>
                </tr>
                <tr>
                    <td><i class="fas fa-clone"></i> Nombre d'exemplaires</td>
                    <td><input type="text" name="nbExemplaire" class="form-control" required></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <button type="submit" class="btn btn-success">
                            Ajouter <i class="fas fa-plus-circle"></i>
                        </button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>