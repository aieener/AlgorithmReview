package alg.laioffer.ood.vendingMVC.repository;

import alg.laioffer.ood.vendingMVC.model.Coin;
import alg.laioffer.ood.vendingMVC.model.Item;

import java.util.List;

public class VendingMachineRepoImpl implements VendingMachineRepo{
    @Override
    public void insertItems(List<Item> items) {

    }

    @Override
    public boolean outItem(Item item) {
        return false;
    }

    @Override
    public void insertMoney(List<Coin> coins) {

    }

    @Override
    public boolean outChanges(Integer change) {
        return false;
    }
}
