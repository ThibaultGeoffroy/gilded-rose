package fr.esiea;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {


    @Test
    public void item_to_string(){
        Item i = new Item("apple", 0, 0);
        System.out.println(i);
    }

    @Test
    public void firstCase() {
        Item[] items = new Item[] {new Item("apple", 1, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9 , app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
    }

    @Test
    public void one_item_minus_sellin() {
        Item[] items = new Item[] {new Item("apple", -1, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8 , app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }

    @Test
    public void concert_sellin_in_1(){
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 1, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(13 , app.items[0].quality);
        assertEquals(0 , app.items[0].sellIn);
    }

    @Test
    public void concert_sellin_in_10(){
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12 , app.items[0].quality);
        assertEquals(9 , app.items[0].sellIn);
    }

    @Test
    public void concert_sellin_in_minus1(){
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", -1, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0 , app.items[0].quality);
        assertEquals(-2 , app.items[0].sellIn);
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