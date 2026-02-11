package repository;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ItemRepository {

    ResultSet getAll() throws SQLException;

    void addItem(String itemCode, String description, String PackSize, double unitPrice, int qtyOnHand);

    void deleteItem(String itemCode);

    void updateItem(String itemCode, String description, String PackSize, double unitPrice, int qtyOnHand);

    ResultSet searchItem(String itemCode, String description) throws SQLException;
}
