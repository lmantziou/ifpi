package com.ifpi;

import java.math.BigDecimal;

public interface PricingPolicy {

     BigDecimal discount(Item item, int percentage);

}
