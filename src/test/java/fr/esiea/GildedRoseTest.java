package fr.esiea;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GildedRoseTest {

    @Test
    public void updateOnGildedRose(){

        GildedRose gr = new GildedRose();

        gr.addItem(new DefaultItem("Apple",5, 30, false));
        gr.addItem(new DefaultItem("Strawberry",5, 40, false));

        gr.updateQuality();

        List<Item> items = gr.getItems();

        assertEquals(4 , items.get(0).sellIn);
        assertEquals(4, items.get(0).sellIn);
    }

}