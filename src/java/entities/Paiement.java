package entities;

public class Paiement extends ClassGenerique{
    private TypePaiement typePaiement;
    private DatePaiement datePaiement;
    private String numeroTransaction;
    private String numeroFacture;
    
    public Paiement(){
        super();
    }
    
    public TypePaiement getTypePaiement() {
        return typePaiement;
    }

    public void setTypePaiement(TypePaiement typePaiement) {
        this.typePaiement = typePaiement;
    }

    public DatePaiement getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(DatePaiement datePaiement) {
        this.datePaiement = datePaiement;
    }

    public String getNumeroTransaction() {
        return numeroTransaction;
    }

    public void setNumeroTransaction(String numeroTransaction) {
        this.numeroTransaction = numeroTransaction;
    }

    public String getNumeroFacture() {
        return numeroFacture;
    }

    public void setNumeroFacture(String numeroFacture) {
        this.numeroFacture = numeroFacture;
    }

}
