package Dictionary;

import java.sql.*;

public class AddWord{


    public void addWord(String word_target,String word_explain){
        Connection connection= DBConnection.KetNoi();

//        String word_target;
//        String word_explain;
//        System.out.print("Nhập từ: ");
//        word_target = scanner.nextLine();
//        System.out.print("Nhập nghĩa: ");
//        word_explain = scanner.nextLine();
        String sql = "insert into tbl_edict(word,detail) values (?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,word_target);
            preparedStatement.setString(2,word_explain);

            preparedStatement.executeUpdate();


            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

