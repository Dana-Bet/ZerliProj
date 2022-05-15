package controlers;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import controlers.AbstractController;
import controlers.LoginScreenController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;


public class MainManagerScreenController extends AbstractController implements  Initializable{


    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="Background"
    private AnchorPane Background; // Value injected by FXMLLoader

    @FXML // fx:id="LabelWelcome"
    private Text LabelWelcome; // Value injected by FXMLLoader

    @FXML
    private Button Revenuebtn;

    @FXML // fx:id="AddAccountBtn"
    private Button AddAccountBtn; // Value injected by FXMLLoader

    @FXML
    private Button LogOutBtn;
    @FXML
    private Label nameLabel;
    

    @FXML
    void AddAccount(ActionEvent event) throws IOException {
    	start(event,"newAccountScreen","Open New Account",LoginScreenController.user.getFirstN());
    }
    @FXML
	void ViewStoreReports(ActionEvent event) throws IOException {
		start(event,"ManagerViewReportsScreen","View Report",LoginScreenController.user.getFirstN());
    }
    
	@Override
	public void display(String string) {
		nameLabel.setText(LoginScreenController.user.getFirstN() + " " + LoginScreenController.user.getLastN());
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	}
