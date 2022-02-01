package com.example.converter.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.converter.R;
import com.example.converter.viewmodel.ConverterViewModel;

public class MainActivity extends AppCompatActivity {
    private ConverterViewModel controller;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        controller =new ViewModelProvider(this).get(ConverterViewModel.class);

    }
}