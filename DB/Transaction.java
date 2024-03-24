package DB;

import java.sql.*;

public class Transaction {
    private static final String DB_URL = "jdbc:mysql://localhost/test";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "sqledu";

    public static void main(String[] args) {
        Connection connect = null;
        try {
            connect = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            Statement st = connect.createStatement();
            connect.setAutoCommit(false);
            st.executeUpdate("INSERT INTO users (id,name,surname) VALUES (5,'John','Wick')");

            st.executeUpdate("INSERT INTO users (id,name,surname) VALUES (6,'Michael','Schofield')");
            connect.commit();
        } catch (SQLException e) {
            if (connect != null){
                try {
                    connect.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            System.out.println(e.getMessage());
        }
    }
}
