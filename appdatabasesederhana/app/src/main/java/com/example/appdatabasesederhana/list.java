package com.example.appdatabasesederhana;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class list extends AppCompatActivity {

    private DBconnector db;
    private ListView lvwMhs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        lvwMhs = (ListView)findViewById(R.id.lvMahasiswa);
        db = new DBconnector(this);

        ArrayList data_mhs = db.getAllMahasiswa();
        ArrayAdapter row_mhs = new ArrayAdapter(this, android.R.layout.simple_list_item_1, data_mhs);
        lvwMhs.setAdapter(row_mhs);
    }
}