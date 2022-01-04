package com.ivca.interviews;

public class ConcertTickets implements ItemState, ItemPrice {
    private Inventory.Item item;

    public ConcertTickets(Inventory.Item item) {
        this.item = item;
    }

    @Override
    public void track() {
        raisePrice();
        reduceSellByByOne();
        if (hasConcertDayPassed())
            setMinimumPrice(item);
    }

    private boolean hasConcertDayPassed() {
        return item.sellBy < 0;
    }

    private void raisePrice() {
        item.price +=1;
        if (sellByIsLessThan(11))
            item.price +=1;

        if (sellByIsLessThan(6))
            item.price +=1;
    }

    private boolean sellByIsLessThan(int days) {
        return item.sellBy < days;
    }


    private void reduceSellByByOne() {
        item.sellBy -=1;
    }
}
