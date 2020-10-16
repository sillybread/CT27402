package com.example.bai_3_toan_b1704780;
import android.view.View;
import android.content.Context;
import android.graphics.*;
import android.view.MotionEvent;
public class TuongTac extends View {
    public final Paint paint =new Paint();
    public final Canvas c =new Canvas();
    public Bitmap bitmap;
    public float x=50;
    public float y=50;
    public int duongkinh;
    public String st=" Begin test touch";
    public TuongTac(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }
    @Override
    protected void onDraw(Canvas c) {
        // TODO Auto-generated method stub
        super.onDraw(c);
        paint.setColor(Color.WHITE);
        c.drawPaint(paint);
        paint.setColor(Color.BLUE);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.network);
        c.drawBitmap(bitmap, x, y, paint);
        duongkinh=bitmap.getWidth();
        paint.setTextSize(60);
        c.drawText(st, x, y, paint);
    }
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x = event.getX() - (duongkinh/2);
                y = event.getY() - (duongkinh/2);
                st= "ACTION Down";
                break;
            case MotionEvent.ACTION_MOVE:
                x = event.getX() - (duongkinh/2);
                y = event.getY() - (duongkinh/2);
                st="ACTION Move";
                break;
            case MotionEvent.ACTION_UP:
                x = event.getX() - (duongkinh/2);
                y = event.getY() - (duongkinh/2);
                st="ACTION Up";
                break;
        }
        invalidate();
        return true;
    }
}
