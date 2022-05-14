package main;
import javafx.application.Application;
import javafx.stage.Stage;
import controlers.ClientZerUIController;

public class ClientUI extends Application {
	
	public static ClientController chat; //only one instance
	public static Stage primary;
	public static void main( String args[] ) throws Exception
	   { 
		    launch(args);  
	   } // end main
	 
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		 primary = primaryStage;
		 ClientZerUIController aFrame = new ClientZerUIController(); 	 
		 aFrame.start(primary);
 }
}

