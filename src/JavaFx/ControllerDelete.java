package JavaFx;

import Dictionary.DeleteWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControllerDelete {
    @FXML
    private TextField textEnglish;
    @FXML
    private Button delete;

    public void deleteWord(ActionEvent event) {
        if (!textEnglish.getText().equals("")) {
            DeleteWord delete = new DeleteWord();
            delete.deleteWord(textEnglish.getText());
            textEnglish.clear();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Congratulations");
            alert.setContentText("Bạn đã xóa thành công!");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("Mời nhập từ");
            alert.show();
        }
    }
}
