package com.example.projectakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Opening extends AppCompatActivity {

    private static final int Durasi = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);

        new Handler().postDelayed(() -> {
            Intent reg = new Intent(Opening.this, LoginActivity.class);
            startActivity(reg);
            finish();
        },Durasi);
    }
}