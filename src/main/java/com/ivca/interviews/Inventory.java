package com.ivca.interviews;

import java.util.List;

public class Inventory {
  private List<Item> items;

  public Inventory(List<Item> items) {
    this.items = items;
  }

  public List<Item> getItems() {
    return items;
  }

  public void updatePrice() {
    try {
      items.forEach(item -> {
        ItemState itemState = ItemFactory.getItemState(item);
        itemState.track();

        ItemPrice itemPrice = ItemFactory.getItemPrice(item);
        if (itemPrice.isLessThanMinimumPrice(item))
          itemPrice.setMinimumPrice(item);
        else if (itemPrice.isMoreThanMaximumPrice(item))
          itemPrice.setMaximumPrice(item);

      });
    } catch (Exception e) {
      e.printStackTrace();
    }

  }


  static class Item {
    public String name;
    public Integer sellBy;
    public Integer price;

    Item(String name, Integer sellBy, Integer price) {
      this.name = name;
      this.sellBy = sellBy;
      this.price = price;
    }

    public String toString() {
      return String.format("%s, %d, %d", name, sellBy, price);
    }
  }


}
