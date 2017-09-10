package com.ifpi;

import java.math.BigDecimal;
import java.util.Objects;

public class Item {

    private String name;

    private BigDecimal price;


    public Item(String pName, BigDecimal pPrice) {
        this.name = pName;
        this.price = pPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Item) {
            Item item = (Item) o;
            return (this.getName().equalsIgnoreCase(item.getName()) );
        }
        return false;
    }


    @Override
    public int hashCode() {
        return Objects.hash(this.getName(), this.getPrice());
    }
}
