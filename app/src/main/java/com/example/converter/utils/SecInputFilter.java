package com.example.converter.utils;

import android.text.InputFilter;
import android.text.Spanned;

public class SecInputFilter  implements InputFilter {
    double max;
    double min;

    public SecInputFilter(double min, double max) {
        this.max =max;
        this.min = min;
    }



    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        try {
            double input = Double.valueOf(dest.toString() + source.toString());
            if (isInRange(min, max, input))
                return null;
        } catch (NumberFormatException nfe) { }
        return "";
    }

    private boolean isInRange(double a, double b, double c) {
        return b > a ? c >= a && c <= b : c >= b && c <= a;
    }
}
