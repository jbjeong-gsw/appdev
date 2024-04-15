package kr.hs.gbsw.appdev.service;

import kr.hs.gbsw.appdev.domain.Person;

import java.util.List;

public interface PersonService {

    public Person addPerson(Person person);

    public Person getPerson(int idx);

    public List<Person> list();

}
