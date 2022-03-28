package com.example.tronzomb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

public class JoystickThread extends Thread {

    private boolean flag = true;
    private SurfaceHolder holder;
    private Context context;
    private Paint paint = new Paint();
    private int x = -1;
    private int y = -1;
    private int objectX = 500;
    private int objectY = 500;
    private Bitmap bitmap;

    public JoystickThread(Context context, SurfaceHolder holder, Bitmap bitmap) {
        this.holder = holder;
        this.context = context;
        paint.setTextSize(20);
        paint.setColor(Color.WHITE);
        this.bitmap = bitmap;
    }

    public void run() {
        while (flag) {
            Canvas canvas = holder.lockCanvas();
            try {
                canvas.drawARGB(255,255,255,255);
                if (x > 0 && x < objectX + bitmap.getWidth() / 2) objectX -=20;
                if (y > 0 && y < objectY + bitmap.getHeight() / 2) objectY -=20;
                if (x > 0 && x > objectX + bitmap.getWidth() / 2) objectX +=20;
                if (y > 0 && y > objectY + bitmap.getHeight() / 2) objectY +=20;

                x = -1;
                y = -1;
                canvas.drawBitmap(bitmap,0,0,paint);
                //canvas.drawText("Click on a screen to move me.", objectX, objectY, paint);
            } catch (Throwable e) {

            } finally {
                if (canvas !=null) holder.unlockCanvasAndPost(canvas);
            }
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
