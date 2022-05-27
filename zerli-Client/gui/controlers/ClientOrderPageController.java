package controlers;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ResourceBundle;
import Entities.Delivery;
import Entities.Message;
import Entities.MessageType;
import Entities.Order;
import Entities.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import main.ClientUI;

public class ClientOrderPageController  extends AbstractController implements Initializable {
	public  static ArrayList <Store> storesList ;
	private ArrayList <String> storesNames ; 
	private ArrayList<LocalTime> hourList;
	private String[] Delivey = {"delivery" , "pick up"};
	
	private String choosingShop = null;
	private String DeliverM = null;
	private boolean IsDelivery ; 
	private String greeting = null;
    private boolean AddGreeting = false;
    public static Order order;
	public static Float TotalPrice;
	
	public static LocalTime orderTime = null;
	public LocalTime suppTime = null;
	public static Date orderDate = null;
	public Date suppDate = null;;

	final int delivery_price = 10;
	private Delivery delivery =null;

    @FXML
    private ChoiceBox<String> shopDropDownMenu;

    @FXML
    private CheckBox addGreeting;

    @FXML
    private TextField GreetingText;

    @FXML
    private DatePicker dateBox;


    @FXML
    private ChoiceBox<String> DeliveryMethodChoice;
    
    @FXML
    private ChoiceBox<String> timeChoiseList;

    @FXML
    private Button backBtn;

    @FXML
    private Button PaymentBtn;

    @FXML
    private RowConstraints City;

    @FXML
    private TextField CityTextFiled;

    @FXML
    private TextField AddressTextFiled;

    @FXML
    private TextField ReciverPhoneText;

    @FXML
    private TextField ReciverNameText;
    
    @FXML
    private Label UpLbl;
    
    @FXML
    private Label deliveryPrice;
    
    @FXML
    private GridPane gridPane;
    
    @FXML
    private Label UpLbl1;

    @FXML
    void Back(ActionEvent event) throws IOException {
    	start(event, "ClientCartScreen", "Cart screen", "");
    }

    @FXML
    void ToPayScreen(ActionEvent event) throws IOException {
    	setTime();
    	if(checkAllFileds()!=1) {return;}
    	if(this.IsDelivery) {
    		TotalPrice +=this.delivery_price;
    	}
    	createOrder();
    	start(event, "PaymentScreen", "Payment screen", "");
    }
    
	private void createOrder() {
		if (AddGreeting) {
			order = new Order(greeting,"Not confirm",choosingShop,LoginScreenController.user.getId(),this.suppTime.toString(),this.suppDate.toString(),this.DeliverM);	
	}
		else {
			order = new Order("without","Not confirm",choosingShop,LoginScreenController.user.getId(),this.suppTime.toString(),this.suppDate.toString(),this.DeliverM);	
			}
		if(this.DeliverM.compareTo("delivery")==0) {
			 order.delivery = this.delivery;
		}
   }

	@FXML
    private void getDeliveryDetails(ActionEvent event) {
    	this.DeliverM = this.DeliveryMethodChoice.getValue();
    	if (DeliverM.compareTo("delivery")==0) {
    		this.CityTextFiled.setDisable(false);
    		this.AddressTextFiled.setDisable(false);
    		this.ReciverPhoneText.setDisable(false);
    		this.ReciverNameText.setDisable(false);
   	        this.deliveryPrice.setText("Extra "+this.delivery_price+"$ shipping");
   	        this.IsDelivery=true;
    	}
    	else {
    		this.CityTextFiled.setDisable(true);
    		this.AddressTextFiled.setDisable(true);
    		this.ReciverPhoneText.setDisable(true);
    		this.ReciverNameText.setDisable(true);
   	        this.deliveryPrice.setText("");
   	        this.IsDelivery=false;
    	}
    }
    
    @FXML
	private void getStoreName(ActionEvent event) {
	    this.UpLbl.setText("");
	    this.UpLbl1.setText("");
		this.choosingShop = this.shopDropDownMenu.getValue();
	}
    
    @FXML
    private void addGreetingChoice(ActionEvent event) {
    	if(this.addGreeting.isSelected()) {
    		this.GreetingText.setDisable(false);
    		AddGreeting = true;
    	}
    	else {
    		this.GreetingText.setDisable(true);
    		AddGreeting = false;
    	}	
    }

