package test;

import com.ifpi.Basket;
import com.ifpi.Item;
import org.junit.Before;

import java.math.BigDecimal;

public abstract class BaseTest {

    protected static Basket basket;

    protected static Item cricketBat, tennisRacket, golfSet, footballKit;

    @Before
    public void setUp() throws Exception {
        basket = new Basket();
        cricketBat = new Item("CricketBat", BigDecimal.valueOf(65));
        tennisRacket = new Item("tennisRacket", BigDecimal.valueOf(80));
        golfSet = new Item("golfSet", BigDecimal.valueOf(130));
        footballKit = new Item("footballKit", BigDecimal.valueOf(100));
    }

}
