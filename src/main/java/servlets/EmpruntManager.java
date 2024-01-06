package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Emprunt;
import models.Emprunteur;

import java.io.IOException;
import java.util.List;

import dao.DaoException;
import dao.EmpruntDao;
import dao.EmprunteurDao;
import dao.OuvrageDao;


public class EmpruntManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	List<Emprunteur> emprunteurs = EmprunteurDao.getAllEmprunteurRenduNotSanction(""); 
    	List<Emprunt> emprunts = EmpruntDao.getAllEmprunt(null);
  
    	
        request.setAttribute("emprunteurs", emprunteurs);
        request.setAttribute("emprunts", emprunts);
        RequestDispatcher dispatcher = request.getRequestDispatcher("empruntManager.jsp");
        dispatcher.forward(request, response);
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String searchId = request.getParameter("searchInput");
        String rendreEmpruntId = request.getParameter("rendreEmpruntId");
        
        int rendreEmpruntIdInt = 0;
        
        if (rendreEmpruntId != null && !rendreEmpruntId.isEmpty()) {
            rendreEmpruntIdInt = Integer.parseInt(rendreEmpruntId);
            Emprunt emprunt = EmpruntDao.getEmpruntById(rendreEmpruntId);
            OuvrageDao.increaseNbExemplaire(rendreEmpruntIdInt ,emprunt.getISBN());
        }
        
        List<Emprunteur> emprunteurs = null;
        emprunteurs = EmprunteurDao.getAllEmprunteurRenduNotSanction(searchId);
           
     	
        request.setAttribute("emprunteurs", emprunteurs);

        RequestDispatcher dispatcher = request.getRequestDispatcher("empruntManager.jsp");
        dispatcher.forward(request, response);
    }

}
