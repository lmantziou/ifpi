package test;


import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;


public class BasketTest extends BaseTest{


    @Test
    public void addItems() throws Exception {

        basket.addItems(cricketBat);
        basket.addItems(cricketBat);
        basket.addItems(tennisRacket);
        basket.addItems(golfSet);
        basket.addItems(footballKit);

        assertEquals(4, basket.getItems().size());
    }

    @Test
    public void calculateTotalEmptyBasket(){
        assertEquals (BigDecimal.ZERO, basket.total());

    }

    @Test
    public void calculateTotalBasicProducts() throws Exception {

        basket.addItems(tennisRacket);
        basket.addItems(golfSet);
        basket.addItems(footballKit);

        assertEquals(new BigDecimal(310), basket.total());

    }

}