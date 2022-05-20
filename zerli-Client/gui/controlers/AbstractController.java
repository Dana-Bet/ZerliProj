package controlers;

import java.io.IOException;

//import Entities.SingletonOrder;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public abstract class AbstractController {

	public void start(ActionEvent event, String fxmlName, String title, String toDisplay) throws IOException {
		((Node) event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		FXMLLoader load = new FXMLLoader(getClass().getResource("/fxml/" + fxmlName + ".fxml"));
		Parent root = load.load();
		AbstractController aFrame = load.getController();
		aFrame.display(toDisplay);
		Scene scene = new Scene(root);
		primaryStage.setTitle("Zer-li" + " " + title);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public abstract void display(String string);

	/**
	 * This method is for logout from the system.
	 */
	
	public void start(MouseEvent event, String fxmlName, String title, String toDisplay) throws IOException {
		((Node) event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		FXMLLoader load = new FXMLLoader(getClass().getResource("/fxml/" + fxmlName + ".fxml"));
		Parent root = load.load();
		AbstractController aFrame = load.getController();
		aFrame.display(toDisplay);
		Scene scene = new Scene(root);
		primaryStage.setTitle("Zer-li" + " " + title);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();

	}
	
	public void startPopUp(ActionEvent event, String fxmlName, String title, String toDisplay) throws IOException {
		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		FXMLLoader load = new FXMLLoader(getClass().getResource("/fxml/" + fxmlName + ".fxml"));
		Parent root = load.load();
		AbstractController aFrame = load.getController();
		aFrame.display(toDisplay);
		Scene scene = new Scene(root);
		primaryStage.setTitle("Zer-li" + " " + title);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();

	}

}