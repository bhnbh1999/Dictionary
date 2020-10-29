package Dictionary;

import java.sql.*;


public class DBConnection {


    public static Connection KetNoi(){

        Connection connection = null;
        String URL = "jdbc:mysql://localhost:3306/dictionary";
        String user = "root";
        String pass = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL,user,pass);

//            if (connection != null){
//                System.out.println("Ket noi thanh cong");
//            }
           // connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }
}
