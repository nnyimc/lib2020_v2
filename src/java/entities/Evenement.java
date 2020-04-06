package entities;

public class Evenement extends ClassGenerique{
    private int evenementCode;
    private String evenementNom;
    private DateEvenementDebut evenementDebut;
    private DateEvenementFin evenementFin;
    private String evenementImage;
    private float remiseTaux;
    
    public Evenement(){
        super();
    }
    
    public int getEvenementCode() {
        return evenementCode;
    }

    public void setEvenementCode(int evenementCode) {
        this.evenementCode = evenementCode;
    }

    public String getEvenementNom() {
        return evenementNom;
    }

    public void setEvenementNom(String evenementNom) {
        this.evenementNom = evenementNom;
    }

    public DateEvenementDebut getEvenementDebut() {
        return evenementDebut;
    }

    public void setEvenementDebut(DateEvenementDebut evenementDebut) {
        this.evenementDebut = evenementDebut;
    }

    public DateEvenementFin getEvenementFin() {
        return evenementFin;
    }

    public void setEvenementFin(DateEvenementFin evenementFin) {
        this.evenementFin = evenementFin;
    }

    public String getEvenementImage() {
        return evenementImage;
    }

    public void setEvenementImage(String evenementImage) {
        this.evenementImage = evenementImage;
    }

    public float getRemiseTaux() {
        return remiseTaux;
    }

    public void setRemiseTaux(float remiseTaux) {
        this.remiseTaux = remiseTaux;
    }
}
