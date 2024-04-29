package kr.hs.gbsw.appdev.service.impl;

import kr.hs.gbsw.appdev.domain.Person;
import kr.hs.gbsw.appdev.service.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimplePersonService implements PersonService {

    private final List<Person> list = new ArrayList<>();

    private int count = 0;

    @Override
    public Person addPerson(Person person) {
        count++;
        person.setIdx(count);

        list.add(person);
        return person;
    }

    @Override
    public Person getPerson(int idx) {
        for (Person person : list) {
            if (person.getIdx() == idx) {
                return person;
            }
        }

        throw new RuntimeException("not found");
    }

    @Override
    public List<Person> list() {
        return list;
    }

    @Override
    public Page<Person> list(int pageNumber, int count) {
        return null;
    }
}
