package controller.placeOrder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.CartItemDTO;
import model.dto.CustomerDTO;
import model.dto.ItemDTO;
import model.dto.Orders;
import service.PlaceOrderService;
import service.impl.PlaceOrderServiceImpl;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class PlaceOrderFormController implements Initializable {

    PlaceOrderService placeOrderService = new PlaceOrderServiceImpl();
    ObservableList<CartItemDTO> cartItems = FXCollections.observableArrayList();

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlaceOrder;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colDiscount;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colQuanitity;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private Label lblNetTotal;

    @FXML
    private TableView<CartItemDTO> tblPlaceOrderView;

    @FXML
    private TextField txtCustomerID;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtDiscount;

    @FXML
    private TextField txtItemCode;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtQuantity;

    @FXML
    private TextField txtUnitPrice;

    @FXML
    private TextField txtOrderId;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colQuanitity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colDiscount.setCellValueFactory(new PropertyValueFactory<>("discount"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));

        txtDiscount.setText("0.0");
    }

    @FXML
    void btnAddToCartOnAction(ActionEvent event) {

        cartItems.add(new CartItemDTO(
                txtItemCode.getText(),
                txtDescription.getText(),
                Integer.parseInt(txtQuantity.getText()),
                Double.parseDouble(txtUnitPrice.getText()),
                Double.parseDouble(txtDiscount.getText()),
                calculateTotal(txtUnitPrice.getText(), txtQuantity.getText())

        ));
        tblPlaceOrderView.setItems(cartItems);
        CalculateNetTotal();
        clearFields();
    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {

        placeOrderService.placeOrder(new Orders(
                txtOrderId.getText(),
                LocalDate.now(),
                txtCustomerID.getText()
        ), cartItems);
    }

    @FXML
    void txtCustomerIdOnAction(ActionEvent event) {

        CustomerDTO customer = placeOrderService.getCustomer(txtCustomerID.getText());
        txtName.setText(customer.getCustomerName());

    }

    @FXML
    void txtItemCodeOnAction(ActionEvent event) {

        ItemDTO itemDTO = placeOrderService.searchItem(txtItemCode.getText(), null);
        txtDescription.setText(itemDTO.getDescription());
        txtUnitPrice.setText(String.valueOf(itemDTO.getUnitPrice()));
//        txtQuantity.setText(String.valueOf(itemDTO.getQtyOnHand()));


    }

    //calculate total
    private double calculateTotal(String unitPrice, String quantity) {
        double total = 0.0;
        total = Double.parseDouble(unitPrice) * Double.parseDouble(quantity);
        return total;
    }

    //clear fields - items
    public void clearFields() {
        txtItemCode.clear();
        txtDescription.clear();
        txtQuantity.clear();
        txtUnitPrice.clear();
    }

    public void CalculateNetTotal() {
        double netTotal = 0.0;
        for (CartItemDTO cartItemDTO : cartItems) {
            netTotal += cartItemDTO.getTotalPrice(); // netTotal = netTotal + cartItemDTO.getTotalPrice()
            lblNetTotal.setText(String.valueOf(netTotal));
        }
    }
}
