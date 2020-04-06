package dao;

import java.sql.SQLException;

public interface IRegNewUser {
    public boolean regNewUser(String rNom,String rPrenom,String rEmail,
                              String rUser, String rPass,int adrLiv,
                              int adrFac, int Stat) throws SQLException;
}
