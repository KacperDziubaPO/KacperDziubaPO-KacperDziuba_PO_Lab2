package system;

import java.sql.*;

public class DB {

    private Connection connection;

    public DB() {
        final String DB_URL = "jdbc:mariadb://127.0.0.1:3306/LibraryDB";
        try {
            this.connection = DriverManager.getConnection(DB_URL, "superuser", "library");
        } catch (SQLException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }


    public ResultSet getDataFromDb(String query) throws SQLException {
        Statement stmt = connection.createStatement();
        return stmt.executeQuery(query);
    }


    public Connection getConnection() {
        return connection;
    }


}


