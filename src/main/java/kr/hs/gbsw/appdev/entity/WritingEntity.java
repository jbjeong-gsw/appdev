package kr.hs.gbsw.appdev.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "writing")
public class WritingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int writingIdx;

    private String title;

    private String content;

    private String writer;

    private String fileName;

    private Date writeTime;
}
