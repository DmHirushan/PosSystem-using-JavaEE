package lk.ijse.gdse.pos.pos.bo;

import lk.ijse.gdse.pos.pos.dao.OrderDao;
import lk.ijse.gdse.pos.pos.dao.OrderDaoImpl;
import lk.ijse.gdse.pos.pos.dto.OrderDto;
import lk.ijse.gdse.pos.pos.entity.Order;

import java.sql.Connection;

public class OrderBoImpl implements OrderBo{
    OrderDao orderDao = new OrderDaoImpl();
    @Override
    public String saveOrder(OrderDto orderDto, Connection connection) {
        return orderDao.saveOrder(Order.toEntity(orderDto), connection);
    }
}
