package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBEngine {
    private Connection connection;

    public DBEngine(){
        connection = connect();
    }

    public Boolean isConnected() {
        return (connection != null);
    }

    //make connection
    private Connection connect() {
        String url = "jdbc:mysql://localhost:3306/rpgDB" +
                "?" +
                "useUnicode=yes" +
                "&" +
                "characterEncoding=UTF-8";
        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "password"); //value should be your password for the mySQL engine

        try {
            return DriverManager.getConnection(url, properties);
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
