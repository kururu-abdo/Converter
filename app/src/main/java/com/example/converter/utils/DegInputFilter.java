package com.example.converter.utils;

import android.text.InputFilter;
import android.text.Spanned;

public class DegInputFilter implements InputFilter {
    int max;
    int min;

    public DegInputFilter(int min, int max) {
       this.max =max;
       this.min = min;
    }

    public DegInputFilter (String minValue , String maxValue) {
        this . min = Integer. parseInt (minValue) ;
        this . max = Integer. parseInt (maxValue) ;
    }
    @Override
    public CharSequence filter (CharSequence source , int start , int end , Spanned dest ,int dstart , int dend) {
        try {
            int input = Integer. parseInt (dest.toString() + source.toString()) ;
            if (isInRange( min , max , input))
                return null;
        } catch (NumberFormatException e) {
            e.printStackTrace() ;
        }
        return "" ;
    }
    private boolean isInRange ( int a , int b , int c) {
        return b > a ? c >= a && c <= b : c >= b && c <= a ;
    }



}
