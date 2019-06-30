package com.example.myapplication;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvCategory;
    private ArrayList<Kebudayaan> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list.addAll(ListKebudayaanData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListKebudayaanAdapter listKebudayaanAdapter = new ListKebudayaanAdapter(this);
        listKebudayaanAdapter.setListKebudayaan(list);
        rvCategory.setAdapter(listKebudayaanAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedKebudayaan(list.get(position));
            }
        });

    }

    private void showSelectedKebudayaan(Kebudayaan kebudayaan){
        Toast.makeText(this, "Kamu memilih "+kebudayaan.getNamaKebudayaan(), Toast.LENGTH_SHORT).show();
        Intent intents = new Intent(MainActivity.this, Main2Activity.class);
        intents.putExtra(Main2Activity.NAMA_KEBUDAYAAN, kebudayaan.getNamaKebudayaan());
        intents.putExtra(Main2Activity.FOTO_KEBUDAYAAN, kebudayaan.getFoto());
        startActivity(intents);
    }
}
