package test;

import com.ifpi.CalculateCharges;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CalculateChargesTest {


    @Test
    public void getTotalAmountDoubleItems() throws Exception {

        String[] items = new String[] {"CricketBat", "CricketBat", "FootballKit", "TennisRacket"};

        assertEquals(new BigDecimal("260.0"), CalculateCharges.getTotalAmount(items));
    }


    @Test
    public void getTotalAmountThreeItems() throws Exception {

        String[] items = new String[] {"FootballKit", "GolfSet", "TennisRacket"};

        assertEquals(new BigDecimal("300.0"), CalculateCharges.getTotalAmount(items));
    }


}