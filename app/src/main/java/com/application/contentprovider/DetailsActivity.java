package com.application.contentprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.text.SimpleDateFormat;
import java.util.Date;

public class DetailsActivity extends AppCompatActivity {
    EditText textView2,textView3;
    Button edit, delete;
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        textView1=findViewById(R.id.idofNote);
        textView2=findViewById(R.id.name);
        textView3=findViewById(R.id.date);
        edit=findViewById(R.id.buttonEdit);
        delete=findViewById(R.id.buttonDelete);
        Intent intent=getIntent();

        textView1.setText(intent.getStringExtra("ID"));
        textView2.setText(intent.getStringExtra("name"));
        textView3.setText(intent.getStringExtra("dateOfC"));
        Log.d("Debug",textView1.getText().toString()+" "+textView2.getText().toString()+" "+textView3.getText().toString());

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateNote();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteNote();
            }
        });

    }
    private void updateNote(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        String strDate = sdf.format(new Date());
        ContentValues contentValues=new ContentValues();
        contentValues.put("_title",textView2.getText().toString());
        contentValues.put("_dateOfCreation",strDate);
        String whereClause= "_id= ?";
        String [] whereValues=new String []{textView1.getText().toString()};
        getContentResolver().update(Uri.parse("content://com.notesmanagement.own.PROVIDER"),contentValues,whereClause,whereValues);

        finish();
    }
    private void deleteNote() {
        String noteId=textView1.getText().toString();
       getContentResolver().delete(Uri.parse("content://com.notesmanagement.own.PROVIDER"),"_id= ?",new String[]{noteId});

        finish();
    }
}
