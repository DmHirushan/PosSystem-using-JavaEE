package lk.ijse.gdse.pos.pos.dao;

import lk.ijse.gdse.pos.pos.dto.OrderDto;

import java.sql.Connection;

public interface OrderDao {
    String saveOrder(OrderDto orderDto, Connection connection);
}
