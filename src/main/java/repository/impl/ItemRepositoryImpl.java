package repository.impl;

import db.DBConnection;
import repository.ItemRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemRepositoryImpl implements ItemRepository {

    @Override
    public ResultSet getAll() throws SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        String SQL = "SELECT * FROM item";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet;
    }
    @Override
    public void addItem(String itemCode, String description, String PackSize, double unitPrice, int qtyOnHand) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String SQL = "INSERT INTO item VALUES(?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setObject(1, itemCode);
            preparedStatement.setObject(2, description);
            preparedStatement.setObject(3, PackSize);
            preparedStatement.setObject(4, unitPrice);
            preparedStatement.setObject(5, qtyOnHand);

            preparedStatement.executeUpdate();

        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteItem(String itemCode) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement("DELETE FROM item WHERE ItemCode = ?");

            pstm.setObject(1,itemCode);
            pstm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateItem(String itemCode, String description, String PackSize, double unitPrice, int qtyOnHand) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String SQL = "UPDATE item SET Description = ?, PackSize = ?, UnitPrice = ?, QtyOnHand = ? WHERE ItemCode = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setObject(1, description);
            preparedStatement.setObject(2, PackSize);
            preparedStatement.setObject(3, unitPrice);
            preparedStatement.setObject(4, qtyOnHand);
            preparedStatement.setObject(5, itemCode);

            preparedStatement.executeUpdate();

        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResultSet searchItem(String itemCode, String description) throws SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        String SQL = "SELECT * FROM item WHERE ItemCode = ? OR Description = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setObject(1, itemCode);
        preparedStatement.setObject(2, description);
        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet;
    }
}
