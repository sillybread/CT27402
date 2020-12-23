package com.example.bai_13_toan_b1704780;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TextViewCompat;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button duyetWeb = (Button) this.findViewById(R.id.btnDuyetWeb);
        EditText url = (EditText) this.findViewById(R.id.inputURL);
        TextView nkType = (TextView) this.findViewById(R.id.nkType);
        TextView nkStatus = (TextView) this.findViewById(R.id.nkStatus);
        Button typeConn = (Button) this.findViewById(R.id.btnLoaiKetNoi);

        duyetWeb.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, WebAct.class);
                String sUrl = url.getText().toString();
                it.putExtra("address",sUrl);
                startActivity(it);
            }
        });

        typeConn.setOnClickListener(new View.OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                ConnectivityManager nk = getSystemService(ConnectivityManager.class);
                Network currNk = nk.getActiveNetwork();
                if (currNk == null){
                    nkType.setText("No default network is currently active");
                    nkStatus.setText("");
                    return;
                }
                NetworkInfo nki = nk.getNetworkInfo(currNk);
                switch (nki.getType()){
                    case ConnectivityManager.TYPE_MOBILE:
                        nkType.setText("GPRS");
                        nkStatus.setText("Network OK");
                        break;
                    case ConnectivityManager.TYPE_WIFI:
                        nkType.setText("Wifi");
                        nkStatus.setText("Network OK");
                        break;
                    default:
                        nkType.setText("No default network is currently active");
                        nkStatus.setText("");
                        break;
                }
            }
        });
    }
}