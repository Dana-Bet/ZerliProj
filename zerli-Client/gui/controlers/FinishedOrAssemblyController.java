package controlers;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class FinishedOrAssemblyController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button finishBouquentBtn;

    @FXML
    private Button selfAssemblyBtn;

    @FXML
    private Button BackBtn;

    
    
    @FXML
    void initialize() {
        assert finishBouquentBtn != null : "fx:id=\"finishBouquentBtn\" was not injected: check your FXML file 'Untitled'.";
        assert selfAssemblyBtn != null : "fx:id=\"selfAssemblyBtn\" was not injected: check your FXML file 'Untitled'.";
        assert BackBtn != null : "fx:id=\"BackBtn\" was not injected: check your FXML file 'Untitled'.";

    }
}
