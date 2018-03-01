package fr.esiea;

import java.util.ArrayList;

public class GildedRose {
    protected ArrayList<Item> items;

    public GildedRose() {
        this.items = new ArrayList<>();
    }

    public void updateQuality() {
        for (Item item : items) item.update();
    }
    
    public void addItem(Item i) {
       this.items.add(i);
    }
    
     public ArrayList<Item> getItems() {
        return this.items;
    }

}
