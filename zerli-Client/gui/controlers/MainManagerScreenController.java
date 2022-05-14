package controlers;
/**
 * Sample Skeleton for 'MainManagerScreen.fxml' Controller Class
 */
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class MainManagerScreenController {


    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="Background"
    private AnchorPane Background; // Value injected by FXMLLoader

    @FXML // fx:id="LabelWelcome"
    private Text LabelWelcome; // Value injected by FXMLLoader

    @FXML // fx:id="ViewBranchReportsBtn"
    private Button ViewBranchReportsBtn; // Value injected by FXMLLoader

    @FXML // fx:id="ViewStoreOrdersBtn"
    private Button ViewStoreOrdersBtn; // Value injected by FXMLLoader

    @FXML // fx:id="AddAccountBtn"
    private Button AddAccountBtn; // Value injected by FXMLLoader

    @FXML // fx:id="ViewAuthorizedUsersBtn"
    private Button ViewAuthorizedUsersBtn; // Value injected by FXMLLoader

    @FXML
    private Button LogOutBtn;
    
    @FXML
    void ViewReports(ActionEvent event) {
    	
    }
    @FXML
    void ViewStoreOrder(ActionEvent event) {
    	
    }
    @FXML
    void AddAccount(ActionEvent event) {
    	
    }
    @FXML
    void ViewUsers(ActionEvent event) {
    	
    }
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert Background != null : "fx:id=\"Backòround\" was not injected: check your FXML file 'MainManagerScreen.fxml'.";
        assert LabelWelcome != null : "fx:id=\"LabelWelcome\" was not injected: check your FXML file 'MainManagerScreen.fxml'.";
        assert ViewBranchReportsBtn != null : "fx:id=\"ViewBranchReportsBtn\" was not injected: check your FXML file 'MainManagerScreen.fxml'.";
        assert ViewStoreOrdersBtn != null : "fx:id=\"ViewStoreOrdersBtn\" was not injected: check your FXML file 'MainManagerScreen.fxml'.";
        assert AddAccountBtn != null : "fx:id=\"AddAccountBtn\" was not injected: check your FXML file 'MainManagerScreen.fxml'.";
        assert ViewAuthorizedUsersBtn != null : "fx:id=\"ViewAuthorizedUsersBtn\" was not injected: check your FXML file 'MainManagerScreen.fxml'.";

    }
	}
