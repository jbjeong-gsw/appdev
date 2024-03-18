package kr.hs.gbsw.appdev.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextViewer {

    @Autowired
    private ApplicationContext applicationContext;


    public String[] getBeans() {
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {

        }
        return names;
    }

    public void getBean(String beanName) {

    }

}
