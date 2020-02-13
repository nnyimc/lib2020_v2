package beans;

import dao.Connector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;


public class Devanture {
    public static final String QUERY = "SELECT TOP 5 L.LIVREISBN, L.LIVRETITRE, L.LIVRESSTITRE, "
                + "L.LIVREPRIXHT, L.LIVRERESUME, L.LIVRECOUV, "
                + "AUTEURNOM, AUTEURPRENOM, EDITEURNOM"
                + " FROM LIVRE L JOIN ECRIRE E ON E.LIVREISBN = L.LIVREISBN "
                + "JOIN AUTEUR A ON A.AUTEURCODE = E.AUTEURCODE "
                + "JOIN EDITEUR EDT ON EDT.EDITEURCODE = L.EDITCODE ORDER BY NEWID();";
    private Connector connector = new Connector();
    
    public Devanture(){
    
    }
    
    public Map<String, BeanArticle> afficher() throws SQLException{
        Connection connexion = connector.contacterBDD();
        Map<String, BeanArticle> listeArticles =  new HashMap<String, BeanArticle>();
        Statement stmt = connexion.createStatement();
        ResultSet rs = stmt.executeQuery(QUERY);
        
        try {
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
                
                rs.close();
                stmt.close();
                connexion.close();
                return listeArticles;
            } catch (SQLException ex) {
                System.err.println("Oops:SQL:" + ex.getErrorCode() + ":" + ex.getMessage());
                return null;
            }

         }

    }
