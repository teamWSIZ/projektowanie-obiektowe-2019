package com.e.multipleactivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button buttonActivity1;
    Button buttonActivity2;
    Button buttonActivity3;
    Button buttonActivity4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonActivity1 = findViewById(R.id.button1);
        buttonActivity2 = findViewById(R.id.button2);
        buttonActivity3 = findViewById(R.id.button3);
        buttonActivity4 = findViewById(R.id.button4);

        buttonActivity1.setOnClickListener(v->{
            Intent intent1 = new Intent(this,Activity1.class);
            startActivity(intent1);
        });
        buttonActivity2.setOnClickListener(v->{});
        buttonActivity3.setOnClickListener(v->{});
        buttonActivity4.setOnClickListener(v->{});
    }
}
