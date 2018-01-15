package fr.esiea;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {


    @Test
    public void firstCase() {
        Item[] items = new Item[] {new Item("apple", 1, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9 , app.items[0].quality);
    }

}