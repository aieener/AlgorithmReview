package alg.laioffer.ood.vendingmachine;

import java.util.List;
/*
    the vendingMachine is very much like a mini version of online shop! review shixiong Liao's design
 */
public interface VendingMachine {
    public long selectItemAndGetPrice(Item item);
    public void insertCoin (Coin coin);
    public List<Coin> refund();
    public Bucket<Item, List<Coin>> collectItemAndChange();
    public void reset();
}
