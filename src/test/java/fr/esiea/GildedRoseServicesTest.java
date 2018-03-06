package fr.esiea;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GildedRoseServicesTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void test(){
        String[] l = {""};
        GildedRoseServices.main(l);
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/add_item?name=test&quality=10&sellin=10",
                String.class)).contains("Items were added to the inventory");

        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/list_item",
                String.class)).contains("{name: test, sellIn: 10, quality: 10, conjured: false }");
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/buy_item?name=test",
                String.class)).contains("{name: test, sellIn: 10, quality: 10, conjured: false }");
    }

}
