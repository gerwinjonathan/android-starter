package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private RecyclerView rvCategory2;
    private ArrayList<KebudayaanDetail> listKebudayaanDetail = new ArrayList<>();

    public static String NAMA_KEBUDAYAAN = "NAMA_KEBUDAYAAN";
    public static String FOTO_KEBUDAYAAN = "FOTO_KEBUDAYAAN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        rvCategory2 = findViewById(R.id.rv_category2);
        rvCategory2.setHasFixedSize(true);

        String namaKebudayaan = getIntent().getStringExtra(NAMA_KEBUDAYAAN);
        getSupportActionBar().setTitle(namaKebudayaan);

        switch (namaKebudayaan) {
            case "Pulau Sumatera":
                listKebudayaanDetail.addAll(KebudayaanData.getListData(KebudayaanData.dataKebudayaanSumatera));
                showRecyclerList();
                break;
            case "Pulau Jawa":
                listKebudayaanDetail.addAll(KebudayaanData.getListData(KebudayaanData.dataKebudayaanJawa));
                showRecyclerList();
                break;
            case "Pulau Kalimantan":
                listKebudayaanDetail.addAll(KebudayaanData.getListData(KebudayaanData.dataKebudayaanKalimantan));
                showRecyclerList();
                break;
            case "Pulau Sulawesi":
                listKebudayaanDetail.addAll(KebudayaanData.getListData(KebudayaanData.dataKebudayaanSulawesi));
                showRecyclerList();
                break;
            case "Pulau Nusa Tenggara":
                listKebudayaanDetail.addAll(KebudayaanData.getListData(KebudayaanData.dataKebudayaanNusaTenggara));
                showRecyclerList();
                break;
            case "Pulau Maluku dan Papua":
                listKebudayaanDetail.addAll(KebudayaanData.getListData(KebudayaanData.dataKebudayaanMalukuPapua));
                showRecyclerList();
                break;
        }
        //Log.d("STATE", text.getText().toString() + "is being executed");
        //list.addAll(KebudayaanData.getListData(text.getText().toString()));
    }

    private void showRecyclerList(){
        rvCategory2.setLayoutManager(new LinearLayoutManager(this));
        KebudayaanDataAdapter kebudayaanDataAdapter = new KebudayaanDataAdapter(this);
        kebudayaanDataAdapter.setListKebudayaanDetail(listKebudayaanDetail);
        rvCategory2.setAdapter(kebudayaanDataAdapter);

        ItemClickSupport.addTo(rvCategory2).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedKebudayaan(listKebudayaanDetail.get(position));
            }
        });

    }

    private void showSelectedKebudayaan(KebudayaanDetail kebudayaanDetail){
        Toast.makeText(this, "Kamu memilih "+kebudayaanDetail.getNamaKebudayaan(), Toast.LENGTH_SHORT).show();
        Intent intents = new Intent(Main2Activity.this, DetailInformasiKebudayaan.class);
        intents.putExtra(DetailInformasiKebudayaan.NAMA_KEBUDAYAAN, kebudayaanDetail.getNamaKebudayaan());
        intents.putExtra(DetailInformasiKebudayaan.ASAL_KEBUDAYAAN, kebudayaanDetail.getAsalKebudayaan());
        intents.putExtra(DetailInformasiKebudayaan.DESKRIPSI_KEBUDAYAAN, kebudayaanDetail.getDeskripsiKebudayaan());
        intents.putExtra(DetailInformasiKebudayaan.FOTO_KEBUDAYAAN, kebudayaanDetail.getFoto());
        startActivity(intents);
    }
}