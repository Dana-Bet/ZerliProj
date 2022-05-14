package controlers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class mainCeoScreenController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text LabelWelcome;

    @FXML
    private Button viewquearterlyBtn;

    @FXML
    private Button downloadquarterlyBtn;

    @FXML
    private Button viewstoreBtn;

    @FXML
    private Button logoutBtn;

    @FXML
    void ViewQuearterlyReports(ActionEvent event) {
    	
    }
    @FXML
    void Downloadquarterly(ActionEvent event) {
    	
    }
    @FXML
    void Viewstore(ActionEvent event) {
    	
    }
    @FXML
    void Logout(ActionEvent event) {
    	
    }
    @FXML
    void initialize() {
        assert LabelWelcome != null : "fx:id=\"LabelWelcome\" was not injected: check your FXML file 'MainCeoScreen.fxml'.";
        assert viewquearterlyBtn != null : "fx:id=\"viewquearterlyBtn\" was not injected: check your FXML file 'MainCeoScreen.fxml'.";
        assert downloadquarterlyBtn != null : "fx:id=\"downloadquarterlyBtn\" was not injected: check your FXML file 'MainCeoScreen.fxml'.";
        assert viewstoreBtn != null : "fx:id=\"viewstoreBtn\" was not injected: check your FXML file 'MainCeoScreen.fxml'.";
        assert logoutBtn != null : "fx:id=\"logoutBtn\" was not injected: check your FXML file 'MainCeoScreen.fxml'.";

    }
}
