package fr.esiea;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.assertEquals;

public class AgedBrieTest {

    @ParameterizedTest
    @CsvSource({"10, false, 1, 2", "50, false, 50, 50,", "10, true, 1, 2", "50, true, 50, 50,"})
    public void agedBrieAfterDays(int sellIn, boolean conjured, int nbrOfDay, int expectedQuality) throws QualityException, SellInException{
        AgedBrie agedBrie = new AgedBrie(sellIn, 1, conjured);
        for(int i = 0; i < nbrOfDay; i++) {
            agedBrie.update();
        }
        assertEquals(expectedQuality, agedBrie.quality);
    }


    @ParameterizedTest()
    @ValueSource(ints = {0, 51})
    public void agedBrieBadQuality(int quality) {
        Assertions.assertThrows(QualityException.class, () ->{
            AgedBrie agedBrie = new AgedBrie(10, quality, false);
        });
    }

    @Test
    public void agedBrieBadSellIn() {
        Assertions.assertThrows(SellInException.class, () ->{
            AgedBrie agedBrie = new AgedBrie(0, 10, false);
        });
    }

}
