package Dictionary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DisplayInfo {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    DBConnection dbConnection = new DBConnection();

    public String lookUp(String word_english) {
        connection = DBConnection.KetNoi();
        String test = "";
        String sql = "select * from tbl_edict";
        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String word_target = resultSet.getString("word");
                String word_explain = resultSet.getString("detail");
                if (word_english.equals(word_target)) {
                    test = word_explain;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return test;
    }

    public ArrayList<String> Searcher(String word_english) {
        connection = dbConnection.KetNoi();
        ArrayList<String> word_ = new ArrayList<>();
        String sql = "select word from tbl_edict";
        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String word_target = resultSet.getString("word");
                if (word_target.startsWith(word_english)) {
                    word_.add(word_target);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return word_;
    }
}
