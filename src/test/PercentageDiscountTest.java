package test;

import com.ifpi.Item;
import com.ifpi.PercentageDiscount;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PercentageDiscountTest extends BaseTest {

    @Test
    public void discount() throws Exception {
        basket.addItems(cricketBat);
        basket.addItems(tennisRacket);
        basket.addItems(golfSet);
        basket.addItems(footballKit);

        BigDecimal discountedPrice = new PercentageDiscount().discount(footballKit, 10);

        basket.getItems().remove(footballKit);
        footballKit = new Item("footballKit", discountedPrice);

        basket.addItems(footballKit);

        assertEquals(new BigDecimal("90.0"), discountedPrice);
        assertEquals(new BigDecimal("365.0"), basket.total());

    }

    @Test(expected = IllegalArgumentException.class)
    public void discountZeroPercentage() throws Exception {
        basket.addItems(cricketBat);
        basket.addItems(tennisRacket);
        basket.addItems(golfSet);
        basket.addItems(footballKit);

        BigDecimal discountedPrice = new PercentageDiscount().discount(footballKit, 0);
    }



}