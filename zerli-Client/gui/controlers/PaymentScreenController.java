package controlers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import Entities.Message;
import Entities.MessageType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import main.ClientUI;

public class PaymentScreenController extends AbstractController implements Initializable {

	
	public ArrayList<String> cardList;
	
    @FXML
    private TextField CardNumberTxt;

    @FXML
    private TextField CardHolderTxt;

    @FXML
    private TextField IdTxt;

    @FXML
    private DatePicker exDatePicker;

    @FXML
    private TextField CvvTxt;

    @FXML
    private Label totalPrice;

    @FXML
    private Label TotalPriceLbl;

    @FXML
    private Button backBtn;

    @FXML
    private Button confirmPaymentBtn;

    @FXML
    private ChoiceBox<?> cardsList;

    @FXML
    private ChoiceBox<?> creditList;

    @FXML
    private CheckBox DefaultCardBtn;

    @FXML
    private CheckBox NewCardBtn;
    
    @FXML
    private VBox g1;


    @FXML
    void AddNewPay(ActionEvent event) {

    }

    @FXML
    void BackOrderPage(ActionEvent event) {

    }

    @FXML
    void confirmPayment(ActionEvent event) {
        
    }

    @FXML
    void defultPay(ActionEvent event) {

    }

    @FXML
    void exDateP(ActionEvent event) {

    }
    @FXML
    void useCredit(ActionEvent event) {

    }

	@Override
	public void display(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		String id = LoginScreenController.user.getId();
		this.cardList = new ArrayList <String>();
		ClientUI.chat.accept(new Message(MessageType.CreditCardList,id));
		//add credit cards to list 
		//add credit to imp
		
		
	}

}
