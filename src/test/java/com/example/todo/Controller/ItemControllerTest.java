package com.example.todo.Controller;

import com.example.todo.Model.Item;
import com.example.todo.Service.ItemService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Collection;
import java.util.HashSet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class ItemControllerTest {

    @Mock
    private ItemService itemService;

    @InjectMocks
    private ItemController itemController;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void testGetAllItems() {
        Collection<Item> expectedItems = new HashSet<Item>(){
            {
                add(new Item(1, "Read"));
                add(new Item(2, "Write"));
            }
        };
        when(itemService.getAllItems()).thenReturn(expectedItems);

        Collection<Item> actualItems = itemController.getAllItems();

        verify(itemService, times(1)).getAllItems();
        assertEquals(expectedItems, actualItems);
    }
}
