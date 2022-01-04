package com.ivca.interviews;

public class GoldCoins implements ItemState {
    private Inventory.Item item;

    public GoldCoins(Inventory.Item item) {
        this.item = item;
    }

    @Override
    public void track() {
    }
}
