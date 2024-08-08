package lk.ijse.gdse.pos.pos.dao;

import lk.ijse.gdse.pos.pos.dto.OrderDetailDto;

import java.sql.Connection;

public interface OrderDetailDao {
    String saveOrderDetail(OrderDetailDto orderDetailDto, Connection connection);
}
