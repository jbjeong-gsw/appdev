package kr.hs.gbsw.appdev.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cashbook")
public class CashbookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cashbookIdx;

    private String content;

    private int amount;

    @Column(name = "use_time", updatable = false)
    private Date inOutTime;

    @Column(updatable = false)
    private String direction;

}
