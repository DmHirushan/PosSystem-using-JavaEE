package lk.ijse.gdse.pos.pos.bo;

import lk.ijse.gdse.pos.pos.dto.OrderDto;

import java.sql.Connection;
import java.sql.SQLException;

public interface OrderBo extends SuperBo{
    String saveOrder(OrderDto orderDto) throws SQLException;
}
