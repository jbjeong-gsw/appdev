package kr.hs.gbsw.appdev.service;

import kr.hs.gbsw.appdev.domain.Person;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PersonService {

    public Person addPerson(Person person);

    public Person getPerson(int idx);

    public List<Person> list();

    public Page<Person> list(int pageNumber, int count);


}
