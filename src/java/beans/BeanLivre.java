package beans;
/*
* ("LIVREISBN"),
                        rs.getInt("TVACODE"),
                        rs.getInt("EVENCODE"),
                        rs.getString("REPDATE"),
                        rs.getInt("EMPLOYEID"),
                        rs.getString("LIVRETITRE"),
                        rs.getString("LIVRESSTITRE"),
                        rs.getDouble("LIVREPRIXHT"),
                        rs.getString("LIVRERESUME"),
                        rs.getString("LIVRECOUV"),
                        rs.getString("LIVRESTATUT"),
                        rs.getInt("CATCODE"),
                        rs.getInt("EDITCODE")));
*
*
* */
public class BeanLivre implements IBeanLivre{
    private String livreIsbn;
    private int tvaCode;
    private int eventCode;
    private String repertDate;
    private int employeId;
    private String livreTitre;
    private String livreSousTitre;
    private double livrePrixHt;
    private String livreResume;
    private String livreStatut;
    private String livreCouverture;
    private int categorieCode;
    private int editeurCode;

    public BeanLivre(String livreIsbn,
                     int tvaCode, int eventCode, String repertDate, int employeId,
                     String livreTitre, String livreSousTitre, double livrePrixHt,
                     String livreStatut, String livreCouverture, String livreResume, int categorieCode,
                     int editeurCode) {
        this.livreIsbn = livreIsbn;
        this.tvaCode = tvaCode;
        this.eventCode = eventCode;
        this.repertDate = repertDate;
        this.employeId = employeId;
        this.livreTitre = livreTitre;
        this.livreSousTitre = livreSousTitre;
        this.livrePrixHt = livrePrixHt;
        this.livreStatut = livreStatut;
        this.livreResume = livreResume;
        this.livreCouverture = livreCouverture;
        this.categorieCode = categorieCode;
        this.editeurCode = editeurCode;
    }

    public String getLivreIsbn() {
        return livreIsbn;
    }

    public void setLivreIsbn(String livreIsbn) {
        this.livreIsbn = livreIsbn;
    }

    public int getTvaCode() {
        return tvaCode;
    }

    public void setTvaCode(int tvaCode) {
        this.tvaCode = tvaCode;
    }

    public int getEventCode() {
        return eventCode;
    }

    public void setEventCode(int eventCode) {
        this.eventCode = eventCode;
    }

    public String getRepertDate() {
        return repertDate;
    }

    public void setRepertDate(String repertDate) {
        this.repertDate = repertDate;
    }

    public int getEmployeId() {
        return employeId;
    }

    public void setEmployeId(int employeId) {
        this.employeId = employeId;
    }

    public String getLivreTitre() {
        return livreTitre;
    }

    public void setLivreTitre(String livreTitre) {
        this.livreTitre = livreTitre;
    }

    public String getLivreSousTitre() {
        return livreSousTitre;
    }

    public void setLivreSousTitre(String livreSousTitre) {
        this.livreSousTitre = livreSousTitre;
    }

    public double getLivrePrixHt() {
        return livrePrixHt;
    }

    public void setLivrePrixHt(double livrePrixHt) {
        this.livrePrixHt = livrePrixHt;
    }

    public String getLivreStatut() {
        return livreStatut;
    }

    public void setLivreStatut(String livreStatut) {
        this.livreStatut = livreStatut;
    }

    public String getLivreResume() {
        return livreResume;
    }

    public void setLivreResume(String livreResume) {
        this.livreResume = livreResume;
    }

    public String getLivreCouverture() {
        return livreCouverture;
    }

    public void setLivreCouverture(String livreCouverture) {
        this.livreCouverture = livreCouverture;
    }

    public int getCategorieCode() {
        return categorieCode;
    }

    public void setCategorieCode(int categorieCode) {
        this.categorieCode = categorieCode;
    }

    public int getEditeurCode() {
        return editeurCode;
    }

    public void setEditeurCode(int editeurCode) {
        this.editeurCode = editeurCode;
    }

    @Override
    public String toString() {
        return getLivreTitre();
    }
}
