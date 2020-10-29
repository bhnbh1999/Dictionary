package Dictionary;

import java.sql.*;

public class DeleteWord {

    public void deleteWord(String word_target){
        Connection connection = DBConnection.KetNoi();
        String sql = "delete from tbl_edict where word = ?";
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Nhập từ cần xóa: ");
//        String word_target = scanner.nextLine();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,word_target);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
