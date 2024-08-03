package lk.ijse.gdse.pos.pos.dao;

import lk.ijse.gdse.pos.pos.dto.ItemDto;

import java.sql.Connection;
import java.sql.SQLException;

public class ItemDaoImpl implements ItemDao{
    public static String SAVE_ITEM = "insert into item values (?,?,?,?)";
    public static String GET_ITEM = "select * from item where item_code = ?";
    public static String UPDATE_ITEM = "update item set item_code =?, item_name = ?, item_qty = ?, unit_price = ?";
    public static String DELETE_CUSTOMER = "delete from item where item_code = ?";

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
        ItemDto itemDto = new ItemDto();
        try{
            var ps = connection.prepareStatement(GET_ITEM);
            ps.setString(1, itemCode);
            var rst = ps.executeQuery();
            while (rst.next()){
                itemDto.setItemCode(rst.getString("item_code"));
                itemDto.setItemName(rst.getString("item_name"));
                itemDto.setItemQty(String.valueOf(rst.getInt("item_qty")));
                itemDto.setUnitPrice(String.valueOf(rst.getDouble("unit_price")));
            }
            return itemDto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
