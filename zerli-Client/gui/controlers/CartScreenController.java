package controlers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;


public class CartScreenController extends AbstractController implements Initializable {
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea AreaForOrders;

    @FXML
    private Label TotalPriceLabel;
    
    @FXML
    private Button backBtn;
    
    @FXML
    private Button confirmBtn;

    
    
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display(String string) {
		// TODO Auto-generated method stub
		
	}
    

}