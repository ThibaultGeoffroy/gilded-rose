package fr.esiea;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ItemFactoryTest {

    @Test
    public void itemType() throws QualityException, SellInException{

       assertTrue(ItemFactory.createItem("truc", 10, 10, true) instanceof DefaultItem);
        assertTrue(ItemFactory.createItem(Constants.SULFURAS_NAME, 0, 80, true) instanceof Sulfuras);
        assertTrue(ItemFactory.createItem(Constants.CONCERT_NAME ,10, 10, true) instanceof Concert);
        assertTrue(ItemFactory.createItem(Constants.AGEDBRIE_NAME, 10, 10, true) instanceof AgedBrie);

    }
}
