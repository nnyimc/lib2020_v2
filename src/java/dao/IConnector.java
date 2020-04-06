package dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConnector {
    public Connection contacterBDD() throws SQLException;
}
