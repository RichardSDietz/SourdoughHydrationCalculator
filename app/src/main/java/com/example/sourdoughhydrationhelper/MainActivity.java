package com.example.sourdoughhydrationhelper;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateHydration(View view)   {

        EditText flourText = findViewById(R.id.flourText);
        EditText hydrationText = findViewById(R.id.hydrationText);
        TextView flourCalcText = findViewById(R.id.flourCalcText);
        TextView waterCalcText = findViewById(R.id.waterCalcText);
        TextView starterCalcText = findViewById(R.id.starterCalcText);
        TextView saltCalcText = findViewById(R.id.saltCalcText);

        String flourAmountS = flourText.getText().toString();
        Float flourAmountF = Float.parseFloat(flourAmountS);
        String hydrationPercS = hydrationText.getText().toString();
        Float hydrationPercF = Float.parseFloat(hydrationPercS);
        Float starterAmountF = flourAmountF * .28f;
        Float waterAmountF = ((flourAmountF + (starterAmountF / 2)) * (hydrationPercF / 100)) - (starterAmountF / 2);
        Float saltAmountF = (flourAmountF + (starterAmountF / 2)) * .02f;
        flourCalcText.setText(String.format(Locale.ENGLISH, "%.0f", flourAmountF));
        waterCalcText.setText(String.format(Locale.ENGLISH, "%.0f", waterAmountF));
        starterCalcText.setText(String.format(Locale.ENGLISH, "%.0f", starterAmountF));
        saltCalcText.setText(String.format(Locale.ENGLISH, "%.0f", saltAmountF));
    }
}