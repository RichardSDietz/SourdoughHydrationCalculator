package com.example.sourdoughhydrationhelper;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Spinner doughTypeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DOUGH TYPE SPINNER CODE
        doughTypeSpinner = findViewById(R.id.doughTypeSpinner);

        List<DoughType> doughTypeList = new ArrayList<>();

        DoughType sourDough = new DoughType("Sourdough");
        doughTypeList.add (sourDough);
        DoughType bagels = new DoughType("Bagels");
        doughTypeList.add (bagels);

        ArrayAdapter<DoughType> adapter = new ArrayAdapter<DoughType>(this, android.R.layout.simple_spinner_dropdown_item, doughTypeList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        doughTypeSpinner.setAdapter(adapter);
    }

    public void calculateHydration(View view)   {

        EditText flourText = findViewById(R.id.flourText);
        EditText hydrationText = findViewById(R.id.hydrationText);
        TextView flourCalcText = findViewById(R.id.flourCalcText);
        TextView waterCalcText = findViewById(R.id.waterCalcText);
        TextView starterCalcText = findViewById(R.id.starterCalcText);
        TextView saltCalcText = findViewById(R.id.saltCalcText);
        String selectedDoughType = doughTypeSpinner.getSelectedItem().toString();

        if(flourText.getText().toString().matches("") || hydrationText.getText().toString().matches("")){
            Float flourAmountF = 0f;
            Float starterAmountF = 0f;
            Float waterAmountF = 0f;
            Float saltAmountF = 0f;
            flourCalcText.setText(String.format(Locale.ENGLISH, "%.0f", flourAmountF));
            waterCalcText.setText(String.format(Locale.ENGLISH, "%.0f", waterAmountF));
            starterCalcText.setText(String.format(Locale.ENGLISH, "%.0f", starterAmountF));
            saltCalcText.setText(String.format(Locale.ENGLISH, "%.0f", saltAmountF));
        }
        else{
            if(selectedDoughType.equals("Sourdough")){
                String flourAmountS = flourText.getText().toString();
                Float flourAmountF = Float.parseFloat(flourAmountS);
                String hydrationPercS = hydrationText.getText().toString();
                Float hydrationPercF = Float.parseFloat(hydrationPercS);
                Float starterAmountF = flourAmountF * .40f;
                Float waterAmountF = ((flourAmountF + (starterAmountF / 2)) * (hydrationPercF / 100)) - (starterAmountF / 2);
                Float saltAmountF = (flourAmountF + (starterAmountF / 2)) * .01f;
                flourCalcText.setText(String.format(Locale.ENGLISH, "%.0f", flourAmountF));
                waterCalcText.setText(String.format(Locale.ENGLISH, "%.0f", waterAmountF));
                starterCalcText.setText(String.format(Locale.ENGLISH, "%.0f", starterAmountF));
                saltCalcText.setText(String.format(Locale.ENGLISH, "%.0f", saltAmountF));
            }
        }
    }
}