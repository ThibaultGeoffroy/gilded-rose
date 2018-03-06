package fr.esiea;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class GildedRoseTest {

    @Test
    public void updateOnGildedRose() throws QualityException, SellInException{

        GildedRose gr = new GildedRose();

        gr.addItem(new DefaultItem("Apple",5, 30, false));
        gr.addItem(new DefaultItem("Strawberry",5, 40, false));
        gr.addItem(new DefaultItem("Orange",5, 40, false));


        gr.updateQuality();

        Item i = gr.buyItem("Orange");
        assertEquals(4 , i.sellIn);

        List<Item> items = gr.getItems();
        assertEquals( 2 , items.size());
        assertEquals(4 , items.get(0).sellIn);
        assertEquals(4, items.get(0).sellIn);

    }

    @Test
    public void buyNonExistentItem(){
        GildedRose gr = new GildedRose();
        Assertions.assertThrows(NoItemException.class, () ->{
            gr.buyItem("test");
        });
        gr.addItem(new DefaultItem("Apple",5, 30, false));
        Assertions.assertThrows(NoItemException.class, () ->{
            gr.buyItem("test");
        });
    }

}