package com.example.bai_3_toan_b1704780;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context that = this;
        setContentView(R.layout.activity_main);
        final FrameLayout hienthi = (FrameLayout)findViewById(R.id.framelayout);
        final TextView tx = (TextView) findViewById(R.id.textView);
        final Button bai1 = (Button) findViewById(R.id.class1);
        final Button bai2 = (Button) findViewById(R.id.class2);
        final Button bai3 = (Button) findViewById(R.id.class3);
        final Button bai4 = (Button) findViewById(R.id.class4);
        final Button thoat = (Button)findViewById(R.id.button1);
        final Button trove = (Button)findViewById(R.id.button2);

        final VeCoBan ve = new VeCoBan(this);
        bai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new clsNView(ve, hienthi).run();
            }
        });

        final ChuyenDong chuyenDong = new ChuyenDong(this);
        bai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new clsNView(chuyenDong, hienthi).run();
            }
        });

        final TuongTac tuongTac = new TuongTac(this);
        bai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new clsNView(tuongTac, hienthi).run();
            }
        });

        bai4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final GamePanel view = new GamePanel(that);;
                new clsNView(view, hienthi).run();
                view.setFinishGameAction(new clsNView(tx, hienthi));
            }
        });
        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
        trove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new clsNView(tx, hienthi).run();
                //Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                //finish();
                //startActivity(intent);
            }
        });
    }
    class clsNView implements Runnable {
        View view;
        FrameLayout fl;
        clsNView(View inp, FrameLayout fl){
            this.view = inp;
            this.fl = fl;
        }
        public void run(){
            fl.removeAllViews();
            fl.addView(view);
        }
    }
}
