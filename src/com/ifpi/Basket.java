package com.ifpi;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class Basket {

    Map<Item, Integer> items;

    public Basket() {

        items = new LinkedHashMap<>();
    }

    public Map<Item, Integer> getItems() {
        return items;
    }

    public void addItems(Item item) {

        items.computeIfPresent(item, (i, q) -> Integer.valueOf(q + 1));
        items.putIfAbsent(item, 1);

    }

    public BigDecimal total() {
        BigDecimal result = BigDecimal.ZERO;

        for (Map.Entry<Item, Integer> item : items.entrySet()) {
            BigDecimal total = item.getKey().getPrice().multiply(new BigDecimal(item.getValue()));
            result = result.add(total);
        }

        return result;
    }

}
