package forms;

import beans.BeanArticle;
import dao.Connector;
import dao.SelectArticle;
import dao.SelectSuggestion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RechercheFormulaire {
   public static final String CHAMP_TYPE_RECHERCHE = "type_recherche";
   public static final String CHAMP_RECHERCHE = "recherche";
   private String message;
   private Connector connector;
   private Connection connexion;
   private SelectArticle selection;
   private SelectSuggestion suggestion;
       
    public RechercheFormulaire() throws SQLException{
        message = "";
        connector = new Connector();
        connexion = connector.contacterBDD();
        selection = new SelectArticle();
        suggestion = new SelectSuggestion();
    }
    
    public String getMessage() {
        return message;
    }


    public Map<String, BeanArticle> afficherResultat(String typeRecherche, String recherche) throws SQLException{
        Map<String, BeanArticle> listeArticles = selection.SelectionnerArticle(connexion, typeRecherche, recherche);
        if(!recherche.equals("")){   
            if (listeArticles.size()<=0){
                message = "Votre recherche par "+ typeRecherche +": "+ recherche + 
                        " n'a retourné aucun résultat.";
            } else {
                message = "Résultats pour votre recherche par " + typeRecherche + ":  " + recherche  + ".";
            }
        }
        return listeArticles;
    }

    public ArrayList<String> afficherSuggestion(String typeRecherche, String recherche) throws SQLException{
        ArrayList<String> listeSuggestions = suggestion.SelectionnerSuggestion(connexion, typeRecherche, recherche);
        if(!recherche.equals("")){   
            if (listeSuggestions.size()<=0){
                message = "Votre recherche par "+ typeRecherche +": "+ recherche + 
                        " n'a retourné aucun résultat.";
            } else {
                message = "Résultats pour votre recherche par " + typeRecherche + ":  " + recherche  + ".";
            }
        }
        System.out.println("liste Suggestions = "+  listeSuggestions);
        return listeSuggestions;
    }
}
