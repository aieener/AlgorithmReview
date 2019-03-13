package OOD_JRI_VendingMachine;


import java.util.*;

public class VendingMachineImpl implements VendingMachine {
    private Inventory<Coin> cashInventory = new Inventory<>();
    private Inventory<Item> itemInventory = new Inventory<>();
    private long totalSales;
    private Item curItem;
    private long curBalance;

    public VendingMachineImpl() {
        for(Coin c : Coin.values()) {
            cashInventory.put(c, 5);
        }

        for(Item i : Item.values()) {
            itemInventory.put(i, 5);
        }
    }

    @Override
    public long selectItemAndGetPrice(Item item) throws SoldOutException {
        if(itemInventory.hasItem(item)) {
            curItem = item;
            return curItem.getPrice();
        }
        throw new SoldOutException("Sold Out, Please buy another item");
    }

    @Override
    public void insertCoin(Coin coin) {
        curBalance = curBalance + coin.getDenomination();
        cashInventory.add(coin);
    }

    @Override
    public List<Coin> refund() {
        List<Coin> refund = getChange(curBalance);
        updateCashInventory(refund);
        curBalance = 0;
        curItem = null;
        return refund;
    }

    @Override
    public Bucket<Item, List<Coin>> collectItemAndChange() {
        Item item = collectItem();
        totalSales = totalSales + curItem.getPrice();
        List<Coin> change = collectChage();
        return new Bucket<>(item, change);
    }

    @Override
    public void reset() {
        cashInventory.clear();
        itemInventory.clear();
        totalSales = 0;
        curItem = null;
        curBalance = 0;
    }

    private Item collectItem() throws NotSufficientChangeException, NotFullPaidException {
        if(isFullPaid()) {
            if(hasSufficientChange()) {
                itemInventory.deduct(curItem);
                return curItem;
            }
            throw new NotSufficientChangeException("Not Sufficient Change!");
        }
        long remainingBalance = curItem.getPrice() - curBalance;
        throw new NotFullPaidException("Price Not fully paid", remainingBalance);
    }

    private List<Coin> collectChage() {
        long changeAmount = curBalance - curItem.getPrice();
        List<Coin> change = getChange(changeAmount);
        updateCashInventory(change);
        curBalance = 0;
        curItem = null;
        return change;
    }

    private void updateCashInventory(List<Coin> change) {
        for(Coin c : change) {
            cashInventory.deduct(c);
        }
    }

    private boolean isFullPaid() {
        if(curBalance >= curItem.getPrice()) {
            return true;
        }
        return false;
    }

    private boolean hasSufficientChange() {
        return hasSufficientChangeForAmount(curBalance - curItem.getPrice()) ;
    }

    private boolean hasSufficientChangeForAmount(long amount) {
        try {
            getChange(amount);
        } catch (NotSufficientChangeException nsce) {
            return false;
        }
        return true;
    }

    private List<Coin> getChange(long amount) throws NotSufficientChangeException {
        List<Coin> changes = new ArrayList<>();
        if(amount > 0) {
            long balance = amount;
            while(balance > 0) {
                if (balance >= Coin.QUARTER.getDenomination() && cashInventory.hasItem(Coin.QUARTER)) {
                    changes.add(Coin.QUARTER);
                    balance = balance - Coin.QUARTER.getDenomination();
                    continue;
                } else if (balance >= Coin.DIME.getDenomination() && cashInventory.hasItem(Coin.DIME)) {
                    changes.add(Coin.DIME);
                    balance = balance - Coin.DIME.getDenomination();
                    continue;
                } else if (balance >= Coin.NICKLE.getDenomination() && cashInventory.hasItem(Coin.NICKLE)) {
                    changes.add(Coin.NICKLE);
                    balance = balance - Coin.NICKLE.getDenomination();
                    continue;
                } else if (balance >= Coin.PENNY.getDenomination() && cashInventory.hasItem(Coin.PENNY)) {
                    changes.add(Coin.PENNY);
                    balance = balance - Coin.PENNY.getDenomination();
                    continue;
                } else {
                    throw new NotSufficientChangeException("Not Sufficient change!");
                }
            }
        }
        return changes;
    }

    public long getTotalSales() {
        return totalSales;
    }
}
