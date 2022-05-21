package controlers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import Entities.Item_In_Catalog;
import Entities.Message;
import Entities.MessageType;
import Entities.ItemInOrder;
import Entities.assembledProduct;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.ClientUI;

public class ClientAssemblyProductController extends AbstractController implements Initializable {
 
    private assembledProduct AProduct;
	public static boolean catalog_Initilaize = false ; 
	public static ArrayList<Item_In_Catalog> Catalog= new ArrayList<>();
	private RadioButton selectedRadioButton ;
	private String TypeOfProduct;
	private ItemInOrder item;
	private Item_In_Catalog choosing_Type;

        @FXML
        private ResourceBundle resources;

       @FXML
        private URL location;
        @FXML
        private Button CartBtn;

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
	    private Label updatelbl;

	    @FXML
	    private Label productPriceLbl;

	    @FXML
	    private Label productColorLbl;

	    @FXML
	    private ChoiceBox<String> listOfProducts;

	    @FXML
	    private TextArea ProductComponent;
	    
	    @FXML
	    private Label priceByQuan;

	    @FXML
	    private RadioButton FlowerPot;

	    @FXML
	    private ToggleGroup g1;

	    @FXML
	    private RadioButton Bouquet;

	    @FXML
	    private RadioButton Flowercluster;
	    
	    @FXML
	    private Button AddToProduct;

	    @FXML
	    private ImageView cartImage;

	    @FXML
	    private Label NumberOfProductLbl;
	    
	    @SuppressWarnings("unchecked")
		@FXML
	    void AddProductToCart(ActionEvent event) {
	    	if (AProduct!=null && this.item!=null) {
	    	if(CartScreenController.cart.Order_Components.containsKey(AProduct.getId())){AProduct.setId(AProduct.getId()+1);} //other id
	    	setSelection();
	    	assembledProduct Temp = new assembledProduct(AProduct.getId(),AProduct.getName(),AProduct.getType(),AProduct.isAssembleItem());
	    	Temp.Product_components_map = AProduct.Product_components_map;		
	    	CartScreenController.cart.AddToCart(Temp);
	    	FlowerPot.setSelected(false);
			Bouquet.setSelected(false);
			Flowercluster.setSelected(false);
			ProductComponent.clear();
			this.NumberOfProductLbl.setText(CartScreenController.cart.getNumberOfItems().toString());
			this.initialize(location,resources);
	    	}
         }
             
	    @FXML
	    void AddQuan(ActionEvent event) {
	    	if (choosing_Type==null ) {
	    		updatelbl.setText("Please choose Product Type");
	    		return;
	    	}
	    	if (this.item==null ) {
	    		updatelbl.setText("Please choose item from list");
	    		return;
	    	}
	    	AProduct.addToProduct(this.item);
	    	updateLbls();
	    	AddToProduct();
	       }
	    
	    @FXML
	    void Back(ActionEvent event) throws IOException {

	    	start(event, "ClientCreateOrderScreen", "Create Order", "");
	    }

	    @FXML
	    void DecQuan(ActionEvent event) {
	    	if (choosing_Type==null ) {
	    		updatelbl.setText("Please choose Product Type");
	    		return;
	    	}
	    	if (this.item==null ) {
	    		updatelbl.setText("Please choose item from list");
	    		return;
	    	}
	        AProduct.DecFromProduct(this.item);
	    	if(this.AProduct.Product_components_map.containsKey(item.getId())) {
	    		updateLbls();
	    }
	    	else {
		    	priceByQuan.setText("Price : 0 $");
		    	QuanLbl.setText("0");
	    	}
	    	AddToProduct();
	    }
	        
	    private void updateLbls() {
	    	priceByQuan.setText("Price : "+AProduct.Product_components_map.get(item.getId()).getTotalPrice().toString()+"$");
	    	QuanLbl.setText(AProduct.Product_components_map.get(item.getId()).getQuan().toString());
	    	
	    }
	        

