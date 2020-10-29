package Dictionary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddWord {
    public void addWord(String word_target, String word_explain) {
        Connection connection = DBConnection.KetNoi();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into tbl_edict(word,detail) values (?,?)");
            preparedStatement.setString(1, word_target);
            preparedStatement.setString(2, word_explain);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