    @FXML
	private void setTime() {
		LocalDate suppDate ;
		LocalTime suppHourVal =LocalTime.now();
		
        this.UpLbl.setText("");
        this.UpLbl1.setText("");
        
    	if(this.dateBox == null || this.timeChoiseList.getValue() ==null ) {
    		this.UpLbl.setText("Please fill all reguired fileds");
    		return;
    	}
    	else {
    		suppDate = this.dateBox.getValue();
            String supphour = this.timeChoiseList.getValue();
            for(LocalTime t : this.hourList) {
            	if(supphour.compareTo(t.toString())==0) {
            		suppHourVal = t;
            		
            	}
            }
    		
    	}
    	LocalDate nowd = LocalDate.now();
    	LocalTime nowh = LocalTime.now();
    	if (suppDate.compareTo(nowd)==-1) {
    		this.UpLbl.setText("There is a problem with the supplier date, please select other date.");
    		return;
    	}
    	if (suppDate.compareTo(nowd)==0 && (suppHourVal.compareTo(nowh)==0 ||suppHourVal.compareTo(nowh)==-1)) {
    		this.UpLbl.setText("There is a problem with the supplier time, please select other hour.");
    		return;
    	}
    	
    	this.suppDate=Date.valueOf(suppDate);
    	this.suppTime=suppHourVal;
    }

	private int checkAllFileds() {
	     this.UpLbl.setText("");
	     this.UpLbl1.setText("");
	     this.deliveryPrice.setText("");
	     if(shopDropDownMenu.getValue()==null){
	    	this.UpLbl.setText("Please choose store");
	    	return 0;
	     }
		 this.choosingShop = this.shopDropDownMenu.getValue();
		 if(addGreeting.isSelected()) {
			 this.greeting = this.GreetingText.getText();
			 if (greeting.isEmpty()) {
				 this.UpLbl1.setText("Please insert greeting");
				 return 0;
			 }
		 }
	     if(this.dateBox == null || this.timeChoiseList.getValue() ==null ) {
	    		this.UpLbl.setText("Please fill time for suppliement");
	    		return 0;
	     }
		 if(this.DeliverM!=null) {
		 if(this.DeliverM.compareTo("delivery")==0) {
			 if(this.CityTextFiled.getText().isEmpty()||this.AddressTextFiled.getText().isEmpty()||this.ReciverPhoneText.getText().isEmpty()||this.ReciverNameText.getText().isEmpty()) {
				 this.UpLbl.setText("Please fill all delivery reguired fileds");
				 return 0;
			 }
			 else {
				this.delivery = new Delivery(this.CityTextFiled.getText(), this.AddressTextFiled.getText(),this.ReciverPhoneText.getText(), this.ReciverNameText.getText());
			 }
		 }
		     else if (this.DeliverM==null) {
	    		this.UpLbl.setText("Please fill all reguired fileds");
	    		return 0;
		   }
		 
		 }
		 else {
			 this.UpLbl.setText("Please fill all delivery reguired fileds");
			 return 0;
		 }
		 return 1;
		 
	 }
	 
	 
     private ArrayList<LocalTime> CreateOpeningTimeList() {
    	 this.hourList = new ArrayList<LocalTime>();
    	 LocalTime current = LocalTime.of(9,0,0);
    	 int i =current.getHour();
    	 while( i < 21)
    	 {
    		     hourList.add(current.plusMinutes(30));	
    			 hourList.add(current.plusHours(1));	 
    			 i++;
    			 current = LocalTime.of(i,0,0);
    	 }
		return hourList;
    	 
     }
     
	@Override
	public void display(String string) {
	
	}
	


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		TotalPrice = CartScreenController.cart.OrderTotalPrice();
		ClientOrderPageController.storesList = new ArrayList <Store>();
		this.storesNames = new ArrayList <String>();
		ClientUI.chat.accept(new Message(MessageType.InitialShopsList,""));
		
		for (Store s : storesList) {
			this.storesNames.add(s.toString());
			
		}
		this.shopDropDownMenu.getItems().addAll(storesNames);
		this.DeliveryMethodChoice.getItems().addAll(this.Delivey);
		this.GreetingText.setDisable(true);
		CreateOpeningTimeList();
		
		ArrayList<String> hours = new ArrayList<String> ();
		for (LocalTime h : this.hourList) {
			 hours.add(h.toString());
		}
		
		this.timeChoiseList.getItems().addAll(hours);
        this.UpLbl.setText("");
        this.UpLbl1.setText("");
	}





}
