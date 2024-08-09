package lk.ijse.gdse.pos.pos.dao;

import lk.ijse.gdse.pos.pos.dto.ItemDto;
import lk.ijse.gdse.pos.pos.entity.Item;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ItemDao extends SuperDao{
    String saveItem(Item item ) throws SQLException;
    Item getItem(String itemCode ) throws SQLException;
    boolean updateItem(String itemCode, Item item ) throws SQLException;
    boolean deleteItem(String itemCode ) throws SQLException;
    public List<Item> getAllItems() throws SQLException;
}
