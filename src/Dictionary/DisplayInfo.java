package Dictionary;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DisplayInfo{

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    DBConnection dbConnection = new DBConnection();

    public void Display(){
        connection = dbConnection.KetNoi();

        String sql = "select * from tbl_edict";

        try {
            preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String word_target = resultSet.getString("word");
                String word_explain = resultSet.getString("detail");


                System.out.println(word_target + "\t" + word_explain);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public String lookUp(String word_english){
        connection = dbConnection.KetNoi();

//        System.out.print("Nhập từ cần tìm: ");
//        Scanner scanner = new Scanner(System.in);
//        String word = scanner.nextLine();
        String test = "";
        String sql = "select * from tbl_edict";

        try {
            preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String word_target = resultSet.getString("word");
                String word_explain = resultSet.getString("detail");
                if (word_english.equals(word_target)){
                   // System.out.println(word_target + "\t" + word_explain);
                    test =  word_explain;
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return test;
    }
    public ArrayList<String> Searcher(String word_english){
        connection = dbConnection.KetNoi();
        ArrayList<String> word_ = new ArrayList<>();

//        System.out.print("Nhập từ cần tìm: ");
//        Scanner scanner = new Scanner(System.in);
//        String word = scanner.nextLine();
        String sql = "select word from tbl_edict";

        try {
            preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String word_target = resultSet.getString("word");
                //String word_explain = resultSet.getString("detail");
                if (word_target.startsWith(word_english)){
                    //System.out.println(word_target + "\t" + word_explain);
                    word_.add(word_target);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return word_;
    }

}
