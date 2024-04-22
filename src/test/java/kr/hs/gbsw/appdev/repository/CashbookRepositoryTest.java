package kr.hs.gbsw.appdev.repository;

import kr.hs.gbsw.appdev.entity.CashbookEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CashbookRepositoryTest {

    @Autowired
    private CashbookRepository cashbookRepository;


    @Test
    public void testFindAllByContentContaining() {
        List<CashbookEntity> list =
                cashbookRepository.findAllByContentContaining("라면");

        for (CashbookEntity entity : list) {
            LoggerFactory.getLogger(getClass()).info("[Cashbook] {}", entity);
        }

        assertEquals(2, list.size());
    }

}