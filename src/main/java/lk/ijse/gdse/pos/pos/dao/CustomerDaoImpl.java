package lk.ijse.gdse.pos.pos.dao;

import lk.ijse.gdse.pos.pos.dto.CustomerDto;
import lk.ijse.gdse.pos.pos.entity.Customer;
import lk.ijse.gdse.pos.pos.util.SqlUtil.SqlUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao{
    public static String SAVE_CUSTOMER = "Insert into customer values (?,?,?,?)";
    public static String GET_CUSTOMER = "Select * from customer where id = ?";
    public static String UPDATE_CUSTOMER = "Update customer SET name=?, address=?, salary=? WHERE id=?";
    public static String DELETE_CUSTOMER = "Delete from customer where id = ?";
    public static String GET_ALL = "Select * from customer";

    @Override
    public boolean saveCustomer(Customer customer) throws SQLException {

        return SqlUtil.execute(SAVE_CUSTOMER,
                customer.getId(),
                customer.getName(),
                customer.getAddress(),
                customer.getSalary()
        );

    }

    @Override
    public Customer getCustomer(String customerId) throws SQLException {
        ResultSet resultSet = SqlUtil.execute(GET_CUSTOMER, customerId);
        if (resultSet.next()) {
            return new Customer(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)
            );
        }
        return null;
    }

    @Override
    public boolean updateCustomer(String customerId, Customer customer) throws SQLException {
        return SqlUtil.execute(UPDATE_CUSTOMER,
                customer.getName(),
                customer.getAddress(),
                customer.getSalary(),
                customer.getId()
        );
    }

    @Override
    public boolean deleteCustomer(String customerId) throws SQLException {
        return SqlUtil.execute(DELETE_CUSTOMER, customerId);

    }

    @Override
    public List<Customer> getAllCustomers() throws SQLException {
        ResultSet resultSet = SqlUtil.execute(GET_ALL);
        List<Customer> customerList = new ArrayList<>();
        while (resultSet.next()) {
            customerList.add(new Customer(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)
            ));
        }
        return customerList;
    }
}
