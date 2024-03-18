package kr.hs.gbsw.appdev.controller;

import kr.hs.gbsw.appdev.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolApiController {

    @Autowired
    @Qualifier("gildong")
    private  Student gildong;

    @Autowired
    @Qualifier("student2")
    private Student chunhyang;

    /*public SchoolApiController(Student student) {
        this.gildong = student;
    }*/

    @GetMapping("/student-one")
    public Student getStudent() {
        return gildong;
    }

}
