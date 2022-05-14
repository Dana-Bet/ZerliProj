package controlers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class ChangePremmisionAccountController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text txtChooseAccount;

    @FXML
    private Label lblChangePermission;

    @FXML
    private ComboBox<?> ActiveAccountComboBox;

    @FXML
    private Button backBtn;

    @FXML
    private Button activeBtn;

    @FXML
    private Button freezeBtn;

    @FXML
    private Button logoutBtn;

    @FXML
    void ActiveAccountComboBox(ActionEvent event) {

    }
    @FXML
    void Active(ActionEvent event) {

    }
    @FXML
    void Freeze(ActionEvent event) {

    }
    @FXML
    void LogOut(ActionEvent event) {

    }
 
    @FXML
    void initialize() {
        assert txtChooseAccount != null : "fx:id=\"txtChooseAccount\" was not injected: check your FXML file 'ChangePermissionsAccount.fxml'.";
        assert lblChangePermission != null : "fx:id=\"lblChangePermission\" was not injected: check your FXML file 'ChangePermissionsAccount.fxml'.";
        assert ActiveAccountComboBox != null : "fx:id=\"ActiveAccountComboBox\" was not injected: check your FXML file 'ChangePermissionsAccount.fxml'.";
        assert backBtn != null : "fx:id=\"backBtn\" was not injected: check your FXML file 'ChangePermissionsAccount.fxml'.";
        assert activeBtn != null : "fx:id=\"activeBtn\" was not injected: check your FXML file 'ChangePermissionsAccount.fxml'.";
        assert freezeBtn != null : "fx:id=\"freezeBtn\" was not injected: check your FXML file 'ChangePermissionsAccount.fxml'.";
        assert logoutBtn != null : "fx:id=\"logoutBtn\" was not injected: check your FXML file 'ChangePermissionsAccount.fxml'.";

    }
}
