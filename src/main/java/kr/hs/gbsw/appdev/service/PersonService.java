package kr.hs.gbsw.appdev.service;

import kr.hs.gbsw.appdev.domain.Person;

public interface PersonService {

    public Person addPerson(Person person);

    public Person getPerson(int idx);

}
