package beans;

import java.util.Date;

public class Evenement {
    private int evenementCode;
    private String evenementNom;
    private Date evenementDebut;
    private Date evenementFin;
    private String evenementImage;
    private float remiseTaux;
    
    public Evenement(){
    
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

    public Date getEvenementDebut() {
        return evenementDebut;
    }

    public void setEvenementDebut(Date evenementDebut) {
        this.evenementDebut = evenementDebut;
    }

    public Date getEvenementFin() {
        return evenementFin;
    }

    public void setEvenementFin(Date evenementFin) {
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
