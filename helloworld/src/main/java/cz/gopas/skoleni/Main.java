package cz.gopas.skoleni;

import cz.gopas.skoleni.service.ItemService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan // skenuje aktualni balicek a vsechny podbalicky
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(Main.class);
        ItemService itemService = applicationContext.getBean(ItemService.class);
        System.out.println(itemService.getItemCount());
    }

}