	    void AddToProduct() {
	    	TotalPriceLbl.setText("Total price:"+AProduct.getPrice().toString()+"$");
	    	ProductComponent.setText(AProduct.toString());
	    }
	    

	    @FXML
	    void getItemDetails(ActionEvent event) {
	    	
	    	if (choosing_Type==null) 
	    		updatelbl.setText("Please choose Product Type");	
	    	setSelection();
	    	this.TotalPriceLbl.setText("Total price: 0 $");
   
    	try {
              String Choosing_Item = listOfProducts.getValue();
              for (Item_In_Catalog i : Catalog) {
              	if (i.getName().compareTo(Choosing_Item)==0){
              		 this.item = new ItemInOrder(i.getId(), i.getColor(), i.getName(),
        				   i.getType(), i.getPrice(), i.isAssembleItem(),0);
        		     break;
        	}
        }
	     	
	              productNameLbl.setText(this.item.getName());
	              productPriceLbl.setText("Price :"+(this.item.getPrice()).toString()+" $");
	              productColorLbl.setText("Dominant color : "+(this.item.getColor()).toString());
	              Image im= new Image("/images/"+this.item.getName()+".JPG");
	              this.productImage.setImage(im);
	              
		    	  if (AProduct.Product_components_map.containsKey(item.getId())) {
		                priceByQuan.setText("Price : "+AProduct.Product_components_map.get(item.getId()).getTotalPrice().toString()+"$");
		                QuanLbl.setText(AProduct.Product_components_map.get(item.getId()).getQuan().toString());
		    	  }
	             }catch(Exception e) {}
    	

	    }
	    
	    
	    @FXML
	    void getProductType(ActionEvent event) {
			listOfProducts.setDisable(false);
			
			ProductComponent.clear();
			this.TotalPriceLbl.setText("Total price: 0 $");
	    	setSelection();
	    	
			selectedRadioButton = (RadioButton) g1.getSelectedToggle();
			TypeOfProduct = selectedRadioButton.getText();
       
            for (Item_In_Catalog i : Catalog) {
            	if (i.getType().compareTo(TypeOfProduct)==0){
            		this.choosing_Type = new Item_In_Catalog(i.getId(), i.getName(),
      				   i.getType(), i.isAssembleItem());
      		        break;
      	        }
	         }
            this.AProduct = new assembledProduct(choosing_Type.getId(),choosing_Type.getName(),choosing_Type.getType(),choosing_Type.isAssembleItem());
	    }
	    
	    private void setSelection() {
	    	updatelbl.setText("");
		    priceByQuan.setText("Price : 0 $");
	    	QuanLbl.setText("0");
	    }
	     
    
	    @Override
	    public void display(String string) {
		 	// TODO Auto-generated method stub
			
	 	}

    	@Override
    	public void initialize(URL arg0, ResourceBundle arg1) {
			ClientUI.chat.accept(new Message(MessageType.Initialize_Catalog,"1"));
			this.item = null;
			this.AProduct = null;
			this.choosing_Type = null;
			this.TypeOfProduct = null;
			ProductComponent.clear();
			setSelection();
            productNameLbl.setText("");
            productPriceLbl.setText("");
            productColorLbl.setText("");
            this.productImage.setImage(null);
			this.NumberOfProductLbl.setText(CartScreenController.cart.getNumberOfItems().toString());
			
			CartBtn.setStyle("-fx-background-color: transparent;");
			CartBtn.setGraphic(cartImage);
						
	    	listOfProducts.setValue("choose product from list");
	    	listOfProducts.getItems().clear();
	    	ArrayList<String> Items =  new ArrayList<String>();
	    	for (Item_In_Catalog i : Catalog) {
	    		if(i.getPrice()!=0) {
	    			Items.add(i.getName());
	    		}	
	    	}
	    	listOfProducts.getItems().addAll(Items);
	    	listOfProducts.setDisable(true);
	    	updatelbl.setText("Please choose Product Type");
	    	
		}
        	
	}

