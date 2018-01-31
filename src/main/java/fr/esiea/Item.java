package fr.esiea;

public abstract class Item {

    public String name;

    public int sellIn;

    public int quality;

    public boolean conjured = false;


    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public Item(String name, int sellIn, int quality, boolean conjured) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.conjured = conjured
    }

    public abstract Item update(Item item);
}