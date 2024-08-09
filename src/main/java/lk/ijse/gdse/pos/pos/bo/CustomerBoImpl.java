package lk.ijse.gdse.pos.pos.bo;

import lk.ijse.gdse.pos.pos.dao.CustomerDao;
import lk.ijse.gdse.pos.pos.dao.CustomerDaoImpl;
import lk.ijse.gdse.pos.pos.dao.DaoFactory;
import lk.ijse.gdse.pos.pos.dto.CustomerDto;
import lk.ijse.gdse.pos.pos.entity.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerBoImpl implements CustomerBo{

    CustomerDao customerDao = (CustomerDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.CUSTOMER);

    @Override
    public boolean saveCustomer(CustomerDto customerDto) throws SQLException {
        return customerDao.saveCustomer(new Customer().toEntity(customerDto));
    }

    @Override
    public CustomerDto getCustomer(String customerId) throws SQLException {
        return CustomerDto.toDto(customerDao.getCustomer(customerId));
    }

    @Override
    public boolean updateCustomer(String customerId, CustomerDto customerDto) throws SQLException {
        return customerDao.updateCustomer(customerId, Customer.toEntity(customerDto));
    }

    @Override
    public boolean deleteCustomer(String customerId) throws SQLException {
        return customerDao.deleteCustomer(customerId);
    }

    @Override
    public List<CustomerDto> getAllCustomers() throws SQLException {
        List<Customer> customers = customerDao.getAllCustomers();
        List<CustomerDto> customerDtos = new ArrayList<>();
        for (int i=0; i<customers.toArray().length; i++){
            customerDtos.add(CustomerDto.toDto(customers.get(i)));
        }
        return customerDtos;
    }
}
