package controlers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

public class ClientAssemblyProductController extends AbstractController  { 

    @FXML
    private Button BridelBouquetBtn;

    @FXML
    private Button FlowerPotsBtn;

    @FXML
    private Button ColorfulBouquetsBtn;

    @FXML
    private Button BackBtn;

    @FXML
    private ListView<?> ListOfItems;

    @FXML
    private Label UpdateTypeProLabel;

    @FXML
    private Button PlusBtn;

    @FXML
    private Label QuanLbl;

    @FXML
    private Label TotalPriceLbl;

    @FXML
    private Button AddToCartBtn;

    @FXML
    private ImageView productImage;

    @FXML
    private Label productNameLbl;

    @FXML
    void AddProductToCart(ActionEvent event) {

    }

    @FXML
    void AddQuan(ActionEvent event) {

    }

    @FXML
    void Back(ActionEvent event) throws IOException {
    	start(event, "ClientCreateOrderScreen", "Create Order", "");
    }

    @FXML
    void DecQuan(ActionEvent event) {

    }

    @FXML
    void ShowBridelProductsCatalog(ActionEvent event) {

    }

    @FXML
    void ShowColorfulBouquetScreen(ActionEvent event) {

    }

    @FXML
    void showFlowerPotsScreen(ActionEvent event) {

    }

	@Override
	public void display(String string) {
		// TODO Auto-generated method stub
		
	}

}
