package beans;

public class Commande {
    private Client client;
    private BeanPanier panier;
    private Paiement paiement;
    private Livraison livraison;
    private int numeroCommande;
    private String ipCommande;
    private String dateCommande;
    private String dateFacturation;
   
    public Commande(){
    
    }
    
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public BeanPanier getPanier() {
        return panier;
    }

    public void setPanier(BeanPanier panier) {
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
