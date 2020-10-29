package JavaFx;

import Dictionary.DisplayInfo;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    DisplayInfo displayInfo = new DisplayInfo();
    @FXML
    private ListView<String> listView;
    @FXML
    private TextField textField;
    @FXML
    private WebView webView;
    @FXML
    private Button add;
    @FXML
    private Button delete;
    @FXML
    private Button edit;
    @FXML
    private Button clearButton;
    @FXML
    private Button speakButton;
    @FXML
    private Button API;
    private ObservableList<String> list = FXCollections.observableArrayList();

    public void Search(KeyEvent event) {
//        listView.getItems().clear();
        ArrayList<String> arrayList = displayInfo.Searcher(textField.getText());
        listView.getItems().setAll(arrayList);
        webView.getEngine().loadContent("");
    }

    public void clickMouse(MouseEvent event) {
        textField.setText(listView.getSelectionModel().getSelectedItem());
        String S = listView.getSelectionModel().getSelectedItems().toString();
        String word_english = S.substring(1, S.length() - 1);
        String word_vietnamese = displayInfo.lookUp(word_english);
        if (word_vietnamese != null) {
            WebEngine webEngine = webView.getEngine();
            webEngine.loadContent(word_vietnamese);
        }
    }

    public void Add(ActionEvent event) {
        Stage primaryStage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("addword.fxml"));
            primaryStage.setTitle("Add");
            primaryStage.setScene(new Scene(root, 300, 220));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Delete(ActionEvent event) {
        Stage primaryStage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("deleteword.fxml"));
            primaryStage.setTitle("Delete");
            primaryStage.setScene(new Scene(root, 300, 220));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Edit(ActionEvent event) {
        Stage primaryStage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("editword.fxml"));
            primaryStage.setTitle("Edit");
            primaryStage.setScene(new Scene(root, 300, 220));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void translate(ActionEvent event) {
        Stage primaryStage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("translateapi.fxml"));
            primaryStage.setTitle("Translate");
            primaryStage.setScene(new Scene(root, 600, 400));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearButton) {
            textField.setText("");
            listView.getItems().clear();
            webView.getEngine().loadContent("");
        }
        if (e.getSource() == speakButton) {
            Voice voice;//Creating object of Voice class
            voice = VoiceManager.getInstance().getVoice("kevin16");//Getting voice
            if (voice != null) {
                voice.allocate();//Allocating Voice
            }
            try {
                voice.setRate(190);//Setting the rate of the voice
                voice.setPitch(150);//Setting the Pitch of the voice
                voice.setVolume(10);//Setting the volume of the voice
                voice.speak(textField.getText());//Calling speak() method
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
