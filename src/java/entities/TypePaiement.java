package entities;

public class TypePaiement extends ClassGenerique{
    private int typePaiementCode;
    private String typePaiementLibelle;

    public TypePaiement(){
        super();
    }

    public int getTypePaiementCode() {
        return typePaiementCode;
    }

    public void setTypePaiementCode(int typePaiementCode) {
        this.typePaiementCode = typePaiementCode;
    }

    public String getTypePaiementLibelle() {
        return typePaiementLibelle;
    }

    public void setTypePaiementLibelle(String typePaiementLibelle) {
        this.typePaiementLibelle = typePaiementLibelle;
    }
}
