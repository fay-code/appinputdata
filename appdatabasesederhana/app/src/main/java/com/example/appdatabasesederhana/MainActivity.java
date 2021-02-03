package com.example.appdatabasesederhana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btninput, btnlist, btnpeta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btninput = (Button)findViewById(R.id.btninput);
        btnlist = (Button)findViewById(R.id.btnlist);
        btnpeta = (Button)findViewById(R.id.btnlokasi);
    }

    public void btninput_Onclick(View v) {
        Intent GotoInput = new Intent(this, input.class);
        startActivity(GotoInput);
    }

    public void btnlist_Onclick(View v) {
        Intent GotoList = new Intent(this, list.class);
        startActivity(GotoList);
    }

    public void btnpeta_Onclick(View v) {
        Intent GotoList = new Intent(this, PetaActivity.class);
        startActivity(GotoList);
    }

}