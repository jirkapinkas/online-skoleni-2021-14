package cz.gopas.skoleni;

import com.zaxxer.hikari.HikariDataSource;
import cz.gopas.skoleni.service.ItemService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan // skenuje aktualni balicek a vsechny podbalicky
public class Main {

    @Bean
    public HikariDataSource dataSource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:hsqldb:hsql://localhost/eshop");
        ds.setUsername("sa");
        ds.setPassword("");
        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource()); // TODO vratit se sem!!!
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(Main.class);
        ItemService itemService = applicationContext.getBean(ItemService.class);
        System.out.println(itemService.getItemCount());
    }

}
