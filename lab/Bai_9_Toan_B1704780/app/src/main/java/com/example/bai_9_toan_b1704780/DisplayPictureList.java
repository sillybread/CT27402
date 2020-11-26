package com.example.bai_9_toan_b1704780;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.database.Cursor;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
public class DisplayPictureList extends AppCompatActivity {
    Button backfromficture;
    ListView lvpicture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_picture_list);
        backfromficture = (Button) findViewById(R.id.btntrove3);
        lvpicture = (ListView) findViewById(R.id.lvmedia);
        backfromficture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ArrayList<String> listImage = new ArrayList<String>();
        ArrayAdapter<String> adapterImage = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listImage);
        lvpicture.setAdapter(adapterImage);
        // get toan bo danh sach hình ảnh
        String[] projection = new String[]{
                MediaStore.Images.Media._ID,
                MediaStore.Images.Media.TITLE,
                MediaStore.Images.Media.DATE_ADDED
        };
        Cursor cursor =
                getApplicationContext().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                        projection, null, null, null);
        int count = 0;
        if (cursor.moveToFirst()){
            do {
                String ds =
                        "count: " + count
                                + "\n_id: " + cursor.getString(0)
                                + "\ntitle: " + cursor.getString(1)
                                + "\ndata_added: " + cursor.getString(2)
                                + "\n--------------------------";
                listImage.add(ds);
                adapterImage.notifyDataSetChanged();
                count++;
            }
            while( cursor.moveToNext() );
        }
        cursor.close();
    }
}
