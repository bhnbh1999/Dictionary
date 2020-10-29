package Dictionary;

import java.sql.*;

public class EditWord {

    public void editWord(String word_target,String word_explain){
        Connection connection= DBConnection.KetNoi();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update tbl_edict set detail =? where word = ?");
            preparedStatement.setString(2,word_target);
            preparedStatement.setString(1,word_explain);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
