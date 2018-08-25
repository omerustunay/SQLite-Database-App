package com.example.dell.datatableexam;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;


/**
 * Created by omerustunay on 23/08/2018.
 */

public class MainActivity extends AppCompatActivity {

    EditText ad;
    EditText mail;
    EditText adres;
    Button ekle, listele;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ad = findViewById(R.id.editText);
        mail = findViewById(R.id.editText2);
        adres = findViewById(R.id.editText3);
        ekle = findViewById(R.id.button3);
        listele = findViewById(R.id.button2);
        listView = findViewById(R.id.list);

        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ad1=ad.getText().toString();
                String mail1=mail.getText().toString();
                String adres1=adres.getText().toString();

                if(ad1.isEmpty() || mail1.isEmpty() || adres1.isEmpty()){
                    Toast.makeText(getApplicationContext(),"alanları doldurunuz",Toast.LENGTH_SHORT).show();
                }
                else{
                    DataBase db = new DataBase(MainActivity.this);
                    db.VeriEkle(ad.getText().toString(), mail.getText().toString(), adres.getText().toString());
                    Toast.makeText(getApplicationContext(), "kaydetme işlemi başarılı ", Toast.LENGTH_SHORT).show();
                    ad.setText("");
                    mail.setText("");
                    adres.setText("");
                }
            }
        });


        listele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(intent);

               /* DataBase db = new DataBase(MainActivity.this);
                List<String> vVeriler = db.Listele();
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, vVeriler);
                listView.setAdapter(adapter);*/
            }
        });
    }
}


