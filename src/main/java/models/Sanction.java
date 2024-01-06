package models;

import java.util.Date;

public class Sanction {
    private int idSanction;
    private Date dateDebut;
    private Date dateFin;
    private int idUtilisateur;

    // Constructeurs, getters, setters, etc.

    public Sanction() {
        // Constructeur par défaut
    }

    public Sanction(int idSanction, Date dateDebut, Date dateFin, int idUtilisateur) {
        this.idSanction = idSanction;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.idUtilisateur = idUtilisateur;
    }

 

    public int getIdSanction() {
        return idSanction;
    }

    public void setIdSanction(int idSanction) {
        this.idSanction = idSanction;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }
}