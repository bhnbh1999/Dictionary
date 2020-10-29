package JavaFx;

import Dictionary.EditWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControllerEdit {
    @FXML
    private TextField textEnglish;
    @FXML
    private TextField textVN;
    @FXML
    private Button edit;

    public void editWord(ActionEvent event) {
        if (!textEnglish.getText().equals("") && !textVN.getText().equals("")) {
            EditWord edit = new EditWord();
            edit.editWord(textEnglish.getText(), textVN.getText());
            textEnglish.clear();
            textVN.clear();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Congratulations");
            alert.setContentText("Bạn đã sửa thành công!");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("Mời nhập từ");
            alert.show();
        }
    }
}
