package com.example.projectakhir;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterBarang extends ArrayAdapter {
    String[] namaBarang;
    int[] imgBarang;
    Activity activity;

    public AdapterBarang(String[] namaBarang, int[] imgBarang, Activity activity){
        super(activity, R.layout.list_barang, namaBarang);
        this.namaBarang = namaBarang;
        this.imgBarang = imgBarang;
        this.activity = activity;
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = activity.getLayoutInflater();
        @SuppressLint({"InflateParams", "ViewHolder"}) View v = inflater.inflate(R.layout.list_barang, null);

        ImageView gambar;
        TextView namabarang;

        gambar = v.findViewById(R.id.img_barang);
        namabarang = v.findViewById(R.id.nama_barang);

        gambar.setImageResource(imgBarang[position]);
        namabarang.setText(namaBarang[position]);

        return v;
    }
}
