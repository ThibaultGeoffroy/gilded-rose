package fr.esiea;

import java.util.regex.*;
import java.util.ArrayList;

public class GildedRose {
    ArrayList<Item> items = new ArrayList<Item>();

    public GildedRose(ArrayList<Item> items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) item.update();
    }
    
    public void addItem() {
        Item item;
        String name;
        int sellIn, quality;
        Scanner scanner = new Scanner( System.in );
        System.out.print( "Type a name: " );
        name = scanner.nextLine();
        System.out.print( "Type a sell in number: " );
        sellIn = scanner.nextInt();
        System.out.print( "Type a quality number: " );
        quality = scanner.nextInt();
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(name);
        boolean nb = m.matches();
        p = Pattern.compile("[0-9]+");
        m = p.matcher(sellIn);
        boolean sb = m.matches();
        m = p.matcher(quality);
        boolean qb = m.matches();
        if(nb && sb && qb){
            item = new Item(name, sellIn, quality);
            items.add(item);
        }
        else{ 
            System.out.println("Try again !");
        }
    }
    
     public Item returnItem() {
        if(items != null) return items;
        else System.out.println("Items not found");
    }

}
