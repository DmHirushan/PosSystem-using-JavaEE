package lk.ijse.gdse.pos.pos.bo;

import lk.ijse.gdse.pos.pos.dao.ItemDao;
import lk.ijse.gdse.pos.pos.dao.ItemDaoImpl;
import lk.ijse.gdse.pos.pos.dto.ItemDto;

import java.sql.Connection;

public class ItemBoImpl implements ItemBo{
    ItemDao itemDao = new ItemDaoImpl();
    @Override
    public String saveItem(ItemDto itemDto, Connection connection) {
        return itemDao.saveItem(itemDto, connection);
    }

    @Override
    public ItemDto getItem(String itemCode, Connection connection) {
        return itemDao.getItem(itemCode, connection);
    }

    @Override
    public boolean updateItem(String itemCode, ItemDto itemDto, Connection connection) {
        return false;
    }

    @Override
    public boolean deleteItem(String itemCode, Connection connection) {
        return false;
    }
}
