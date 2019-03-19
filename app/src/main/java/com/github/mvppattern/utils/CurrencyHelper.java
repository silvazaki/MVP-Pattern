package com.github.mvppattern.utils;

public class CurrencyHelper {

    public static String formatRP(int number) {
        return String.format("Rp. %,d", number).replace(",", ".") + ",-";
    }


    public static String formatRP(String number) {
        int numberint = 0;
        try {
            numberint = Integer.parseInt(number);
        } catch (Exception ignored) {

        }

        return String.format("Rp. %,d", numberint).replace(",", ".") + ",-";
    }

}
