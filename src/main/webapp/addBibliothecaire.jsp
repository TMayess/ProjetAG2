<%@ page language="java"%>
<%@ page import="java.sql.*"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bibliothèque</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
<%@ include file="header.jsp" %>
<div class="container">

<%
    String errorMessage = (String) request.getAttribute("errorMessage");
%>

<%
    if (errorMessage != null && !errorMessage.isEmpty()) {
%>
    <div class="alert alert-danger" role="alert">
        <%= errorMessage %>
    </div>
<%
    }
%>
<h1>Gestion des bibliothecaire</h1>
<h2 >Ajouter un Bibliothecaire</h2>

<form method="POST" action="AddBibliothecaire">
     <table class="table table-bordered">
        <tr>
            <td><i class="fas fa-id-card"></i> IdUtilisateur</td>
            <td><input type="text" name="IdUtilisateur" class="form-control" required></td>
        </tr>
        <tr>
            <td><i class="fas fa-user"></i> Nom</td>
            <td><input type="text" name="Nom" class="form-control" required></td>
        </tr>
      
        <tr>
            <td><i class="fas fa-key"></i> MotDePasse</td>
            <td><input type="password" name="MotDePasse" class="form-control" required></td>
        </tr>

        <tr>
            <td colspan="2">
                <button type="submit" class="btn btn-success"><i class="fas fa-plus"></i> Ajouter</button>
            </td>
        </tr>
    </table>
</form>
</div>
</body>
</html>
