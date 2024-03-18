package kr.hs.gbsw.appdev.controller;

import kr.hs.gbsw.appdev.bean.ApplicationContextViewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequiredArgsConstructor
public class HelloApiController {

    @Autowired
    private ApplicationContextViewer applicationContextViewer;


    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring";
    }

    @GetMapping("/beans")
    public String[] beanNames() {
        return applicationContextViewer.getBeans();
    }



}
