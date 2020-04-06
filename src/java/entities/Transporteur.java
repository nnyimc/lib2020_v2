package entities;

public class Transporteur extends ClassGenerique {
    private int transporteurId;
    private String transporteurNom;
    
    public Transporteur(){
        super();
    }

    public int getTransporteurId() {
        return transporteurId;
    }

    public void setTransporteurId(int transporteurId) {
        this.transporteurId = transporteurId;
    }

    public String getTransporteurNom() {
        return transporteurNom;
    }

    public void setTransporteurNom(String transporteurNom) {
        this.transporteurNom = transporteurNom;
    }
}
