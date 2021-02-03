package com.example.appdatabasesederhana;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBconnector extends SQLiteOpenHelper {
    public static final String DB_NAME = "mahasiswa.db";

    public DBconnector(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Membuat data mahasiswa
        sqLiteDatabase.execSQL("create table mahasiswa " +
                "(nim text unique," +
                "nama text," +
                "fakultas text," +
                "jurusan text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists mahasiswa");
        onCreate(sqLiteDatabase);
    }

    public long insertMahasiswa(String nim, String nama,String fakultas , String jurusan) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nim", nim);
        cv.put("nama", nama);
        cv.put("fakultas", fakultas);
        cv.put("jurusan", jurusan);
        long hasil = db.insert("mahasiswa", null, cv);

        return hasil;
    }

    public ArrayList<String> getAllMahasiswa() {
        ArrayList<String> allMhs = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res = db.rawQuery("select * from mahasiswa", null);
        res.moveToFirst();

        while (res.isAfterLast() == false) {
            allMhs.add( res.getString(res.getColumnIndex("nim")) + " - " +
                    res.getString(res.getColumnIndex("nama")));
            res.moveToNext();
        }
        res.close();
        return allMhs;
    }
}
