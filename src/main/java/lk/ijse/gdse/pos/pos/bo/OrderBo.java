package lk.ijse.gdse.pos.pos.bo;

import lk.ijse.gdse.pos.pos.dto.OrderDto;

import java.sql.Connection;

public interface OrderBo {
    String saveOrder(OrderDto orderDto, Connection connection);
}
