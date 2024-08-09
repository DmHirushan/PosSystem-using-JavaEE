package lk.ijse.gdse.pos.pos.bo;

import lk.ijse.gdse.pos.pos.dto.ItemDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ItemBo extends SuperBo{
    String saveItem(ItemDto itemDto) throws SQLException;
    ItemDto getItem(String itemCode) throws SQLException;
    boolean updateItem(String itemCode, ItemDto itemDto) throws SQLException;
    boolean deleteItem(String itemCode) throws SQLException;
    List<ItemDto> getAllItems() throws SQLException;
}
