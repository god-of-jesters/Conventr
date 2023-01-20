package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button but = findViewById(R.id.button);
        Button b = findViewById(R.id.button2);

        but.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startNewW(v);
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startNewC(v);
            }
        });
    }

    public void startNewW(View v){
        Intent intent = new Intent(this, WiatActivityR.class);
        startActivity(intent);
    }

    public void startNewC(View v){
        Intent intent = new Intent(this, Cripto.class);
        startActivity(intent);
    }
}