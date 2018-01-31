package fr.esiea;

public class DefaultItem extends Item{

    private static final int MAXQUALITY = 50;

    public DefaultItem(String name, int SellIn, int quality) {
        super(name, SellIn, quality);
        if(this.quality > MAXQUALITY)
            this.quality = MAXQUALITY;

    }


    public Item update(Item item){
        if(item.sellIn > 0){
            if( item.quality > 0){
                item.quality--;
                if (item.conjured == true)
                    item.quality--;
            }

            item.sellIn--;
        }
        else{
            if(item.quality > 1 )
                item.quality -= 2;
            else if (item.quality > 0)
                item.quality--;
        }
        return item;
    }
}
