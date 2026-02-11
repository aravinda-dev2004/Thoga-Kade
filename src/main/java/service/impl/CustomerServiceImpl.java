package service.impl;

import model.dto.CustomerDTO;
import repository.CustomerRepository;
import repository.ItemRepository;
import repository.impl.CustomerRepositoryImpl;
import repository.impl.ItemRepositoryImpl;
import service.CustomerService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public CustomerDTO getCustomer(String customerID) {
        try {
            ResultSet resultSet = customerRepository.searchCustomer(customerID);
            resultSet.next();
            return new CustomerDTO(
                    resultSet.getString("CustID"),
                    resultSet.getString("CustTitle"),
                    resultSet.getString("CustName"),
                    resultSet.getDate("DOB").toLocalDate(),
                    resultSet.getDouble("salary"),
                    resultSet.getString("CustAddress"),
                    resultSet.getString("City"),
                    resultSet.getString("Province"),
                    resultSet.getString("PostalCode")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
