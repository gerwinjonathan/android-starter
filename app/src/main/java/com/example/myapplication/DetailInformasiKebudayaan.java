package com.example.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class DetailInformasiKebudayaan extends AppCompatActivity {

    public static String NAMA_KEBUDAYAAN = "NAMA_KEBUDAYAAN";
    public static String ASAL_KEBUDAYAAN = "ASAL_KEBUDAYAAN";
    public static String DESKRIPSI_KEBUDAYAAN = "DESKRIPSI_KEBUDAYAAN";
    public static String FOTO_KEBUDAYAAN = "FOTO_KEBUDAYAAN";

    TextView namaKebudayaan, asalKebudayaan, deskripsiKebudayaan;
    ImageView fotoKebudayaan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_informasi_kebudayaan);

        namaKebudayaan = findViewById(R.id.tv_item_name);
        asalKebudayaan = findViewById(R.id.tv_item_remarks);
        deskripsiKebudayaan = findViewById(R.id.textView2);
        fotoKebudayaan = findViewById(R.id.img_item_photo);

        String nama = getIntent().getStringExtra(NAMA_KEBUDAYAAN);
        String asal = getIntent().getStringExtra(ASAL_KEBUDAYAAN);
        String deskripsi = getIntent().getStringExtra(DESKRIPSI_KEBUDAYAAN);
        String foto = getIntent().getStringExtra(FOTO_KEBUDAYAAN);
        getSupportActionBar().setTitle(nama);

        namaKebudayaan.setText(nama);
        asalKebudayaan.setText(asal);
        deskripsiKebudayaan.setText(deskripsi);

        Picasso.with(this).load(foto).into(fotoKebudayaan);

    }
}
