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

import dao.EmpruntDao;
import dao.EmprunteurDao;
import dao.OuvrageDao;

/**
 * Servlet implementation class ListEmprunt
 */
public class ListEmprunt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListEmprunt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
   
    	List<Emprunt> emprunts = EmpruntDao.getAllEmprunt(null);
  
    	

        request.setAttribute("emprunts", emprunts);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listEmprunt.jsp");
        dispatcher.forward(request, response);
        
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	        String searchId = request.getParameter("searchInput");
	        String rendreEmpruntId = request.getParameter("rendreEmpruntId");
	        
	        int rendreEmpruntIdInt = 0;
	       
	        if (rendreEmpruntId != null && !rendreEmpruntId.isEmpty()) {
	            rendreEmpruntIdInt = Integer.parseInt(rendreEmpruntId);
	            Emprunt emprunt = EmpruntDao.getEmpruntById(rendreEmpruntId);
	            OuvrageDao.increaseNbExemplaire(rendreEmpruntIdInt ,emprunt.getISBN());
	        }
	        
	           
	     	List<Emprunt> emprunts = EmpruntDao.getAllEmprunt(searchId);

	        request.setAttribute("emprunts", emprunts);

	        RequestDispatcher dispatcher = request.getRequestDispatcher("listEmprunt.jsp");
	        dispatcher.forward(request, response);
	}

}
