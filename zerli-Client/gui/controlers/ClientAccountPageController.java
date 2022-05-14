package controlers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ClientAccountPageController extends AbstractController {

    @FXML
    private Label FirstNameLbl;

    @FXML
    private Label LastNameLbl;

    @FXML
    private Label EmailLbl;

    @FXML
    private Label PhoneLbl;

    @FXML
    private Button BackBtn;
    
    

    @FXML
    void BackToMain(ActionEvent event) throws IOException {
    	start(event, "ClientMainPage", "Customer Screen", "");
    }

	@Override
	public void display(String UserName) {
		FirstNameLbl.setText(LoginScreenController.user.getFirstN());
		LastNameLbl.setText(LoginScreenController.user.getLastN());
		EmailLbl.setText(LoginScreenController.user.getEmail());
		PhoneLbl.setText(LoginScreenController.user.getPhone());
	}

}