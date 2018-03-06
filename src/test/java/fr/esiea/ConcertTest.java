package fr.esiea;

import org.junit.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;



public class ConcertTest {

    @ParameterizedTest
    @CsvSource({
            "20, false, 31",
            "7, false, 32",
            "2, false, 33",
            "0, false, 0",
            "20, true, 31",
    })
    public void concertSellIn(int sellIn, boolean conjured, int expectedValue) throws QualityException, SellInException {
        Concert concert = new Concert(sellIn, 30, conjured);
        concert.update();
        assertEquals(expectedValue, concert.quality);
    }

    @ParameterizedTest()
    @ValueSource(ints = {0, 51})
    public void agedBrieBadQuality(int quality) {
        Assertions.assertThrows(QualityException.class, () ->{
            Concert concert = new Concert(10, quality, false);
        });
    }

    @Test
    public void agedBrieBadSellIn() {
        Assertions.assertThrows(SellInException.class, () ->{
            Concert concert = new Concert(-1, 10, false);
        });
    }
}
