package beans;

import entities.*;

public interface IBeanArticle {
    public Auteur getAuteur();
    public void setAuteur(Auteur auteur);
    public Tva getTva();
    public void setTva(Tva tva);
    public Evenement getEvenement();
    public void setEvenement(Evenement evenement);
    public Employe getEmploye();
    public void setEmploye(Employe employe);
    public Categorie getCategorie();
    public void setCategorie(Categorie categorie);
    public Editeur getEditeur();
    public void setEditeur(Editeur editeur);
    public String getLivreIsbn();
    public void setLivreIsbn(String livreIsbn);
    public String getLivreTitre();
    public void setLivreTitre(String livreTitre);
    public String getLivreSousTitre();
    public void setLivreSousTitre(String livreSousTitre);
    public String getLivreCouverture();
    public String getLivrePrixHt();
    public void setLivrePrixHt(String livrePrixHt);
    public String getLivreResume();
    public void setLivreResume(String livreResume);
    public String getLivreStatut();
    public void setLivreStatut(String livreStatut);
    public String getRepertorisationDate();
    public void setRepertorisationDate(String repertorisationDate);
    public int getLivreQteCommandee();
    public void changerQteCommandee(int quantite);
    public int getLivreQteStock();
    public void setLivreQteStock(int livreQteStock);

}
