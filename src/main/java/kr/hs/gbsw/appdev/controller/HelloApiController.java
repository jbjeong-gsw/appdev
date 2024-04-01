package kr.hs.gbsw.appdev.controller;

import kr.hs.gbsw.appdev.bean.dl.PrototypeBean;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequiredArgsConstructor
public class HelloApiController {

    @Autowired
    private ObjectProvider<PrototypeBean> beanProvider;

    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring";
    }

    @GetMapping("/count")
    public int count() {
        PrototypeBean bean = beanProvider.getObject();
        bean.addCount();;

        return bean.getCount();
    }

}
