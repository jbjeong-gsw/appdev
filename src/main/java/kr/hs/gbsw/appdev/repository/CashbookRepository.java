package kr.hs.gbsw.appdev.repository;

import kr.hs.gbsw.appdev.entity.CashbookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CashbookRepository
        extends JpaRepository<CashbookEntity, Integer> {

    public List<CashbookEntity> findAllByDirection(String direction);

    public List<CashbookEntity> findAllByContentContaining(String content);


}
