package com.example.todo.Service;

import com.example.todo.Dao.ItemDao;
import com.example.todo.Model.Item;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.util.Collection;
import java.util.HashSet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class ItemServiceTest {

    @Mock
    private ItemDao itemDao;

    @InjectMocks
    private ItemService itemService;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void testFindAll() {
        Collection<Item> expectedItems = new HashSet<Item>(){
            {
                add(new Item(1, "Read"));
                add(new Item(2, "Write"));
            }
        };
        when(itemDao.findAll()).thenReturn(expectedItems);

        Collection<Item> actualItems = itemService.getAllItems();

        verify(itemDao, times(1)).findAll();
        assertArrayEquals(expectedItems.toArray(), actualItems.toArray());
    }

}
