
package dao;

import beans.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegNewUser {
  private Connector connector;

    public RegNewUser() {
        connector = new Connector(); 
    }
    public Boolean regNewUser(String rNom,String rPrenom,String rEmail,String rUser,String rPass,int adrLiv, int adrFac, int Stat) throws SQLException {
      
        Connection connexion = connector.contacterBDD();
        String query = "INSERT INTO CLIENT VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = connexion.prepareStatement(query);

        pstmt.setInt(1, adrLiv);
        pstmt.setInt(2, adrFac);
        pstmt.setString(3, rNom);
        pstmt.setString(4, rPrenom);
        pstmt.setString(5, rUser);
        pstmt.setString(6, rPass);
        pstmt.setString(7, rEmail);
        pstmt.setInt(8, Stat);

        pstmt.executeUpdate();
        pstmt.close();
        connexion.close();
        return true; 
    }
}

  
            

