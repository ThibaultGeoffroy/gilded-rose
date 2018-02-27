package fr.esiea;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SulfurasTest {

    @Test
    public void sulfurasAfterOneDay() {
        Item[] items = new Item[] {new Sulfuras(false), new Sulfuras(true)};
        items[0].update();
        assertEquals(80 , items[0].quality);
        assertEquals(0, items[0].sellIn);
        items[1].update();
        assertEquals(80 , items[1].quality);
        assertEquals(0, items[1].sellIn);
    }
}
