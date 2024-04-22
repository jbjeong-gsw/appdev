package kr.hs.gbsw.appdev.service;

import kr.hs.gbsw.appdev.domain.Cashbook;

import java.util.List;

public interface CashbookService {

    public Cashbook addItemToCashbook(Cashbook cashbook);

    public Cashbook getCashbookItem(int idx);

    public List<Cashbook> listItems();

    public Cashbook updateItem(Cashbook cashbook);

    public void deleteItem(int idx);

}
