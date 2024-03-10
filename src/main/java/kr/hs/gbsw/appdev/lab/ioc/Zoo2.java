package kr.hs.gbsw.appdev.lab.ioc;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Zoo2 {
    private Animal cat;


    @Autowired
    public void setCat(Cat cat) {
        this.cat = cat;
    }

    @PostConstruct
    public void init() {
        System.out.println("init of Zoo2 " + (cat != null));
    }

}
