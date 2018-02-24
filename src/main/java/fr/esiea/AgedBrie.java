package fr.esiea;

public class AgedBrie extends Item{


    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    public void update() {
        if(this.quality >= 0 && this.quality < 50)
            this.updateQuality(1);
        if(this.sellIn > 0)
            this.sellIn--;
    }
}
