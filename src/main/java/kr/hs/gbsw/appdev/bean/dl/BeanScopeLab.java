package kr.hs.gbsw.appdev.bean.dl;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class BeanScopeLab {
    private final ObjectProvider<SingletonBean> singletonBeanObjectProvider;
    private final ObjectProvider<PrototypeBean> prototypeBeanObjectProvider;

    @PostConstruct
    public void compareScopes() {
        SingletonBean singletonBean1 = singletonBeanObjectProvider.getObject();
        SingletonBean singletonBean2 = singletonBeanObjectProvider.getObject();
        PrototypeBean prototypeBean1 = prototypeBeanObjectProvider.getObject();
        PrototypeBean prototypeBean2 = prototypeBeanObjectProvider.getObject();

        singletonBean1.addCount();
        log.info("SingletonBean count : {} ", singletonBean2.getCount());   // 1

        prototypeBean1.addCount();
        log.info("PrototypeBean count : {} ", prototypeBean2.getCount());   // 0
    }
}
