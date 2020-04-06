package entities;

import beans.BeanPanier;
import beans.IBeanPanier;

public class Commande extends ClassGenerique{
    private Client client;
    private IBeanPanier panier;
    private Paiement paiement;
    private Livraison livraison;
    private int numeroCommande;
    private String ipCommande;
    private String dateCommande;
    private String dateFacturation;
   
    public Commande(){
        super();
    }
    
    public Client getClient() {

        return client;
    }

    public void setClient(Client client) {

        this.client = client;
    }

    public IBeanPanier getPanier() {

        return panier;
    }

    public void setPanier(IBeanPanier panier) {

        this.panier = panier;
    }


    public Paiement getPaiement() {

        return paiement;
    }

    public void setPaiement(Paiement paiement) {

        this.paiement = paiement;
    }

    public Livraison getLivraison() {

        return livraison;
    }

    public void setLivraison(Livraison livraison) {
        this.livraison = livraison;
    }

    public int getNumeroCommande() {
        return numeroCommande;
    }

    public void setNumeroCommande(int numeroCommande) {
        this.numeroCommande = numeroCommande;
    }

    public String getIpCommande() {
        return ipCommande;
    }

    public void setIpCommande(String ipCommande) {
        this.ipCommande = ipCommande;
    }

    public String getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(String dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getDateFacturation() {
        return dateFacturation;
    }

    public void setDateFacturation(String dateFacturation) {
        this.dateFacturation = dateFacturation;
    }

    
}
