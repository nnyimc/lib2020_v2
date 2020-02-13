package dao;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class Connector {
   public Connection contacterBDD() throws SQLException{
         DataSource ds = null;
            try {
                InitialContext context = new InitialContext();
                ds = (DataSource) context.lookup("jdbc/LibGrp1");
            } catch (NamingException ex) {
                System.err.println("Oops:naming:" + ex.getMessage());
            }
        Connection connexion = ds.getConnection();
        return connexion;
    }
}
