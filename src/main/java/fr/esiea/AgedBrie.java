package fr.esiea;

public class AgedBrie extends Item{


    AgedBrie(int sellIn, int quality, boolean conjured) throws QualityException, SellInException{
        super(Constants.AGEDBRIE_NAME, sellIn, quality, conjured);
        if(this.quality > 50) {
            throw new QualityException("Quality of a AgedBrie object must be under 50");
        } else if(this.quality <= 0) {
            throw new QualityException("Quality of a AgedBrie object must be over 0");
        }
        if(this.sellIn <= 0){
            throw new SellInException("Sellin of a AgedBrie object must be over 0");
        }
    }

    public void update() {
        if(this.quality >= 0 && this.quality < 50)
            this.updateQuality(1);
        if(this.sellIn > 0)
            this.sellIn--;
    }
}
