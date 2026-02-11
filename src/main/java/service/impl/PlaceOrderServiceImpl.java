package service.impl;

import javafx.collections.ObservableList;
import model.dto.CartItemDTO;
import model.dto.CustomerDTO;
import model.dto.ItemDTO;
import model.dto.Orders;
import service.CustomerService;
import service.ItemService;
import service.PlaceOrderService;

public class PlaceOrderServiceImpl implements PlaceOrderService {

    ItemService itemService = new ItemServiceImpl();
    CustomerService customerService = new CustomerServiceImpl();

    @Override
    public CustomerDTO getCustomer(String customerID) {
        return customerService.getCustomer(customerID);
    }

    @Override
    public ItemDTO searchItem(String itemCode, String description) {
        return itemService.searchItem(itemCode, description);
    }

    @Override
    public void placeOrder(Orders orders, ObservableList<CartItemDTO> cartItems) {

    }
}
