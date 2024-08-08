package lk.ijse.gdse.pos.pos.dao;

import lk.ijse.gdse.pos.pos.dto.CustomerDto;
import lk.ijse.gdse.pos.pos.dto.ItemDto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl implements ItemDao{
    public static String SAVE_ITEM = "insert into item values (?,?,?,?)";
    public static String GET_ITEM = "select * from item where item_code = ?";
    public static String UPDATE_ITEM = "update item set item_name = ?, item_qty = ?, unit_price = ? where item_code = ?";
    public static String DELETE_ITEM = "delete from item where item_code = ?";
    public static String GET_ALL = "select * from item";

    @Override
    public String saveItem(ItemDto itemDto, Connection connection) {
        try {
            var ps = connection.prepareStatement(SAVE_ITEM);
            ps.setString(1, itemDto.getItemCode());
            ps.setString(2, itemDto.getItemName());
            ps.setInt(3, itemDto.getItemQty());
            ps.setDouble(4, itemDto.getUnitPrice());
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
                itemDto.setItemQty(rst.getInt("item_qty"));
                itemDto.setUnitPrice(rst.getDouble("unit_price"));
            }
            return itemDto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<ItemDto> getAllItems(Connection connection) {
        List<ItemDto> itemDtos = new ArrayList<>();
        try {
            var ps = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                ItemDto itemDto = new ItemDto();
                itemDto.setItemCode(resultSet.getString("item_code"));
                itemDto.setItemName(resultSet.getString("item_name"));
                itemDto.setItemQty(resultSet.getInt("item_qty"));
                itemDto.setUnitPrice(resultSet.getDouble("unit_price"));
                itemDtos.add(itemDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return itemDtos;
    }


        @Override
    public boolean updateItem(String itemCode, ItemDto itemDto, Connection connection) {
        try{
            var ps = connection.prepareStatement(UPDATE_ITEM);
            ps.setString(1, itemDto.getItemName());
            ps.setInt(2, itemDto.getItemQty());
            ps.setDouble(3, itemDto.getUnitPrice());
            ps.setString(4, itemDto.getItemCode());
            return ps.executeUpdate() != 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteItem(String itemCode, Connection connection) {
        try{
            var ps = connection.prepareStatement(DELETE_ITEM);
            ps.setString(1, itemCode);
            return  ps.executeUpdate() != 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
