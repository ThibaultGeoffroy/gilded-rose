package fr.esiea;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runners.Parameterized;


import static org.junit.Assert.assertEquals;

public class SulfurasTest {

    @Test
    public void sulfurasBadQuality() {
        Assertions.assertThrows(QualityException.class, () ->{
            Sulfuras sulfuras = new Sulfuras(0, 50, false);
        });
    }
    @Test
    public void sulfurasBadSellIn() {
        Assertions.assertThrows(SellInException.class, () ->{
            Sulfuras sulfuras = new Sulfuras(10, 80, false);
        });
    }

    @Test
    public void sulfurasAfterOneDay() throws QualityException, SellInException {
        Sulfuras sulfuras = new Sulfuras(0, 80, true);
        sulfuras.update();
        assertEquals(0, sulfuras.sellIn);
        assertEquals(80, sulfuras.quality);
        assertEquals( true, sulfuras.conjured);
    }


}
