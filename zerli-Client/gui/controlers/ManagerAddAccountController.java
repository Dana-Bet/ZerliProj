package controlers;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Entities.Client;
import Entities.Message;
import Entities.MessageType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import main.ClientUI;


public class ManagerAddAccountController extends AbstractController implements Initializable {

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
    private Button confirmBtn;

    @FXML
    private Label firstNamelbl;

    @FXML
    private Label lastNamelbl;

    @FXML
    private Label IDlbl;

    @FXML
    private Label emaillbl;

    @FXML
    private Label phonelbl;

    @FXML
    private Label creditCardlbl;
    
    @FXML
    private Text userName;
    
    @FXML
    private Label updateLbl;
    
    @FXML
    private Label userNamelbl;

    @FXML
    private Label passwordLbl;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;
    
    public static Client Account = new Client(null, null, null, null, null, null, null, null, null, null,null);
	public static boolean ConfirmOpenNewAccountFlag = false;
	
	@FXML
	void back(ActionEvent event) throws IOException {
		start(event,"MainManagerScreen","Branch Manager", LoginScreenController.user.getFirstN());
	}
    
    @FXML
	void Confirm(ActionEvent event) throws IOException {
//compleate username and password
		if (txtFirstName.getText().isEmpty() || txtLastName.getText().isEmpty() || txtID.getText().isEmpty()
				|| txtPhone.getText().isEmpty() || txtEmail.getText().isEmpty()
				|| txtCreditcard.getText().isEmpty())
			{
				updateLbl.setText("You need compleate all");
			}
		else {
			Account.setUserName(txtUsername.getText());
			Account.setPassword(txtPassword.getText());
			Account.setFirstN(txtFirstName.getText());
			Account.setLastN(txtLastName.getText());
			Account.setId(txtID.getText());
			Account.setPhone(txtPhone.getText());
			Account.setEmail(txtEmail.getText());
			Account.setCreditCardNumber(txtCreditcard.getText());
			Account.setRole("Customer");
			ClientUI.chat.accept(new Message(MessageType.add_account, Account));
			updateLbl.setText("New Account Complete");
		}
		}
	
	@Override
	public void display(String string) {
		userName.setText(LoginScreenController.user.getFirstN() + " " + LoginScreenController.user.getLastN());		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ConfirmOpenNewAccountFlag = false;
		
	}
}