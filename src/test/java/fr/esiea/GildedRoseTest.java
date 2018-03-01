package fr.esiea;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GildedRoseTest {

    @Test
    public void initalisationAt80(){

        GildedRose gr = new GildedRose();

        gr.addItem(new DefaultItem("Apple",5, 30));
        gr.addItem(new DefaultItem("Strawberry",5, 40));

        gr.updateQuality();

        List<Item> items = gr.getItems();

        assertEquals(4 , items.get(0).sellIn);
        assertEquals(4, items.get(0).sellIn);
    }

}