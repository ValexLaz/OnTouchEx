package com.example.ontouchex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    ImageView imgflecha;
    CardView cardview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgflecha = findViewById(R.id.imgflecha);
        cardview = findViewById(R.id.cardview);
        cardview.setOnTouchListener(this);

    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        int screenWidth = getResources().getDisplayMetrics().widthPixels;
        int screenHeight = getResources().getDisplayMetrics().heightPixels;
        int imgWidth = imgflecha.getWidth();
        int imgHeight = imgflecha.getHeight();
        int x = (int) event.getX();
        int y = (int) event.getY();
        if (x >= 0 && x + imgWidth <= screenWidth && y >= 0 && y + imgHeight <= screenHeight) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    Log.i("TAG", "touched down");
                    imgflecha.setX(x);
                    imgflecha.setY(y);
                    break;
                case MotionEvent.ACTION_MOVE:
                    Log.i("TAG", "moving: (" + x + " , " + y + ")");
                    imgflecha.setX(x);
                    imgflecha.setY(y);
                    break;
                case MotionEvent.ACTION_UP:
                    Log.i("TAG", "touched up");
                    break;
            }
        }
        return true;
    }
}