package fr.esiea;

import static org.junit.Assert.*;

import org.junit.Test;

public class AgedBrieTest {

    @Test
    public void agedBrieAfterOneDay(){
        Item i = new AgedBrie(10, 0, false);
        i.update();
        assertEquals(1 , i.quality);
    }

    @Test
    public void agedBrieAfter50Days(){
        Item item = new AgedBrie(50, 0, false);
        for(int i=0; i<50; i++)
            item.update();
        assertEquals(50 , item.quality);
    }

    @Test
    public void agedBrieAfter50DaysPassed(){
        Item item = new AgedBrie(50, 0, false);
        for(int i=0; i<50; i++)
            item.update();
        assertEquals(50 , item.quality);
    }

    @Test
    public void AgedBrieDefaultConstructor(){
        Item item = new AgedBrie(50, 0, false);
        for(int i=0; i<50; i++)
            item.update();
        assertEquals(50 , item.quality);
    }

}
