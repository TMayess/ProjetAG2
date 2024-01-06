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
    
    <h1 class="mt-4">Gestion des emprunteurs</h1>
 	<h2 class="mt-4">Ajouter un Emprunteur</h2>
    <form method="POST" action="AddEmprunteur">
        <table class="table table-bordered">
  <tr>
    <td><i class="fas fa-id-card"></i> IdEmprunteur</td>
    <td><input type="text" name="IdEmprunteur" class="form-control" required></td>
</tr>
<tr>
    <td><i class="fas fa-user"></i> Nom</td>
    <td><input type="text" name="Nom" class="form-control" required></td>
</tr>
<tr>
    <td><i class="fas fa-user"></i> Prenom</td>
    <td><input type="text" name="Prenom" class="form-control" required></td>
</tr>
<tr>
    <td><i class="fas fa-calendar"></i> Date Naissance</td>
    <td><input type="date" name="DateNaissance" class="form-control" required></td>
</tr>
<tr>
    <td><i class="fas fa-map-marker-alt"></i> Adresse</td>
    <td><input type="text" name="Adresse" class="form-control" required></td>
</tr>
<tr>
    <td><i class="fas fa-mobile-alt"></i> Mobile</td>
    <td><input type="tel" name="Mobile" class="form-control" required></td>
</tr>
<tr>
    <td><i class="fas fa-envelope"></i> Email</td>
    <td><input type="email" name="Email" class="form-control" required></td>
</tr>
<tr>
    <td><i class="fas fa-user-tag"></i> Type</td>
    <td>
        <select name="Type" class="form-control" required>
            <option value="etudiant">Etudiant</option>
            <option value="enseignant">Enseignant</option>
            <option value="etudiant_etranger">Etudiant etranger</option>
        </select>
    </td>
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
