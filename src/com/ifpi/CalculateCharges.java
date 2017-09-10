package com.ifpi;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CalculateCharges {

    private static Basket mainBasket;

    private static BigDecimal subTotal;

    private static BigDecimal total;

    private static final int TEN_PERCENT_DISCOUNT = 10;

    public static BigDecimal getTotalAmount(String[] args) {

        mainBasket = new Basket();
        Item item;

        for (String arg : args) {
            try {
                BigDecimal price = ProductList.valueOf(arg.toUpperCase()).getValue();

                item = new Item(arg, price);
                mainBasket.addItems(item);
            } catch (Exception e) {
                System.out.println("there is no product with name " + arg + " in the produc tlist");
            }

        }

        subTotal = mainBasket.total();

        System.out.println("Subtotal: £" + subTotal);


        boolean isFootballKitInList = mainBasket.getItems().entrySet().stream().anyMatch(e -> e.getKey().getName().equalsIgnoreCase("footballkit"));

        if (isFootballKitInList) {

            List<Map.Entry<Item, Integer>> footballKitList = mainBasket.getItems().entrySet().stream().filter(e -> e.getKey().getName().equalsIgnoreCase("footballkit")).collect(Collectors.toList());

            if (footballKitList.size() > 0) {

                BigDecimal discountedPrice = new PercentageDiscount().discount(footballKitList.get(0).getKey(), TEN_PERCENT_DISCOUNT);

                footballKitList.get(0).getKey().setPrice(discountedPrice);

                System.out.println(" FootballKit 10% off: -" + TEN_PERCENT_DISCOUNT + "£");
            }
        }

        boolean isCricketBatInList = mainBasket.getItems().entrySet().stream().anyMatch(e -> e.getKey().getName().equalsIgnoreCase("cricketBat"));

        if (isCricketBatInList) {

            List<Map.Entry<Item, Integer>> cricketBatList = mainBasket.getItems().entrySet().stream().filter(e -> e.getKey().getName().equalsIgnoreCase("cricketBat")).collect(Collectors.toList());

            if (cricketBatList.size() > 0 && cricketBatList.get(0).getValue() > 1) {

                try {

                    Map.Entry<Item, Integer> tennisRacket = mainBasket.getItems().entrySet().stream().filter(e -> e.getKey().getName().equalsIgnoreCase("tennisracket")).collect(Collectors.toList()).get(0);

                    BigDecimal discountedPrice = new BundleDiscount().discount(tennisRacket.getKey(), cricketBatList.get(0).getValue());

                    mainBasket.getItems().remove(tennisRacket.getKey());
                    Item discountedTennisRacket = new Item("tennisRacket", discountedPrice);

                    mainBasket.addItems(discountedTennisRacket);

                    System.out.println(" TennisRacket half price: " + discountedPrice + "£");
                } catch (Exception e) {
                    System.out.println("no tennisRacket in Basket. We won't proceed with discount");
                }

            }
        }


        total = mainBasket.total();
        System.out.println("Total: £" + total);

        return total;

    }
}
