package controlers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class UpdateCatalogController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label updateCatalog;

    @FXML
    private Button updatePriceBtn;

    @FXML
    private Button updateQuantityBtn;

    @FXML
    private Button backBtn;

    @FXML
    void initialize() {
        assert updateCatalog != null : "fx:id=\"updateCatalog\" was not injected: check your FXML file 'UpadteCatalog.fxml'.";
        assert updatePriceBtn != null : "fx:id=\"updatePriceBtn\" was not injected: check your FXML file 'UpadteCatalog.fxml'.";
        assert updateQuantityBtn != null : "fx:id=\"updateQuantityBtn\" was not injected: check your FXML file 'UpadteCatalog.fxml'.";
        assert backBtn != null : "fx:id=\"backBtn\" was not injected: check your FXML file 'UpadteCatalog.fxml'.";

    }
}
