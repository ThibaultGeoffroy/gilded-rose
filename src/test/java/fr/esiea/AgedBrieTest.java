package fr.esiea;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class AgedBrieTest {

    @Test
    public void agedBrieAfterOneDay() throws QualityException, SellInException{
        Item i = new AgedBrie(10, 0, false);
        i.update();
        assertEquals(1, i.quality);
    }

    @Test
    public void agedBrieAfter50Days() throws QualityException, SellInException{
        Item item = new AgedBrie(50, 0, false);
        for (int i = 0; i < 50; i++)
            item.update();
        assertEquals(50, item.quality);
    }

    @Test
    public void agedBrieAfter50DaysPassed() throws QualityException, SellInException{
        Item item = new AgedBrie(50, 0, false);
        for (int i = 0; i < 50; i++)
            item.update();
        assertEquals(50, item.quality);
    }

    @Test
    public void AgedBrieDefaultConstructor() throws QualityException, SellInException{
        Item item = new AgedBrie(50, 0, false);
        for (int i = 0; i < 50; i++)
            item.update();
        assertEquals(50, item.quality);
    }

}
