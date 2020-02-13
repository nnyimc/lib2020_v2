package dao;

import beans.BeanArticle;
import beans.Auteur;
import beans.Editeur;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class SelectArticle {
    private Connection connexion;
    public void setConnexion(Connection connexion){
        this.connexion = connexion;
    }
    
    public Connection getConnexion(){
        return connexion;
    }
 
    
    public Map<String, BeanArticle> SelectionnerArticle(Connection connexion, String typeRecherche, String recherche) throws SQLException{
         
         Map<String, BeanArticle> listeArticles =  new HashMap<String, BeanArticle>();
         String query = "";
         if  (!recherche.equals("")) {
             if (typeRecherche.equals("mot_cle")){
                 query = "SELECT L.LIVREISBN, L.LIVRETITRE, L.LIVRESSTITRE, "
                         + "L.LIVREPRIXHT, L.LIVRERESUME, L.LIVRECOUV, "
                         + "AUTEURNOM, AUTEURPRENOM, EDITEURNOM  \n" +
                         "FROM AUTEUR A \n" +
                         "JOIN ECRIRE E ON A.AUTEURCODE = E.AUTEURCODE \n"+
                         "JOIN LIVRE L ON L.LIVREISBN = E.LIVREISBN \n" +
                         "JOIN EDITEUR EDT ON EDT.EDITEURCODE = L.EDITCODE \n"+
                         "JOIN CARACTERISER C ON C.LIVREISBN = L.LIVREISBN \n" +
                         "JOIN MOT_CLE M ON M.MOTCLEID = C.MOTCLEID \n" +
                         "WHERE MOTCLEDESIGN LIKE '% "+ recherche +"%'"
                         + " OR MOTCLEDESIGN LIKE '"+recherche+"%';";
                 
             } else if (typeRecherche.equals("titre")){
                 query = "SELECT L.LIVREISBN, L.LIVRETITRE, L.LIVRESSTITRE, "
                         + "L.LIVREPRIXHT, L.LIVRERESUME, L.LIVRECOUV, "
                         + "AUTEURNOM, AUTEURPRENOM, EDITEURNOM  \n" +
                         "FROM AUTEUR A \n" +
                         "JOIN ECRIRE E ON A.AUTEURCODE = E.AUTEURCODE \n"+
                         "JOIN LIVRE L ON L.LIVREISBN = E.LIVREISBN \n" +
                         "JOIN EDITEUR EDT ON EDT.EDITEURCODE = L.EDITCODE \n" +
                         "WHERE LIVRETITRE LIKE '% " + recherche + "%' "
                         + "OR LIVRETITRE LIKE '"+recherche+"%';";
              
             } else if (typeRecherche.equals("theme")){
                 query="SELECT L.LIVREISBN, L.LIVRETITRE, L.LIVRESSTITRE, "
                         + "L.LIVREPRIXHT, L.LIVRERESUME, L.LIVRECOUV, "
                         + "AUTEURNOM, AUTEURPRENOM, EDITEURNOM  \n" +
                         "FROM AUTEUR A \n" +
                         "JOIN ECRIRE E ON A.AUTEURCODE = E.AUTEURCODE \n"+
                         "JOIN LIVRE L ON L.LIVREISBN = E.LIVREISBN \n" +
                         "JOIN EDITEUR EDT ON EDT.EDITEURCODE = L.EDITCODE \n" +
                         "JOIN SUBDIVISER S ON S.LIVREISBN = L.LIVREISBN\n" +
                         "JOIN THEME T ON S.THEMECODE = T.THEMECODE\n" +
                         "WHERE THEMELIBELLE LIKE '% " + recherche + "%' "
                         + "OR THEMELIBELLE LIKE '"+recherche+"%';";
             
             } else if (typeRecherche.equals("auteur")){
                 query="SELECT L.LIVREISBN, L.LIVRETITRE, L.LIVRESSTITRE, "
                         + "L.LIVREPRIXHT, L.LIVRERESUME, L.LIVRECOUV, "
                         + "AUTEURNOM, AUTEURPRENOM, EDITEURNOM  \n" +
                         "FROM AUTEUR A \n" +
                         "JOIN ECRIRE E ON A.AUTEURCODE = E.AUTEURCODE \n"+
                         "JOIN LIVRE L ON L.LIVREISBN = E.LIVREISBN \n" +
                         "JOIN EDITEUR EDT ON EDT.EDITEURCODE = L.EDITCODE \n" +
                         "WHERE AUTEURNOM LIKE '% " + recherche + "%' "
                         + "OR AUTEURNOM LIKE '"+ recherche +"%' OR " +
                         "AUTEURPRENOM LIKE '% " + recherche + "%' OR "
                         + "AUTEURPRENOM LIKE '"+ recherche +"%';";
             
             } else if (typeRecherche.equals("isbn")) {
                 query="SELECT L.LIVREISBN, L.LIVRETITRE, L.LIVRESSTITRE, "
                         + "L.LIVREPRIXHT, L.LIVRERESUME, L.LIVRECOUV, "
                         + "AUTEURNOM, AUTEURPRENOM, EDITEURNOM  \n" +
                         "FROM AUTEUR A \n" +
                         "JOIN ECRIRE E ON E.AUTEURCODE = A.AUTEURCODE \n" +
                         "JOIN LIVRE L ON L.LIVREISBN = E.LIVREISBN \n" +
                         "JOIN EDITEUR EDT ON EDT.EDITEURCODE = L.EDITCODE \n" +
                         "WHERE L.LIVREISBN = '" + recherche + "';";
                
             }
             
         
        
        try (Statement stmt = connexion.createStatement();
         ResultSet rs = stmt.executeQuery(query);){
                while (rs.next()) {
                    BeanArticle article = new BeanArticle();
                    article.setLivreIsbn(rs.getString("LIVREISBN"));
                    article.setLivreTitre(rs.getString("LIVRETITRE"));
                    article.setLivreSousTitre(rs.getString("LIVRESSTITRE"));
                    article.setLivrePrixHt(rs.getString("LIVREPRIXHT"));
                    article.setLivreResume(rs.getString("LIVRERESUME"));
                    article.setLivreCouverture(rs.getString("LIVRECOUV"));
                    
                    Auteur aut = new Auteur();
                    aut.setAuteurNom(rs.getString("AUTEURNOM"));
                    aut.setAuteurPrenom(rs.getString("AUTEURPRENOM"));
                    article.setAuteur(aut);
                    
                    Editeur edit = new Editeur();
                    edit.setEditeurNom(rs.getString("EDITEURNOM"));
                    article.setEditeur(edit);
                    
                    if(listeArticles.get(rs.getString("LIVREISBN"))==null){
                        listeArticles.put(rs.getString("LIVREISBN"), article);
                    }
                }
                return listeArticles;
            } catch (SQLException ex) {
                System.err.println("Oops:SQL:" + ex.getErrorCode() + ":" + ex.getMessage());
                return null;
            }
 
         }
         return listeArticles;
    }
         
    public BeanArticle SelectionnerArticle(Connection connexion, String livreIsbn) throws SQLException{
         BeanArticle livreChoisi = new BeanArticle();
         String query = "";
         if  (!livreIsbn.equals("")) {
                 query="SELECT L.LIVREISBN, L.LIVRETITRE, L.LIVRESSTITRE, "
                         + "L.LIVREPRIXHT, L.LIVRERESUME, L.LIVRECOUV, "
                         + "AUTEURNOM, AUTEURPRENOM, EDITEURNOM  \n" +
                         "FROM AUTEUR A \n" +
                         "JOIN ECRIRE E ON E.AUTEURCODE = A.AUTEURCODE \n" +
                         "JOIN LIVRE L ON L.LIVREISBN = E.LIVREISBN \n" +
                         "JOIN EDITEUR EDT ON EDT.EDITEURCODE = L.EDITCODE \n" +
                         "WHERE L.LIVREISBN = '" + livreIsbn + "';";

        try (Statement stmt = connexion.createStatement();
         ResultSet rs = stmt.executeQuery(query);){
                if (rs.next()) {
                    livreChoisi.setLivreIsbn(rs.getString("LIVREISBN"));
                    livreChoisi.setLivreTitre(rs.getString("LIVRETITRE"));
                    livreChoisi.setLivreSousTitre(rs.getString("LIVRESSTITRE"));
                    livreChoisi.setLivrePrixHt(rs.getString("LIVREPRIXHT"));
                    livreChoisi.setLivreResume(rs.getString("LIVRERESUME"));
                    livreChoisi.setLivreCouverture(rs.getString("LIVRECOUV"));
                    
                    Auteur aut = new Auteur();
                    aut.setAuteurNom(rs.getString("AUTEURNOM"));
                    aut.setAuteurPrenom(rs.getString("AUTEURPRENOM"));
                    livreChoisi.setAuteur(aut);
                    
                    Editeur edit = new Editeur();
                    edit.setEditeurNom(rs.getString("EDITEURNOM"));
                    livreChoisi.setEditeur(edit);

                }
                return livreChoisi;
            } catch (SQLException ex) {
                System.err.println("Oops:SQL:" + ex.getErrorCode() + ":" + ex.getMessage());
                return null;
            }
 
         }
         return livreChoisi;
    }
    
    
}
