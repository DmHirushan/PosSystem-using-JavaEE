package lk.ijse.gdse.pos.pos.dao;

import lk.ijse.gdse.pos.pos.dto.OrderDetailDto;
import lk.ijse.gdse.pos.pos.entity.OrderDetail;

import java.sql.Connection;
import java.sql.SQLException;

public interface OrderDetailDao extends SuperDao{
    String saveOrderDetail(OrderDetail orderDetail) throws SQLException;
}
