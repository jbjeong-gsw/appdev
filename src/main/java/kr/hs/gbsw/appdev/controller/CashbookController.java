package kr.hs.gbsw.appdev.controller;

import kr.hs.gbsw.appdev.domain.Cashbook;
import kr.hs.gbsw.appdev.service.CashbookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cashbook")
@RequiredArgsConstructor
public class CashbookController {

    private final CashbookService cashbookService;

    @PostMapping("")
    public Cashbook addCashbook(@RequestBody Cashbook cashbook) {
         return cashbookService.addItemToCashbook(cashbook);
    }

}
