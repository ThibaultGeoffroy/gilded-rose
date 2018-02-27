package fr.esiea;

import static org.junit.Assert.*;

import org.junit.Test;

public class DefaultItemTest {

    @Test
    public void initalisationAt80(){
        Item[] items = new Item[] {
                new DefaultItem("Apple",1, 80),
                new DefaultItem("Orange",1, 80, true)
        };
        assertEquals(50 , items[0].quality);
        assertEquals(50, items[1].quality);
    }

    @Test
    public void decreaseNormalBehavior(){
        Item[] items = new Item[] {new DefaultItem("Apple",10, 10)        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9 , app.items[0].quality);
    }

    @Test
    public void decreaseOutDatedBehavior(){
        Item[] items = new Item[] {new DefaultItem("Apple",0, 10)        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8 , app.items[0].quality);
    }

    @Test
    public void doNotDecreaseQualityUnderZero(){
        Item[] items = new Item[] {
                new DefaultItem("Apple",1, 0),
                new DefaultItem("Strawberry",0, 1),
                new DefaultItem("HazelNut",0, 0)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0 , app.items[0].quality);
        assertEquals(0 , app.items[1].quality);
        assertEquals(0, app.items[2].quality);
    }

    @Test
    public void cursedItem(){
        DefaultItem i = new DefaultItem("Apple", 1, 30, true);
        i.update();
        assertEquals(28, i.quality);
    }


}
