package lk.ijse.gdse.pos.pos.dao;

import lk.ijse.gdse.pos.pos.dto.OrderDetailDto;

import java.sql.Connection;
import java.sql.SQLException;

public class OrderDetailDaoImpl implements OrderDetailDao{
    public static String SAVE_ORDER_DETAIL = "insert into order_detail values (?,?,?,?)";
    @Override
    public String saveOrderDetail(OrderDetailDto orderDetailDto, Connection connection) {
        try {
            var ps = connection.prepareStatement(SAVE_ORDER_DETAIL);
            ps.setString(1, orderDetailDto.getOrderId());
            ps.setString(2, orderDetailDto.getItemCode());
            ps.setDouble(3, orderDetailDto.getUnitPrice());
            if (ps.executeUpdate() !=0 ){
                return "Order Details Saved Successfully";
            }else {
                return "Something went wrong";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
