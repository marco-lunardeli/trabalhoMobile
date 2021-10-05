package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    TextView textView;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        textView = (TextView) findViewById(R.id.textButtonCadastro);

        textView2 = (TextView) findViewById(R.id.button2);

        textView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(LoginActivity.this, MenuActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });
    }
}