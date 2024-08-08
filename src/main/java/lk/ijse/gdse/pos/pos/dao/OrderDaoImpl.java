package lk.ijse.gdse.pos.pos.dao;

import lk.ijse.gdse.pos.pos.dto.OrderDto;

import java.sql.Connection;
import java.sql.SQLException;

public class OrderDaoImpl implements OrderDao{
    public static String SAVE_ORDER = "insert into order values (?,?,?,?)";
    @Override
    public String saveOrder(OrderDto orderDto, Connection connection) {
        try {
            var ps = connection.prepareStatement(SAVE_ORDER);
            ps.setString(1, orderDto.getOrderID());
            ps.setString(2, orderDto.getCustomerId());
            ps.setInt(3, orderDto.getTotal());
            if (ps.executeUpdate() !=0 ){
                return "Order Saved Successfully";
            }else {
                return "Something went wrong";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
