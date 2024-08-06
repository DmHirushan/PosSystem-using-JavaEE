package lk.ijse.gdse.pos.pos.bo;

import lk.ijse.gdse.pos.pos.dao.CustomerDao;
import lk.ijse.gdse.pos.pos.dao.CustomerDaoImpl;
import lk.ijse.gdse.pos.pos.dto.CustomerDto;

import java.sql.Connection;
import java.util.List;

public class CustomerBoImpl implements CustomerBo{
    CustomerDao customerDao = new CustomerDaoImpl();
    @Override
    public boolean saveCustomer(CustomerDto customerDto, Connection connection) {
        return customerDao.saveCustomer(customerDto, connection);
    }

    @Override
    public CustomerDto getCustomer(String customerId, Connection connection) {
        return customerDao.getCustomer(customerId, connection);
    }

    @Override
    public boolean updateCustomer(String customerId, CustomerDto customerDto, Connection connection) {
        return customerDao.updateCustomer(customerId, customerDto, connection);
    }

    @Override
    public boolean deleteCustomer(String customerId, Connection connection) {
        return customerDao.deleteCustomer(customerId, connection);
    }

    @Override
    public List<CustomerDto> getAllCustomers(Connection connection) {
        return customerDao.getAllCustomers(connection);
    }
}
