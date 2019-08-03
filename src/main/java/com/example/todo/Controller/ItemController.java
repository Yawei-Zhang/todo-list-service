package com.example.todo.Controller;

import com.example.todo.Model.Item;
import com.example.todo.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @RequestMapping(params = "{id}", method = RequestMethod.GET)
    public Item getItemById(@RequestParam int id) {
        return itemService.getItemById(id);
    }
}
