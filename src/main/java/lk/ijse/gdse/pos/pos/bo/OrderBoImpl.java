package lk.ijse.gdse.pos.pos.bo;

import lk.ijse.gdse.pos.pos.dao.DaoFactory;
import lk.ijse.gdse.pos.pos.dao.OrderDao;
import lk.ijse.gdse.pos.pos.dao.OrderDaoImpl;
import lk.ijse.gdse.pos.pos.dto.OrderDto;
import lk.ijse.gdse.pos.pos.entity.Order;

import java.sql.Connection;
import java.sql.SQLException;

public class OrderBoImpl implements OrderBo{
    OrderDao orderDao = (OrderDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.ORDER);
    @Override
    public String saveOrder(OrderDto orderDto) throws SQLException {
        return orderDao.saveOrder(Order.toEntity(orderDto));
    }
}
