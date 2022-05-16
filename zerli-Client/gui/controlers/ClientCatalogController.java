package controlers;

import java.io.IOException;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.ClientUI;

public class ClientCatalogController extends AbstractController implements Initializable {
	
    
	
	public static boolean catalog_Initilaize = false ; 
	public static ArrayList<Item_In_Catalog> Catalog= new ArrayList<>();
	
    @FXML
    public ChoiceBox<String> listOfProduct;

    @FXML
    private Button BridelBouquetBtn;

    @FXML
    private Button FlowerPotsBtn;

    @FXML
    private Button ColorfulBouquetsBtn;

    @FXML
    private Button BackBtn;

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
    private Label productNameLbl;
    
    @FXML
    private Label productPriceLbl;

    @FXML
    private Label productColorLbl;
    
    @FXML
    private ImageView productImage;

    
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
    	InitialPerType("Bridel bouquet");
    	UpdateTypeProLabel.setText("Bridel bouquets");
    }

    @FXML
    void ShowColorfulBouquetScreen(ActionEvent event) {
    	InitialPerType("colorful bouquet");
    	UpdateTypeProLabel.setText("colorful bouquets");
    }

    @FXML
    void showFlowerPotsScreen(ActionEvent event) {
    	InitialPerType("pot");
    	UpdateTypeProLabel.setText("Flower pots");
    }
    
    
    @FXML
    void getItemDetails(ActionEvent event) {
            productNameLbl.setText("");
            productPriceLbl.setText("");
            productColorLbl.setText("");
            this.productImage.setImage(null);
    	try {
    	
              String Choosing_Item = listOfProduct.getValue();
              Item_In_Catalog item = null ;
              for (Item_In_Catalog i : Catalog) {
              	if (i.getName().compareTo(Choosing_Item)==0){
         	     	item = new Item_In_Catalog(i.getId(), i.getColor(), i.getName(),
        				   i.getType(), i.getPrice(), i.isAssembleItem());
        		     break;
        	}
        }
     	
       
              productNameLbl.setText(item.getName());
              productPriceLbl.setText("Price :"+(item.getPrice()).toString()+" $");
              productColorLbl.setText("Dominant color : "+(item.getColor()).toString());
              Image im= new Image("/images/"+item.getName()+".JPG");
              this.productImage.setImage(im);
        
        
             }catch(Exception e) {}
    }
    
    /*
     * This function initialize the choice box according the product type choosing by the user
     */
    
    private void InitialPerType(String typeName) {
    	listOfProduct.setValue("choose product from list");
    	listOfProduct.getItems().clear();
    	ArrayList<String> Items =  new ArrayList<String>();
    	for (Item_In_Catalog i : Catalog) {
    		if (i.getType().compareTo(typeName)==0) {
    			Items.add(i.getName());
    		}	
    	}
    	listOfProduct.getItems().addAll(Items);
    	
    }

	@Override
	public void display(String string) {
	
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ClientUI.chat.accept(new Message(MessageType.Initialize_Catalog,"0"));
    	InitialPerType("Bridel bouquet");
    	UpdateTypeProLabel.setText("Bridel bouquets");
		
	}

}