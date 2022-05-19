package controlers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MarketingWorkerController extends AbstractController implements Initializable{

	
	@FXML
    private Label nameLbl;

    @FXML
    private Button updateCatalogBtn;


    @FXML 
    void updateCatalog(ActionEvent event) throws IOException {
    	start(event,"UpdateItemsInCatalogScreen","","");
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display(String string) {
		nameLbl.setText(LoginScreenController.user.getFirstN() + " " + LoginScreenController.user.getLastN());		
	}

}
