package com.example.bai_10_toan_b1704780;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    EditText textBox; Button SaveExt, LoadExt, help;
    static final int READ_BLOCK_SIZE = 100;
    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textBox = (EditText) findViewById(R.id.txtText1);
        SaveExt = (Button)findViewById(R.id.btnSave2);
        LoadExt = (Button)findViewById(R.id.btnLoad2);
        help = (Button) findViewById(R.id.help);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tnt= new Intent(MainActivity.this,StaticResources.class);
                startActivity(tnt);
            }
        });
    }
    public void onClickSaveInternal(View view) {
        String str = textBox.getText().toString();
        try {
            FileOutputStream fOut = openFileOutput("textfile.txt", MODE_APPEND);
            OutputStreamWriter osw = new OutputStreamWriter(fOut);
            //---write the string to the file---
            osw.write(str);
            osw.flush();
            osw.close();
            //---display file saved message---
            Toast.makeText(getBaseContext(), "File saved successfully!",
                    Toast.LENGTH_SHORT).show();
            //---clears the EditText---
            textBox.setText(" ");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    public void onClickLoadInternal(View view) {
        try {
            //……………………………………………………………………………………………………….
            FileInputStream fIn = openFileInput("textfile.txt");
            InputStreamReader isr = new InputStreamReader(fIn);
            char[] inputBuffer = new char[READ_BLOCK_SIZE];
            String s = "";
            int charRead;
            while ((charRead = isr.read(inputBuffer)) > 0) {
                //---convert the chars to a String---
                String readString =
                        String.copyValueOf(inputBuffer, 0, charRead);
                s += readString;
                inputBuffer = new char[READ_BLOCK_SIZE];
            }
//---set the EditText to the text that has been
// read---
            textBox.setText(s);
            Toast.makeText(getBaseContext(),
                    "File loaded successfully!",Toast.LENGTH_SHORT).show();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    public void onClickSaveExternal (View view) {
        String str = textBox.getText().toString();
        try
        {
            //---Luu tren SD Card---
            File sdCard = Environment.getExternalStorageDirectory();
            File directory =
                    new File (sdCard.getAbsolutePath() + "/MyFiles");
            directory.mkdirs();
            File file = new File(directory, "textfile.txt");
            FileOutputStream fOut = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fOut);
            //---write the string to the file---
            osw.write(str);
            osw.flush();
            osw.close();
//---display file saved message---
            Toast.makeText(getBaseContext(),"File saved successfully!",
                    Toast.LENGTH_SHORT).show();
            //---clears the EditText---
            textBox.setText(" ");
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
    public void onClickLoadExternal(View view){
        try {
            //--- Đọc file lưu trên SD---
            File sdCard = Environment.getExternalStorageDirectory();
            File directory =
                    new File (sdCard.getAbsolutePath()+"/MyFiles");
            File file = new File(directory, "textfile.txt");
            FileInputStream fIn = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fIn);
            char[] inputBuffer = new char[READ_BLOCK_SIZE];
            String s = "";
            int charRead;
            while ((charRead = isr.read(inputBuffer)) > 0) {
                //---convert the chars to a String---
                String readString =
                        String.copyValueOf(inputBuffer, 0, charRead);
                s += readString;
                inputBuffer = new char[READ_BLOCK_SIZE];
            }
//---set the EditText to the text that has been
// read---
            textBox.setText(s);
            Toast.makeText(getBaseContext(),
                    "File loaded successfully!",Toast.LENGTH_SHORT).show();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
