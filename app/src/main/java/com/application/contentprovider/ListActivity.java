package com.application.contentprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Note> arrayList;
    Note note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView=(ListView)findViewById(R.id.listOfContacts);
        arrayList=new ArrayList();


            Uri uri= Uri.parse("content://com.notesmanagement.own.PROVIDER");
            ContentResolver resolver = getContentResolver();
            Cursor cursor = resolver.query(uri, null, null, null, null);

            if (cursor.moveToFirst()) {
                do {
                    String id1=cursor.getString(cursor.getColumnIndex("_id"));
                    String title = cursor.getString(cursor.getColumnIndex("_title"));
                    String dateOfCreation = cursor.getString(cursor.getColumnIndex("_dateOfCreation"));
                     note=new Note(id1,title,dateOfCreation);
                    arrayList.add(note);

                }while (cursor.moveToNext());



            }
            ArrayAdapter arrayAdapter=new ArrayAdapter(ListActivity.this,android.R.layout.simple_expandable_list_item_1,arrayList);
            listView.setAdapter(arrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),DetailsActivity.class);
                Note note= (Note) listView.getAdapter().getItem(position);
                intent.putExtra("ID",note.get_id());
                intent.putExtra("name",note.get_title());
                intent.putExtra("dateOfC",note.get_dateOfCreation());
                startActivity(intent);
            }
        });
        }
    }

