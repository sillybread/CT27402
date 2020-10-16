package com.example.bai_3_toan_b1704780;
import android.graphics.*;
import android.view.*;
public class ThreadView extends Thread{
    private GamePanel mpanel; // Khai báo 1 thể hiện của lớp Gamepanel
    private SurfaceHolder mholder; //Khai báo 1 đối tượng quản lý giao diện mức thấp
    private boolean mrun = false; // Khai báo biền điều kiện cho vòng lặp while
    //Contructor
    public ThreadView (GamePanel panel){
        mpanel = panel;
        mholder = mpanel.getHolder();
    }
    public void setRunning(boolean run){
        mrun = run;
    }
    @Override
    public void run() {
        Canvas canvas = null;
        while (mrun){
            canvas = mholder.lockCanvas(); // Hàm lockCanvas () tạo một canvas để vẽ
            if(canvas != null)
            {
                mpanel.doDraw(canvas); //Thực hiện hành động trên canvas (hiển thị)
                mholder.unlockCanvasAndPost(canvas); //Hoàn thành việc vẽ trên canvas
            }
        }
    }
}