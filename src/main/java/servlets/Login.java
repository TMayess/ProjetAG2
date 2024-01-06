package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Utilisateur;

import java.io.IOException;


import dao.LoginDao;


public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Utilisateur userLogin = LoginDao.login(username, password);
        if (userLogin != null) {
        	HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("typeUser", userLogin.getTypeUtilisateur());
            
            response.sendRedirect("home.jsp");
        }else {
        	String errorMessage = "Erreur de connexion";
        	request.getSession().setAttribute("errorMessage", errorMessage);
        	response.sendRedirect("Login");
        }
        
    }
}
