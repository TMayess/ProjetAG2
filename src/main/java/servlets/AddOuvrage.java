package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dao.DaoException;
import dao.OuvrageDao; 


public class AddOuvrage extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("username") != null) {
            String ISBN = request.getParameter("ISBN");
            String Titre = request.getParameter("Titre");
            String Annee = request.getParameter("Année"); 
            String Type = request.getParameter("Type");
            String Editeur = request.getParameter("Editeur");
            String Auteur = request.getParameter("Auteur");
            String nbExemplaire = request.getParameter("nbExemplaire");

       
            
            boolean successAdd;
			try {
				successAdd = OuvrageDao.addOuvrage(ISBN, Titre, Annee, Type, Editeur, Auteur, nbExemplaire);
				if (successAdd) {
	            	response.sendRedirect("OuvrageManager");
	            }
			} catch (DaoException e) {
				String errorMessage = e.getMessage();
                request.setAttribute("errorMessage", errorMessage);
                RequestDispatcher dispatcher = request.getRequestDispatcher("addOuvrage.jsp");
                dispatcher.forward(request, response);
            
			}
        } else {
            response.sendRedirect("Login.jsp");
        }
    }
}