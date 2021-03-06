package alg.laioffer.ood.vendingmachine;

public enum Item {
    COKE("Coke", 25), PESPI("Pepsi", 35), SODA("Soda", 45);

    private String name;
    private int price;

    private Item(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }
}
