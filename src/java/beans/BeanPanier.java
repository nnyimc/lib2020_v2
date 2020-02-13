package beans;

import dao.Connector;
import dao.SelectArticle;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class BeanPanier implements Serializable{

    
    private Map<String, BeanArticle> contenuPanier;
    private Connector connector;
    private Connection connexion;
    private SelectArticle selection;

    public Connection getConnexion() {
        return connexion;
    }

    public void setConnexion(Connection connexion) {
        this.connexion = connexion;
    }
    
    public BeanPanier() throws SQLException{
        contenuPanier = new HashMap<String, BeanArticle>();
        connector = new Connector();
        connexion = connector.contacterBDD();
        selection = new SelectArticle();  
    }

    public Connector getConnector() {
        return connector;
    }

    public void setConnector(Connector connector) {
        this.connector = connector;
    }

    public SelectArticle getSelection() {
        return selection;
    }

    public void setSelection(SelectArticle selection) {
        this.selection = selection;
    }
    
    public Map<String, BeanArticle> getContenuPanier() {
        return contenuPanier;
    }

    public void setContenuPanier(Map<String, BeanArticle> contenuPanier) {
        this.contenuPanier = contenuPanier;
    }
    
    public void inc(String livreIsbn) throws SQLException {
        add(livreIsbn, +1);
    }
     
    public void add(String livreIsbn, int quantite) throws SQLException {
        if (contenuPanier.containsKey(livreIsbn)) {
            BeanArticle a = contenuPanier.get(livreIsbn);
            a = selection.SelectionnerArticle(this.connexion, livreIsbn);
            a.changerQteCommandee(quantite);
            a.setLivreQteStock(-quantite);
            if (a.getLivreQteStock() < 1) {
                del(livreIsbn);
            }
        } else {
            BeanArticle a = selection.SelectionnerArticle(this.connexion, livreIsbn);
            contenuPanier.put(livreIsbn, a);
        }

    }

    public void dec(String livreIsbn) throws SQLException {
        add(livreIsbn, -1);
    }

    public void sub(String livreIsbn, int qty) throws SQLException {
        add(livreIsbn, -qty);
    }

    public void del(String livreIsbn) {
        contenuPanier.remove(livreIsbn);
    }

    public void clear() {
        contenuPanier.clear();
    }

    public Collection<BeanArticle> list() {
        return contenuPanier.values();
    }

    public boolean isEmpty() {
        return contenuPanier.isEmpty();
    }
     
}
