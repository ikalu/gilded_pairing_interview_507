package com.ivca.interviews;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    @Test
    public void testEndOfDaySellByAndPriceAreReduced() {
        // This was timeboxed, so I was going prettyfast.
        // Ideally, these lines and the first assertion should have been
        // factored out to a method for each test to call.
        Inventory.Item item = new Inventory.Item("normal", 50, 50);
        Inventory inventory = new Inventory(Arrays.asList(item));
        inventory.updatePrice();
        Inventory.Item finalItemState = inventory.getItems().get(0);

        assertEquals("normal", finalItemState.name);
        assertEquals(49, finalItemState.sellBy);
        assertEquals(49,finalItemState.price);
        /*assertThat(finalItemState.name).isEqualTo("normal");
        assertThat(finalItemState.sellBy).isEqualTo(49);
        assertThat(finalItemState.price).isEqualTo(49);*/
    }

    @Test
    public void testOnceTheSellByDateHasPassedPriceDegradesTwiceAsFast() {
        Inventory.Item item = new Inventory.Item("normal", 0, 50);
        Inventory inventory = new Inventory(Arrays.asList(item));
        inventory.updatePrice();
        Inventory.Item finalItemState = inventory.getItems().get(0);

        assertEquals("normal", finalItemState.name);
        assertEquals(-1, finalItemState.sellBy);
        assertEquals(48,finalItemState.price);

        /*assertThat(finalItemState.name).isEqualTo("normal");
        assertThat(finalItemState.sellBy).isEqualTo(-1);
        assertThat(finalItemState.price).isEqualTo(48);*/
    }

    @Test
    public void testPriceIsNeverNegative() {
        Inventory.Item item = new Inventory.Item("normal", 0, 0);
        Inventory inventory = new Inventory(Arrays.asList(item));
        inventory.updatePrice();
        Inventory.Item finalItemState = inventory.getItems().get(0);

        assertEquals("normal", finalItemState.name);
        assertEquals(-1, finalItemState.sellBy);
        assertEquals(0,finalItemState.price);

        /*assertThat(finalItemState.name).isEqualTo("normal");
        assertThat(finalItemState.sellBy).isEqualTo(-1);
        assertThat(finalItemState.price).isEqualTo(0);*/
    }

    @Test
    public void testFineArtIncreasesInPriceAsItAges() {
        Inventory.Item item = new Inventory.Item("Fine Art", 50, 40);
        Inventory inventory = new Inventory(Arrays.asList(item));
        inventory.updatePrice();
        Inventory.Item finalItemState = inventory.getItems().get(0);

        assertEquals("Fine Art", finalItemState.name);
        assertEquals(49, finalItemState.sellBy);
        assertEquals(41,finalItemState.price);

        /*assertThat(finalItemState.name).isEqualTo("Fine Art");
        assertThat(finalItemState.sellBy).isEqualTo(49);
        assertThat(finalItemState.price).isEqualTo(41);*/
    }

    @org.junit.jupiter.api.Test
    public void testPriceDoesNotExceed50() {
        Inventory.Item item = new Inventory.Item("Fine Art", 10, 50);
        Inventory inventory = new Inventory(Arrays.asList(item));
        inventory.updatePrice();
        Inventory.Item finalItemState = inventory.getItems().get(0);

        assertEquals("Fine Art", finalItemState.name);
        assertEquals(9, finalItemState.sellBy);
        assertEquals(50,finalItemState.price);

        /*assertThat(finalItemState.name).isEqualTo("Fine Art");
        assertThat(finalItemState.sellBy).isEqualTo(9);
        assertThat(finalItemState.price).isEqualTo(50);*/
    }

    @org.junit.jupiter.api.Test
    public void testGoldCoinsDoNotChangePrice() {
        Inventory.Item item = new Inventory.Item("Gold Coins", 10, 10);
        Inventory inventory = new Inventory(Arrays.asList(item));
        inventory.updatePrice();
        Inventory.Item finalItemState = inventory.getItems().get(0);

        assertEquals("Gold Coins", finalItemState.name);
        assertEquals(10, finalItemState.sellBy);
        assertEquals(10,finalItemState.price);

        /*assertThat(finalItemState.name).isEqualTo("Gold Coins");
        assertThat(finalItemState.sellBy).isEqualTo(10);
        assertThat(finalItemState.price).isEqualTo(10);*/
    }

    @org.junit.jupiter.api.Test
    public void testConcertTicketsIncreaseByOneWhenSellByIsGreaterThanTen() {
        Inventory.Item item = new Inventory.Item("Concert Tickets", 11, 10);
        Inventory inventory = new Inventory(Arrays.asList(item));
        inventory.updatePrice();
        Inventory.Item finalItemState = inventory.getItems().get(0);

        assertEquals("Concert Tickets", finalItemState.name);
        assertEquals(10, finalItemState.sellBy);
        assertEquals(11,finalItemState.price);

        /*assertThat(finalItemState.name).isEqualTo("Concert Tickets");
        assertThat(finalItemState.sellBy).isEqualTo(10);
        assertThat(finalItemState.price).isEqualTo(11);*/
    }

    @org.junit.jupiter.api.Test
    public void testConcertTicketsIncreaseByTwoWhenSellByIsTen() {
        Inventory.Item item = new Inventory.Item("Concert Tickets", 10, 10);
        Inventory inventory = new Inventory(Arrays.asList(item));
        inventory.updatePrice();
        Inventory.Item finalItemState = inventory.getItems().get(0);

        assertEquals("Concert Tickets", finalItemState.name);
        assertEquals(9, finalItemState.sellBy);
        assertEquals(12,finalItemState.price);

        /*assertThat(finalItemState.name).isEqualTo("Concert Tickets");
        assertThat(finalItemState.sellBy).isEqualTo(9);
        assertThat(finalItemState.price).isEqualTo(12);*/
    }

    @org.junit.jupiter.api.Test
    public void testConcertTicketsIncreaseByThreeWhenSellByIsFive() {
        Inventory.Item item = new Inventory.Item("Concert Tickets", 5, 10);
        Inventory inventory = new Inventory(Arrays.asList(item));
        inventory.updatePrice();
        Inventory.Item finalItemState = inventory.getItems().get(0);

        assertEquals("Concert Tickets", finalItemState.name);
        assertEquals(4, finalItemState.sellBy);
        assertEquals(13,finalItemState.price);

        /*assertThat(finalItemState.name).isEqualTo("Concert Tickets");
        assertThat(finalItemState.sellBy).isEqualTo(4);
        assertThat(finalItemState.price).isEqualTo(13);*/
    }

    @org.junit.jupiter.api.Test
    public void testConcertTicketsDropToZeroAfterTheSellBy() {
        Inventory.Item item = new Inventory.Item("Concert Tickets", 0, 10);
        Inventory inventory = new Inventory(Arrays.asList(item));
        inventory.updatePrice();
        Inventory.Item finalItemState = inventory.getItems().get(0);

        assertEquals("Concert Tickets", finalItemState.name);
        assertEquals(-1, finalItemState.sellBy);
        assertEquals(0,finalItemState.price);

        /*assertThat(finalItemState.name).isEqualTo("Concert Tickets");
        assertThat(finalItemState.sellBy).isEqualTo(-1);
        assertThat(finalItemState.price).isEqualTo(0);*/
    }

    @org.junit.jupiter.api.Test
    public void testGoldCoinsMayHavePriceOf80() {
        Inventory.Item item = new Inventory.Item("Gold Coins", 10, 80);
        Inventory inventory = new Inventory(Arrays.asList(item));
        inventory.updatePrice();
        Inventory.Item finalItemState = inventory.getItems().get(0);

        assertEquals("Gold Coins", finalItemState.name);
        assertEquals(10, finalItemState.sellBy);
        assertEquals(80, finalItemState.price);

        /*assertThat(finalItemState.name).isEqualTo("Gold Coins");
        assertThat(finalItemState.sellBy).isEqualTo(10);
        assertThat(finalItemState.price).isEqualTo(80);*/
    }

    @Test
    public void testEndOfDaySellByAndPriceAreReducedFLowers() {
        // This was timeboxed, so I was going prettyfast.
        // Ideally, these lines and the first assertion should have been
        // factored out to a method for each test to call.
        Inventory.Item item = new Inventory.Item("flowers", 50, 50);
        Inventory inventory = new Inventory(Arrays.asList(item));
        inventory.updatePrice();
        Inventory.Item finalItemState = inventory.getItems().get(0);

        assertEquals("flowers", finalItemState.name);
        assertEquals(49, finalItemState.sellBy);
        assertEquals(48, finalItemState.price);
    }

    @Test
    public void testOnceTheSellByDateHasPassedPriceDegradesTwiceAsFastAsNormalForFlowers() {
        Inventory.Item item = new Inventory.Item("flowers", 0, 50);
        Inventory inventory = new Inventory(Arrays.asList(item));
        inventory.updatePrice();
        Inventory.Item finalItemState = inventory.getItems().get(0);

        assertEquals("flowers",finalItemState.name);
        assertEquals(-1, finalItemState.sellBy);
        assertEquals(46,finalItemState.price);

    }

    @Test
    public void testPriceIsNeverNegativeFlowers() {
        Inventory.Item item = new Inventory.Item("flowers", 0, 0);
        Inventory inventory = new Inventory(Arrays.asList(item));
        inventory.updatePrice();
        Inventory.Item finalItemState = inventory.getItems().get(0);

        assertEquals("flowers",finalItemState.name);
        assertEquals(-1, finalItemState.sellBy);
        assertEquals(0,finalItemState.price);

    }
}