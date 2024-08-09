package lk.ijse.gdse.pos.pos.dao;

import lk.ijse.gdse.pos.pos.dto.OrderDetailDto;
import lk.ijse.gdse.pos.pos.entity.OrderDetail;
import lk.ijse.gdse.pos.pos.util.SqlUtil.SqlUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class OrderDetailDaoImpl implements OrderDetailDao{
    public static String SAVE_ORDER_DETAIL = "insert into order_detail values (?,?,?,?)";
    @Override
    public String saveOrderDetail(OrderDetail orderDetail) throws SQLException {
        return SqlUtil.execute(SAVE_ORDER_DETAIL,
                orderDetail.getOrderId(),
                orderDetail.getItemCode(),
                orderDetail.getUnitPrice(),
                orderDetail.getQty()
        );
    }
}
