package kr.hs.gbsw.appdev.bean.callback;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CallbackBeanByAnnotation {
    /*
        Bean이 생성되고 의존성 주입이 일어난 이후에 스프링에 의해서 호출됨
    */
    @PostConstruct
    public void init() throws Exception {
        LoggerFactory.getLogger(getClass()).info("CallbackBeanByAnnotation Bean의 init 호출됨");
    }

    /*
        Bean이 소멸되기 전에 호출됨
    */
    @PreDestroy
    public void close() throws Exception {
        LoggerFactory.getLogger(getClass()).info("CallbackBeanByAnnotation Bean의 close 호출됨");
    }
}
