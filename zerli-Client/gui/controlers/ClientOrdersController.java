package controlers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ClientOrdersController {

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> orderNumberCol;

    @FXML
    private TableColumn<?, ?> priceCol;

    @FXML
    private TableColumn<?, ?> greetingCardCol;

    @FXML
    private TableColumn<?, ?> colorCol;

    @FXML
    private TableColumn<?, ?> DeliveryMethodCol;

    @FXML
    private TableColumn<?, ?> ShopCol;

    @FXML
    private TableColumn<?, ?> DateCol;

    @FXML
    private TableColumn<?, ?> OrderTimeCol;

    @FXML
    private Button backBtn;

    @FXML
    void backMainPage(ActionEvent event) {

    }

}
