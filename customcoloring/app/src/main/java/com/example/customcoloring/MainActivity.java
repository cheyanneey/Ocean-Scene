package com.example.customcoloring;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

//@author Cheyanne Yim
//due date: 02/08/2022

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        oceanView oceanV = findViewById(R.id.oceanView);
        oceanController oceanC = new oceanController(oceanV);
        oceanV.setOnTouchListener(oceanC);
        TextView objName = findViewById(R.id.objectName);
        objName.setText(oceanV.getOceanModel().currObject);
        SeekBar seekR = findViewById(R.id.rSeek);
        seekR.setOnSeekBarChangeListener(oceanC);
        SeekBar seekG = findViewById(R.id.gSeek);
        seekG.setOnSeekBarChangeListener(oceanC);
        SeekBar seekB = findViewById(R.id.bSeek);
        seekB.setOnSeekBarChangeListener(oceanC);
    }
}