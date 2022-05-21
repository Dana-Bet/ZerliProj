package controlers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import Entities.ItemInOrder;
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
	ItemInOrder tempItem;
	String TypeOfProduct;
	
    @FXML
    public ChoiceBox<String> listOfProduct;

    @FXML
    private Button BridelBouquetBtn;

    @FXML
    private Button FlowerPotsBtn;

    @FXML
    private Button CartBtn;

    @FXML
    private Label NumberOfProductLbl;
    
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
    private ImageView cartImage;
    
    @FXML
    void AddProductToCart(ActionEvent event) {
    	TotalPriceLbl.setText("Price : ");
    	QuanLbl.setText("0");
    	CartScreenController.cart.AddToCart(new ItemInOrder(tempItem.getId(), tempItem.getColor(), tempItem.getName(),
    			tempItem.getType(), tempItem.getPrice(), tempItem.isAssembleItem(),tempItem.getQuan()));
		this.NumberOfProductLbl.setText(CartScreenController.cart.getNumberOfItems().toString());
		ArrayList<String> s = new ArrayList<>();
		s= CartScreenController.cart.Create_Recipt();
		System.out.println(s);

    }
    
    @FXML
    void AddQuan(ActionEvent event) {
    	tempItem.AddToQuan();
    	TotalPriceLbl.setText("Price : "+tempItem.getTotalPrice().toString()+"$");
    	QuanLbl.setText(tempItem.getQuan().toString());
    }

    @FXML
    void Back(ActionEvent event) throws IOException {
    	start(event, "ClientCreateOrderScreen", "Create Order", "");
    }

    @FXML
    void DecQuan(ActionEvent event) {
    	if(tempItem!=null) {
    	    tempItem.DecToQuan();
        if  (tempItem.getQuan()!=0) {
        	TotalPriceLbl.setText("Price : "+tempItem.getTotalPrice().toString()+"$");
        	QuanLbl.setText(tempItem.getQuan().toString());
    	}
        else {  
        	TotalPriceLbl.setText("Price : ");
        	QuanLbl.setText("0");
          }
    	}
    	
    }

    @FXML
    void ShowBridelProductsCatalog(ActionEvent event) {
    	InitialPerType("Bridel bouquets");
    }

    @FXML
    void ShowColorfulBouquetScreen(ActionEvent event) {
    	InitialPerType("colorful bouquets");
    }

    @FXML
    void showFlowerPotsScreen(ActionEvent event) {
    	InitialPerType("pots");
    }
    
    
    @FXML
    void getItemDetails(ActionEvent event) {
    	this.tempItem = null;
            productNameLbl.setText("");
            productPriceLbl.setText("");
            productColorLbl.setText("");
            this.productImage.setImage(null);
    	try {
    	
              String Choosing_Item = listOfProduct.getValue();
              for (Item_In_Catalog i : Catalog) {
              	if (i.getName().compareTo(Choosing_Item)==0){
              		this.tempItem = new ItemInOrder(i.getId(), i.getColor(), i.getName(),
         				   i.getType(), i.getPrice(), i.isAssembleItem(),0);
         		     break;
        	}
        }
     	
              productNameLbl.setText(tempItem.getName());
              productPriceLbl.setText("Price :"+(tempItem.getPrice()).toString()+" $");
              productColorLbl.setText("Dominant color : "+(tempItem.getColor()).toString());
              Image im= new Image("/images/"+tempItem.getName()+".JPG");
              this.productImage.setImage(im);
        
        
             }catch(Exception e) {}
    }
    
    /*
     * This function initialize the choice box according the product type choosing by the user
     */
    
    private void InitialPerType(String typeName) {
    	this.tempItem = null;
    	TypeOfProduct = typeName;
    	listOfProduct.setValue("choose product from list");
    	listOfProduct.getItems().clear();
    	ArrayList<String> Items =  new ArrayList<String>();
    	for (Item_In_Catalog i : Catalog) {
    		if (i.getType().compareTo(typeName)==0) {
    			Items.add(i.getName());
    		}	
    	}
    	listOfProduct.getItems().addAll(Items);
    	UpdateTypeProLabel.setText(TypeOfProduct);
    	listOfProduct.setValue("Romantic bridel bouquet");
    }

	@Override
	public void display(String string) {
	
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ClientUI.chat.accept(new Message(MessageType.Initialize_Catalog,"0"));
    	InitialPerType("Bridel bouquet");

    	UpdateTypeProLabel.setText("Bridel bouquets");
		this.NumberOfProductLbl.setText(CartScreenController.cart.getNumberOfItems().toString());
		CartBtn.setStyle("-fx-background-color: transparent;");
		CartBtn.setGraphic(cartImage);
	}

}