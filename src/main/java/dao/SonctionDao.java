package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class SonctionDao {
	
	public static boolean addSanction(int idUtilisateur) throws DaoException {
	    DBManager dbManager = new DBManager();
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    System.out.print(idUtilisateur);
	    System.out.print("zzzzzzzzzzzzzzzzzz");

	    try {
	    	
	        LocalDate dateDebut = LocalDate.now();
	        LocalDate dateFin = dateDebut.plusMonths(2);

	        connection = dbManager.getConnection();
	        String query = "INSERT INTO sanction (DateDebut, DateFin, IdUtilisateur) " +
	                       "VALUES (?, ?, ?)";

	        preparedStatement = connection.prepareStatement(query);
	        
	        preparedStatement.setDate(1, Date.valueOf(dateDebut));
	        preparedStatement.setDate(2, Date.valueOf(dateFin));
	        preparedStatement.setInt(3, idUtilisateur);

	        int rowsAffected = preparedStatement.executeUpdate();

	        if (rowsAffected > 0) {
	            System.out.println("L'insertion de la sanction a réussi. " + rowsAffected + " ligne(s) ajoutée(s).");
	            return true;
	        } else {
	            throw new DaoException("L'insertion de la sanction a échoué. Aucune ligne ajoutée.");
	        }

	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	        throw new DaoException(e.getMessage());
	    } finally {
	        try {
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new DaoException(e.getMessage());
	        }
	    }
	}
}
