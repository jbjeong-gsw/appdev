package kr.hs.gbsw.appdev.service.impl;

import kr.hs.gbsw.appdev.domain.Cashbook;
import kr.hs.gbsw.appdev.service.CashbookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class CashbookServiceImplTest {

    @Autowired
    private CashbookService cashbookService;

    @Test
    public void notNull() {
        assertNotNull(cashbookService);

        Cashbook cashbook = cashbookService.getCashbookItem(1);
        System.out.println(cashbook);

        assertNotNull(cashbook);
    }

}