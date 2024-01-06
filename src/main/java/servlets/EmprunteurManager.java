package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Emprunteur;

import java.io.IOException;
import java.util.List;

import dao.EmprunteurDao;


public class EmprunteurManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmprunteurManager() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Emprunteur> emprunteurs = EmprunteurDao.getAllEmprunteur();   
  
	
        
        request.setAttribute("emprunteurs", emprunteurs);

        RequestDispatcher dispatcher = request.getRequestDispatcher("emprunteurManager.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String searchId = request.getParameter("searchInput");
        
		List<Emprunteur> emprunteurs = EmprunteurDao.searchAllEmprunteurWithID(searchId);
	


        request.setAttribute("emprunteurs", emprunteurs);


        RequestDispatcher dispatcher = request.getRequestDispatcher("emprunteurManager.jsp");
        dispatcher.forward(request, response);
	}

}
