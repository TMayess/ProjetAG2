package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Ouvrage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.OuvrageDao;



public class OuvrageManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public OuvrageManager() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	        List<Ouvrage> ouvrages = OuvrageDao.getAllOuvrage();   
	
	        request.setAttribute("ouvrages", ouvrages);

	        RequestDispatcher dispatcher = request.getRequestDispatcher("ouvrageManager.jsp");
	        dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Ouvrage> ouvrages = new ArrayList<>();
	
		String searchId = request.getParameter("searchInput");
	
		System.out.print(searchId);
		ouvrages = OuvrageDao.searchAllOuvrageWithID(searchId);    
	


        request.setAttribute("ouvrages", ouvrages);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ouvrageManager.jsp");
        dispatcher.forward(request, response);
	}

}

