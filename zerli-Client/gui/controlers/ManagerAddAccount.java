package controlers;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ManagerAddAccount {

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblAccount;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtCreditcard;

    @FXML
    private Button backBtn;

    @FXML
    private Button LogOutbtn;

    @FXML
    private Button confirmBtn;
    
    void back(MouseEvent event) throws IOException{
    	
    }
    
    void Logout(MouseEvent event) throws IOException{
    	
    }
    void Confirm(MouseEvent event) throws IOException{
    	
    }
    
    @FXML
    void initialize() {
        assert lblAccount != null : "fx:id=\"lblAccount\" was not injected: check your FXML file 'newAccount.fxml'.";
        assert txtFirstName != null : "fx:id=\"txtFirstName\" was not injected: check your FXML file 'newAccount.fxml'.";
        assert txtLastName != null : "fx:id=\"txtLastName\" was not injected: check your FXML file 'newAccount.fxml'.";
        assert txtID != null : "fx:id=\"txtID\" was not injected: check your FXML file 'newAccount.fxml'.";
        assert txtEmail != null : "fx:id=\"txtEmail\" was not injected: check your FXML file 'newAccount.fxml'.";
        assert txtPhone != null : "fx:id=\"txtPhone\" was not injected: check your FXML file 'newAccount.fxml'.";
        assert txtCreditcard != null : "fx:id=\"txtCreditcard\" was not injected: check your FXML file 'newAccount.fxml'.";
        assert backBtn != null : "fx:id=\"backBtn\" was not injected: check your FXML file 'newAccount.fxml'.";
        assert LogOutbtn != null : "fx:id=\"LogOutbtn\" was not injected: check your FXML file 'newAccount.fxml'.";
        assert confirmBtn != null : "fx:id=\"confirmBtn\" was not injected: check your FXML file 'newAccount.fxml'.";

    }
}
