package kr.hs.gbsw.appdev.repository;

import kr.hs.gbsw.appdev.entity.CashbookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashbookRepository
        extends JpaRepository<CashbookEntity, Integer> {
}
