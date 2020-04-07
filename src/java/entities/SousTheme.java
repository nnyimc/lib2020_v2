package entities;

public class SousTheme extends ClassGenerique{
    private int Id;
    private String nom;

    public SousTheme(){
        super();
    }

    public SousTheme(int id, String nom) {
        super();
        Id = id;
        this.nom = nom;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return getNom();
    }
}
