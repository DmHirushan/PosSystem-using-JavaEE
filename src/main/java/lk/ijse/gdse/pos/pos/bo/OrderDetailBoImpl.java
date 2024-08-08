package lk.ijse.gdse.pos.pos.bo;

import lk.ijse.gdse.pos.pos.dao.OrderDetailDao;
import lk.ijse.gdse.pos.pos.dao.OrderDetailDaoImpl;
import lk.ijse.gdse.pos.pos.dto.OrderDetailDto;

import java.sql.Connection;

public class OrderDetailBoImpl implements OrderDetailBo{
    OrderDetailDao orderDetailDao = new OrderDetailDaoImpl();
    @Override
    public String saveOrderDetail(OrderDetailDto orderDetailDto, Connection connection) {
       return orderDetailDao.saveOrderDetail(orderDetailDto, connection);
    }
}
