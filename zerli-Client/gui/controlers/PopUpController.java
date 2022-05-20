package controlers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PopUpController extends AbstractController implements IPopUpController {
 
	IPopUpController IpopUp;
	PopUpController(String Lbl1 ,String Lbl2, String BtnLeft , String BtnRight) {
		this.BtnLeft.setText(BtnLeft);
		this.BtnRight.setText(BtnRight);
		this.Lbl1.setText(Lbl1);
		this.Lbl2.setText(Lbl2);
	}
	
    @FXML
    private Label Lbl1;

    @FXML
    private Label Lbl2;

    @FXML
    private Button BtnRight;

    @FXML
    private Button BtnLeft;

    
    @FXML
    void BtnRight(ActionEvent event) {
    	IpopUp.ClickedRightOption();
    }
    
    @FXML
    void BtnLeft(ActionEvent event) {
    	IpopUp.ClickdLeftOption();
    }

	@Override
	public void display(String string) {
		
		
	}

	@Override
	public void ClickdLeftOption() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ClickedRightOption() {
		// TODO Auto-generated method stub
		
	}

}