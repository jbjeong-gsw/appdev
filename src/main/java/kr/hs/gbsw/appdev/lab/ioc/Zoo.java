package kr.hs.gbsw.appdev.lab.ioc;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Zoo {
    private final Animal cat;


    public Zoo(Animal cat) {
        System.out.println("constructor of Cat");
        this.cat = cat;
    }

    @PostConstruct
    public void init() {
        System.out.println("init of Zoo " + (cat != null));
    }

}
