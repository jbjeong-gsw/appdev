package kr.hs.gbsw.appdev.service.impl;

import kr.hs.gbsw.appdev.domain.Cashbook;
import kr.hs.gbsw.appdev.entity.CashbookEntity;
import kr.hs.gbsw.appdev.repository.CashbookRepository;
import kr.hs.gbsw.appdev.service.CashbookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CashbookServiceImpl implements CashbookService {

    private final CashbookRepository cashbookRepository;

    @Override
    public Cashbook addItemToCashbook(Cashbook cashbook) {
        CashbookEntity entity = Cashbook.toEntity(cashbook);
        entity.setInOutTime(new Date());

        cashbookRepository.save(entity);

        return getCashbookItem(entity.getCashbookIdx());
    }

    @Override
    public Cashbook getCashbookItem(int idx) {
        Optional<CashbookEntity> optional = cashbookRepository.findById(idx);

        /*
        if (optional.isPresent()) {
            CashbookEntity entity = optional.get();
        } else {
            throw new RuntimeException("not found");
        }
         */

        CashbookEntity entity =
                optional.orElseThrow(() -> new RuntimeException("not found"));

        return Cashbook.toDomain(entity);
    }

    @Override
    public List<Cashbook> listItems() {
        return null;
    }

    @Override
    public Cashbook updateItem(Cashbook cashbook) {
        return null;
    }

    @Override
    public void deleteItem(int idx) {

    }
}
