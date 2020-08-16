package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity4 extends AppCompatActivity {

    Button button7,button8,button9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        button7 = findViewById(R.id.button6);
        button8= findViewById(R.id.button7);
        button9 = findViewById(R.id.button8);

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity4.this, MainActivity3.class);
                startActivity(intent);
            }

        });
    button8.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent2 = new Intent(MainActivity4.this, MainActivity.class);
            startActivity(intent2);
        }
    });
    button9.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent3 = new Intent(MainActivity4.this, MainActivity3.class);
            startActivity(intent3);
        }
    });
    }
}