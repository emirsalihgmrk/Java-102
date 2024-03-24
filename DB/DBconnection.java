package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/test?user=root&password=sqledu";
        try{
            Connection connect = DriverManager.getConnection(url);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
