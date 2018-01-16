package fr.esiea;

public class AgedBrie extends Item{

    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    public AgedBrie() {
        super("Aged Brie", 0, 0);
    }

    public Item update(Item item) {
        if(item.quality >= 0 && item.quality < 50)
            item.quality++;
        if(item.sellIn > 0)
            item.sellIn--;
        return item;
    }
}
