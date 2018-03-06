package fr.esiea;

public class DefaultItem extends Item{

    DefaultItem(String name, int SellIn, int quality, boolean conjured) throws QualityException, SellInException{
        super(name, SellIn, quality, conjured);
        if(this.quality > 50) {
            throw new QualityException("Quality of a DefaultItem object must be under 50");
        } else if(this.quality < 0) {
            throw new QualityException("Quality of a DefaultItem object must be over 0");
        }
        if(this.sellIn < 0){
            throw new SellInException("Sellin of a DefaultItem object must be over 0");
        }
    }

    public void update(){
        if(this.sellIn > 0){
            this.updateQuality(-1);
        }else {
            this.updateQuality(-2);
        }
        this.sellIn --;
    }
}
