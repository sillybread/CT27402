package com.example.bai_10_toan_b1704780;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
public class StaticResources extends AppCompatActivity {
    TextView hd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_resources);
        hd = (TextView)findViewById(R.id.txthd);
        hd.setMovementMethod(new ScrollingMovementMethod());
        InputStream is = this.getResources().openRawResource(R.raw.huongdan);
        InputStreamReader ir=new InputStreamReader(is);
        BufferedReader br = new BufferedReader(ir);
        String str = "";
        String line = null;
        try {
            while ((line = br.readLine()) != null) {
                str += line + "\n";
            }
            hd.setText(str);
            is.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}