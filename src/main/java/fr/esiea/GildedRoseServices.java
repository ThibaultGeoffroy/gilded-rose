package fr.esiea;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class GildedRoseServices {

    GildedRose gildedRose = new GildedRose();


    public static void main(String[] args) {
        SpringApplication.run(GildedRoseServices.class, args);
    }

    /**
     * Add an Item in Gilded Rose
     * @param name  name of the Item
     * @param quality   Quality of the Item
     * @param sellin    Sellin of the Item
     * @param cursed    Is the Item cursed or not
     * @param quantity  quantity of item to be created
     * @return  A message saying that the items were created.
     * @throws RuntimeException
     */
    @RequestMapping("/add_item")
    String addItem(
            @RequestParam("name") String name,
            @RequestParam("quality") int quality,
            @RequestParam("sellin") int sellin,
            @RequestParam(name="cursed", defaultValue = "false") boolean cursed,
            @RequestParam(name="quantity", defaultValue= "1") int quantity) throws RuntimeException{

        for (int i = 0; i < quantity; i++) {
            gildedRose.addItem(ItemFactory.createItem(name, sellin, quality, cursed));
        }

        return "All items have been added";
    }

    /**
     * Allow you to buy an item and remove it from the Gilded Rose inventory
     * @param name name of the item you want to buy
     * @return A message saying that the item was bought
     * @throws RuntimeException
     */
    @RequestMapping("/buy_item")
    String buyItem(@RequestParam("name") String name) throws RuntimeException{
            Item i = gildedRose.buyItem(name);

        return i.toString();
    }



}


