package com.example.appdatabasesederhana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class input extends AppCompatActivity {

    private DBconnector db;
    private EditText editnim, editnama, editfakultas, editjurusan;
    private Button btnsimpan, btnkembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        db = new DBconnector(this);
        editnim = (EditText)findViewById(R.id.editnim);
        editnama = (EditText)findViewById(R.id.editnama);
        editfakultas = (EditText)findViewById(R.id.editfakultas);
        editjurusan = (EditText)findViewById(R.id.editjurusan);
        btnsimpan = (Button)findViewById(R.id.btnsimpan);
        btnkembali = (Button)findViewById(R.id.btnkembali);
    }

    public void btnsimpan_Onclick(View v) {
        long hasilInsert = db.insertMahasiswa(
                editnim.getText().toString(),
                editnama.getText().toString(),
                editfakultas.getText().toString(),
                editjurusan.getText().toString());
        if(hasilInsert != -1) { //mengecek hasil insert
            Toast.makeText(getApplicationContext(),
                    "Data mahasiswa berhasil disimpan", Toast.LENGTH_LONG).show();
            finish(); //untuk kembali ke layar
        } else {
            Toast.makeText(getApplicationContext(),
                    "Data mahasiswa gagal disimpan", Toast.LENGTH_LONG).show();
        }
    }

    public void btnkembali_Onclick(View v) {
        Intent GotoList = new Intent(this, MainActivity.class);
        startActivity(GotoList);
    }
}