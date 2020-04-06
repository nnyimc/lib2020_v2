package beans;

import dao.Connector;
import dao.SelectArticle;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

public interface IBeanPanier {
    public Connector getConnector();
    public void setConnector(Connector connector);

    public SelectArticle getSelection();
    public void setSelection(SelectArticle selection);

    public Map<String, BeanArticle> getContenuPanier();
    public void setContenuPanier(Map<String, BeanArticle> contenuPanier);

    public void inc(String livreIsbn) throws SQLException;

    public void add(String livreIsbn, int quantite) throws SQLException;
    public void dec(String livreIsbn) throws SQLException;
    public void sub(String livreIsbn, int qty) throws SQLException;
    public void del(String livreIsbn);
    public void clear();

    public Collection<BeanArticle> list();
    public boolean isEmpty();

}
