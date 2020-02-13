
package dao;

import beans.Utilisateur;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectClient {

    private Connector connector;

    public SelectClient() {
        connector = new Connector();
    }

    public Utilisateur getClient(String bUser, String bPass) throws SQLException {
        
        Utilisateur util = new Utilisateur();
        Connection connexion = connector.contacterBDD();
        String query="select * from client where clientlogin = '" + bUser + "' AND clientmdp='"+bPass+"'";
        Statement stmt = connexion.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        if (rs.next()) {
            util.setLog(bUser);
            util.setPass(bPass);
            rs.close();
            stmt.close();
            connexion.close();
            return util;
        } else {
            rs.close();
            stmt.close();
            connexion.close();
            return null;
        }

    }
   
}
