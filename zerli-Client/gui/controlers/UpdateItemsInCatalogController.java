package controlers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Entities.Message;
import Entities.MessageType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import main.ClientUI;

public class UpdateItemsInCatalogController extends AbstractController implements  Initializable{
	
	 	@FXML
	    private ResourceBundle resources;

	 	@FXML
	 	private URL location;
	    @FXML
	    private ComboBox<String> gtetype;
	@FXML
    private Text chooseTypelbl;

    @FXML
    private Text pricelbl;

    @FXML
    private Text ChooseNamelbl;

    @FXML
    private ComboBox<String> chooseName;

    @FXML
    private TextArea setPrice;

    @FXML
    private Button backBtn;
    
    @FXML
    private Button updateBtn;
    @FXML
    private Button chooseBtn;
    
    public static ArrayList<String> productType1 = new ArrayList<String>();
    public static ArrayList<String> NamesproductList = new ArrayList<String>();
    @FXML
    void back(ActionEvent event) throws IOException {
    	start(event,"MainMarketingWorkerScreen","", "");
    }

    @FXML
    void chooseName(ActionEvent event) {
    	String type  = gtetype.getValue();
    	ClientUI.chat.accept(new Message(MessageType.getTypeNames,type));
    	ObservableList<String> observableList2 = FXCollections.observableArrayList(NamesproductList);
    	chooseName.setItems(observableList2);
    }
    
    @FXML
    void update(ActionEvent event) {
    	String price = setPrice.getText();
    	ArrayList<String> details = new ArrayList<String>();
    	details.add(price);
    	details.add(gtetype.getValue());
    	details.add(chooseName.getValue());
    	ClientUI.chat.accept(new Message(MessageType.UpdatePriceToItem,details));
    }



	@Override
	public void display(String string) {
		chooseTypelbl.setText("Choos Type:");
		ChooseNamelbl.setText("Choose name of product:");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		ClientUI.chat.accept(new Message(MessageType.getTypeProductForUpdateCatalog1,null));
//		ObservableList<String> observableList1 = FXCollections.observableArrayList(productType1);
//		gtetype.setItems(observableList1);
		
	}

}
