package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {
    private int maxCurvature = -100;
    private int circleVal = 0;

    public MyView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    public MyView(Context context, AttributeSet attrs,
                           int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public void setCircleVal(int circleVal){
        this.circleVal = circleVal;
    }

    public int getCircleVal(){return circleVal;}

    public void setMaxCurvature(int maxCurvature){
        this.maxCurvature = maxCurvature;
    }

    public int getMaxCurvature(){
        return maxCurvature;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        float width = (float) getWidth();
        float height = (float) getHeight();
        float radius;

        if (width > height) {
            radius = height / 2;
        } else {
            radius = width / 2;
        }

        Path path = new Path();
        path.addCircle(width / 2,
                height / 2, radius,
                Path.Direction.CW);

        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#00a94f"));
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.FILL);

        float center_x, center_y;
        final RectF oval = new RectF();
        paint.setStyle(Paint.Style.FILL);

        center_x = width / 2;
        center_y = height / 3;

//        oval.set(center_x - radius,
//                center_y - radius,
//                center_x + radius,
//                center_y + radius);
        circleVal = circleVal >= 0 ? 0 : (Math.max(circleVal, maxCurvature));
        oval.set(0, circleVal, width, -circleVal);
        canvas.drawArc(oval, 0, 180, false, paint);
    }
}
