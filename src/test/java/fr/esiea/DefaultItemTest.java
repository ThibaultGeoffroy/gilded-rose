package fr.esiea;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class DefaultItemTest {

    @ParameterizedTest
    @CsvSource({
            "10, 10, false, 9",
            "0, 10, false, 8",
            "1, 0, false, 0",
            "0, 1, false, 0",
            "0, 0, false, 0",
            "1, 30, true, 28"
    })
    public void defaultItemBehavior(int sellIn, int quality, boolean cursed, int expectedValue) throws QualityException, SellInException {
        DefaultItem defaultItem = new DefaultItem("Test", sellIn, quality, cursed);
        defaultItem.update();
        System.out.println(defaultItem);
        assertEquals(expectedValue, defaultItem.quality);
    }

    @ParameterizedTest()
    @ValueSource(ints = {-1, 51})
    public void defaultItemBadQuality(int quality) {
        Assertions.assertThrows(QualityException.class, () ->{
            DefaultItem defaultItem = new DefaultItem("test", 10, quality, false);
        });
    }

    @Test
    public void defaultItemBadSellIn() {
        Assertions.assertThrows(SellInException.class, () ->{
            DefaultItem defaultItem = new DefaultItem("test", -1, 10, false);
        });
    }
}
