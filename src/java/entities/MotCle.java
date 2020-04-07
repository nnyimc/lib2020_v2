package entities;

public class MotCle extends ClassGenerique{
    private int Id;
    private String nom;
    public MotCle (){
       super();
    }

    public MotCle( int Id, String nom){
        super();
        this.Id = Id;
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
