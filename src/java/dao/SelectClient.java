
package dao;

import entities.Client;
import entities.IUtilisateur;
import entities.Utilisateur;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectClient implements ISelectGenerique {

    private IConnector connector;
    private Connection connexion;
    private IUtilisateur client = new Client();

    public SelectClient() {

        connector = new Connector();
    }

    @Override
    public Connection getConnexion() {
        return null;
    }

    @Override
    public void setConnexion(Connection connexion) {

    }

    public Client getClient(String bUser, String bPass) throws SQLException {
        connexion = connector.contacterBDD();
        String query="select * from client where clientlogin = '" + bUser + "' AND clientmdp='"+bPass+"'";
        Statement stmt = connexion.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        if (rs.next()) {
            client.setLogin(bUser);
            client.setPass(bPass);
            rs.close();
            stmt.close();
            connexion.close();
            return (Client) client;
        } else {
            rs.close();
            stmt.close();
            connexion.close();
            return null;
        }

    }
   
}
