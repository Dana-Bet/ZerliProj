package controlers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.RowConstraints;

public class ClientOrderPageController  extends AbstractController {

    @FXML
    private ChoiceBox<?> shopDropDownMenu;

    @FXML
    private CheckBox addGreeting;

    @FXML
    private TextField GreetingText;

    @FXML
    private DatePicker dateBox;

    @FXML
    private TextField HourTextField;

    @FXML
    private ChoiceBox<?> DeliveryMethodChoice;

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
    private TextField postCodeTextFiled;

    @FXML
    private TextField ReciverPhoneText;

    @FXML
    private TextField ReciverNameText;

    @FXML
    void Back(ActionEvent event) throws IOException {
    	start(event, "ClientCreateOrderScreen", "Create Order", "");
    }

    @FXML
    void ToPayScreen(ActionEvent event) throws IOException {
    	start(event, "PaymentScreen", "Payment screen", "");
    }

	@Override
	public void display(String string) {
		// TODO Auto-generated method stub
		
	}

}
