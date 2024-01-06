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
import java.util.Map.Entry;

import dao.DaoException;
import dao.EmpruntDao;
import dao.SonctionDao;

/**
 * Servlet implementation class SanctionManager
 */
public class SanctionManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SanctionManager() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   	String sanctionEmprunteurId = (String) request.getAttribute("sanctionId");

	   	if (sanctionEmprunteurId != null && !sanctionEmprunteurId.isEmpty()) {
		   	int sanctionEmprunteurIdInt = Integer.parseInt(sanctionEmprunteurId);

	   		EmpruntDao.prolongeEmprunt(sanctionEmprunteurIdInt);
	   	}
    	List<Entry<Emprunt, Emprunteur>> emprunts = EmpruntDao.getEmpruntsEmprunteurExpire("");

        request.setAttribute("emprunts", emprunts);


        RequestDispatcher dispatcher = request.getRequestDispatcher("sanctionManager.jsp");
        dispatcher.forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   	String sanctionEmprunteurId = (String) request.getParameter(("sanctionId"));
	   	String searchInput = (String) request.getParameter(("searchInput"));
	   	if( searchInput != null && searchInput.isEmpty()) {
	   		searchInput = "";
	   	}
	   	
	   	
	   	System.out.print(sanctionEmprunteurId);
	   	
	   	if (sanctionEmprunteurId != null && !sanctionEmprunteurId.isEmpty()) {
		   	int sanctionEmprunteurIdInt = Integer.parseInt(sanctionEmprunteurId);

	   		try {
				SonctionDao.addSanction(sanctionEmprunteurIdInt);
			} catch (DaoException e) {
				e.printStackTrace();
			}
	   	}
    	List<Entry<Emprunt, Emprunteur>> emprunts = EmpruntDao.getEmpruntsEmprunteurExpire(searchInput);

        request.setAttribute("emprunts", emprunts);


        RequestDispatcher dispatcher = request.getRequestDispatcher("sanctionManager.jsp");
        dispatcher.forward(request, response);

	}

}
