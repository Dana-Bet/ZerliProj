package controlers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ClientCreateOrderController extends AbstractController  {
	public CartScreenController cart ;
	
    @FXML 
    private Button OurCatalogBtn;

    @FXML 
    private Button MakeYourOwnBtn;

    @FXML 
    private Button CartBtn; 

    @FXML 
    private Button backBtn; 

    @FXML
    void MakeYourOwnPage(ActionEvent event) throws IOException {
    	start(event, "ClientMakeYourOwnProScreen", "Make Your Own Product screen", "");
    }

    @FXML
    void OpenCartPage(ActionEvent event) throws IOException {
       start(event, "ClientCartScreen", "Cart Screen", "");
    }

    @FXML
    void OpenCatalog(ActionEvent event) throws IOException {
       start(event, "ClientOurCatalogScreen", "Our Catalog ", "");
    }

    @FXML
    void backToMain(ActionEvent event) throws IOException {
      
       start(event, "ClientMainPage", "Customer Screen", "");
    }

	@Override
	public void display(String string) {
		
		
	}

}
