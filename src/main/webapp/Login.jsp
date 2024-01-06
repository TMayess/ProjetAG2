<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
  String errorMessage = (String) session.getAttribute("errorMessage");

  session.removeAttribute("errorMessage");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bibliothèque</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<form method="POST" action="Login">
    <div class="container">
        <div class="text-center my-5">
            <h1>Bienvenue dans notre Bibliothèque</h1>
            <p>Votre source de connaissance, d'aventures et de découvertes.</p>
        </div>
        <div class="row">
            <div class="col-md-6">
                <img src="https://static.licdn.com/aero-v1/sc/h/27wv8uagx5uo86uw1t23je20k" alt="Bibliothèque" class="img-fluid">
            </div>
            <div class="col-md-6 mt-3"> 
                <form>
                <% if (errorMessage != null && !errorMessage.isEmpty()) { %>
		            <div class="alert alert-danger" role="alert">
		                <%= errorMessage %>
		            </div>
		        <% } %>
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Nom d'utilisateur</label>
                        <input type="text" name="username" required class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                    </div>
                    <div class="mb-3">
                        <label for "exampleInputPassword1" class="form-label">Mot de passe</label>
                        <input type="password" name="password" required class="form-control" id="exampleInputPassword1">
                    </div>
                    <button type="submit" class="btn btn-primary">Se connecter</button>
                </form>
               
            </div>
        </div>
    </div>
</form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
