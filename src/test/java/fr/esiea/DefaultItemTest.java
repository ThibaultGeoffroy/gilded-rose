package fr.esiea;

import static org.junit.Assert.*;

import org.junit.Test;

public class DefaultItemTest {

    @Test
    public void initalisationAt80() throws QualityException, SellInException{
        try {
            Item[] items = new Item[]{
                    new DefaultItem("Apple", 1, 80, false),
                    new DefaultItem("Orange", 1, 80, true)
            };
            assertEquals(50, items[0].quality);
            assertEquals(50, items[1].quality);
        } catch(Exception e){}
    }

    @Test
    public void decreaseNormalBehavior() throws QualityException, SellInException{
        try {
            Item item = new DefaultItem("Apple", 10, 10, false);
            item.update();
            assertEquals(9, item.quality);
        } catch(Exception e){}
    }

    @Test
    public void decreaseOutDatedBehavior() throws QualityException, SellInException{
        try {
            Item item = new DefaultItem("Apple", 0, 10, false);
            item.update();
            assertEquals(8, item.quality);
        } catch(Exception e){}
    }

    @Test
    public void doNotDecreaseQualityUnderZero() throws QualityException, SellInException{
        Item item1 = new DefaultItem("Apple", 1, 0, false);
        Item item2 = new DefaultItem("Strawberry", 0, 1, false);
        Item item3 = new DefaultItem("HazelNut", 0, 0, false);


        item1.update();
        item2.update();
        item3.update();

        assertEquals(0, item1.quality);
        assertEquals(0, item2.quality);
        assertEquals(0, item3.quality);
    }

    @Test
    public void cursedItem() throws QualityException, SellInException{
        DefaultItem i = new DefaultItem("Apple", 1, 30, true);
        i.update();
        assertEquals(28, i.quality);
    }


}
