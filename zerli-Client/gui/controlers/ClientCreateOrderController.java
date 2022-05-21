package controlers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class ClientCreateOrderController extends AbstractController   {;

    @FXML
    private ImageView cartImage;
    @FXML 
    private Button OurCatalogBtn;

    @FXML 
    private Button MakeYourOwnBtn;

    @FXML 
    private Button CartBtn; 

    @FXML
    private Label NumberOfProductLbl;
    
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
		CartBtn.setStyle("-fx-background-color: transparent;");
		CartBtn.setGraphic(cartImage);
		this.NumberOfProductLbl.setText(CartScreenController.cart.getNumberOfItems().toString());
		
	}

}
