package fr.esiea;

public class Concert extends Item {

    Concert(int SellIn, int quality, boolean cursed) throws QualityException, SellInException{
        super(Constants.CONCERT_NAME, SellIn, quality, cursed);
        if(this.quality > 50) {
            throw new QualityException("Quality of a Concert object must be under 50");
        } else if(this.quality < 0) {
            throw new QualityException("Quality of a Concert object must be over 0");
        }
        if(this.sellIn <= 0){
            throw new SellInException("Sellin of a Concert object must be over 0");
        }
    }

    public void update() {
        if(this.sellIn < 0){
            this.resetQuality();
        }else if(this.sellIn < 5){
            this.updateQuality(3);
        }else if(this.sellIn < 10){
            this.updateQuality(2);
        }else{
            this.updateQuality(1);
        }
        this.sellIn --;
    }
}
