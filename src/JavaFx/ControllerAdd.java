package JavaFx;

import Dictionary.AddWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControllerAdd {

    @FXML private TextField textEnglish;
    @FXML private TextField textVN;
    @FXML private Button add;

    public void addtoWord(ActionEvent event) {
        if (!textEnglish.getText().equals("") && !textVN.getText().equals("")) {
            AddWord addWord = new AddWord();
            addWord.addWord(textEnglish.getText(),textVN.getText());
            textEnglish.clear();
            textVN.clear();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Congratulations");
            alert.setContentText("Bạn đã thêm thành công!");
            alert.show();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("Mời nhập từ");
            alert.show();
        }
    }
}
