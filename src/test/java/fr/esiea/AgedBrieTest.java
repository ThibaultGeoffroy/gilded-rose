package fr.esiea;

import static org.junit.Assert.*;

import org.junit.Test;

public class AgedBrieTest {

    @Test
    public void agedBrieAfterOneDay(){
        Item[] items = new Item[] {new AgedBrie(10, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1 , app.items[0].quality);
    }

    @Test
    public void agedBrieAfter50Days(){
        Item[] items = new Item[] {new AgedBrie(50, 0)};
        GildedRose app = new GildedRose(items);
        for(int i=0; i<50; i++)
            app.updateQuality();
        assertEquals(50 , app.items[0].quality);
    }

    @Test
    public void agedBrieAfter50DaysPassed(){
        Item[] items = new Item[] {new AgedBrie(50, 0)};
        GildedRose app = new GildedRose(items);
        for(int i=0; i<50; i++)
            app.updateQuality();
        assertEquals(50 , app.items[0].quality);
    }

    @Test
    public void AgedBrieDefaultConstructor(){
        Item[] items = new Item[] {new AgedBrie()};
        GildedRose app = new GildedRose(items);
        for(int i=0; i<50; i++)
            app.updateQuality();
        assertEquals(50 , app.items[0].quality);
    }

}
