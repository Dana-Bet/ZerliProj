package controlers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PaymentScreenController {

    @FXML
    private CheckBox DefaultCardBtn;

    @FXML
    private CheckBox NewCardBtn;

    @FXML
    private TextField CardNumberTxt;

    @FXML
    private TextField CardHolderTxt;

    @FXML
    private TextField IdTxt;

    @FXML
    private TextField ExDateTxt;

    @FXML
    private TextField CvvTxt;

    @FXML
    private Label TotalPriceLbl;

    @FXML
    private Button backBtn;

    @FXML
    private Button confirmPaymentBtn;

    @FXML
    void BackOrderPage(ActionEvent event) {

    }

    @FXML
    void DisableOtherPayButtons(ActionEvent event) {

    }

    @FXML
    void confirmPayment(ActionEvent event) {

    }

}