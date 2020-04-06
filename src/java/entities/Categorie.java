package entities;


public class Categorie extends ClassGenerique {
    private int categorieCode;
    private String categorieLibelle;

    public Categorie(){
        super();
    }

    public int getCategorieCode() {
        return categorieCode;
    }

    public void setCategorieCode(int categorieCode) {
        this.categorieCode = categorieCode;
    }

    public String getCategorieLibelle() {
        return categorieLibelle;
    }

    public void setCategorieLibelle(String categorieLibelle) {
        this.categorieLibelle = categorieLibelle;
    }
}
