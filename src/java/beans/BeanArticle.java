package beans;

import entities.*;

import java.io.Serializable;

public class BeanArticle implements Serializable, IBeanArticle{
    private Auteur auteur;
    private Tva tva;
    private Evenement evenement;
    private Employe employe;
    private Categorie categorie;
    private Editeur editeur;
    private String livreIsbn;
    private String livreTitre;
    private String livreSousTitre;
    private String livreCouverture;
    private String livrePrixHt;
    private String livreResume;
    private String livreStatut;
    private String repertorisationDate;
    private int livreQteCommandee;
    private int livreQteStock;
    
    public BeanArticle(){
        
    }
   
    public Auteur getAuteur() {
        return auteur;
    }
    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    public Tva getTva() {
        return tva;
    }
    public void setTva(Tva tva) {
        this.tva = tva;
    }

    public Evenement getEvenement() {
        return evenement;
    }
    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public Employe getEmploye() {
        return employe;
    }
    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Categorie getCategorie() {
        return categorie;
    }
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Editeur getEditeur() {
        return editeur;
    }
    public void setEditeur(Editeur editeur) {
        this.editeur = editeur;
    }

    public String getLivreIsbn() {
        return livreIsbn;
    }
    public void setLivreIsbn(String livreIsbn) {
        this.livreIsbn = livreIsbn;
    }

    public String getLivreTitre() {
        return livreTitre;
    }
    public void setLivreTitre(String livreTitre) {
        this.livreTitre = livreTitre;
    }

    public String getLivreSousTitre() {
        return livreSousTitre;
    }
    public void setLivreSousTitre(String livreSousTitre) {
        this.livreSousTitre = livreSousTitre;
    }
    
    public String getLivreCouverture() {
        return livreCouverture;
    }
    public void setLivreCouverture(String livreCouverture) {
        this.livreCouverture = livreCouverture;
    }

    public String getLivrePrixHt() {
        return livrePrixHt;
    }
    public void setLivrePrixHt(String livrePrixHt) {
        this.livrePrixHt = livrePrixHt;
    }

    public String getLivreResume() {
        return livreResume;
    }
    public void setLivreResume(String livreResume) {
        this.livreResume = livreResume;
    }

    public String getLivreStatut() {
        return livreStatut;
    }
    public void setLivreStatut(String livreStatut) {
        this.livreStatut = livreStatut;
    }

    public String getRepertorisationDate() {
        return repertorisationDate;
    }
    public void setRepertorisationDate(String repertorisationDate) {
        this.repertorisationDate = repertorisationDate;
    }

    public int getLivreQteCommandee() {
        return livreQteCommandee;
    }
    public void changerQteCommandee(int quantite){
        this.livreQteCommandee += quantite;
    }

    public int getLivreQteStock() {
        return livreQteStock;
    }
    public void setLivreQteStock(int livreQteStock) {
        this.livreQteStock -= livreQteStock;
    }  
   
}
