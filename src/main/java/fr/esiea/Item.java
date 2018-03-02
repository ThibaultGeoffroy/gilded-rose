package fr.esiea;

public abstract class Item {

    public String name;
    public int sellIn;
    public int quality;

    public boolean cursed = false;


    protected Item(String name, int sellIn, int quality, boolean cursed) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.cursed = cursed;
    }

    public abstract void update();

    void updateQuality(int value){
        if(this.cursed && value <0){
            this.quality = this.quality + value*2;
        }else{
            this.quality += value;
        }
        if(this.quality < 0){
            this.quality = 0;
        }
    }

    void resetQuality(){
        this.quality = 0;
    }
}