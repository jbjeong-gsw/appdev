package kr.hs.gbsw.appdev.service.impl;

import kr.hs.gbsw.appdev.domain.Person;
import kr.hs.gbsw.appdev.entity.PersonEntity;
import kr.hs.gbsw.appdev.repository.PersonRepository;
import kr.hs.gbsw.appdev.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        Optional<PersonEntity> optional = personRepository.findById(idx);
        PersonEntity entity = optional.orElse(null);

        if (entity != null) {
            return PersonEntity.toDomain(entity);
        } else {
            return null;
        }
    }

    @Override
    public List<Person> list() {
        List<PersonEntity> list = personRepository.findAll();

        List<Person> result = new ArrayList<>();

        for (PersonEntity entity : list) {
            result.add(PersonEntity.toDomain(entity));
        }

        return result;
    }

    @Override
    public Page<Person> list(int pageNumber, int count) {



        return null;
    }
}
