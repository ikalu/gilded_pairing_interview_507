package com.ivca.interviews;

public class GoldCoins implements ItemState, ItemPrice {
    private Inventory.Item item;
    int MAXIMUM_PRICE = 80;

    public GoldCoins(Inventory.Item item) {
        this.item = item;
    }

    @Override
    public boolean isMoreThanMaximumPrice(Inventory.Item item) {
        return item.price > MAXIMUM_PRICE;
    }

    @Override
    public void setMaximumPrice(Inventory.Item item) {
        item.price = MAXIMUM_PRICE;
    }
}
