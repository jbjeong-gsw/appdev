package kr.hs.gbsw.appdev.controller;

import kr.hs.gbsw.appdev.domain.Cashbook;
import kr.hs.gbsw.appdev.service.CashbookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cashbook")
@RequiredArgsConstructor
public class CashbookController {

    private final CashbookService cashbookService;

    @PostMapping("")
    public Cashbook addCashbook(@RequestBody Cashbook cashbook) {
         return cashbookService.addItemToCashbook(cashbook);
    }

    @GetMapping("")
    public List<Cashbook> listCashbook() {
        return cashbookService.listItems();
    }

    @GetMapping("/{idx}")
    public Cashbook getItem(@PathVariable(value = "idx") int idx) {
        return cashbookService.getCashbookItem(idx);
    }

    @PutMapping("")
    public Cashbook updateItem(@RequestBody Cashbook cashbook) {
        return cashbookService.updateItem(cashbook);
    }

    @DeleteMapping("/{idx}")
    public String deleteItem(@PathVariable(value = "idx") int idx) {
        cashbookService.deleteItem(idx);
        return "success";
    }

}
