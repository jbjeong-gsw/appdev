package kr.hs.gbsw.appdev.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Calendar;
import java.util.Date;

@Configuration
public class MyConfiguration {

    @Bean
    @Primary
    public Date march1stMovement() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 1919);
        calendar.set(Calendar.MONTH, 2);
        calendar.set(Calendar.DATE, 1);

        return new Date(calendar.getTimeInMillis());
    }


    @Bean(value = "independenceDayOfKorea")
    public Date date2() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 1945);
        calendar.set(Calendar.MONTH, 7);
        calendar.set(Calendar.DATE, 15);

        return new Date(calendar.getTimeInMillis());
    }
}
