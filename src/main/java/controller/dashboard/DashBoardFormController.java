package controller.dashboard;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBoardFormController {

    Stage stage = new Stage();

    @FXML
    private Button btnCustoemerManagement;

    @FXML
    private Button btnItemManagement;

    @FXML
    private Button btnOrderDetailsManagement;

    @FXML
    private Button btnOrderManagement;

    @FXML
    void btnCustoemerManagementOnAction(ActionEvent event) {

    }

    @FXML
    void btnItemManagementOnAction(ActionEvent event) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/item.fxml"))));
            stage.show();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/placeOrder.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

    }

    @FXML
    void btnOrderManagementOnAction(ActionEvent event) {

    }

}
