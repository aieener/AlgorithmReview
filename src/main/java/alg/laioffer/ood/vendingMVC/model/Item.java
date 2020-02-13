package alg.laioffer.ood.vendingMVC.model;

import java.math.BigDecimal;

/*
if in the database, then item entity would be defined as
Item {
    quantity: number
    name: string
    unitPrice : bigDecimal
}
 */
public class Item {
    private int id;
    private long quantity;
    private String name;
    private BigDecimal unitPrice;

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
}
