package kr.hs.gbsw.appdev.bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = "mySchoolBean")
public class School {

    @Autowired
    @Qualifier("gildong")
    private Student student1;

    @Autowired
    private Student student2;


    @PostConstruct
    public void before() {
        System.out.println("mySchoolBean 이 준비되다.");
        System.out.println(student1.getName() +
                "  " + student2.getName());
    }

    @PreDestroy
    public void after() {
        System.out.println("mySchoolBean 이 수명을 다하다.");
    }

}
