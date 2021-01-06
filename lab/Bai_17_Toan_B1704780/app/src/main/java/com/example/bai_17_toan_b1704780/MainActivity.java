package com.example.bai_17_toan_b1704780;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.socket.client.IO;
import io.socket.client.Manager;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import io.socket.engineio.client.Transport;

public class MainActivity extends AppCompatActivity {
    // Khai báo các View
    private Button mButtonLogin;
    private Button mButtonChat;
    private EditText edtContent;
    private ListView lvUser, lvChat;
    private ImageButton btnAdd, btnSend;
    private TextView mTVRequest;
    ArrayList<String> arrayUser, arrayChat;
    ArrayAdapter adapterUser, adapterChat;
    // Khai báo ip và port của Server
    // Gõ lệnh ipconfig trên Command Promp hoặc mở Tark Manager để tìm ip.
    private Socket mSocket; // Chọn Socket (IO.socket.client)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Ánh xạ các view từ layout
        btnAdd = findViewById(R.id.btn_login);
        btnSend = findViewById(R.id.btnchat);
        edtContent = findViewById(R.id.editTextContent);
        lvChat = findViewById(R.id.listviewChat);
        lvUser = findViewById(R.id.listviewUser);
        // Khởi tạo arrayUser, adapterUser và đưa arrayUser vào ListView
        arrayUser = new ArrayList<>();
        adapterUser = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayUser);
        lvUser.setAdapter(adapterUser);
        // Khởi tạo arrayChat, adapterChat và đưa arrayChat vào ListView
        arrayChat = new ArrayList<>();
        adapterChat = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayChat);
        lvChat.setAdapter(adapterChat);

        SocketHandler handler = new SocketHandler();
        mSocket = handler.getSocket();

        // Gởi yêu cầu kết nối
        mSocket.on("server-send-user", onListUser);
        mSocket.on("server-send-chat", onListChat);
        mSocket.on("connect", new Emitter.Listener() {
                @Override
                public void call(final Object... args) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "Connect success", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            });
        mSocket.on("connect_error", new Emitter.Listener() {
                @Override
                public void call(final Object... args) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "Connect error", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            });
        mSocket.connect();
        // Xử lý tương tác cho nút đăng ký user.
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Nếu có nhập tên vào EditText thì gởi đăng ký User.
                if(edtContent.getText().toString().trim().length()>0){
                    mSocket.emit("client-register-user",
                            edtContent.getText().toString());
                    // Nhớ sửa lại sự kiện bên Server
                }
            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Nếu có nhập message vào EditText thì gởi.
                if (edtContent.getText().toString().trim().length() > 0) {
                    mSocket.emit("client-send-chat",
                            edtContent.getText().toString());
                    // Nhớ sửa lại sự kiện bên Server
                }
            }
        });
    }
    private Emitter.Listener onListChat = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject object = (JSONObject) args[0];
                    try {
                        String noiDung = object.getString("chatComent");
                        arrayChat.add(noiDung);
                        adapterUser.notifyDataSetChanged();
                        lvChat.invalidateViews();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    };
    private Emitter.Listener onListUser = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject object = (JSONObject) args[0];
                    try {
                        JSONArray array = object.getJSONArray("danhsach");
                        adapterUser.clear();
                        for (int i = 0; i < array.length(); i++) {
                            String username = array.getString(i);
                            adapterUser.add(username);
                        }
                        adapterUser.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    };
    private Emitter.Listener onRetrieveResult = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject object = (JSONObject) args[0];
                    try {
                        //String ten = object.getString("noidung");
                        boolean exits = object.getBoolean("ketqua");
                        if(exits) {
                            Toast.makeText(MainActivity.this, "Tài khoản này đã tôn tại!", Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(MainActivity.this, "Đã đăng ký thành công", Toast.LENGTH_LONG).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    };

    private Emitter.Listener onConnect = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(MainActivity.this, "Connect Success", 1).show();
                }
            });
        }
    };
}