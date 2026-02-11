package service;

import javafx.collections.ObservableList;
import model.dto.ItemDTO;

public interface ItemService {

    void addItemDetails(String itemCode, String description, String PackSize, double unitPrice, int qtyOnHand);

    void deleteItemDetails(String itemCode);

    void updateItemDetails(String itemCode, String description, String PackSize, double unitPrice, int qtyOnHand);

    ObservableList<ItemDTO> getAllItemDetails();

    ItemDTO searchItem(String itemCode, String description);
}
