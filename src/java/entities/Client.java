package entities;

public class Client extends Individu implements IUtilisateur {
    private AdresseLivraison adresseLivraison;
    private AdresseFacturation adresseFacturation;
    private int clientCode;
    private String clientNom;
    private String clientPrenom;
    private String clientLogin;
    private String clientMotDePasse;
    private String clientMail;
    private String clientStatut;

    public Client(){
        super();
    }

    @Override
    public int getCode() {
        return clientCode;
    }

    @Override
    public void setCode(int code) {
        clientCode = code;
    }

    @Override
    public String getNom() {
        return clientNom;
    }

    @Override
    public void setNom(String nom) {
        clientNom = nom;
    }

    @Override
    public String getPrenom() {
        return clientPrenom;
    }

    @Override
    public void setPrenom(String prenom) {
        clientPrenom = prenom;
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

    public String getClientStatut() {
        return clientStatut;
    }

    public void setClientStatut(String clientStatut) {
        this.clientStatut = clientStatut;
    }

    @Override
    public String getLogin() {
        return clientLogin;
    }

    @Override
    public void setLogin(String login) {
        clientLogin = login;
    }

    @Override
    public String getPass() {
        return clientMotDePasse;
    }

    @Override
    public void setPass(String pass) {
        clientMotDePasse = pass;
    }

    @Override
    public String getEmail() {
        return clientMail;
    }

    @Override
    public void setEmail(String email) {
        clientMail = email;
    }
}
