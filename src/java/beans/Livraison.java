package beans;

import java.util.Date;


public class Livraison {
    private Adresse adresseLivraison;
    private Adresse adresseFacturation;
    private Transporteur transporteur;
    private Date dateRecuperation;
    private Date etapeDate;
    private Date etapeArrivee;
    private int colisNumero;
    private String colisStatut;
    
    public Livraison(){
    
    }

    public Adresse getAdresseLivraison() {
        return adresseLivraison;
    }

    public void setAdresseLivraison(Adresse adresseLivraison) {
        this.adresseLivraison = adresseLivraison;
    }

    public Adresse getAdresseFacturation() {
        return adresseFacturation;
    }

    public void setAdresseFacturation(Adresse adresseFacturation) {
        this.adresseFacturation = adresseFacturation;
    }

    public Transporteur getTransporteur() {
        return transporteur;
    }

    public void setTransporteur(Transporteur transporteur) {
        this.transporteur = transporteur;
    }

    public Date getDateRecuperation() {
        return dateRecuperation;
    }

    public void setDateRecuperation(Date dateRecuperation) {
        this.dateRecuperation = dateRecuperation;
    }

    public Date getEtapeDate() {
        return etapeDate;
    }

    public void setEtapeDate(Date etapeDate) {
        this.etapeDate = etapeDate;
    }

    public Date getEtapeArrivee() {
        return etapeArrivee;
    }

    public void setEtapeArrivee(Date etapeArrivee) {
        this.etapeArrivee = etapeArrivee;
    }

    public int getColisNumero() {
        return colisNumero;
    }
    
    public void setColisNumero(String colisStatut) {
        this.colisStatut = colisStatut;
    }
    
    public String getColisStatut() {
        return colisStatut;
    }
    
    public void setColisStatut(String colisStatut) {
        this.colisStatut = colisStatut;
    }
    
    
}
