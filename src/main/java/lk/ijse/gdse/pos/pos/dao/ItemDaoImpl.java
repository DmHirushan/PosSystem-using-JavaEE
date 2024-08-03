package lk.ijse.gdse.pos.pos.dao;

import lk.ijse.gdse.pos.pos.dto.ItemDto;

import java.sql.Connection;
import java.sql.SQLException;

public class ItemDaoImpl implements ItemDao{
    public static String SAVE_ITEM = "insert into item values (?,?,?,?)";

    @Override
    public String saveItem(ItemDto itemDto, Connection connection) {
        try {
            var ps = connection.prepareStatement(SAVE_ITEM);
            ps.setString(1, itemDto.getItemCode());
            ps.setString(2, itemDto.getItemName());
            ps.setString(3, itemDto.getItemQty());
            ps.setString(4, itemDto.getUnitPrice());
            if (ps.executeUpdate() !=0 ){
                return "Item Saved Successfully";
            }else {
                return "Something went wrong";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ItemDto getItem(String itemCode, Connection connection) {
        return null;
    }
}
