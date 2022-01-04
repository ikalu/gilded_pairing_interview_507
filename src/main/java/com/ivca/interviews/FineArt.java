package com.ivca.interviews;

public class FineArt implements ItemState, ItemPrice {
    private Inventory.Item item;

    public FineArt(Inventory.Item item) {
        this.item = item;
    }

    @Override
    public void track() {
        raisePrice();
        reduceSellByByOne();
        if (isPriceGreaterThanMax())
            adjustPrice();
    }

    private boolean isPriceGreaterThanMax() {
        return item.price > 50;
    }

    private void adjustPrice() {
        item.price = 50;
    }

    private void raisePrice() {
        item.price +=1;
    }

    private void reduceSellByByOne() {
        item.sellBy -=1;
    }


}
