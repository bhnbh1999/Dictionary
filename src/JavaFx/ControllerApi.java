package JavaFx;

import com.darkprograms.speech.translator.GoogleTranslate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.web.WebView;

public class ControllerApi {


    private static String fromLang = "en";
    private static String toLang = "vi";

    @FXML private TextArea textArea;
    @FXML private Button api;
    @FXML private WebView webView;

    public void translateAPI(ActionEvent event) {
        try {

            if (!textArea.getText().equals("")) {

                String s = GoogleTranslate.translate(fromLang, toLang, textArea.getText());
                webView.getEngine().loadContent(s);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setContentText("Mời nhập");
                alert.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
