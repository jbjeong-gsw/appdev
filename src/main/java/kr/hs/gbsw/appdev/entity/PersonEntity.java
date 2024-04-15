package kr.hs.gbsw.appdev.entity;


import jakarta.persistence.*;
import kr.hs.gbsw.appdev.domain.Person;
import lombok.*;
import org.springframework.web.service.annotation.GetExchange;

@Setter
@Getter
@Entity
@Table(name = "person")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    private String name;

    private String email;

    private int age;


    public static PersonEntity toEntity(Person person) {
        return PersonEntity.builder()
                .idx(person.getIdx())
                .name(person.getName())
                .email(person.getEmail())
                .age(person.getAge())
                .build();
    }

    public static Person toDomain(PersonEntity entity) {
        return Person.builder()
                .idx(entity.getIdx())
                .name(entity.getName())
                .email(entity.getEmail())
                .age(entity.getAge())
                .build();
    }

}
