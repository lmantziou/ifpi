package test;

import com.ifpi.BundleDiscount;
import com.ifpi.Item;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class BundleDiscountTest extends BaseTest{

    @Test
    public void discount() throws Exception {

        basket.addItems(cricketBat);
        basket.addItems(cricketBat);
        basket.addItems(tennisRacket);
        basket.addItems(golfSet);
        basket.addItems(footballKit);

        BigDecimal discountedPrice = new BundleDiscount().discount(tennisRacket, basket.getItems().get(cricketBat).intValue());

        basket.getItems().remove(tennisRacket);
        tennisRacket = new Item("tennisRacket", discountedPrice);

        basket.addItems(tennisRacket);

        assertEquals(new BigDecimal("40.0"), discountedPrice);
        assertEquals(new BigDecimal("400.0"), basket.total());

    }

    @Test(expected = IllegalArgumentException.class)
    public void discountZeroQuantity() throws Exception {

        basket.addItems(cricketBat);
        basket.addItems(tennisRacket);
        basket.addItems(golfSet);
        basket.addItems(footballKit);

        BigDecimal discountedPrice = new BundleDiscount().discount(tennisRacket, 0);
    }

}