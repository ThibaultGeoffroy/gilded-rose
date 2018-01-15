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

    @Test
    public void agedBrieAfterOneDay(){
        Item[] items = new Item[] {new Item("Aged Brie", 10, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1 , app.items[0].quality);
    }

    @Test
    public void agedBrieAfter50Days(){
        Item[] items = new Item[] {new Item("Aged Brie", 50, 0)};
        GildedRose app = new GildedRose(items);
        for(int i=0; i<50; i++)
            app.updateQuality();
        assertEquals(50 , app.items[0].quality);
    }

    @Test
    public void agedBrieAfter51DaysPassed(){
        Item[] items = new Item[] {new Item("Aged Brie", 1, 0)};
        GildedRose app = new GildedRose(items);
        for(int i=0; i<51; i++)
            app.updateQuality();
        assertEquals(50 , app.items[0].quality);
    }

}