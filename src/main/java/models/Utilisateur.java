package models;

public class Utilisateur {
    private String idUtilisateur;
    private String nom;
    private String typeUtilisateur;
    private String motDePasse;

    
    public Utilisateur(String idUtilisateur, String nom, String typeUtilisateur, String motDePasse) {
        this.idUtilisateur = idUtilisateur;
        this.nom = nom;
        this.typeUtilisateur = typeUtilisateur;
        this.motDePasse = motDePasse;
    }

   
    public Utilisateur() {

    }

    public String getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(String idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTypeUtilisateur() {
        return typeUtilisateur;
    }

    public void setTypeUtilisateur(String typeUtilisateur) {
        this.typeUtilisateur = typeUtilisateur;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
    
}