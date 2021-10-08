package cz.gopas.eshopweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {


    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("jirka"));
        System.out.println(passwordEncoder.encode("jirka"));
        System.out.println(passwordEncoder.encode("jirka"));
        System.out.println(passwordEncoder.encode("jirka"));
        System.out.println(passwordEncoder.encode("jirka"));

        System.out.println(passwordEncoder.matches("jirka", "$2a$10$lqSyzI3YSIufhq0YNqTG1uQNk9hf9F.sc2iDu560HTy7PqdfpRtGe"));

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                // POZOR! Na poradi antMatchers ZALEZI !!!
                .antMatchers("/actuator/**")
                .hasRole("ADMIN")
                .antMatchers("/**")
                .hasRole("USER")
                .and()
                .formLogin()
                .and()
                .httpBasic()
                .and()
                .logout()
                .and()
                .rememberMe();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.builder()
                        .username("jirka")
//                        .password("{noop}jirka")
                        .password("{bcrypt}$2a$10$lqSyzI3YSIufhq0YNqTG1uQNk9hf9F.sc2iDu560HTy7PqdfpRtGe")
                        .roles("USER")
                        .build();
        return new InMemoryUserDetailsManager(user);
    }
}