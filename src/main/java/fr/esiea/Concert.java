package fr.esiea;

public class Concert extends Item {

    final int MAXQUALITY = 50;


    public Concert(int SellIn, int quality, boolean cursed) {
        super(Constants.CONCERT_NAME, SellIn, quality, cursed);
        if(this.quality > MAXQUALITY)
            this.quality = MAXQUALITY;
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
