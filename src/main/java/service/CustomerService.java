package service;

import model.dto.CustomerDTO;

public interface CustomerService {

    CustomerDTO getCustomer(String customerID);

}
