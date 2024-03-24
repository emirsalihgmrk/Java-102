package DB;

import java.sql.*;

public class Statements {
    private static final String DB_URL = "jdbc:mysql://localhost/test";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "sqledu";

    public static void main(String[] args) {
        try {
            Connection connect = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            Statement st = connect.createStatement();
            ResultSet data = st.executeQuery("SELECT * FROM users");
            while(data.next()){
                System.out.println("ID : " + data.getInt("id"));
                System.out.println("Name : " + data.getString("name"));
                System.out.println("Surname : " + data.getString("surname"));
                System.out.println("###########");
            }
            //Satır ekleme
            st.executeUpdate("INSERT INTO users (id,name,surname) VALUES (4,'Sophia','Rodriguez')");
            //Prepared statement ile satır ekleme
            PreparedStatement prSt = connect.prepareStatement("INSERT INTO users (id,name,surname) VALUES (?,?,?)");
            prSt.setInt(1,5);
            prSt.setString(2,"Alexander");
            prSt.setString(3,"Schmidt");
            prSt.executeUpdate();
            //Satır güncelleme
            st.executeUpdate("UPDATE users SET surname='Smith' WHERE id=5");
            //Prepared Statement ile satır güncelleme
            prSt = connect.prepareStatement("UPDATE users SET surname=? WHERE id=?");
            prSt.setString(1,"Schmidt");
            prSt.setInt(2,5);
            prSt.executeUpdate();
            //Satır silme
            st.executeUpdate("DELETE FROM users WHERE id=5");
            connect.close();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
