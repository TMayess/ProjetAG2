package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import models.Emprunt;
import models.Emprunteur;

public class EmpruntDao {
	
	public static Boolean AddEmprunt(int idEmprunteur, String ISBN, Date dateEmprunt, Date dateRendre) throws DaoException {
	    DBManager dbManager = new DBManager();
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;

	    try {
	        connection = dbManager.getConnection();
	        String query = "INSERT INTO emprunter (IdEmprunteur, ISBN, IdBibliotecaire, DateEmprunt, DateRendre) " +
	                "VALUES (?, ?, '1', ?, ?)";

	        preparedStatement = connection.prepareStatement(query);

	       
	        preparedStatement.setInt(1, idEmprunteur);
	        preparedStatement.setString(2, ISBN);
	        //preparedStatement.setInt(3, idBibliotecaire);
	        preparedStatement.setDate(3, dateEmprunt);
	        preparedStatement.setDate(4, dateRendre);

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
	
	public static List<Emprunt> getAllEmprunt(String searchId) {
	    List<Emprunt> emprunts = new ArrayList<>();

	    DBManager dbManager = new DBManager();
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;

	    try {
	        connection = dbManager.getConnection();
	        String query = "SELECT IdEmprunt, IdEmprunteur, ISBN, IdBibliotecaire, DateEmprunt, DateRendre, Rendu FROM emprunter";
	        
	        // Ajout de la condition pour l'ID d'emprunteur
	        if (searchId != null && !searchId.isEmpty()) {
	            query += " WHERE IdEmprunt LIKE ?";
	        }

	        // Limiter les résultats à 20
	        query += " LIMIT 20";

	        preparedStatement = connection.prepareStatement(query);

	        // Lier le paramètre pour l'ID d'emprunt
	        if (searchId != null && !searchId.isEmpty()) {
	            preparedStatement.setString(1, searchId + "%");
	        }

	        ResultSet result = preparedStatement.executeQuery();

	        while (result.next()) {
	            Emprunt emprunt = new Emprunt();
	            emprunt.setIdEmprunt(result.getInt("IdEmprunt"));
	            emprunt.setIdEmprunteur(result.getInt("IdEmprunteur"));
	            emprunt.setISBN(result.getString("ISBN"));
	            emprunt.setIdBibliotecaire(result.getInt("IdBibliotecaire"));
	            emprunt.setDateEmprunt(result.getDate("DateEmprunt"));
	            emprunt.setDateRendre(result.getDate("DateRendre"));
	            emprunt.setRendu(result.getBoolean("Rendu"));

	            emprunts.add(emprunt);
	        }

	        result.close();
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
	    return emprunts;
	}
	 
	 public static List<Emprunt> getAllEmpruntNotRendu(String searchId) {
		    List<Emprunt> emprunts = new ArrayList<>();

		    DBManager dbManager = new DBManager();
		    Connection connection = null;
		    PreparedStatement preparedStatement = null;

		    try {
		        connection = dbManager.getConnection();
		        String query = "SELECT IdEmprunt, IdEmprunteur, ISBN, IdBibliotecaire, DateEmprunt, DateRendre, Rendu FROM emprunter WHERE Rendu = false";

		        if (searchId != null && !searchId.isEmpty()) {
		            query += " AND IdEmprunt LIKE ?";
		        }

		        preparedStatement = connection.prepareStatement(query);

		        if (searchId != null && !searchId.isEmpty()) {
		            preparedStatement.setString(1, searchId + "%");
		        }

		        ResultSet result = preparedStatement.executeQuery();

		        while (result.next()) {
		            Emprunt emprunt = new Emprunt();
		            emprunt.setIdEmprunt(result.getInt("IdEmprunt"));
		            emprunt.setIdEmprunteur(result.getInt("IdEmprunteur"));
		            emprunt.setISBN(result.getString("ISBN"));
		            emprunt.setIdBibliotecaire(result.getInt("IdBibliotecaire"));
		            emprunt.setDateEmprunt(result.getDate("DateEmprunt"));
		            emprunt.setDateRendre(result.getDate("DateRendre"));
		            emprunt.setRendu(result.getBoolean("Rendu"));

		            emprunts.add(emprunt);
		        }

		        result.close();
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
		    return emprunts;
		}
	 
	 public static Emprunt getEmpruntById(String idEmprunt) {
		    Connection connection = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    Emprunt emprunt = null;
		    DBManager dbManager = new DBManager();

		    try {
		        connection = dbManager.getConnection();
		        String query = "SELECT `IdEmprunt`, `IdEmprunteur`, `ISBN`, `IdBibliotecaire`, `DateEmprunt`, `DateRendre`, `Rendu` FROM `emprunter` WHERE `IdEmprunt` = ?";
		        preparedStatement = connection.prepareStatement(query);
		        preparedStatement.setString(1, idEmprunt);

		        resultSet = preparedStatement.executeQuery();

		        if (resultSet.next()) {
		            emprunt = new Emprunt();
		            emprunt.setIdEmprunt(resultSet.getInt("IdEmprunt"));
		            emprunt.setIdEmprunteur(resultSet.getInt("IdEmprunteur"));
		            emprunt.setISBN(resultSet.getString("ISBN"));
		            emprunt.setIdBibliotecaire(resultSet.getInt("IdBibliotecaire"));
		            emprunt.setDateEmprunt(resultSet.getDate("DateEmprunt"));
		            emprunt.setDateRendre(resultSet.getDate("DateRendre"));
		            emprunt.setRendu(resultSet.getBoolean("Rendu"));
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

		    return emprunt;
		}
	 public static void prolongeEmprunt(int empruntId) {
	        DBManager dbManager = new DBManager();
	        Connection connection = null;
	        PreparedStatement preparedStatementOuvrage = null;
	        PreparedStatement preparedStatementEmprunter = null;

	        try {
	            connection = dbManager.getConnection();
	            connection.setAutoCommit(false);



	            String emprunterQuery = "UPDATE emprunter SET DateRendre = DATE_ADD(DateRendre, INTERVAL 2 WEEK) WHERE IdEmprunt = ?";
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
	 

	 public static List<Entry<Emprunt, Emprunteur>> getEmpruntsEmprunteurExpire(String searchId) {
		    List<Entry<Emprunt, Emprunteur>> empruntEmprunteurPairs = new ArrayList<>();

		    DBManager dbManager = new DBManager();
		    Connection connection = null;
		    PreparedStatement preparedStatement = null;

		    try {
		        connection = dbManager.getConnection();
		        String query = "SELECT e.IdEmprunt, e.IdEmprunteur, e.ISBN, e.IdBibliotecaire, e.DateEmprunt, e.DateRendre, e.Rendu, "
		                + "m.IdEmprunteur, m.Nom, m.Prenom, m.DateNaissance, m.Adresse, m.Mobile, m.Email "
		                + "FROM emprunter e "
		                + "JOIN emprunteur m ON e.IdEmprunteur = m.IdEmprunteur "
		                + "WHERE e.DateRendre > ? "
		                + "AND e.IdEmprunteur NOT IN ( "
		                + "    SELECT IdUtilisateur "
		                + "    FROM sanction "
		                + "    WHERE DateFin >= CURDATE() "
		                + ") "
		                + "AND e.IdEmprunt LIKE ?";

		        preparedStatement = connection.prepareStatement(query);
		        
		        preparedStatement.setDate(1, new Date(System.currentTimeMillis()));
		        preparedStatement.setString(2, searchId + "%"); 

		        ResultSet result = preparedStatement.executeQuery();

		        while (result.next()) {
		            Emprunt emprunt = new Emprunt();
		            emprunt.setIdEmprunt(result.getInt("IdEmprunt"));
		            emprunt.setIdEmprunteur(result.getInt("IdEmprunteur"));
		            emprunt.setISBN(result.getString("ISBN"));
		            emprunt.setIdBibliotecaire(result.getInt("IdBibliotecaire"));
		            emprunt.setDateEmprunt(result.getDate("DateEmprunt"));
		            emprunt.setDateRendre(result.getDate("DateRendre"));
		            emprunt.setRendu(result.getBoolean("Rendu"));

		            Emprunteur emprunteur = new Emprunteur();
		            emprunteur.setIdEmprunteur(result.getInt("IdEmprunteur"));
		            emprunteur.setNom(result.getString("Nom"));
		            emprunteur.setPrenom(result.getString("Prenom"));
		            emprunteur.setDateNaissance(result.getDate("DateNaissance"));
		            emprunteur.setAdresse(result.getString("Adresse"));
		            emprunteur.setMobile(result.getString("Mobile"));
		            emprunteur.setEmail(result.getString("Email"));

		            Entry<Emprunt, Emprunteur> pair = new AbstractMap.SimpleEntry<>(emprunt, emprunteur);
		            empruntEmprunteurPairs.add(pair);
		        }

		        result.close();
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

		    return empruntEmprunteurPairs;
		}
	 
/*	 public static int getNbEmprunts() throws DaoException {
		    DBManager dbManager = new DBManager();
		    Connection connection = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;

		    try {
		        connection = dbManager.getConnection();
		        String query = "SELECT COUNT(*) AS nombre_total FROM emprunter";
		        preparedStatement = connection.prepareStatement(query);
		        resultSet = preparedStatement.executeQuery();

		        if (resultSet.next()) {
		            return resultSet.getInt("nombre_total");
		        } else {
		            throw new DaoException("La récupération du nombre total d'emprunteurs a échoué.");
		        }

		    } catch (SQLException | ClassNotFoundException e) {
		        e.printStackTrace();
		        throw new DaoException(e.getMessage());
		    } finally {
		        try {
		            if (resultSet != null) {
		                resultSet.close();
		            }
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
	 
	 public static int getNbEmpruntsEtranger() throws DaoException {
		    DBManager dbManager = new DBManager();
		    Connection connection = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;

		    try {
		        connection = dbManager.getConnection();
		        String query = "SELECT COUNT(*) AS nombre_total FROM emprunter " +
		                       "INNER JOIN emprunteur ON emprunter.IdEmprunteur = emprunteur.IdEmprunteur " +
		                       "WHERE emprunteur.type = 'etudiant_etranger'";

		        preparedStatement = connection.prepareStatement(query);
		        resultSet = preparedStatement.executeQuery();

		        if (resultSet.next()) {
		            return resultSet.getInt("nombre_total");
		        } else {
		            throw new DaoException("La récupération du nombre total d'emprunts étranges a échoué.");
		        }

		    } catch (SQLException | ClassNotFoundException e) {
		        e.printStackTrace();
		        throw new DaoException(e.getMessage());
		    } finally {
		        try {
		            if (resultSet != null) {
		                resultSet.close();
		            }
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
*/

}
