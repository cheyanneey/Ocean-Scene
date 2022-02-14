package com.example.customcoloring;

import android.widget.TextView;

import java.util.ArrayList;

public class oceanModel {
    public String currObject = "Sun";
    public TextView textView;
    public ArrayList<CustomElement> elementArray;
    public void addElement(CustomElement e){
        elementArray.add(e);
    }

}
