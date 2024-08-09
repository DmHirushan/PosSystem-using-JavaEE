package lk.ijse.gdse.pos.pos.dao;

import lk.ijse.gdse.pos.pos.dto.OrderDto;
import lk.ijse.gdse.pos.pos.entity.Order;
import lk.ijse.gdse.pos.pos.util.SqlUtil.SqlUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public class OrderDaoImpl implements OrderDao{
    public static String SAVE_ORDER = "insert into order values (?,?,?)";
    @Override
    public String saveOrder(Order order) throws SQLException {
        return SqlUtil.execute(SAVE_ORDER,
                order.getOrderID(),
                order.getCustomerId(),
                order.getTotal()
        );
    }
}
