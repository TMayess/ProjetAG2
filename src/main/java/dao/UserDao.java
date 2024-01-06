package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Utilisateur;

public class UserDao {
	public static List<Utilisateur> getAllBibliothacaire() {
	    List<Utilisateur> utilisateurs = new ArrayList<>();

	    DBManager dbManager = new DBManager();
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;

	    try {
	        connection = dbManager.getConnection();
	        String query = "SELECT IdUtilisateur, Nom, TypeUtilisateur, MotDePasse FROM utilisateur WHERE TypeUtilisateur = 'bibliothecaire'";

	        preparedStatement = connection.prepareStatement(query);
	        ResultSet result = preparedStatement.executeQuery();

	        while (result.next()) {
	            Utilisateur utilisateur = new Utilisateur();
	            utilisateur.setIdUtilisateur(result.getString("IdUtilisateur"));
	            utilisateur.setNom(result.getString("Nom"));
	            utilisateur.setTypeUtilisateur(result.getString("TypeUtilisateur"));
	            utilisateur.setMotDePasse(result.getString("MotDePasse"));

	            utilisateurs.add(utilisateur);
	        }

	        result.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
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
	        }
	    }
	    return utilisateurs;
	}
	public static Boolean addUtilisateur(String IdUtilisateur, String Nom, String TypeUtilisateur, String MotDePasse) throws DaoException {
	    DBManager dbManager = new DBManager();
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;

	    try {
	        connection = dbManager.getConnection();
	        String query = "INSERT INTO utilisateur (IdUtilisateur, Nom, TypeUtilisateur, MotDePasse) " +
	                "VALUES (?, ?, ?, ?)";

	        preparedStatement = connection.prepareStatement(query);

	        preparedStatement.setString(1, IdUtilisateur);
	        preparedStatement.setString(2, Nom);
	        preparedStatement.setString(3, TypeUtilisateur);
	        preparedStatement.setString(4, MotDePasse);

	        int rowsAffected = preparedStatement.executeUpdate();

	        if (rowsAffected > 0) {
	            System.out.println("L'insertion a réussi. " + rowsAffected + " ligne(s) ajoutée(s).");
	            return true;
	        } else {
	            throw new DaoException("L'insertion a échoué. Aucune ligne ajoutée.");
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
	
	public static List<Utilisateur> searchAllBibliothecaireWithId(String searchId) {
	    
	        List<Utilisateur> utilisateurs = new ArrayList<>();
	        DBManager dbManager = new DBManager();
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;

	        try {
	            connection = dbManager.getConnection();
	            String query = "SELECT * FROM utilisateur WHERE IdUtilisateur LIKE ? AND TypeUtilisateur = 'bibliothecaire'";

	            preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setString(1, searchId + "%");

	            ResultSet result = preparedStatement.executeQuery();

	            while (result.next()) {
	                Utilisateur utilisateur = new Utilisateur();
	                utilisateur.setIdUtilisateur(result.getString("IdUtilisateur"));
	                utilisateur.setNom(result.getString("Nom"));
	                utilisateur.setTypeUtilisateur(result.getString("TypeUtilisateur"));
	                utilisateur.setMotDePasse(result.getString("MotDePasse"));

	                utilisateurs.add(utilisateur);
	            }

	            result.close();
	            return utilisateurs;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
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
	            }
	        }
	    
	    return null;
	}



}
