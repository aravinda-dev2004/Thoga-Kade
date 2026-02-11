package service.impl;

import javafx.collections.ObservableList;
import model.dto.ItemDTO;
import repository.ItemRepository;
import repository.impl.ItemRepositoryImpl;
import service.ItemService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemServiceImpl implements ItemService {

    ItemRepository itemRepository = new ItemRepositoryImpl();

    @Override
    public void addItemDetails(String itemCode, String description, String PackSize, double unitPrice, int qtyOnHand) {
        itemRepository.addItem(itemCode,description,PackSize,unitPrice,qtyOnHand);

    }

    @Override
    public void deleteItemDetails(String itemCode) {

        itemRepository.deleteItem(itemCode);

    }

    @Override
    public void updateItemDetails(String itemCode, String description, String PackSize, double unitPrice, int qtyOnHand) {

        itemRepository.updateItem(itemCode,description,PackSize,unitPrice,qtyOnHand);

    }

    @Override
    public ObservableList<ItemDTO> getAllItemDetails() {
        ObservableList<ItemDTO> itemDetails = javafx.collections.FXCollections.observableArrayList();
        try {
            ResultSet resultSet = itemRepository.getAll();
            while (resultSet.next()){
                itemDetails.add(new ItemDTO(
                        resultSet.getString("ItemCode"),
                        resultSet.getString("Description"),
                        resultSet.getString("PackSize"),
                        resultSet.getDouble("UnitPrice"),
                        resultSet.getInt("QtyOnHand")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return itemDetails;
    }
    @Override
    public ItemDTO searchItem(String itemCode, String description){
        try {
            ResultSet resultSet = itemRepository.searchItem(itemCode,description);
            resultSet.next();
            return new ItemDTO(
                    resultSet.getString("ItemCode"),
                    resultSet.getString("Description"),
                    resultSet.getString("PackSize"),
                    resultSet.getDouble("UnitPrice"),
                    resultSet.getInt("QtyOnHand")
                );

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
