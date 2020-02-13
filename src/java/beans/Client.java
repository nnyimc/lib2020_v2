package beans;

public class Client {
    private Adresse adresseLivraison;
    private Adresse adresseFacturation;
    private int clientCode;
    private String clientNom;
    private String clientPrenom;
    private String clientLogin;
    private String clientMotDePasse;
    private String clientMail;
    private String clientStatut;

    public Client(){
    
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
    
    
    public int getClientCode() {
        return clientCode;
    }

    public void setClientCode(int clientCode) {
        this.clientCode = clientCode;
    }
    
    public String getClientNom() {
        return clientNom;
    }

    public void setClientNom(String clientNom) {
        this.clientNom = clientNom;
    }

    public String getClientPrenom() {
        return clientPrenom;
    }

    public void setClientPrenom(String clientPrenom) {
        this.clientPrenom = clientPrenom;
    }

    public String getClientLogin() {
        return clientLogin;
    }

    public void setClientLogin(String clientLogin) {
        this.clientLogin = clientLogin;
    }

    public String getClientMotDePasse() {
        return clientMotDePasse;
    }

    public void setClientMotDePasse(String clientMotDePasse) {
        this.clientMotDePasse = clientMotDePasse;
    }

    public String getClientMail() {
        return clientMail;
    }

    public void setClientMail(String clientMail) {
        this.clientMail = clientMail;
    }

    public String getClientStatut() {
        return clientStatut;
    }

    public void setClientStatut(String clientStatut) {
        this.clientStatut = clientStatut;
    }
    
    
}
