package kr.hs.gbsw.appdev.domain;

import jakarta.persistence.Column;
import kr.hs.gbsw.appdev.entity.CashbookEntity;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cashbook {

    private int cashbookIdx;

    private String content;

    private int amount;

    private Date inOutTime;

    private String direction;

    public static CashbookEntity toEntity(Cashbook cashbook) {
        return CashbookEntity.builder()
                .cashbookIdx(cashbook.getCashbookIdx())
                .content(cashbook.getContent())
                .amount(cashbook.getAmount())
                .inOutTime(cashbook.getInOutTime())
                .direction(cashbook.getDirection())
                .build();
    }

    public static Cashbook toDomain(CashbookEntity entity) {
        return Cashbook.builder()
                .cashbookIdx(entity.getCashbookIdx())
                .content(entity.getContent())
                .amount(entity.getAmount())
                .inOutTime(entity.getInOutTime())
                .direction(entity.getDirection())
                .build();
    }
}
