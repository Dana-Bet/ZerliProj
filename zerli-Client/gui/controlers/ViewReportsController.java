package controlers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

public class ViewReportsController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private ComboBox<?> chooseStoreComboBox;
    @FXML
    private ComboBox<?> typeReportComboBox;
    @FXML
    private ComboBox<?> yearComboBox;
    @FXML
    private ComboBox<?> mouthComboBox;
    @FXML
    private TableColumn<?, ?> tableColumnStore;
    @FXML
    private TableColumn<?, ?> tableColumnOrders;
    @FXML
    private TableColumn<?, ?> tableColumnComplaint;
    @FXML
    private Button showReportBtn;
    @FXML
    private Label lblview;
    @FXML
    private Button backBtn;
    @FXML
    private Button logoutBtn;

    @FXML
    void ChooseStoreComboBox(ActionEvent event) {

    }
    @FXML
    void TypeReportComboBox(ActionEvent event) {

    }
    @FXML
    void YearComboBox(ActionEvent event) {

    }
    @FXML
    void MouthComboBox(ActionEvent event) {

    }
    @FXML
    void ColOrders(ActionEvent event) {

    }
    @FXML
    void ColStore(ActionEvent event) {

    }
    @FXML
    void ColComplaint(ActionEvent event) {

    }
    @FXML
    void ShowReports(ActionEvent event) {

    }
    @FXML
    void Back(ActionEvent event) {

    }
    @FXML
    void LogOut(ActionEvent event) {

    }
    @FXML
    void initialize() {
        assert chooseStoreComboBox != null : "fx:id=\"chooseStoreComboBox\" was not injected: check your FXML file 'ViewReport.fxml'.";
        assert typeReportComboBox != null : "fx:id=\"typeReportComboBox\" was not injected: check your FXML file 'ViewReport.fxml'.";
        assert yearComboBox != null : "fx:id=\"yearComboBox\" was not injected: check your FXML file 'ViewReport.fxml'.";
        assert mouthComboBox != null : "fx:id=\"mouthComboBox\" was not injected: check your FXML file 'ViewReport.fxml'.";
        assert tableColumnStore != null : "fx:id=\"tableColumnStore\" was not injected: check your FXML file 'ViewReport.fxml'.";
        assert tableColumnOrders != null : "fx:id=\"tableColumnOrders\" was not injected: check your FXML file 'ViewReport.fxml'.";
        assert tableColumnComplaint != null : "fx:id=\"tableColumnComplaint\" was not injected: check your FXML file 'ViewReport.fxml'.";
        assert showReportBtn != null : "fx:id=\"showReportBtn\" was not injected: check your FXML file 'ViewReport.fxml'.";
        assert lblview != null : "fx:id=\"lblview\" was not injected: check your FXML file 'ViewReport.fxml'.";
        assert backBtn != null : "fx:id=\"backBtn\" was not injected: check your FXML file 'ViewReport.fxml'.";
        assert logoutBtn != null : "fx:id=\"logoutBtn\" was not injected: check your FXML file 'ViewReport.fxml'.";

    }
}
