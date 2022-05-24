package controlers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ResourceBundle;
import Entities.Delivery;
import Entities.Message;
import Entities.MessageType;
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
	private String greeting = null;
    private boolean AddGreeting = false;
    private boolean setTime = false;
    
	private LocalDate suppDate ;
	private LocalTime suppHourVal;
	
	public Delivery delivery;


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
    	checkAllFileds();
    	//start(event, "PaymentScreen", "Payment screen", "");
    }
    
    @FXML
    private void getDeliveryDetails(ActionEvent event) {
    	this.DeliverM = this.DeliveryMethodChoice.getValue();
    	if (DeliverM.compareTo("delivery")==0) {
    		this.CityTextFiled.setDisable(false);
    		this.AddressTextFiled.setDisable(false);
    		this.ReciverPhoneText.setDisable(false);
    		this.ReciverNameText.setDisable(false);
    	}
    	else {
    		this.CityTextFiled.setDisable(true);
    		this.AddressTextFiled.setDisable(true);
    		this.ReciverPhoneText.setDisable(true);
    		this.ReciverNameText.setDisable(true);
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
	    this.setTime = true;
        this.UpLbl.setText("");
        this.UpLbl1.setText("");
    	if(this.dateBox == null || this.timeChoiseList.getValue() ==null ) {
    		this.UpLbl.setText("Please fill all reguired fileds");
    		return;
    	}
    	else {
    		this.suppDate = this.dateBox.getValue();
            String supphour = this.timeChoiseList.getValue();
            for(LocalTime t : this.hourList) {
            	if(supphour.compareTo(t.toString())==0) {
            		this.suppHourVal = t;
            	}
            }
    		
    	}
    	LocalDate nowd = LocalDate.now();
    	LocalTime nowh = LocalTime.now();
    	if (this.suppDate.compareTo(nowd)==-1) {
    		this.UpLbl.setText("There is a problem with the supplier date, please select other date.");
    		return;
    	}
    	if (this.suppDate.compareTo(nowd)==0 && (this.suppHourVal.compareTo(nowh)==0 ||this.suppHourVal.compareTo(nowh)==-1)) {
    		this.UpLbl.setText("There is a problem with the supplier time, please select other hour.");
    		return;
    	}
    }

	private void checkAllFileds() {
	     this.UpLbl.setText("");
	     this.UpLbl1.setText("");
	     if(this.shopDropDownMenu.getValue()==null){
	    	this.UpLbl.setText("Please choose store");
	    	return;
	     }
		 this.choosingShop = this.shopDropDownMenu.getValue();
		 if(this.addGreeting.isSelected()) {
			 this.greeting = this.GreetingText.getText();
			 if (greeting.isEmpty()) {
				 this.UpLbl1.setText("Please insert greeting");
				 return;
			 }
		 }

		 setTime();
		 if(this.DeliverM.compareTo("delivery")==0) {
			 if(this.CityTextFiled.getText().isEmpty()||this.AddressTextFiled.getText().isEmpty()||this.ReciverPhoneText.getText().isEmpty()||this.ReciverNameText.getText().isEmpty()) {
				 this.UpLbl.setText("Please fill all delivery reguired fileds");
				 return;
			 }
			 else {
				 this.delivery = new Delivery(this.CityTextFiled.getText(), this.AddressTextFiled.getText(),this.ReciverPhoneText.getText(), this.ReciverNameText.getText());
			 }
		 }
		 else if (this.DeliverM==null) {
	    		this.UpLbl.setText("Please fill all reguired fileds");
	    		return;
		 }
		 
	 }
	 
	 
     private ArrayList<LocalTime> CreateOpeningTimeList() {
    	 this.hourList = new ArrayList<LocalTime>();
    	 LocalTime current = LocalTime.of(9,0);
    	 int i =current.getHour();
    	 while( i < 21)
    	 {
    		     hourList.add(current.plusMinutes(30));	
    			 hourList.add(current.plusHours(1));	 
    			 i++;
    			 current = LocalTime.of(i, 0);
    	 }
		return hourList;
    	 
     }
     
	@Override
	public void display(String string) {
	
	}
	
	public void setOrder() {}
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
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
