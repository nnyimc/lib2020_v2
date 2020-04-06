package entities;


public class Livraison extends ClassGenerique {
    private AdresseLivraison adresseLivraison;
    private AdresseFacturation adresseFacturation;
    private Transporteur transporteur;
    private DateRecuperation dateRecuperation;
    private DateEtapeDepart etapeDepart;
    private DateEtapeArrivee etapeArrivee;
    private int colisNumero;
    private String colisStatut;
    
    public Livraison(){
        super();
    }

    public AdresseLivraison getAdresseLivraison() {
        return adresseLivraison;
    }

    public void setAdresseLivraison(AdresseLivraison adresseLivraison) {
        this.adresseLivraison = adresseLivraison;
    }

    public AdresseFacturation getAdresseFacturation() {
        return adresseFacturation;
    }

    public void setAdresseFacturation(AdresseFacturation adresseFacturation) {
        this.adresseFacturation = adresseFacturation;
    }

    public Transporteur getTransporteur() {
        return transporteur;
    }

    public void setTransporteur(Transporteur transporteur) {
        this.transporteur = transporteur;
    }

    public DateRecuperation getDateRecuperation() {
        return dateRecuperation;
    }

    public void setDateRecuperation(DateRecuperation dateRecuperation) {
        this.dateRecuperation = dateRecuperation;
    }

    public DateEtapeDepart getEtapeDepart() {
        return etapeDepart;
    }

    public void setEtapeDepart(DateEtapeDepart etapeDepart) {
        this.etapeDepart = etapeDepart;
    }

    public DateEtapeArrivee getEtapeArrivee() {
        return etapeArrivee;
    }

    public void setEtapeArrivee(DateEtapeArrivee etapeArrivee) {
        this.etapeArrivee = etapeArrivee;
    }

    public int getColisNumero() {
        return colisNumero;
    }
    
    public void setColisNumero(int colisNumero) {
        this.colisNumero = colisNumero;
    }
    
    public String getColisStatut() {
        return colisStatut;
    }
    
    public void setColisStatut(String colisStatut) {
        this.colisStatut = colisStatut;
    }
    
    
}
