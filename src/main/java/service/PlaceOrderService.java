package service;

import javafx.collections.ObservableList;
import model.dto.CartItemDTO;
import model.dto.CustomerDTO;
import model.dto.ItemDTO;
import model.dto.Orders;

public interface PlaceOrderService {
    CustomerDTO getCustomer(String customerID);

    ItemDTO searchItem(String itemCode, String description);

    void placeOrder(Orders orders, ObservableList<CartItemDTO> cartItems);
}
