package beans;

public interface IBeanLivre {
    public String getLivreIsbn();
    public void setLivreIsbn(String livreIsbn);
    public int getTvaCode();
    public void setTvaCode(int tvaCode);
    public int getEventCode();
    public void setEventCode(int eventCode);
    public String getRepertDate();
    public void setRepertDate(String repertDate);
    public int getEmployeId();
    public void setEmployeId(int employeId);
    public String getLivreTitre();
    public void setLivreTitre(String livreTitre);
    public String getLivreSousTitre();
    public void setLivreSousTitre(String livreSousTitre);
    public double getLivrePrixHt();
    public void setLivrePrixHt(double livrePrixHt);
    public String getLivreStatut();
    public void setLivreStatut(String livreStatut);
    public String getLivreCouverture();
    public void setLivreCouverture(String livreCouverture);
    public String getLivreResume();
    public void setLivreResume(String livreResume);
    public int getCategorieCode();
    public void setCategorieCode(int categorieCode);
    public int getEditeurCode();
    public void setEditeurCode(int editeurCode);
}
