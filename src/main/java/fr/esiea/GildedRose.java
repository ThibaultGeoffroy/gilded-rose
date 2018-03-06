package fr.esiea;

import java.util.ArrayList;

public class GildedRose {
    protected ArrayList<Item> items = new ArrayList<>();

    public GildedRose() {
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

    public Item buyItem(String name) throws NoItemException{
        Item i = items.stream().filter(item -> item.name.equals(name)).findAny().orElse(null);
        if(i != null){
            items.remove(i);
        }else{
            throw new NoItemException("This item is not available available in Gilded Rose.");
        }
        return i;

    }
}

