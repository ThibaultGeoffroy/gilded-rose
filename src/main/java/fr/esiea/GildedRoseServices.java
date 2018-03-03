package fr.esiea;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class GildedRoseServices {

    GildedRose gildedRose = new GildedRose();


    public static void main(String[] args) {
        SpringApplication.run(GildedRoseServices.class, args);
    }

/*
    @RequestMapping("/")
    String index() {
        return "index";
    }

*/
    @RequestMapping("/create_user")
    String createUser() {
        System.out.println("User_created");

        return "User_created";
    }
}


