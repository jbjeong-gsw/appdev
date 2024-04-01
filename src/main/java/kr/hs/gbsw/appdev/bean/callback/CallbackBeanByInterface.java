package kr.hs.gbsw.appdev.bean.callback;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class CallbackBeanByInterface implements InitializingBean, DisposableBean {
    /*
        InitializingBean 에 선언되어 있음
        Bean이 생성되고 의존성 주입이 일어난 이후에 스프링에 의해서 호출됨
    */
    @Override
    public void afterPropertiesSet() throws Exception {
        LoggerFactory.getLogger(getClass()).info("CallbackBeanByInterface Bean의 afterPropertiesSet 호출됨");
    }

    /*
        DisposableBean 에 선언되어 있음
        Bean이 소멸되기 전에 호출됨
    */
    @Override
    public void destroy() throws Exception {
        LoggerFactory.getLogger(getClass()).info("CallbackBeanByInterface Bean의 destroy 호출됨");
    }
}
