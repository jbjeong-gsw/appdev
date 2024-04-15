package kr.hs.gbsw.appdev.service.impl;

import kr.hs.gbsw.appdev.domain.Person;
import kr.hs.gbsw.appdev.entity.PersonEntity;
import kr.hs.gbsw.appdev.repository.PersonRepository;
import kr.hs.gbsw.appdev.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Primary
public class DatabasePersonService implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public Person addPerson(Person person) {
        PersonEntity entity = PersonEntity.toEntity(person);

        personRepository.save(entity);

        person.setIdx(entity.getIdx());

        return person;
    }

    @Override
    public Person getPerson(int idx) {
        return null;
    }
}
