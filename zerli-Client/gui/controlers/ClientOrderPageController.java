
package controlers;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.RowConstraints;

public class ClientOrderPageController {

    @FXML 
    private ChoiceBox<?> shopDropDownMenu;

    @FXML 
    private CheckBox addGreeting; 

    @FXML // 
    private TextField GreetingText;

    @FXML 
    private DatePicker dateBox;

    @FXML 
    private TextField HourTextField; 

    @FXML 
    private ChoiceBox<?> DeliveryMethodChoice; 

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

}
