package kr.hs.gbsw.appdev.lab.ioc;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Zoo1 {
    @Autowired
    private Animal cat;

    @PostConstruct
    public void init() {
        System.out.println("init of Zoo1 " + (cat != null));
    }

}
