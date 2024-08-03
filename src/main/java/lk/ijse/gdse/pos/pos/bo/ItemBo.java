package lk.ijse.gdse.pos.pos.bo;

import lk.ijse.gdse.pos.pos.dto.ItemDto;

import java.sql.Connection;

public interface ItemBo {
    String saveItem(ItemDto itemDto, Connection connection);
    ItemDto getItem(String itemCode, Connection connection);
}
