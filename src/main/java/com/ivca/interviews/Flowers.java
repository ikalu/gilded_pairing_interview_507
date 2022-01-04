package com.ivca.interviews;

public class Flowers implements ItemState, ItemPrice {
    private Inventory.Item item;

    public Flowers(Inventory.Item item) {
        this.item = item;
    }

    @Override
    public void track() {
        reducePrice();
        reduceSellByByOne();

        if (isPastSellBy())
            reducePrice();
    }

    private boolean isPastSellBy() {
        return item.sellBy < 0;
    }

    private void reducePrice() {
        item.price -=2;
    }

    private void reduceSellByByOne() {
        item.sellBy -=1;
    }

}
