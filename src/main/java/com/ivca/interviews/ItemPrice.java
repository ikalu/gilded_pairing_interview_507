package com.ivca.interviews;

public interface ItemPrice {
    int MINIMUM_PRICE = 0;
    int MAXIMUM_PRICE = 50;

    default void setMinimumPrice(Inventory.Item item) {
        item.price = MINIMUM_PRICE;
    }

    default void setMaximumPrice(Inventory.Item item) {
        item.price = MAXIMUM_PRICE;
    }

    default boolean isLessThanMinimumPrice(Inventory.Item item) {
        return item.price < MINIMUM_PRICE;
    }

    default boolean isMoreThanMaximumPrice(Inventory.Item item) {
        return item.price > MAXIMUM_PRICE;
    }
}
