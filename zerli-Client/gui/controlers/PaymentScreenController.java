package controlers;

import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import Entities.CreditCard;
import Entities.Message;
import Entities.MessageType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import main.ClientUI;

public class PaymentScreenController extends AbstractController implements Initializable {

	
	public static ArrayList<CreditCard> cardList = new ArrayList <CreditCard>();
	public static Object CreditAmmount;
	public static Float TotalPrice;
	private String choosingCard=null;
	String ChoosingMethod = null;
	public static Object newClient;
	private RadioButton selectedRadioButton;
	private LocalDate exDate;
	private Integer creditUsed = 0;


	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField CardNumberTxt;

    @FXML
    private TextField CardHolderTxt;

    @FXML
    private DatePicker exDatePicker;

    @FXML
    private TextField CvvTxt;

    @FXML
    private Label TotalPriceLbl;

    @FXML
    private Button backBtn;

    @FXML
    private Button confirmPaymentBtn;

    @FXML
    private ChoiceBox<String> cardsList;

    @FXML
    private ChoiceBox<Integer> creditList;
    
    @FXML
    private ToggleGroup g2;
    
    @FXML
    private RadioButton DefaultCardBtn;

    @FXML
    private RadioButton NewCardBtn;
    
    @FXML
    private Label upLbl;



    @FXML
    void confirmPayment(ActionEvent event) throws IOException {
    	this.upLbl.setText("");
    	if (ChoosingMethod==null) {
    		this.upLbl.setText("Please Choose payment method");
    		return;
    	}

		if(this.CvvTxt.getText().isEmpty()||this.CardHolderTxt.getText().isEmpty()||this.CardNumberTxt.getText().isEmpty()) {
	    		this.upLbl.setText("Please fill in all the required fields");
	    		return;
			}
		
		if(this.CardNumberTxt.getText().length()<10) {
			this.upLbl.setText("Please Insert Valid credit card number");
			return;
		}
		
	    Save_Payment_in_DB(); //if its new payment method
	    
		if(this.creditUsed>0) {//if the client used credit we need to update in DB
			creditUsed = (Integer)PaymentScreenController.CreditAmmount-creditUsed;
			StringBuilder str = new StringBuilder();
			str.append(LoginScreenController.user.getId());
			str.append("@");
			str.append(this.creditUsed);
			ClientUI.chat.accept(new Message(MessageType.CreditUsed,str.toString()));	
			}		
		PaymentScreenController.TotalPrice-=this.creditUsed;
		UpdateOrderInDB();
		CartScreenController.cart.Order_Components.clear();
		start(event, "ClientMainPage", "Main page", "");

    }
    
    @FXML
    void getPaymentMethod(ActionEvent event) {
		this.CardNumberTxt.setText(" ");
		selectedRadioButton = (RadioButton) g2.getSelectedToggle();
		this.ChoosingMethod = selectedRadioButton.getText();
    }
		

    @FXML
    void BackOrderPage(ActionEvent event) throws IOException {
    	 start(event, "ClientOrderPage", "order page", "");
    }		  

    private void Save_Payment_in_DB() {
		selectedRadioButton = (RadioButton) g2.getSelectedToggle();
		this.ChoosingMethod = selectedRadioButton.getText();
		if(ChoosingMethod.equals("Add new payment method")){
			StringBuilder str = new StringBuilder();
			str.append(LoginScreenController.user.getId());
			str.append("@");
			str.append(CardNumberTxt.getText());
			ClientUI.chat.accept(new Message(MessageType.Add_New_Payment_Method,str.toString()));
		}
		else{
		
		}
	}
 

    @FXML
    void getCardFromL(ActionEvent event) {
        this.choosingCard = this.cardsList.getValue();
        for(CreditCard c : cardList) {
        	if(c.toString().compareTo(choosingCard)==0) {
        		this.CardNumberTxt.setText(c.getCreditCard());
        	}
        }
    }
    
    @FXML
    void exDateP(ActionEvent event) {
    	LocalDate now = LocalDate.now();
    	this.exDate = this.exDatePicker.getValue();
    	if (this.exDate.compareTo(now)==-1) {
    		this.upLbl.setText("The expiration date is unvalid.");
    		return;
    	}
    	
    }
    @FXML
    void useCredit(ActionEvent event) {
    	if(creditList.getValue()!=0) {
    		this.creditUsed =creditList.getValue();
    	}
    	Float forDisplayTotalPrice = TotalPrice-creditList.getValue();
    	TotalPriceLbl.setText(forDisplayTotalPrice.toString() + "$");

    }
    
	public static void UpdateOrderInDB() {

    	StringBuilder str = new StringBuilder();
		str.append(ClientOrderPageController.order.getStore());
		str.append("@");
		str.append(LoginScreenController.user.getId());
		str.append("@");
		str.append(TotalPrice.toString());
		str.append("@");
		str.append(ClientOrderPageController.order.getGreetingCard());
		str.append("@");
		str.append(ClientOrderPageController.order.getStatus());
		str.append("@");
		str.append(ClientOrderPageController.order.getSupplimentMethod());
		str.append("@");
		str.append(ClientOrderPageController.order.getSuppTime());
		str.append("@");
		str.append(ClientOrderPageController.order.getSuppDate());

        ClientUI.chat.accept(new Message(MessageType.Add_Order,str.toString()));
	
}

	@Override
	public void display(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		String id = LoginScreenController.user.getId();
		PaymentScreenController.TotalPrice = ClientOrderPageController.TotalPrice;
		ClientUI.chat.accept(new Message(MessageType.IsNewClient,id));
		if((int)newClient==1)
		{
          PaymentScreenController.TotalPrice = (float) (TotalPrice*0.8);
  	      ClientUI.chat.accept(new Message(MessageType.UpdateNewClientDiscount,id));
		}	
		ClientUI.chat.accept(new Message(MessageType.CreditValue,id));


		ClientUI.chat.accept(new Message(MessageType.CreditCardList,id));
		ArrayList<String> cardsForView = new ArrayList<String>();
		for(CreditCard c : cardList ) {
			 cardsForView.add(c.toString());
	}
		cardsList.getItems().addAll(cardsForView);
		
		ClientUI.chat.accept(new Message(MessageType.CreditValue,id));
		ArrayList<Integer> numList = new ArrayList<Integer>();
		int i = 0 ;
		if((Integer)CreditAmmount > TotalPrice ) {
			PaymentScreenController.CreditAmmount =TotalPrice.intValue();
		}
	
		while(i<=(Integer)PaymentScreenController.CreditAmmount) {
			numList.add(i);
			i++;
	}
		this.creditList.getItems().addAll(numList);
		this.creditList.setValue(creditUsed);
	}

}
