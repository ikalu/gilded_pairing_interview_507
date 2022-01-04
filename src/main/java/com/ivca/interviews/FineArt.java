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
    }

    private void raisePrice() {
        item.price +=1;
    }

    private void reduceSellByByOne() {
        item.sellBy -=1;
    }


}
