package dao;

import java.sql.Connection;
import java.sql.DriverManager;import java.sql.SQLException;

public class DBManager {
    private String url = "jdbc:mysql://localhost:3306/gestion_bibliotheque_web?useSSL=false";
    private String user = "root";
    private String password = "";

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);
    }
}