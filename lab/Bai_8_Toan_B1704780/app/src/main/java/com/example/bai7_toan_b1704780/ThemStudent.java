package com.example.bai7_toan_b1704780;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.database.Cursor;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class ThemStudent extends AppCompatActivity {
    DBAdapter db = new DBAdapter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_student);
        //Thêm contact
        final EditText masosv=(EditText)this.findViewById(R.id.mssv);//Thêm
        final EditText ten=(EditText)this.findViewById(R.id.hoten);
        final EditText email=(EditText)this.findViewById(R.id.email);
        final TextView ct=(TextView)this.findViewById(R.id.studentduocthem);
        final EditText sdt=(EditText)this.findViewById(R.id.sdt);
        Button themcontact=(Button)this.findViewById(R.id.btnthem);
        Button trove=(Button)this.findViewById(R.id.btntrove);
        themcontact.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                db.open();
                String masosinhvien=masosv.getText().toString();//Thêm
                String hoten=ten.getText().toString();
                String e_mail=email.getText().toString();
                String sodienthoai=sdt.getText().toString();
                long id = db.insertStudent(hoten,masosinhvien, e_mail, sodienthoai);//Sửa
                // Hiển thị contact được thêm
                Cursor c = db.getAllStudent();
                c.moveToLast();//Có thêm
                String tx="id: " + c.getString(0) + "\n" +
                        "MSSV: " + c.getString(1) + "\n" +
                        "Name: " + c.getString(2) + "\n" +
                        "Email: " + c.getString(3) + "\n" +
                        "Số điện thoại: " + c.getString(4);
                ct.setText(tx);
                db.close();
            }
        });
        trove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ThemStudent.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
