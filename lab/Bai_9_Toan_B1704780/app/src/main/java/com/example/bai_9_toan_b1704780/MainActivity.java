package com.example.bai_9_toan_b1704780;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void makeIntent(Class toActivity){
        Intent intent = new Intent(this, toActivity);
        startActivity(intent);
    }
    public void displayAllContact(View v) {
        makeIntent(DisplayAllContact.class);
    }
    public void displayAllCallLog(View v) {
        makeIntent(DisplayAllCallLog.class);
    }
    public void mediaContent(View v) {
        makeIntent(MediaContent.class);
    }
}