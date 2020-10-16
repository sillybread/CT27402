package com.example.bai_3_toan_b1704780;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.*;
public class Bug {
    Bitmap background;
    Bitmap bitmap;
    int dia;
    int x = 70;
    int y = 70;
    int w, h;
    int sX = 10;
    int sY = 10;
    public Bug(Context context){
        Resources res = context.getResources();
        bitmap = BitmapFactory.decodeResource(res,R.drawable.bug);
        background = BitmapFactory.decodeResource(res, R.drawable.background);
    }
    public void onDraw(Canvas c)
    {
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        dia = bitmap.getWidth();
        w = c.getWidth();
        h = c.getHeight();
        c.drawPaint(paint);
        RectF bgFrame = new RectF(0,0, w,h); //defined rectangle
        c.drawBitmap(background, null, bgFrame, paint);
        c.drawBitmap(bitmap, x, y, paint);
        x += sX;
        y += sY;
        //Neu cham bien thi quay lai va doi Ball
        if (x<=0||(x>=w- dia)) {
            sX = -sX;
        }
        if (y<=0||y>=h-dia) {
            sY = -sY;
        }
    }
}
