package controlers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class MainServiceSpecialistScreenController extends AbstractController implements  Initializable{

		@FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private Text name;

	    @FXML
	    private Button complaintBtn;

	    @FXML
	    void Complaint(ActionEvent event) throws IOException {
	    	start(event,"TableComplainScreen","","");
	    }

	@Override
	public void display(String string) {
		name.setText(LoginScreenController.user.getFirstN() + " " + LoginScreenController.user.getLastN());		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
