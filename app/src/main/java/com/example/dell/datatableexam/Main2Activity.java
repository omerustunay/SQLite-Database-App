package com.example.dell.datatableexam;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class Main2Activity extends AppCompatActivity {

    ListView musteri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        musteri = findViewById(R.id.elemanyazdir);


        DataBase db = new DataBase(getApplicationContext());
        List<String> vVeriler = db.Listele();

        for (String cursor :vVeriler) {

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(Main2Activity.this,
                    android.R.layout.simple_list_item_1, android.R.id.text1, vVeriler);
            musteri.setAdapter(adapter);
        }

    }
}
