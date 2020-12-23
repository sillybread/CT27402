package com.example.bai_14_toan_b1704780;
import android.app.ListActivity;
import android.os.Bundle;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class Inbox extends ListActivity {
    private ListAdapter adapter;
    @SuppressWarnings("deprecation")
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ListView lv = (ListView)findViewById(R.id.list);
        //ArrayList<String> list=new ArrayList<String>();
        //ContentResolver cr = getContentResolver();
        //ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,
        // android.R.layout.simple_list_item_1, list);
        //lv.setAdapter(adapter);
        Cursor c = getContentResolver().query(
                Uri.parse("content://sms/inbox"), null,
                null, null, null);
        startManagingCursor(c);
        //LoaderManager(c);
        String[] columns = new String[] { "body" };
        int[] names = new int[] { R.id.row };
        adapter=new SimpleCursorAdapter(this, R.layout.activity_inbox,
                c,columns,names);
        setListAdapter(adapter);
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long
            ida) {
        super.onListItemClick(l, v, position, ida);
        Cursor mycursor = (Cursor) getListView().getItemAtPosition(position);
 /*
 String tinnhan = "From" +
 mycursor.getString(mycursor.getColumnIndex("address")) +
 ":\n" + mycursor.getString(mycursor.getColumnIndex("body"));
 list.add(contact);
 adapter.notifyDataSetChanged();
 */
        Toast toast = Toast.makeText(Inbox.this, "From " +
                        mycursor.getString(mycursor.getColumnIndex("address")) + ":\n" +
                        mycursor.getString(mycursor.getColumnIndex("body")),
                Toast.LENGTH_LONG);
        toast.show();
    }
}
