package kr.hs.gbsw.appdev.bean;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MyComponent {

    private final Date date;

    public MyComponent(@Qualifier("independenceDayOfKorea") Date independenceDayOfKorea) {
        this.date = independenceDayOfKorea;
    }

    @PostConstruct
    public void prepare() {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date));
    }

    // ......
}
