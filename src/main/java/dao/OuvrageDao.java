package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Ouvrage;

public class OuvrageDao {
	  public static List<Ouvrage> getAllOuvrage(){
	    	List<Ouvrage> ouvrages = new ArrayList<>();
	        DBManager dbManager = new DBManager();
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        

	        try {
	            connection = dbManager.getConnection();
	            String query = "SELECT * FROM ouvrage"; 

	            preparedStatement = connection.prepareStatement(query);
	            ResultSet result = preparedStatement.executeQuery();

	            while (result.next()) {
	                Ouvrage ouvrage = new Ouvrage();
	                ouvrage.setISBN(result.getString("ISBN"));
	                ouvrage.setTitre(result.getString("Titre"));
	                ouvrage.setAnnee(result.getInt("Année"));
	                ouvrage.setType(result.getString("Type"));
	                ouvrage.setEditeur(result.getString("Editeur"));
	                ouvrage.setNbExemplaire(result.getInt("nbExemplaire"));
	                ouvrage.setAuteur(result.getString("Auteur"));

	                ouvrages.add(ouvrage);
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
	        
	        return ouvrages;
	        
	    }
	    
	    
	    public static List<Ouvrage> searchAllOuvrageWithID(String searchId){
	    	List<Ouvrage> ouvrages = new ArrayList<>();
			
	        DBManager dbManager = new DBManager();
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;

	        try {
	            connection = dbManager.getConnection();
	            String query = "SELECT * FROM ouvrage WHERE ISBN LIKE ?"; 

	            preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setString(1, searchId + "%"); 
	            
	            ResultSet result = preparedStatement.executeQuery();

	            while (result.next()) {
	                Ouvrage ouvrage = new Ouvrage();
	                ouvrage.setISBN(result.getString("ISBN"));
	                ouvrage.setTitre(result.getString("Titre"));
	                ouvrage.setAnnee(result.getInt("Année"));
	                ouvrage.setType(result.getString("Type"));
	                ouvrage.setEditeur(result.getString("Editeur"));
	                ouvrage.setNbExemplaire(result.getInt("nbExemplaire"));
	                ouvrage.setAuteur(result.getString("Auteur"));

	                ouvrages.add(ouvrage);
	            }

	            result.close();
	            
	            return ouvrages;
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
	        return ouvrages;

	    }
	    
	    
	    public static Ouvrage getOuvrageById(String searchId) {
	        Ouvrage ouvrage = null;
	        DBManager dbManager = new DBManager();
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;

	        try {
	            connection = dbManager.getConnection();
	            String query = "SELECT * FROM ouvrage WHERE ISBN = ?";

	            preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setString(1, searchId); // Utiliser simplement searchId ici, sans ajout de "%"

	            ResultSet result = preparedStatement.executeQuery();

	       

	            while (result.next()) {
	                ouvrage = new Ouvrage(); 
	                ouvrage.setISBN(result.getString("ISBN"));
	                ouvrage.setTitre(result.getString("Titre"));
	                ouvrage.setAnnee(result.getInt("Année"));
	                ouvrage.setType(result.getString("Type"));
	                ouvrage.setEditeur(result.getString("Editeur"));
	                ouvrage.setNbExemplaire(result.getInt("nbExemplaire"));
	                ouvrage.setAuteur(result.getString("Auteur"));

	             
	            }

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
	        return ouvrage;
	    }
	    
	    public static boolean addOuvrage(String ISBN, String Titre, String Annee, String Type, String Editeur, String Auteur, String nbExemplaire) throws DaoException {
	    	DBManager dbManager = new DBManager();
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;

	        try {
	            connection = dbManager.getConnection();
	            String query = "INSERT INTO ouvrage (ISBN, Titre, Année, Type, Editeur, Auteur, nbExemplaire) VALUES (?, ?, ?, ?, ?, ?, ?)";
	            preparedStatement = connection.prepareStatement(query);

	            preparedStatement.setString(1, ISBN);
	            preparedStatement.setString(2, Titre);
	            preparedStatement.setString(3, Annee);
	            preparedStatement.setString(4, Type);
	            preparedStatement.setString(5, Editeur);
	            preparedStatement.setString(6, Auteur);
	            preparedStatement.setString(7, nbExemplaire);

	     
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
	        }  finally {
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
	    
	    
	    
	    public static boolean deleteOuvrage(String ISBN) {
	    	DBManager dbManager = new DBManager();
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;

	        try {
	            connection = dbManager.getConnection();
	            String query = "DELETE FROM ouvrage WHERE ISBN=?";

	            preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setString(1, ISBN);

	            preparedStatement.executeUpdate();
	            
	            return true;
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
	        return false;
	    }
	    
	    public static void decreaseNbExemplaire(String ISBN) {
	    	DBManager dbManager = new DBManager();
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        try {
	        	connection = dbManager.getConnection();
	            String query = "UPDATE ouvrage SET nbExemplaire = nbExemplaire - 1 WHERE ISBN = ?";

	            preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setString(1, ISBN);

	            preparedStatement.executeUpdate();
	        } catch (SQLException | ClassNotFoundException e) {
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
	    }
	    
	    public static void increaseNbExemplaire(int empruntId ,String ISBN) {
	        DBManager dbManager = new DBManager();
	        Connection connection = null;
	        PreparedStatement preparedStatementOuvrage = null;
	        PreparedStatement preparedStatementEmprunter = null;

	        try {
	            connection = dbManager.getConnection();
	            connection.setAutoCommit(false);


	            String ouvrageQuery = "UPDATE ouvrage SET nbExemplaire = nbExemplaire + 1 WHERE ISBN = ?";
	            preparedStatementOuvrage = connection.prepareStatement(ouvrageQuery);
	            preparedStatementOuvrage.setString(1, ISBN);
	            preparedStatementOuvrage.executeUpdate();


	            String emprunterQuery = "UPDATE emprunter SET Rendu = true WHERE IdEmprunt = ?";
	            preparedStatementEmprunter = connection.prepareStatement(emprunterQuery);
	            preparedStatementEmprunter.setInt(1, empruntId);
	            preparedStatementEmprunter.executeUpdate();

	            connection.commit();
	        } catch (SQLException | ClassNotFoundException e) {
	            e.printStackTrace();
	            try {
	                if (connection != null) {
	                    connection.rollback();
	                }
	            } catch (SQLException rollbackException) {
	                rollbackException.printStackTrace();
	            }
	        } finally {
	            try {
	                if (preparedStatementOuvrage != null) {
	                    preparedStatementOuvrage.close();
	                }
	                if (preparedStatementEmprunter != null) {
	                    preparedStatementEmprunter.close();
	                }
	                if (connection != null) {
	                    connection.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
}
