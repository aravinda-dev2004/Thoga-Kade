package repository.impl;

import db.DBConnection;
import repository.CustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public ResultSet searchCustomer(String customerID) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String SQL = "SELECT * FROM customer WHERE CustID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setObject(1, customerID);
        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet;

    }
}
