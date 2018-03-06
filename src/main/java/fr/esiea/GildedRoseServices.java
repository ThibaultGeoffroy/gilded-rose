package fr.esiea;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@EnableScheduling
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
     * @param conjured    Is the Item conjured or not
     * @param quantity  quantity of item to be created
     * @return  A message saying that the items were created.
     * @throws RuntimeException
     */
    @RequestMapping("/add_item")
    String addItem(
            @RequestParam("name") String name,
            @RequestParam("quality") int quality,
            @RequestParam("sellin") int sellin,
            @RequestParam(name="conjured", defaultValue = "false") boolean conjured,
            @RequestParam(name="quantity", defaultValue= "1") int quantity) throws RuntimeException {

        for (int i = 0; i < quantity; i++) {
            gildedRose.addItem(ItemFactory.createItem(name, sellin, quality, conjured));
        }
        return "Items were added to the inventory";
    }


    /**
     * Update the gilded rose and decrease sellin of items and change their quality
     */
    @Scheduled(fixedRate = 15000)
    public void updateGildedRose() {
        gildedRose.updateQuality();
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

    @RequestMapping("/list_item")
    String ListItem() throws SellInException, QualityException {
        return "Les items pouvant etre vendus sont:" + gildedRose.getItems().toString();
    }



}


