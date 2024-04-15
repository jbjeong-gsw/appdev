package kr.hs.gbsw.appdev.repository;

import kr.hs.gbsw.appdev.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {
}
