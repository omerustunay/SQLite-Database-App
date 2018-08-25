package com.example.dell.datatableexam;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by omerustunay on 23/08/2018.
 */

public class DataBase extends SQLiteOpenHelper {

    private static final String database_name = "kisiler";
    private static final int database_version = 1;
    private static final String kisiler_table = "kisiler";

    private static final String row_ID = "id";
    private static final String row_name = "ad";
    private static final String row_mail = "mail";
    private static final String row_adres = "adres";

    public DataBase(Context context) {
        super(context, database_name, null, database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + kisiler_table + "(" + row_ID + " INTEGER PRIMARY KEY,"
                + row_name + " TEXT NOT NULL," + row_mail + " TEXT NOT NULL, " + row_adres + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {


        db.execSQL("DROP TABLE IF EXISTS " + kisiler_table);
        onCreate(db);
    }

    public void VeriEkle(String ad, String mail, String adres) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(row_name, ad.trim());
        cv.put(row_mail, mail.trim());
        cv.put(row_adres, adres.trim());
        db.insert(kisiler_table, null, cv);
        db.close();
    }

    public List<String> Listele() {
        List<String> veriler = new ArrayList<String>();
        SQLiteDatabase db = this.getWritableDatabase();
        String[] sutunlar = {row_ID, row_name, row_mail, row_adres};
        Cursor cursor = db.query(kisiler_table, sutunlar, null, null, null, null, null);

        while (cursor.moveToNext()) {
            veriler.add(cursor.getInt(0) + "-" + cursor.getString(1) + "-" + cursor.getString(2) + "-" + cursor.getString(3));
        }
        return veriler;

    }
}
