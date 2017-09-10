package com.ifpi;

import java.math.BigDecimal;

public class PercentageDiscount implements PricingPolicy {

    @Override
    public BigDecimal discount(Item pItem, int pPercentage) {
        BigDecimal discountedPrice = BigDecimal.ZERO;

        if (pPercentage <= 0 || pPercentage > 100) {
            throw new IllegalArgumentException("percentage should be in range [0,100 ]");

        }

        BigDecimal factor = new BigDecimal(pPercentage).divide(new BigDecimal(100));
        BigDecimal total = pItem.getPrice().multiply(factor);
        discountedPrice = pItem.getPrice().subtract(total);

        return discountedPrice;
    }
}
