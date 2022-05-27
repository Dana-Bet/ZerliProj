package controlers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ClientOrdersController extends AbstractController implements Initializable {

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> orderNumberCol;

    @FXML
    private TableColumn<?, ?> storeCol;

    @FXML
    private TableColumn<?, ?> greetingCardCol;

    @FXML
    private TableColumn<?, ?> priceCol;

    @FXML
    private TableColumn<?, ?> DeliveryMethodCol;

    @FXML
    private TableColumn<?, ?> suppTimeCol;

    @FXML
    private TableColumn<?, ?> suppDateCol;

    @FXML
    private TableColumn<?, ?> OrderTimeCol;

    @FXML
    private Button backBtn;

    @FXML
    void backMainPage(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display(String string) {
		// TODO Auto-generated method stub
		
	}

}

