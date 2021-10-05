package cz.gopas.skoleni;

import com.zaxxer.hikari.HikariDataSource;
import cz.gopas.skoleni.service.ItemService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@ComponentScan // skenuje aktualni balicek a vsechny podbalicky
public class Main {

    @Profile("jdbc")
    @Bean
    public HikariDataSource dataSource(@Value("${java.version}") String javaVersion) {
        System.out.println("java version = " + javaVersion);
        var dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:hsqldb:hsql://localhost/eshop");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }

//    @Profile("jdbc")
//    @Bean
//    public JdbcTemplate jdbcTemplate() {
//        return new JdbcTemplate(dataSource());
//    }

    @Profile("jdbc")
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext();
        if(applicationContext.getEnvironment().getActiveProfiles().length == 0) {
            applicationContext.getEnvironment().setActiveProfiles("dummy");
        }
        applicationContext.register(Main.class);
        applicationContext.refresh();
        // NEBO:
        // -Dspring.profiles.active=jdbc
//        AnnotationConfigApplicationContext applicationContext
//                = new AnnotationConfigApplicationContext(Main.class);
        ItemService itemService = applicationContext.getBean(ItemService.class);
        System.out.println(itemService.getItemCount());
    }

}
