package lk.ijse.gdse.pos.pos.dao;

import lk.ijse.gdse.pos.pos.dto.ItemDto;

import java.sql.Connection;
import java.util.List;

public interface ItemDao {
    String saveItem(ItemDto itemDto, Connection connection);
    ItemDto getItem(String itemCode, Connection connection);
    boolean updateItem(String itemCode, ItemDto itemDto, Connection connection);
    boolean deleteItem(String itemCode, Connection connection);
    public List<ItemDto> getAllItems(Connection connection);
}
