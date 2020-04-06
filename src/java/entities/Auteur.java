package entities;

public class Auteur extends Individu{
    private int auteurCode;
    private String auteurNom;
    private String auteurPrenom;


    @Override
    public int getCode() {
        return auteurCode;
    }

    @Override
    public void setCode(int code) {
        auteurCode = code;
    }

    @Override
    public String getNom() {
        return auteurNom;
    }

    @Override
    public void setNom(String nom) {
        auteurNom = nom;
    }

    @Override
    public String getPrenom() {
        return auteurPrenom;
    }

    @Override
    public void setPrenom(String prenom) {
        auteurPrenom = prenom;
    }


}
