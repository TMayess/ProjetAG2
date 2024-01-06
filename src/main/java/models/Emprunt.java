package models;

import java.sql.Date;

public class Emprunt {
    private int idEmprunt;
    private int idEmprunteur;
    private String ISBN;
    private int idBibliotecaire;
    private Date dateEmprunt;
    private Date dateRendre;
    private boolean rendu;

    public Emprunt(int idEmprunt, int idEmprunteur, String ISBN, int idBibliotecaire, Date dateEmprunt, Date dateRendre) {
        this.idEmprunt = idEmprunt;
        this.idEmprunteur = idEmprunteur;
        this.ISBN = ISBN;
        this.idBibliotecaire = idBibliotecaire;
        this.dateEmprunt = dateEmprunt;
        this.dateRendre = dateRendre;
    }
    public Emprunt() {
    	
    }

    // Getters and setters for each field

    public int getIdEmprunt() {
        return idEmprunt;
    }

    public void setIdEmprunt(int idEmprunt) {
        this.idEmprunt = idEmprunt;
    }

    public int getIdEmprunteur() {
        return idEmprunteur;
    }

    public void setIdEmprunteur(int idEmprunteur) {
        this.idEmprunteur = idEmprunteur;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getIdBibliotecaire() {
        return idBibliotecaire;
    }

    public void setIdBibliotecaire(int idBibliotecaire) {
        this.idBibliotecaire = idBibliotecaire;
    }

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public Date getDateRendre() {
        return dateRendre;
    }

    public void setDateRendre(Date dateRendre) {
        this.dateRendre = dateRendre;
    }
	public boolean isRendu() {
		return rendu;
	}
	public void setRendu(boolean rendu) {
		this.rendu = rendu;
	}


}