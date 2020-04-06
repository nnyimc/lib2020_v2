package dao;

import java.sql.Connection;

public interface ISelectGenerique {
    public Connection getConnexion();
    public void setConnexion(Connection connexion);
}
