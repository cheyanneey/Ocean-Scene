package com.example.customcoloring;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
/**
 * This class updates the color of each element as the user moves the seekbar and taps on the screen
 *
 *
 *
 * @author Cheyanne Yim
 * @version February 10 2022
 */

/**
 * External Citation
 * Date: Feb 10, 2022
 * Problem: Could not figure out how to change the element color
 * Resource: Selena Li
 * Solution: Used her methods
 */
public class oceanController implements View.OnTouchListener, SeekBar.OnSeekBarChangeListener{
    private oceanView oceanV1;
    private oceanModel oceanM1;
    private SeekBar rBar;
    private SeekBar gBar;
    private SeekBar bBar;
    private int color;
    private TextView elements = null;

    public oceanController(oceanView initDrawing) {
        this.oceanV1 = initDrawing;
    }
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int x = (int)motionEvent.getX();
        int y = (int)motionEvent.getY();
        oceanV1.invalidate();
        for (CustomElement e : oceanM1.elementArray) {
            if (e.containsPoint(x, y)) {
                elements.setText(String.format("%s", e.getName()));

                int[] rgb = oceanV1.getRGB(e.getColor());
                rBar.setProgress(rgb[0]);
                gBar.setProgress(rgb[1]);
                bBar.setProgress(rgb[2]);
            }
        }
        return false;

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        for(CustomElement e : oceanM1.elementArray){
            String textField = (String) oceanM1.getText();
            String elementName = String.format("%s", e.getName());
            }
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
