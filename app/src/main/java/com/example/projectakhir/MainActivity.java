package com.example.projectakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] nama_Barang = {"Radio", "Jam Pasir", "Jam Weker", "Kamera Analog", "Guci"};
        int[] img_Barang = {R.drawable.foto1, R.drawable.foto2, R.drawable.foto_3, R.drawable.foto_4, R.drawable.foto_5};

        listView = findViewById(R.id.listBarang);
        ListAdapter adapter = new AdapterBarang(nama_Barang, img_Barang, this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            String Nama_Barang = nama_Barang[position];
            int Img_Barang = img_Barang[position];
            Intent intent = new Intent(MainActivity.this, DetailBarang.class);
            intent.putExtra("namabarang", Nama_Barang);
            intent.putExtra("gambarbarang", Img_Barang);
            startActivity(intent);
        });
    }
}