package lk.ijse.gdse.pos.pos.bo;

import lk.ijse.gdse.pos.pos.dao.CustomerDao;
import lk.ijse.gdse.pos.pos.dao.CustomerDaoImpl;
import lk.ijse.gdse.pos.pos.dto.CustomerDto;

import java.sql.Connection;

public class CustomerBoImpl implements CustomerBo{
    CustomerDao customerDao = new CustomerDaoImpl();
    @Override
    public String saveCustomer(CustomerDto customerDto, Connection connection) {
        return customerDao.saveCustomer(customerDto, connection);
    }

    @Override
    public CustomerDto getCustomer(String customerId, Connection connection) {
        return customerDao.getCustomer(customerId, connection);
    }
}
