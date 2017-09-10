package com.ifpi;

import java.math.BigDecimal;

public enum ProductList {

    CRICKETBAT(new BigDecimal("65")),
    TENNISRACKET(new BigDecimal("80")),
    GOLFSET(new BigDecimal("130")),
    FOOTBALLKIT(new BigDecimal("100"));

    private BigDecimal value;

    ProductList(BigDecimal value){
        this.value = value;
    }

    public BigDecimal getValue(){
        return this.value;
    }

}
