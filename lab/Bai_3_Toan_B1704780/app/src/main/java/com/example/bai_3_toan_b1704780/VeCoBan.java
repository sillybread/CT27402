package com.example.bai_3_toan_b1704780;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

public class VeCoBan extends View{
    private final Paint paint=new Paint();
    public VeCoBan(Context context){super(context);}
    @Override
    protected void onDraw (Canvas canvas){
        super.onDraw(canvas);
        int cvWidth = canvas.getWidth(); //Lấy chiều ngang của màn hình.
        int cvHeight = canvas.getHeight(); // Lấy chiều dọc của màn hình.
        int unitSz = cvWidth/18;

        // cho canvas màu trắng
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);

        //Vẽ text "LẬP TRÌNH GIAO DIỆN MỨC THẤP"
        paint.setColor(Color.MAGENTA);
        paint.setTextSize(unitSz);
        canvas.drawText("LẬP TRÌNH GIAO DIỆN MỨC THẤP", unitSz, unitSz * 8/6, paint);

        // Hiển thị kích thước màn hình
        paint.setColor(Color.BLUE);
        paint.setTextSize(unitSz * 5/6);
        canvas.drawText("Chiều rộng của màn hình ="+Integer.toString(cvWidth), unitSz * 8/6,unitSz*5/2,paint);
        canvas.drawText("Chiều cao của màn hình = " + Integer.toString(cvHeight), unitSz * 8/6, unitSz*7/2,paint);

        // Khai báo 1 hình chữ nhật để vẽ cung trong đó
        RectF rectF = new RectF(unitSz/2, unitSz*5, unitSz*(1/2+8), unitSz*(5+8));
        paint.setColor(Color.WHITE);
        canvas.drawOval(rectF,paint);//Hình Oval nằm trong hình chữ nhật chứa cung sắp vẽ
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(rectF,-135,90,true,paint); // Vẽ cung

        //Vẽ circle
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        canvas.drawCircle(unitSz*(1/2+10), unitSz*7, unitSz*2, paint);

        //Vẽ line
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        canvas.drawLine(unitSz*13, unitSz*5, unitSz*17, unitSz*9, paint);

        //Vẽ hình chữ nhật đầy màu
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(20, unitSz*10, cvWidth-20,cvHeight-20, paint);

        // Vẽ rotated text "Seahorse"
        paint.setColor(Color.RED);
        canvas.rotate(-45, unitSz*10, unitSz*20); // Quay canvas -45 độ
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(unitSz*10/6);
        canvas.drawText("Seahorse", unitSz*10, unitSz*20, paint);

        //canvas.restore();
        canvas.rotate(45, unitSz*10, unitSz*20); // Quay canvas trở lại (thay hàm restore)

        //Vẽ image
        Resources res = this.getResources();
        Bitmap bit = BitmapFactory.decodeResource(res,R.drawable.seahorse);
        float bw=bit.getWidth(); //the width of the bitmap
        float xstar=unitSz; //the coordinates of the left edge of the rectangle
        float ystar=unitSz*14 ; //the coordinates of the top edge of the rectangle
        RectF rectF2 = new RectF(xstar,ystar, xstar+bw,ystar+bw); //defined rectangle
        canvas.drawBitmap(bit,null,rectF2,paint);
    }
}
