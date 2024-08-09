package lk.ijse.gdse.pos.pos.dao;

import lk.ijse.gdse.pos.pos.dto.OrderDto;
import lk.ijse.gdse.pos.pos.entity.Order;

import java.sql.Connection;
import java.sql.SQLException;

public interface OrderDao extends SuperDao{
    String saveOrder(Order order) throws SQLException;
}
