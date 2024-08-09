package lk.ijse.gdse.pos.pos.dao;

import lk.ijse.gdse.pos.pos.dto.CustomerDto;
import lk.ijse.gdse.pos.pos.entity.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface CustomerDao extends SuperDao{
    boolean saveCustomer(Customer customer) throws SQLException;
    Customer getCustomer(String customerId) throws SQLException;
    boolean updateCustomer(String customerId, Customer customer) throws SQLException;
    boolean deleteCustomer(String customerId) throws SQLException;
    List<Customer> getAllCustomers() throws SQLException;
}
