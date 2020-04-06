package entities;

public class Editeur extends ClassGenerique {
    private int editeurCode;
    private String editeurNom;

    public Editeur(){
        super();
    }

    public int getEditeurCode() {
        return editeurCode;
    }

    public void setEditeurCode(int editeurCode) {
        this.editeurCode = editeurCode;
    }

    public String getEditeurNom() {
        return editeurNom;
    }

    public void setEditeurNom(String editeurNom) {
        this.editeurNom = editeurNom;
    }
}
