package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Emprunt;

import java.io.IOException;
import java.util.List;

import dao.EmpruntDao;

/**
 * Servlet implementation class ProlongeManager
 */
public class ProlongeManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProlongeManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   	String prolongerEmpruntId = (String) request.getAttribute("addTimeEmprunt");

	   	if (prolongerEmpruntId != null && !prolongerEmpruntId.isEmpty()) {
		   	int prolongerEmpruntIdInt = Integer.parseInt(prolongerEmpruntId);

	   		EmpruntDao.prolongeEmprunt(prolongerEmpruntIdInt);
	   	}
    	List<Emprunt> emprunts = EmpruntDao.getAllEmpruntNotRendu("");

        request.setAttribute("emprunts", emprunts);


        RequestDispatcher dispatcher = request.getRequestDispatcher("prolongeManager.jsp");
        dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String prolongerEmpruntId = request.getParameter("addTimeEmprunt");
		String searchInput = (String) request.getParameter(("searchInput"));
	  

	   	if (prolongerEmpruntId != null && !prolongerEmpruntId.isEmpty()) {
		   	int prolongerEmpruntIdInt = Integer.parseInt(prolongerEmpruntId);

	   		EmpruntDao.prolongeEmprunt(prolongerEmpruntIdInt);
	   	}
		List<Emprunt> emprunts = EmpruntDao.getAllEmpruntNotRendu(searchInput);


        request.setAttribute("emprunts", emprunts);


        RequestDispatcher dispatcher = request.getRequestDispatcher("prolongeManager.jsp");
        dispatcher.forward(request, response);
	}

}
