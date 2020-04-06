package entities;

public abstract class Adresse implements IAdresse{
    private int adresseId;
    private String adresseRue;
    private String adresseComplement;
    private String adresseVille;
    private String adresseCodePostal;
    private String adressePays;
    private String adresseNom;
    private String adressePrenom;
    private String adresseTelephone;
    
    public Adresse() {
    
    }

    public int getAdresseId() {
        return adresseId;
    }

    public void setAdresseId(int adresseId) {
        this.adresseId = adresseId;
    }

    public String getAdresseRue() {
        return adresseRue;
    }

    public void setAdresseRue(String adresseRue) {
        this.adresseRue = adresseRue;
    }

    public String getAdresseComplement() {
        return adresseComplement;
    }

    public void setAdresseComplement(String adresseComplement) {
        this.adresseComplement = adresseComplement;
    }

    public String getAdresseVille() {
        return adresseVille;
    }

    public void setAdresseVille(String adresseVille) {
        this.adresseVille = adresseVille;
    }

    public String getAdresseCodePostal() {
        return adresseCodePostal;
    }

    public void setAdresseCodePostal(String adresseCodePostal) {
        this.adresseCodePostal = adresseCodePostal;
    }

    public String getAdressePays() {
        return adressePays;
    }

    public void setAdressePays(String adressePays) {
        this.adressePays = adressePays;
    }

    public String getAdresseNom() {
        return adresseNom;
    }

    public void setAdresseNom(String adresseNom) {
        this.adresseNom = adresseNom;
    }

    public String getAdressePrenom() {
        return adressePrenom;
    }

    public void setAdressePrenom(String adressePrenom) {
        this.adressePrenom = adressePrenom;
    }

    public String getAdresseTelephone() {
        return adresseTelephone;
    }

    public void setAdresseTelephone(String adresseTelephone) {
        this.adresseTelephone = adresseTelephone;
    }
    
    
}
