package kr.hs.gbsw.appdev.bean;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ComponentForBeanProvider {

    private final ObjectProvider<Date> dateProvider;

    public ComponentForBeanProvider(ObjectProvider<Date> dateProvider) {
        this.dateProvider = dateProvider;
    }

    @PostConstruct
    public void prepare() {

        Date date1 = dateProvider.getObject();
        System.out.println("Provider Component - " + new SimpleDateFormat("yyyy-MM-dd").format(date1));

    }

}
