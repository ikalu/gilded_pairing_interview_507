package com.ivca.interviews;

import com.google.common.collect.ImmutableMap;

public class ItemFactory {
    private static final ImmutableMap<String, String> INVENTORY_ITEMS =
            ImmutableMap.of("NORMAL", Normal.class.getName(),
                    "FINE ART", FineArt.class.getName(),
                    "GOLD COINS", GoldCoins.class.getName(),
                    "CONCERT TICKETS", ConcertTickets.class.getName(),
                    "FLOWERS", Flowers.class.getName()
            );

    public static ItemState getItemState(Inventory.Item item) {
        //Using Java Reflection API
        try {
            return (ItemState) Class.forName(INVENTORY_ITEMS.get(item.name.toUpperCase()))
                    .getDeclaredConstructor(Inventory.Item.class)
                    .newInstance(item);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ItemPrice getItemPrice(Inventory.Item item) {
        //Using Java Reflection API
        try {
            return (ItemPrice) Class.forName(INVENTORY_ITEMS.get(item.name.toUpperCase()))
                    .getDeclaredConstructor(Inventory.Item.class)
                    .newInstance(item);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
