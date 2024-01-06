package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Utilisateur;

public class LoginDao {
	
	public static Utilisateur login(String username, String password) {
	    DBManager dbManager = new DBManager();
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet rs = null;

	    try {
	        connection = dbManager.getConnection();
	        String query = "SELECT * FROM utilisateur WHERE Nom=? AND MotDePasse=?";
	        preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setString(1, username);
	        preparedStatement.setString(2, password);

	        rs = preparedStatement.executeQuery();

	        if (rs.next()) {
	            Utilisateur utilisateur = new Utilisateur(
	                rs.getString("IdUtilisateur"),
	                rs.getString("Nom"),
	                rs.getString("TypeUtilisateur"),
	                rs.getString("MotDePasse")
	            );
	            return utilisateur;
	        } 
	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();

	    } finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return null;
	}

}
