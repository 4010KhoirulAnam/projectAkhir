package com.example.projectakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class DetailBarang extends AppCompatActivity {

    ImageView gambarget;
    Button btnpesan;

    int gambarBarang;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_barang);

        gambarget = findViewById(R.id.getgambar);
        final Spinner list = findViewById(R.id.spnitem);
        btnpesan = findViewById(R.id.btnPesen);

        Bundle bundle = getIntent().getExtras();

        gambarBarang = bundle.getInt("gambarbarang");
        gambarget.setImageResource(gambarBarang);

        btnpesan.setOnClickListener(v -> Toast.makeText(getApplicationContext(), "Saya Pesan " + list.getSelectedItem(), Toast.LENGTH_LONG).show());
    }
}