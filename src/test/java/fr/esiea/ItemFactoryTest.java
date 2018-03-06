package fr.esiea;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ItemFactoryTest {

    @Test
    public void constructorTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<ItemFactory> constructor = ItemFactory.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        constructor.newInstance();
    }


    @Test
    public void itemType() throws QualityException, SellInException{

       assertTrue(ItemFactory.createItem("truc", 10, 10, true) instanceof DefaultItem);
        assertTrue(ItemFactory.createItem(Constants.SULFURAS_NAME, 0, 80, true) instanceof Sulfuras);
        assertTrue(ItemFactory.createItem(Constants.CONCERT_NAME ,10, 10, true) instanceof Concert);
        assertTrue(ItemFactory.createItem(Constants.AGEDBRIE_NAME, 10, 10, true) instanceof AgedBrie);

    }
}
