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
    items.forEach(item -> {
      ItemState itemState = ItemFactory.getItemState(item);

      itemState.track();
    });
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
