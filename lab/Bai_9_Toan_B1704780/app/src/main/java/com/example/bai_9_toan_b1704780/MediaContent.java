package com.example.bai_9_toan_b1704780;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
public class MediaContent extends AppCompatActivity {
    Button popupmenu, back5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_content);
        popupmenu = (Button) findViewById(R.id.mediaMenu);
        back5 = (Button) findViewById(R.id.btntrove5);
        back5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        popupmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu();
            }
        });
    }
    // Tạo Popup menu
    private void showPopupMenu(){
        // Tạo 1 popupmenu.
        PopupMenu popupMenu=new PopupMenu(this,popupmenu);
        //Lấy giao diện menu trong resoucse.

        popupMenu.getMenuInflater().inflate(R.menu.menu_popup,popupMenu.getMenu());
        //Lập trình hành động khi chọn item.

        popupMenu.setOnMenuItemClickListener(new
        PopupMenu.OnMenuItemClickListener() {
             @Override
             public boolean onMenuItemClick(MenuItem item) {
                 switch (item.getItemId()) {
                     case R.id.audio:
                         Intent intent1 = new Intent(MediaContent.this,
                                 DisplayAudioList.class);
                         startActivity(intent1);
                         break;
                 }
                 switch (item.getItemId()) {
                     case R.id.video:
                         Intent intent2 = new Intent(MediaContent.this,
                                 DisplayVideoList.class);
                         startActivity(intent2);;
                         break;
                 }
                 switch (item.getItemId()) {
                     case R.id.picture:
                         Intent intent3 = new Intent(MediaContent.this,
                                 DisplayPictureList.class);
                         startActivity(intent3);
                         break;
                 }
                 return false;
             }
         });
        popupMenu.show();
    }
}