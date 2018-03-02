package fr.esiea;

public class AgedBrie extends Item{


    AgedBrie(int sellIn, int quality, boolean cursed) {
        super(Constants.AGEDBRIE_NAME, sellIn, quality, cursed);
    }

    public void update() {
        if(this.quality >= 0 && this.quality < 50)
            this.updateQuality(1);
        if(this.sellIn > 0)
            this.sellIn--;
    }
}
