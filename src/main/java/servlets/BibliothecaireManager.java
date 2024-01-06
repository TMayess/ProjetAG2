package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import dao.UserDao;
import models.Utilisateur;

/**
 * Servlet implementation class BibliothecaireManager
 */
public class BibliothecaireManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BibliothecaireManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Utilisateur> utilisateurs = UserDao.getAllBibliothacaire();

        request.setAttribute("utilisateurs", utilisateurs);

        RequestDispatcher dispatcher = request.getRequestDispatcher("bibliothacaireManager.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchId = request.getParameter("searchInput");

        List<Utilisateur> utilisateurs = UserDao.searchAllBibliothecaireWithId(searchId);

        request.setAttribute("utilisateurs", utilisateurs);

        RequestDispatcher dispatcher = request.getRequestDispatcher("bibliothacaireManager.jsp");
        dispatcher.forward(request, response);
    }

}
