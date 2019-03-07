package com.ibm.crud.common;

public class NumberUtils {
    public static String formatCard(String cardNumber) {
        if (cardNumber == null) {
            return null;
        }
        char delimiter = ' ';
        return cardNumber.replaceAll(".{4}(?!$)", "$0" + delimiter);
    }
}
