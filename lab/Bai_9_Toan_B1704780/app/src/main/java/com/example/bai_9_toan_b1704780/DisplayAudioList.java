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
public class DisplayAudioList extends AppCompatActivity {
    Button backaudio;
    ListView lvaudio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_audio_list);
        backaudio = (Button) findViewById(R.id.btntrove3);
        lvaudio = (ListView) findViewById(R.id.lvmedia);
        ArrayList<String> listaudio = new ArrayList<String>();
        ArrayAdapter<String> adapteraudio = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listaudio);
        lvaudio.setAdapter(adapteraudio);
        // lay cac cot nhu trong bang projection
        String[] projection = new String[]{ MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.ARTIST, MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.DISPLAY_NAME,
                MediaStore.Audio.Media.DURATION };
        Cursor cursor =
                getApplicationContext().getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                        projection, null, null,
                        "LOWER(" + MediaStore.Audio.Media.TITLE + ") ASC");
        int count = 0;
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false) {
            String ds =
                    "count: " + count
                            + "\n_id: " + cursor.getString(0)
                            + "\n artist: " + cursor.getString(1)
                            + "\ntitle: " + cursor.getString(2)
                            + "\ndata: " + cursor.getString(3)
                            + "\ndisplay name: " + cursor.getString(4)
                            + "\n duration: " + cursor.getString(5)
                            + "\n--------------------------";
            listaudio.add(ds);
            adapteraudio.notifyDataSetChanged();
            // log toan bo danh sach bai hat ra logcat
            Log.d("List Music",
                    "\ncount: " + count + "\n_id: " + cursor.getString(0)
                            + "\n artist: " + cursor.getString(1) + "\ntitle: "
                            + cursor.getString(2) + "\ndata: "
                            + cursor.getString(3) + "\ndisplay name: "
                            + cursor.getString(4) + "\n duration: "
                            + cursor.getString(5)
                            + "\n--------------------------");
            cursor.moveToNext();
            count++;
        }
        cursor.close();
        backaudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
