package com.example.tronzomb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import androidx.annotation.NonNull;

public class JoystickView extends SurfaceView implements SurfaceHolder.Callback {
    JoystickThread thread;
    Bitmap bitmap;
    public JoystickView(Context context) {
        super(context);
        getHolder().addCallback(this);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.smile);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        thread = new JoystickThread (getContext(), getHolder(),bitmap);
        thread.start();

    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        try {
            thread.setFlag(false);
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        thread.setX((int)event.getX());
        thread.setY((int)event.getY());
        return super.onTouchEvent(event);
    }
}
