package com.example.test.botom_nav_test.ValueHolder;

public class Common {

    public static int basket_price_sum_holder = 0;

    public static void pricePlusBehavior(int newPriceVal) {
        basket_price_sum_holder = basket_price_sum_holder + newPriceVal;
    }

    public static void pricePlusByCountBehavior(int newPriceVal, int count) {
        basket_price_sum_holder = basket_price_sum_holder + (newPriceVal * count);
    }

    public static int showCurrentPrice() {
        return basket_price_sum_holder;
    }

    public static void priceRemoveBehavior(int removePriceVal, int countItem) {
        basket_price_sum_holder = basket_price_sum_holder - (removePriceVal * countItem);
    }
}