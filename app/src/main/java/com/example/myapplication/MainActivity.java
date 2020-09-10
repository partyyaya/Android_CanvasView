package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {
    private MyView myView;
    private int beforeYPos = -1,displacement = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();//隱藏標題列
        myView = findViewById(R.id.myView);
        myView.setMaxCurvature(-100);// 設定最大曲度,負數越大彎曲度越大
        myView.setCircleVal(-100);// 設定初始曲度
        myView.invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int)event.getX();
        int y = (int)event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                beforeYPos = y;
                break;
            case MotionEvent.ACTION_MOVE:
                // -100:橢圓 0:平
                displacement = (beforeYPos-y);
                myView.setCircleVal(myView.getCircleVal()+displacement);
                myView.invalidate();
                break;
            case MotionEvent.ACTION_UP:
                beforeYPos = -1;
                displacement = 0;
                break;
        }

        return false;
    }

}
