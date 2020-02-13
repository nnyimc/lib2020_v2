package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SelectSuggestion {
    private Connection connexion;

    public Connection getConnexion() {
        return connexion;
    }

    public void setConnexion(Connection connexion) {
        this.connexion = connexion;
    }
    
    public ArrayList<String> SelectionnerSuggestion(Connection connexion, String typeRecherche, String recherche) throws SQLException{
         
         ArrayList<String> listeMots =  new ArrayList<String>();
         String query = "";
         if  (!recherche.equals("")) {
             if (typeRecherche.equals("mot_cle")){
                 query = "SELECT MOTCLEDESIGN FROM MOT_CLE" +
                         "WHERE MOTCLEDESIGN LIKE '% "+ recherche +"%'"
                         + " OR MOTCLEDESIGN LIKE '"+recherche+"%';";
                 
             } else if (typeRecherche.equals("titre")){
                 query = "SELECT LIVRETITRE FROM LIVRE" +
                         "WHERE LIVRETITRE LIKE '% " + recherche + "%' "
                         + "OR LIVRETITRE LIKE '"+recherche+"%';";
              
             } else if (typeRecherche.equals("theme")){
                 query="SELECT THEMELIBELLE FROM THEME "
                         + "WHERE THEMELIBELLE LIKE '% " + recherche + "%' "
                         + " OR THEMELIBELLE LIKE '"+recherche+"%';";
             
             } else if (typeRecherche.equals("auteur")){
                 query="SELECT AUTEURNOM, AUTEURPRENOM FROM AUTEUR WHERE "
                         + "AUTEURNOM LIKE '% " + recherche + "%' "
                         + "OR AUTEURNOM LIKE '"+ recherche +"%' OR " +
                         "AUTEURPRENOM LIKE '% " + recherche + "%' OR "
                         + "AUTEURPRENOM LIKE '"+ recherche +"%';";
             
             } else if (typeRecherche.equals("isbn")) {
                 query="SELECT LIVREISBN FROM LIVRE L WHERE"
                         + " L.LIVREISBN = '" + recherche + "';";
             }
             
         
        
        try (Statement stmt = connexion.createStatement();
         ResultSet rs = stmt.executeQuery(query);){
                while (rs.next()) {
                       if(typeRecherche.equals("mot_cle")){
                           listeMots.add(rs.getString("MOTCLEDESIGN"));
                       } else if(typeRecherche.equals("titre")){
                           listeMots.add( rs.getString("LIVRETITRE"));
                       } else if(typeRecherche.equals("theme")){
                           listeMots.add( rs.getString("THEMELIBELLE"));
                       } else if(typeRecherche.equals("auteur")){
                           listeMots.add(rs.getString("AUTEURPRENOM"));
                           listeMots.add(rs.getString("AUTEURNOM"));
                       }else if (typeRecherche.equals("isbn")){
                           listeMots.add(rs.getString("LIVREISBN"));
                       }
                    }
            } catch (SQLException ex) {
                System.err.println("Oops:SQL:" + ex.getErrorCode() + ":" + ex.getMessage());
                return null;
            }
 
         }
         return listeMots;
    }
         
}
