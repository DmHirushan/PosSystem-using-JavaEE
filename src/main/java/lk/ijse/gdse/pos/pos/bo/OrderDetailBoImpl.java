package lk.ijse.gdse.pos.pos.bo;

import lk.ijse.gdse.pos.pos.dao.DaoFactory;
import lk.ijse.gdse.pos.pos.dao.OrderDetailDao;
import lk.ijse.gdse.pos.pos.dao.OrderDetailDaoImpl;
import lk.ijse.gdse.pos.pos.dto.OrderDetailDto;
import lk.ijse.gdse.pos.pos.entity.OrderDetail;

import java.sql.Connection;
import java.sql.SQLException;

public class OrderDetailBoImpl implements OrderDetailBo{
    OrderDetailDao orderDetailDao = (OrderDetailDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.ORDER_DETAIL);
    @Override
    public String saveOrderDetail(OrderDetailDto orderDetailDto) throws SQLException {
       return orderDetailDao.saveOrderDetail(OrderDetail.toEntity(orderDetailDto));
    }
}
