package fr.esiea;

public class ItemFactory {

    private ItemFactory(){}

    public static Item createItem(String name, int sellin, int quality, boolean conjured) throws SellInException, QualityException {
        switch (name){
            case Constants.CONCERT_NAME:
                return new Concert(sellin, quality, conjured);
            case Constants.AGEDBRIE_NAME:
                return new AgedBrie(sellin, quality, conjured);
            case Constants.SULFURAS_NAME:
                return new Sulfuras(sellin, quality, conjured);
            default:
                return new DefaultItem(name, sellin, quality, conjured);
        }
    }
}
