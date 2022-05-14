// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

package main;

import java.io.IOException;
import java.util.ArrayList;
import Entities.Message;
import Entities.Order;
import Parsing.ParsingClient;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import ocsf.client.AbstractClient;


public class ChatClient extends AbstractClient
{

	public static ChatClient chatClient;
	public static ArrayList<Order> orders = new ArrayList<Order>();
	public static boolean waitingForResponse = false;
	
	public ChatClient(String host, int port) throws IOException {
		super(host, port);
		chatClient = this;
		openConnection();
	}

  public void handleMessageFromServer(Object msg) {
	System.out.println("--> get message from server");
	if (msg instanceof Message) {
		waitingForResponse = false;
		try {
			ParsingClient.Message(msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	public void handleMessageFromClientUI(Object message) {
		try {
			waitingForResponse = true;
			sendToServer(message);
			while (waitingForResponse) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setHeaderText("Error Connection");
			errorAlert.setContentText("cant connect to server");
			errorAlert.showAndWait();
		}
	}
  
  /**
   * This method terminates the client.
   */
  public void quit()
  {
    try
    {
      closeConnection();
    }
    catch(IOException e) {}
    System.exit(0);
  }
}
//End of ChatClient class

