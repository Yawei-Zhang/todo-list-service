package com.example.todo.Service;

import com.example.todo.Dao.ItemDao;
import com.example.todo.Model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ItemService {

    @Autowired
    private ItemDao itemDao;

    public Collection<Item> getAllItems() {
        return itemDao.findAll();
    }
}
