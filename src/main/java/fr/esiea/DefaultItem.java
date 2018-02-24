package fr.esiea;

public class DefaultItem extends Item{

    private static final int MAXQUALITY = 50;

    public DefaultItem(String name, int SellIn, int quality) {
        super(name, SellIn, quality);
        if(this.quality > MAXQUALITY)
            this.quality = MAXQUALITY;
    }

    public DefaultItem(String name, int SellIn, int quality, boolean cursed) {
        super(name, SellIn, quality, cursed);
        if(this.quality > MAXQUALITY)
            this.quality = MAXQUALITY;
    }



    public void update(){
        if(this.sellIn > 0){
            this.updateQuality(-1);
        }else {
            this.updateQuality(-2);
        }
    }
}
