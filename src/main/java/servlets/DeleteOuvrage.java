package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dao.OuvrageDao;


public class DeleteOuvrage extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
      
            String ISBN = request.getParameter("ISBN");

            boolean successDelete = OuvrageDao.deleteOuvrage(ISBN);
            
            if (successDelete) {
            	response.sendRedirect("OuvrageManager");
            }
            
     
    }
}