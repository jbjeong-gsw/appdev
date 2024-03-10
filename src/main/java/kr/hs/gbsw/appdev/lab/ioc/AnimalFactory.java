package kr.hs.gbsw.appdev.lab.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnimalFactory {

    @Bean
    public Animal cat() {
        return new Cat();
    }
}
