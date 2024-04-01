package kr.hs.gbsw.appdev.bean.callback;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CallbackConfiguration {
    /*
        Bean 을 생성할 때, initMethod와 destroyMethod 속성으로
        콜백 메소드의 이름을 지정해 줍니다.
     */
    @Bean(initMethod = "prepare", destroyMethod = "clear")
    public CallbackBeanByConfiguration callbackBean() {
        return new CallbackBeanByConfiguration();
    }
}
