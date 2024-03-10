package kr.hs.gbsw.appdev.lab.ioc;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public class Cat implements Animal {

    @Override
    public String getName() {
        return "고양이";
    }

    @Override
    public String makeSound() {
        return "야옹";
    }
}
