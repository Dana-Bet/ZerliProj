package controlers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Entities.Order;
//import client.ClientController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import main.ChatClient;

public class ShowFormController implements Initializable {

	public ResourceBundle getResources() {
		return resources;
	}

	public URL getLocation() {
		return location;
	}

	@FXML
	private TableView<Order> table;

	ObservableList<Order> observableList;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TableColumn<Order, Integer> orderNumber;

	@FXML
	private TableColumn<Order, Integer> price;

	@FXML
	private TableColumn<Order, String> greetingCard;

	@FXML
	private TableColumn<Order, String> color;

    @FXML
    private TableColumn<Order,String> dOrder;

    @FXML
    private TableColumn<Order,String> shop;
    
    @FXML
    private TableColumn<Order,String> date;
    
    @FXML
    private TableColumn<Order,String> orderDate;

	@FXML
	private Button backBtn;

	@FXML
	private Button showOrderBtn;

	@FXML
	void backToMain(ActionEvent event) throws IOException {
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding primary window
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/ShowUpdate.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("ZerLi");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<Order> observableList = FXCollections.observableArrayList(ChatClient.orders);
		table.getItems().clear();
		orderNumber.setCellValueFactory(new PropertyValueFactory<>("OrderNumber"));
		price.setCellValueFactory(new PropertyValueFactory<>("price"));
		greetingCard.setCellValueFactory(new PropertyValueFactory<>("greetingCard"));
		color.setCellValueFactory(new PropertyValueFactory<>("color"));
		dOrder.setCellValueFactory(new PropertyValueFactory<>("dOrder"));
		shop.setCellValueFactory(new PropertyValueFactory<>("shop"));
		date.setCellValueFactory(new PropertyValueFactory<>("date"));
		orderDate.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
		table.setItems(observableList);
	}
}