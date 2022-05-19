package controlers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Entities.Item_In_Catalog;
import Entities.Message;
import Entities.MessageType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import main.ClientUI;

public class ClientAssemblyProductController extends AbstractController implements Initializable {
 
	String TypeOfProduct= null;
	public static boolean catalog_Initilaize = false ; 
	public static ArrayList<Item_In_Catalog> Catalog= new ArrayList<>();
	
    @FXML
    private Button BackBtn;

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
    private Label productPriceLbl;

    @FXML
    private Label productColorLbl;

    @FXML
    private ChoiceBox<?> listOfProducts;

    @FXML
    private TextField ProductComponent;

    @FXML
    private Label priceByQuan;

    @FXML
    private ToggleGroup BtnGroup;

    @FXML
    private RadioButton Bouquet;

    @FXML
    private RadioButton Flowercluster;

    @FXML
    private RadioButton FlowerPot;

    @FXML
    void AddProductToCart(ActionEvent event) {

    }

    @FXML
    void AddQuan(ActionEvent event) {

    }

    @FXML
    void Back(ActionEvent event) {

    }

    @FXML
    void DecQuan(ActionEvent event) {

    }

    @FXML
    void getItemDetails(ActionEvent event) {

    }

	    
	@Override
	public void display(String string) {
			// TODO Auto-generated method stub
			
		}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
			ClientUI.chat.accept(new Message(MessageType.Initialize_Catalog,"1"));
			
			
		}

	}

