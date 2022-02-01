package com.example.converter.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.converter.R;
import com.example.converter.model.State;
import com.example.converter.utils.DegInputFilter;
import com.example.converter.utils.SecInputFilter;
import com.example.converter.viewmodel.ConverterViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private ConverterViewModel controller;

  private TextInputEditText deg;
    private TextInputEditText sec;
  private TextView outputs;
    private TextInputEditText mins;
private  Button calcButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
  deg =findViewById(R.id.deg);
  sec=findViewById(R.id.sec);
  mins = findViewById(R.id.mins);
  outputs = findViewById(R.id.outputs);
  calcButton =findViewById(R.id.calcBtn);



        controller =new ViewModelProvider(this).get(ConverterViewModel.class);




        DegInputFilter degInputFilter = new DegInputFilter(0,360);
     SecInputFilter secInputFilter = new SecInputFilter(0.0 ,59.0);





        deg.setFilters(new InputFilter[]{degInputFilter});

//Accept Digits and Characters
        sec.setFilters(new InputFilter[]{secInputFilter});


  calcButton.setOnClickListener(new View.OnClickListener(){

      @Override
      public void onClick(View view) {
       if (calcButton.getText().toString()=="calculate"){
           double  secs = Double.parseDouble(sec.getText().toString());
           int minutes = Integer.parseInt(mins.getText().toString());
           int degrees = Integer.parseInt(deg.getText().toString());
           State state = new State(minutes ,degrees,secs);

           controller.convert(state);
       }else {
  enableFields();
  focusOnSec();
refresh();

       }
      }
  });


        controller.isConverted.observe(this , value -> {
            if (value){
                disableFields();
                removeFocusOnSec();
calcButton.setText("New");
            }else {
                enableFields();
                focusOnSec();
calcButton.setText("calculate");
            }
        });




        controller.value.observe(this , data -> {
        outputs.setText(data.toString());
        });


    }
  private  void focusOnSec(){
        sec.requestFocus();
  }
    private  void removeFocusOnSec(){
        sec.clearFocus();
    }
    private  void refresh() {
        controller.refreshUI();
        deg.setText("0");
        sec.setText("0");
        mins.setText("0");
        focusOnSec();
    }

    private void enableFields() {

        deg.setEnabled(true);
        sec.setEnabled(true);
        mins.setEnabled(true);
    }
    private void disableFields() {

        deg.setEnabled(false);
        sec.setEnabled(false);
        mins.setEnabled(false);
    }
}