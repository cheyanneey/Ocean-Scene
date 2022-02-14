package com.example.customcoloring;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.ArrayList;


//creating surface view to make a complete drawing of the ocean
public class oceanView extends SurfaceView {
    //making reference to oceanModel to be able to change color
    private oceanModel oceanM;
    public Paint bubblePaint = new Paint();
    public Paint waterPaint = new Paint();
    public Paint sunPaint = new Paint();
    public Paint fishPaint = new Paint();
    public Paint sandPaint = new Paint();
    public Paint seaweedPaint = new Paint();

    public oceanView(Context context, AttributeSet attrs) {
        super(context, attrs);

        setWillNotDraw(false);

        oceanM = new oceanModel();

        setBackgroundColor(Color.WHITE);
        bubblePaint.setColor(0xFFACEAFF);
        bubblePaint.setStyle(Paint.Style.FILL);
        waterPaint.setColor(0xFF3E4EFF);
        waterPaint.setStyle(Paint.Style.FILL);
        sunPaint.setColor(0xFFFFF33E);
        sunPaint.setStyle(Paint.Style.FILL);
        fishPaint.setColor(0xFFFF933E);
        fishPaint.setStyle(Paint.Style.FILL);
        sandPaint.setColor(0xFFFFE492);
        sandPaint.setStyle(Paint.Style.FILL);
        seaweedPaint.setColor(0xFF23611B);
        seaweedPaint.setStyle(Paint.Style.FILL);
    }

    public oceanModel getOceanModel() {
        return oceanM;
    }

    public int getRGB(int hex) {
        int Alpha = Integer.valueOf(hex);
        Alpha = (Alpha << 24) & 0xFF000000;
        return Alpha;
    }
    public int getRed(String hex) {
        int Red = Integer.valueOf(hex.substring(2, 4), 16);
        Red = (Red << 16) & 0x00FF0000;
        return Red;
    }

    public int getGreen(String hex) {
        int Green = Integer.valueOf(hex.substring(4, 6), 16);
        Green = (Green << 8) & 0x0000FF00;
        return Green;
    }

    public int getBlue(String hex) {
        int Blue = Integer.valueOf(hex.substring(6, 8), 16);
        Blue = Blue & 0x000000FF;
        return Blue;
    }

    public void drawOcean(Canvas canvas) {
        //ocean
        canvas.drawCircle(150.0f, 700.0f, 200.0f, waterPaint);
        canvas.drawCircle(550.0f, 700.0f, 200.0f, waterPaint);
        canvas.drawCircle(950.0f, 700.0f, 200.0f, waterPaint);
        canvas.drawRect(0.0f, 700.0f, 1100.0f, 2000.0f, waterPaint);
    }

    public void drawSun(Canvas canvas) {
        //sun
        canvas.drawCircle(100.0f, 100.0f, 150.0f, sunPaint);
    }

    public void drawBubbles(Canvas canvas) {
        //bubbles
        canvas.drawCircle(850.0f, 900.0f, 50.0f, bubblePaint);
        canvas.drawCircle(750.0f, 1250.0f, 30.0f, bubblePaint);
        canvas.drawCircle(650.0f, 1050.0f, 55.0f, bubblePaint);
    }

    public void drawSand(Canvas canvas) {
        //sand
        canvas.drawRect(0.0f, 1600.0f, 1100.0f, 2000.0f, sandPaint);
    }

    public void drawFish(Canvas canvas) {
        //fish
        canvas.drawOval(700.0f, 1300.0f, 950.0f, 1500.0f, fishPaint);
        canvas.drawArc(900.0f, 1300.0f, 1100.0f, 1500.0f, 90, 180, true, fishPaint);
        canvas.drawCircle(750.0f, 1380.0f, 10.0f, sunPaint);
    }

    public void drawSeaweed(Canvas canvas) {
        //seaweed
        canvas.drawArc(150f, 900f, 250f, 1200f, 90, 180, true, seaweedPaint);
        canvas.drawArc(130f, 1100f, 230f, 1400f, 90, -180, true, seaweedPaint);
        canvas.drawArc(150f, 1300f, 250f, 1600f, 90, 180, true, seaweedPaint);
        canvas.drawArc(350f, 1100f, 450f, 1400f, 90, 180, true, seaweedPaint);
        canvas.drawArc(330f, 1300f, 430f, 1600f, 90, -180, true, seaweedPaint);
    }
    protected void onDraw(Canvas canvas) {
        drawOcean(canvas);
        drawBubbles(canvas);
        drawFish(canvas);
        drawSand(canvas);
        drawSeaweed(canvas);
        drawSun(canvas);
    }
    CustomElement water = new CustomElement("water", waterPaint.getColor());;
    CustomElement bubble = new CustomElement("water", bubblePaint.getColor());;
    CustomElement sun = new CustomElement("water", sunPaint.getColor());;
    CustomElement fish = new CustomElement("water", fishPaint.getColor());;
    CustomElement sand = new CustomElement("water", sandPaint.getColor());;
    CustomElement seaweed = new CustomElement("water", seaweedPaint.getColor());;
}

