package lk.ijse.gdse.pos.pos.dao;

import lk.ijse.gdse.pos.pos.dto.CustomerDto;
import lk.ijse.gdse.pos.pos.dto.ItemDto;
import lk.ijse.gdse.pos.pos.entity.Item;
import lk.ijse.gdse.pos.pos.util.SqlUtil.SqlUtil;

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
    public String saveItem(Item item) throws SQLException {
        return SqlUtil.execute(SAVE_ITEM,
                item.getItemCode(),
                item.getItemName(),
                item.getItemQty(),
                item.getUnitPrice()
        );
    }

    @Override
    public Item getItem(String itemCode) throws SQLException {
        ResultSet resultSet = SqlUtil.execute(GET_ITEM, itemCode);
        if (resultSet.next()) {
            return new Item(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getDouble(4)
            );
        }
        return null;
    }

    public List<Item> getAllItems() throws SQLException {
        ResultSet resultSet = SqlUtil.execute(GET_ALL);
        List<Item> itemList = new ArrayList<>();
        while (resultSet.next()) {
            itemList.add(new Item(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getDouble(4)
            ));
        }
        return itemList;
    }


        @Override
    public boolean updateItem(String itemCode, Item item) throws SQLException {
            return SqlUtil.execute(UPDATE_ITEM,
                    item.getItemName(),
                    item.getItemQty(),
                    item.getUnitPrice(),
                    item.getItemCode()
            );
    }

    @Override
    public boolean deleteItem(String itemCode) throws SQLException {
        return SqlUtil.execute(DELETE_ITEM, itemCode);
    }
}
