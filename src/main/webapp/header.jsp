<%@ page import="java.sql.*"%>
<%
String login = "";
String typeUser = "";

if(session.getAttribute("username") != null){
    login = session.getAttribute("username").toString();
    typeUser = session.getAttribute("typeUser").toString();
} else {
    response.sendRedirect("home.jsp");
}
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Barre de navigation latérale</title>
    <!-- Ajouter vos liens vers les bibliothèques externes ici -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
     <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
     <style>
        /* Votre style CSS pour la mise en page */
        .sidebar {
            height: 100%;
            background-color: #1C2942; 
            position: fixed;
            top: 0;
            left: 0;
            overflow-x: hidden;
            padding-top: 20px;
            display: flex;
            flex-direction: column;
            color: white;
        }

        .sidebar a {
            padding: 8px 20px;
            text-decoration: none;
            font-size: 1rem;
            color: white;
            display: flex;
            align-items: center;
            transition: 0.3s;
        }
        .sidebar i {
            margin: 10px;
        }
        

        .sidebar a:hover {
            background-color: #3B556D; 
        }

        .sidebar h3 {
            margin: 10px 20px;
            display: flex;
            align-items: center;
            font-size: 20px;
        }

        .profile {
            display: flex;
            flex-direction: column;
            align-items: center;
            padding: 10px;
        }

        .profile i {
            font-size: 40px; /* Taille de l'icône utilisateur */
            margin-bottom: 5px;
        }

        .profile p {
            margin-bottom: 0;
        }

        .role {
            display: flex;
            align-items: center;
            font-size: 14px;
        }

        .role i {
            margin: 5px;
        }

        .sidebar .logout {
            color: #ff3333;
           border-radius: 10px;
            padding: 7px 15px;
            font-size: 16px;
            margin-top: 40px;
            margin-left: 40px;
            margin-right: 40px;
            cursor: pointer;
            margin-top:35px;
            border: 2px solid #ff3333;
        }
        .sidebar .logout:hover{
        color: white;
        background-color: #ff3333;
        }
         

        .logout i {
            margin-right: 8px;
        }

        /* Styles pour les lignes de séparation */
        .sidebar hr {
            width: 90%;
           border: 0.5px solid white; 
        
        }
          .container {
            margin: 10px;
            margin-left: 250px;
            float: right;
            width: calc(100% - 350px);
        }
          @media print {
		    .no-print {
		      display: none;
		    }
		  }
        
    </style>
    </style>
</head>
<body>

<div class="sidebar no-print">
    <div class="profile">
        <i class="fas fa-user-circle"></i>
        <p><%= login %></p>
        <div class="role">
            <p><%= typeUser %></p>
        </div>
        <a class href='home.jsp'>Home</a>
    </div>
    <% if (typeUser.equals("gestionnaire")) { %>
  
    <div>
        <hr>
        <h3> Gestion des emprunteurs</h3>
        <!-- Ajoutez ici les liens vers les pages ou les actions pour la gestion des emprunteurs -->
        <a href="EmprunteurManager"><i class="fas fa-list"></i>Liste des emprunteurs</a>
        <a href="addEmprunteur.jsp"><i class="fas fa-user-plus"></i>Ajouter un emprunteur</a>
        <a href="SanctionManager"><i class="fas fa-list"></i>Sanctionner un emprunteur</a>
        
    </div>
      <div>
        <hr>
        <h3>Gestion des bibliothecaire</h3>
 			<a href="BibliothecaireManager"><i class="fas fa-list"></i>Liste des bibliothecaire</a>
        	<a href="addBibliothecaire.jsp"><i class="fas fa-user-plus"></i>Ajouter un bibliothecaire</a>
    </div>
    <% } else { %>
      <div>
        <hr>
        <h3>Gestion des ouvrages</h3>
        <!-- Ajoutez ici les liens vers les pages ou les actions pour la gestion des ouvrages -->
        <a href="OuvrageManager"><i class="fas fa-list-alt"></i>Liste des ouvrages</a>
        <a href="addOuvrage.jsp"><i class="fas fa-plus"></i>Ajouter un nouvel ouvrage</a>
    </div>
    <div>
    
        <hr>
        <h3></i>Gestion des Emprunts</h3>
        <!-- Ajoutez ici les liens vers les pages ou les actions pour la gestion des emprunts -->
        <a href="ListEmprunt"><i class="fas fa-list-alt"></i>Restitution emprunt</a>
        <a href="EmpruntManager"><i class="fas fa-plus"></i>Ajouter un nouveau emprunt</a>
        <a href="ProlongeManager"><i class="fas fa-plus"></i>Prolonger un emprunt</a>
        <a href="ImprimeEmprunt"><i class="fas fa-print"></i>Imprimer la liste des emprunt</a>
    </div>
  
 
    <% } %>
       <a class="logout" href="Logout"><i class="fas fa-sign-out-alt"></i>Se déconnecter</a>
</div>

</body>
</html>