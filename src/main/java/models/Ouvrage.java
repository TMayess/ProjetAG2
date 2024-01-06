package models;



public class Ouvrage {
    private String ISBN;
    private String titre;
    private int annee;
    private String type;
    private String editeur;
    private int nbExemplaire;
    private String auteur;
    
    
    public Ouvrage() {
        this.ISBN = null;
        this.titre = null;
        this.annee = 0;
        this.type = null;
        this.editeur = null;
        this.nbExemplaire = 0;
        this.auteur = null;
    }
    
    public Ouvrage(String ISBN, String titre, int annee, String type, String editeur, int nbExemplaire, String auteur) {
        this.ISBN = ISBN;
        this.titre = titre;
        this.annee = annee;
        this.type = type;
        this.editeur = editeur;
        this.nbExemplaire = nbExemplaire;
        this.auteur = auteur;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public int getNbExemplaire() {
        return nbExemplaire;
    }

    public void setNbExemplaire(int nbExemplaire) {
        this.nbExemplaire = nbExemplaire;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
    
    
  
}