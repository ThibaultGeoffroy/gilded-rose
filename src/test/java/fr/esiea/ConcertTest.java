package fr.esiea;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ConcertTest {


    @Test
    public void concertSellIn20() throws QualityException, SellInException{
        Concert c = new Concert(20, 30, false);
        c.update();
        assertEquals(31, c.quality);
    }

    @Test
    public void concertSellIn7() throws QualityException, SellInException{
        Concert c = new Concert(7, 30, false);
        c.update();
        assertEquals(32, c.quality);
    }

    @Test
    public void concertSellIn2() throws QualityException, SellInException{
        Concert c = new Concert(2, 30, false);
        c.update();
        assertEquals(33, c.quality);
    }

    @Test
    public void  concertNoValue() throws QualityException, SellInException{
       Concert c = new Concert(-1, 30, false);
       c.update();
       assertEquals(0, c.quality);
    }

    @Test
    public void CursedConcert() throws QualityException, SellInException{
        Concert c = new Concert(20, 30, true);
        c.update();
        assertEquals(31, c.quality);
    }

    @Test
    public void ConcertTooMuchQuality() throws QualityException, SellInException{
        Concert c = new Concert(20, 70, false);
        Concert c2 = new Concert(20, 70, true);
        assertEquals(50, c.quality);
        assertEquals(50, c2.quality);
    }
}
