package kr.hs.gbsw.appdev.bean.dl;

import jakarta.annotation.PostConstruct;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeBean {
    private int count = 0;

    @PostConstruct
    public void prepare() {
        LoggerFactory.getLogger(getClass()).info("PrototypeBean created");
    }

    public int getCount() {
        return count;
    }

    public void addCount() {
        this.count++;
    }
}
