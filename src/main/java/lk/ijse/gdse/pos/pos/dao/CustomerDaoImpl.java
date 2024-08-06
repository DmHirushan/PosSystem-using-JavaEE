package lk.ijse.gdse.pos.pos.dao;

import lk.ijse.gdse.pos.pos.dto.CustomerDto;

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
    public boolean saveCustomer(CustomerDto customerDto, Connection connection) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SAVE_CUSTOMER);
            preparedStatement.setString(1, customerDto.getId());
            preparedStatement.setString(2, customerDto.getName());
            preparedStatement.setString(3, customerDto.getAddress());
            preparedStatement.setString(4, customerDto.getSalary());

            if (preparedStatement.executeUpdate() != 0){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public CustomerDto getCustomer(String customerId, Connection connection) {
        var customerDto = new CustomerDto();
        try {
            var ps = connection.prepareStatement(GET_CUSTOMER);
            ps.setString(1, customerId);
            var rst = ps.executeQuery();
            while (rst.next()){
                customerDto.setId(rst.getString("id"));
                customerDto.setName(rst.getString("name"));
                customerDto.setAddress(rst.getString("address"));
                customerDto.setSalary(rst.getString("salary"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerDto;
    }

    @Override
    public boolean updateCustomer(String customerId, CustomerDto customerDto, Connection connection) {
        try{
            var ps = connection.prepareStatement(UPDATE_CUSTOMER);
            ps.setString(1, customerDto.getName());
            ps.setString(2, customerDto.getAddress());
            ps.setString(3, customerDto.getSalary());
            ps.setString(4, customerId);
            return ps.executeUpdate() != 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteCustomer(String customerId, Connection connection){
        try{
            var ps = connection.prepareStatement(DELETE_CUSTOMER);
            ps.setString(1, customerId);
            return  ps.executeUpdate() != 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<CustomerDto> getAllCustomers(Connection connection) {
        List <CustomerDto> customerDtos = new ArrayList<>();
        try{
            CustomerDto customerDto = new CustomerDto();
            var ps = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                customerDto.setId(resultSet.getString("id"));
                customerDto.setName(resultSet.getString("name"));
                customerDto.setAddress(resultSet.getString("address"));
                customerDto.setSalary(resultSet.getString("salary"));
                customerDtos.add(customerDto);
            }
            return customerDtos;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
