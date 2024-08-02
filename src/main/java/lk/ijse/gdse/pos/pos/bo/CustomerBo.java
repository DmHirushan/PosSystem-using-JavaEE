package lk.ijse.gdse.pos.pos.bo;

import lk.ijse.gdse.pos.pos.dto.CustomerDto;

import java.sql.Connection;

public interface CustomerBo {
    String saveCustomer(CustomerDto customerDto, Connection connection);
    CustomerDto getCustomer(String customerId, Connection connection);
    boolean updateCustomer(String customerId, CustomerDto customerDto, Connection connection);
    boolean deleteCustomer(String customerId, Connection connection);
}
