package kr.hs.gbsw.appdev.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class SchoolConfiguration {

    @Bean(value = "gildong")
    @Scope("prototype")
    public Student student1() {
        System.out.println("길동 생성중");
        Student student = new Student();
        student.setName("홍길동");
        return student;
    }

    @Bean
    public Student student2() {
        System.out.println("춘향 생성중");
        Student student = new Student();
        student.setName("성춘향");
        return student;
    }


}
