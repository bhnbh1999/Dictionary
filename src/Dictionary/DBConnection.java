package Dictionary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection KetNoi() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dictionary", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("ERROR");
        }
        return connection;
    }
}
