package alg.laioffer.ood.vendingMVC.repository;

import alg.laioffer.ood.vendingMVC.model.Coin;
import alg.laioffer.ood.vendingMVC.model.Item;

import java.util.List;

/*
do Curd here
 */
public interface VendingMachineRepo {
    void insertItems(List<Item> items);
    boolean outItem(Item item);
    void insertMoney(List<Coin> coins);
    boolean outChanges(Integer change);
}
