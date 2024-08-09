package lk.ijse.gdse.pos.pos.bo;

import lk.ijse.gdse.pos.pos.dao.DaoFactory;
import lk.ijse.gdse.pos.pos.dao.ItemDao;
import lk.ijse.gdse.pos.pos.dao.ItemDaoImpl;
import lk.ijse.gdse.pos.pos.dto.ItemDto;
import lk.ijse.gdse.pos.pos.entity.Item;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemBoImpl implements ItemBo{
    ItemDao itemDao = (ItemDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.ITEM);
    @Override
    public String saveItem(ItemDto itemDto) throws SQLException {
        return itemDao.saveItem(Item.toEntity(itemDto));
    }

    @Override
    public ItemDto getItem(String itemCode) throws SQLException {
        return ItemDto.toDto(itemDao.getItem(itemCode));
    }

    @Override
    public boolean updateItem(String itemCode, ItemDto itemDto) throws SQLException {
        return itemDao.updateItem(itemCode, Item.toEntity(itemDto));
    }

    @Override
    public boolean deleteItem(String itemCode) throws SQLException {
        return itemDao.deleteItem(itemCode);
    }

    @Override
    public List<ItemDto> getAllItems() throws SQLException {
        List<Item> items = itemDao.getAllItems();
        List<ItemDto> itemDtos = new ArrayList<>();
        for (int i=0; i<items.toArray().length; i++){
            itemDtos.add(ItemDto.toDto(items.get(i)));
        }
        return itemDtos;
    }
}
