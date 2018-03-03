package fr.esiea;

public abstract class Item {

    public String name;
    public int sellIn;
    public int quality;

    public boolean conjured = false;

    public Item(String name, int sellIn, int quality, boolean conjured) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.conjured = conjured;
    }

    public abstract void update();

    protected void updateQuality(int value){
        if(this.conjured && value <0){
            this.quality = this.quality + value*2;
        } else {
            this.quality += value;
        }
        if(this.quality < 0){
            this.quality = 0;
        }
    }

    protected void resetQuality(){
        this.quality = 0;
    }


    public String toString() {
        return "name:" + this.name + ", sellIn:" + this.sellIn + ", quality:" + this.quality + ", conjured:" + this.conjured;

    }

}

