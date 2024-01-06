package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Emprunteur;
import models.Ouvrage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import com.itextpdf.awt.geom.Rectangle;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import dao.DaoException;
import dao.EmpruntDao;
import dao.OuvrageDao;

/**
 * Servlet implementation class ValideEmprunt
 */
public class ValideEmprunt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	public ValideEmprunt() {
	    
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String searchId = request.getParameter("searchInput");
 
        
  

        String idEmprunteur = request.getParameter("IdEmprunteur");

        if (idEmprunteur != null && !idEmprunteur.isEmpty()) {
            try {
                int emprunteur = Integer.parseInt(idEmprunteur);

                List<Ouvrage> ouvrageList = (List<Ouvrage>) session.getAttribute("ouvrageSelectedList");

                LocalDate dateDebut = LocalDate.now();

                LocalDate dateFin = dateDebut.plusDays(14);


                Date dateDebutSql = Date.valueOf(dateDebut);
                Date dateFinSql = Date.valueOf(dateFin);

               if(ouvrageList != null){
            	   for (Ouvrage ouvrage : ouvrageList) {
                       try {
                           EmpruntDao.AddEmprunt(emprunteur, ouvrage.getISBN(), dateDebutSql, dateFinSql);
                           OuvrageDao.decreaseNbExemplaire(ouvrage.getISBN());
                       } catch (DaoException e) {
                           e.printStackTrace();
                       }
                   }
        

            	   Document document = new Document(PageSize.A6);
     
            	document.setMargins(10, 10, 10, 10);
               	response.setContentType("application/pdf");
            	response.setHeader("Content-Disposition", "attachment;filename=result.pdf");
            	   try {
            		   PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());
            		    document.open();

            		    PdfPTable table = new PdfPTable(2);
            		    table.setWidthPercentage(50);

            		   

            		    // Espacement avant le titre
            		    document.add(new Paragraph("\n"));

            		    // Titre du reçu d'emprunt centré
            		    Paragraph title = new Paragraph("Reçu d'emprunt");
            		    title.setAlignment(Element.ALIGN_CENTER);
            		    document.add(title);

            		    // Espacement après le titre
            		    document.add(new Paragraph("\n"));

            		    // Ligne séparatrice
            		    document.add(new LineSeparator());

            		    // Informations sur l'emprunteur
            		    document.add(new Paragraph("Matricule de l'emprunteur : " + emprunteur));
         

            		    // Liste des ouvrages empruntés
            		    document.add(new Paragraph("Liste des ouvrages empruntés :"));
            		    for (Ouvrage ouvrage : ouvrageList) {
            		        document.add(new Paragraph("ISBN : " + ouvrage.getISBN()));
            		 
            		    }

            		    // Dates de début et de fin de l'emprunt
            		    document.add(new Paragraph("Date de début d'emprunt : " + LocalDate.now()));
            		    document.add(new Paragraph("Date de fin d'emprunt : " + LocalDate.now().plusDays(14)));


            		    document.add(table);
            		    document.close();

            		    System.out.println("PDF generated successfully!");
            		      session.removeAttribute("ouvrageSelectedList");
            	          response.sendRedirect("EmpruntManager");


            		} catch (DocumentException | IOException e) {
            		    e.printStackTrace();
            		}
               }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
      

        }
    }
	   private static void addRowToTable(PdfPTable table, String key, String value) {
	        PdfPCell cellKey = new PdfPCell(new Phrase(key, FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD)));
	        PdfPCell cellValue = new PdfPCell(new Phrase(value, FontFactory.getFont(FontFactory.HELVETICA, 12)));

	        table.addCell(cellKey);
	        table.addCell(cellValue);
	    }

}
