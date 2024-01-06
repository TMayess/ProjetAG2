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
import dao.UserDao;

/**
 * Servlet implementation class AddBibliothecaire
 */
public class AddBibliothecaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBibliothecaire() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("username") != null) {
            String IdUtilisateur = request.getParameter("IdUtilisateur");
            String Nom = request.getParameter("Nom");
            String MotDePasse = request.getParameter("MotDePasse");

            boolean successAdd;
            try {
                successAdd = UserDao.addUtilisateur(IdUtilisateur, Nom, "bibliothecaire", MotDePasse);
                if (successAdd) {
                    response.sendRedirect("BibliothecaireManager");
                }
            } catch (DaoException e) {
                String errorMessage = e.getMessage();
                request.setAttribute("errorMessage", errorMessage);
                RequestDispatcher dispatcher = request.getRequestDispatcher("addBibliothecaire.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            response.sendRedirect("Login.jsp");
        }
    }
}
