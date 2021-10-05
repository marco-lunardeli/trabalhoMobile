package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MenuActivity extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        button1 = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button4);
        button3 = (Button) findViewById(R.id.button6);

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MenuActivity.this, MangaActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MenuActivity.this, CaracterActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MenuActivity.this, WeaponActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });
    }
}