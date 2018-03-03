package fr.esiea;

public class ItemFactory {

    public static Item createItem(String name, int sellin, int quality, boolean cursed) throws SellInException, QualityException {
        switch (name){
            case Constants.CONCERT_NAME:
                return new Concert(sellin, quality, cursed);
            case Constants.AGEDBRIE_NAME:
                return new AgedBrie(sellin, quality, cursed);
            case Constants.SULFURAS_NAME:
                return new Sulfuras(sellin, quality, cursed);
            default:
                return new DefaultItem(name, sellin, quality, cursed);
        }
    }
}
