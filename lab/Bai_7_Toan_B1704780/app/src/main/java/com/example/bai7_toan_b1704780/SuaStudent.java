package com.example.bai7_toan_b1704780;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SuaStudent extends AppCompatActivity {
    DBAdapter db = new DBAdapter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_student);
        final EditText sott=(EditText)this.findViewById(R.id.stt);//Thêm
        final EditText masosv=(EditText)this.findViewById(R.id.mssv);//Thêm
        final EditText ten=(EditText)this.findViewById(R.id.hoten);
        final EditText email=(EditText)this.findViewById(R.id.email);
        final TextView ct=(TextView)this.findViewById(R.id.studentduocsua);
        final EditText sdt=(EditText)this.findViewById(R.id.sdt);
        Button suacontact=(Button)this.findViewById(R.id.btnsua);
        Button trove=(Button)this.findViewById(R.id.btntrove);
        suacontact.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                db.open();
                String masosinhvien=masosv.getText().toString();
                String tensv=ten.getText().toString();
                String e_mail=email.getText().toString();
                String sodienthoai=sdt.getText().toString();
                String sID = sott.getText().toString();
                int chiso=Integer.parseInt(sID);
                //---update contact---
                if (db.updateStudent(chiso,masosinhvien, tensv,e_mail,sodienthoai)) {
                    ct.setText("thành công.");
                    // Hiển thị contact được sửa
                    Cursor c = db.getAllStudent();
                    //c.moveToPosition(0);//chiso - 1);
                    while (c.moveToNext()){
                        if (c.getString(0).compareTo(sID)==0){
                            String tx = "id: " + c.getString(0) + "\n" +
                                    "MSSV: " + c.getString(1) + "\n" +
                                    "Name: " + c.getString(2) + "\n" +
                                    "Email: " + c.getString(3) + "\n" +
                                    "SDT: " + c.getString(4);
                            ct.setText(tx);
                            break;
                        }
                    }
                    }
                else
                    ct.setText("không thành công, đây là giá trị cũ, vui lòng thực hiện lại lần nữa");
                db.close();
            }
        });
        trove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(SuaStudent.this,MainActivity.class);
                startActivity(intent3);
            }
        });
    }
}
