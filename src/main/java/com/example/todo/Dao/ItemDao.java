package com.example.todo.Dao;

import com.example.todo.Model.Item;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ItemDao {
    private static Map<Integer, Item> items;

    static {
        items = new HashMap<Integer, Item>() {
            {
                put(1, new Item(1, "QT"));
                put(2, new Item(2, "Pray"));
                put(3, new Item(3, "Wait"));
            }
        };
    }

    public Collection<Item> findAll() {
        return items.values();
    }
}
