package kr.hs.gbsw.appdev.bean.dl;

import jakarta.annotation.PostConstruct;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class PrototypeBeanUser {

    private final ObjectProvider<PrototypeBean> prototypeBeanObjectProvider;

    public PrototypeBeanUser(ObjectProvider<PrototypeBean> prototypeBeanObjectProvider) {
        this.prototypeBeanObjectProvider = prototypeBeanObjectProvider;
    }

    @PostConstruct
    public void execute() {
        PrototypeBean bean1 = prototypeBeanObjectProvider.getObject();
        PrototypeBean bean2 = prototypeBeanObjectProvider.getObject();

        bean1.addCount();
        LoggerFactory.getLogger(getClass()).info("Count Of bean2 - {}", bean2.getCount());

    }

}
