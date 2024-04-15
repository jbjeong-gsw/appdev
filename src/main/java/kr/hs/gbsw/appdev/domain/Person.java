package kr.hs.gbsw.appdev.domain;

import kr.hs.gbsw.appdev.entity.PersonEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    private int idx;

    private String name;

    private String email;

    private int age;


}
