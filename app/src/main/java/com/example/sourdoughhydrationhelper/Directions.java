package com.example.sourdoughhydrationhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;

public class Directions extends AppCompatActivity {

    String selectedDoughType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directions);

        TextView directionsTextView = findViewById(R.id.directionsText);

        Intent directionsIntent = getIntent();
        selectedDoughType = directionsIntent.getStringExtra(MainActivity.DOUGHTYPE_TEXT);

        directionsTextView.setText("input directions here");
    }
}