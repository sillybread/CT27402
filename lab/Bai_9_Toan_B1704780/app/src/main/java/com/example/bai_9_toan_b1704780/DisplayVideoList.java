package com.example.bai_9_toan_b1704780;
import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentUris;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.BaseColumns;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class DisplayVideoList extends AppCompatActivity {
    Button back4;
    ListView video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_video_list);
        back4 = (Button) findViewById(R.id.btntrove4);
        video = (ListView) findViewById(R.id.lvvideo);
        ArrayList<Bitmap> list4 = new ArrayList<Bitmap>();
        ArrayAdapter<Bitmap> adapter4 = new ArrayAdapter<Bitmap>(this,
                android.R.layout.simple_list_item_1, list4);
        video.setAdapter(adapter4);
        ContentResolver cr = getContentResolver();
        String[] proj = {BaseColumns._ID};
        Cursor c = cr.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, proj,
                null, null, null);
        if (c.moveToFirst()) {
            do
            {
                int id = c.getInt(0);
                Bitmap b = MediaStore.Video.Thumbnails.getThumbnail(cr, id,
                        MediaStore.Video.Thumbnails.MINI_KIND, null);
                Log.d("*****My Thumbnail*****", "onCreate bitmap " + b);
                list4.add(b);
                adapter4.notifyDataSetChanged();
            }
            while( c.moveToNext() );
        }
        c.close();
        back4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public static Bitmap retriveVideoFrameFromVideo(String videoPath) throws
            Throwable {
        Bitmap bitmap = null;
        MediaMetadataRetriever mediaMetadataRetriever = null;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(videoPath, new HashMap<String,
                    String>());
            // mediaMetadataRetriever.setDataSource(videoPath);
            bitmap = mediaMetadataRetriever.getFrameAtTime();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Throwable("Exception in retriveVideoFrameFromVideo(String videoPath)" + e.getMessage());
        } finally {
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
        }
        return bitmap;
    }
}
