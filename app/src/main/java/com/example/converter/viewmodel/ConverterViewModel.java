package com.example.converter.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.converter.model.State;

public class ConverterViewModel extends ViewModel {
     MutableLiveData<Boolean> isConverted =  new MutableLiveData<Boolean>(false);
    MutableLiveData<Double>  value =  new MutableLiveData<Double>(0.0);




      public  void  refreshUI() {
          isConverted.setValue(false);
          value.setValue(0.0);
      }
       public void convert  (State values){
            double seconds = convertSeconds(values.getSeconds());
            double degs = convertDegs(values.getDegs());
            double minutes=  convertMinutes(values.getMinutes());

            double val =  runEquation(seconds ,degs,minutes);
            isConverted.setValue(true);
            value.setValue(val);
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
           return  mins/60;
      }

      public  double convertDegs(int degs){
           return  degs;
      }









}
