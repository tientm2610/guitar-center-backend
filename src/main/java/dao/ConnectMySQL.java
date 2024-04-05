package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectMySQL {

    public static Connection getConnection(){
        
        String urlDB = "jdbc:mysql://localhost:3306/guitar_center_db";
        String username = "root";
        String password = "Minhtien1";

        return getConnection(urlDB,username,password);
        
    }

    private  static Connection getConnection(String urlDB, String username, String password){
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                conn = DriverManager.getConnection(urlDB, username, password);
                System.out.println("connect thanh cong");
                System.out.println(password);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;

    }
    public static void main(String[] args) {
        ConnectMySQL connectMySQL = new ConnectMySQL();
        connectMySQL.getConnection();
    }
}
