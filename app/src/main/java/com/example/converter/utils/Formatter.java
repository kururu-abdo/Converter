package com.example.converter.utils;

public class Formatter {

    public static   double roundResultValue(double value ,int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;

    }
}
