package com.ifpi;

import java.math.BigDecimal;

public class BundleDiscount implements PricingPolicy {

    @Override
    public BigDecimal discount(Item pItem, int pHowMany) {
        BigDecimal discountedPrice = BigDecimal.ZERO;

        if (pHowMany < 1) {
            throw new IllegalArgumentException("quantity of product should be more than 1");
        }

        if (pHowMany == 2) {
            BigDecimal total = pItem.getPrice().multiply(new BigDecimal(0.5));
            discountedPrice = pItem.getPrice().subtract(total);
        }

        return discountedPrice;
    }


}
