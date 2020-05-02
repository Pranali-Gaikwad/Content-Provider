package com.application.contentprovider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContentProviderOperation;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CreateActivity extends AppCompatActivity {
    EditText title;
    Button add;

    ArrayList<ContentProviderOperation> operations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        title = findViewById(R.id.name);

        add = findViewById(R.id.buttonAdd);
        operations = new ArrayList<ContentProviderOperation>();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    createNote();

            }
        });
    }

    private void createNote(){
        ContentResolver contentResolver=getContentResolver();
        String title1=title.getText().toString();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        String strDate = sdf.format(new Date());
        ContentValues contentValues=new ContentValues();
        contentValues.put("_title",title1);
        contentValues.put("_dateOfCreation",strDate);
        contentResolver.insert(Uri.parse("content://com.notesmanagement.own.PROVIDER"),contentValues);
        Toast.makeText(this,"Note Add Successfully", Toast.LENGTH_LONG).show();
        finish();
    }


}

