package com.example.converter.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.converter.model.State;
import com.example.converter.utils.Formatter;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class ConverterViewModel extends ViewModel {
   public   MutableLiveData<Boolean> isConverted =  new MutableLiveData<Boolean>(false);
 public    MutableLiveData<Double>  value =  new MutableLiveData<Double>(0.0);




      public  void  refreshUI() {
          isConverted.setValue(false);
          value.setValue(0.0);
      }
       public void convert  (State values){
            double seconds = convertSeconds(values.getSeconds());
            double degs = convertDegs(values.getDegs());
            double minutes=  convertMinutes(values.getMinutes());
           Log.v("DATA" , "sec textfiled  " + values.getSeconds()+" ");
           Log.v("DATA" , "sec  " + seconds+" ");
           Log.v("DATA" , "degs  " +degs+" ");
           Log.v("DATA" , "mins textfield "  + values.getMinutes()+" ");

           Log.v("DATA" , "mins "  + minutes+" ");
            double val = Formatter.roundResultValue( runEquation(seconds ,degs,minutes) ,6);
           Log.v("DATA" , "value  "  + val+" ");
           BigDecimal bd = BigDecimal.valueOf(Double.valueOf(val));
           Double d=bd.doubleValue() ;
           DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
           DecimalFormat formatter = new DecimalFormat("0.0000" ,symbols);

            isConverted.setValue(true);

            double myData =  Double.parseDouble(formatter.format(d));
            value.setValue(myData);
       }

    private double runEquation(double seconds, double degs, double minutes) {

            try {
                double value = Math.PI  *  (seconds +degs +minutes)  /  180;

                return  value;
            }catch (Exception e){
                return  0.0;
            }

    }


    public  double convertSeconds(double sec){
           return  sec/3600;
      }

      public double convertMinutes(int mins){
          double result= (double) mins/60;
           return  result;
      }

      public  double convertDegs(int degs){
           return  degs;
      }









}
