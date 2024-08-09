package lk.ijse.gdse.pos.pos.bo;

import lk.ijse.gdse.pos.pos.dto.CustomerDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface CustomerBo extends SuperBo{
    boolean saveCustomer(CustomerDto customerDto) throws SQLException;
    CustomerDto getCustomer(String customerId) throws SQLException;
    boolean updateCustomer(String customerId, CustomerDto customerDto) throws SQLException;
    boolean deleteCustomer(String customerId) throws SQLException;
    List<CustomerDto> getAllCustomers() throws SQLException;
}
