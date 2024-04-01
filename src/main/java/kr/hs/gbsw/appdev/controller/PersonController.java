package kr.hs.gbsw.appdev.controller;

import kr.hs.gbsw.appdev.domain.Person;
import kr.hs.gbsw.appdev.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PersonController {

    private final PersonService personService;

    @PostMapping(value = "/person/add")
    public void addPerson(@RequestParam(value = "name") String name,
                          @RequestParam(value = "email") String email,
                          @RequestParam(value = "age") int age) {
        log.info("/person/add 호출됨  {} {} {}", name, email, age);

    }

    @PostMapping(value = "/person/add2")
    public void addPerson(@ModelAttribute Person person) {
        log.info("/person/add2 호출됨  {}", person);
    }

    @PostMapping(value = "/person/add3")
    public Person addPerson3(@RequestBody Person person) {
        log.info("/person/add3 호출됨  {}", person);

        return personService.addPerson(person);
    }

    @GetMapping(value = "/person/{idx}")
    public Person readPerson(@PathVariable(value = "idx") int idx) {
        return personService.getPerson(idx);
    }

}
