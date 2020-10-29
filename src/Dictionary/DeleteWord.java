package Dictionary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteWord {
    public void deleteWord(String word_target) {
        Connection connection = DBConnection.KetNoi();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from tbl_edict where word = ?");
            preparedStatement.setString(1, word_target);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
