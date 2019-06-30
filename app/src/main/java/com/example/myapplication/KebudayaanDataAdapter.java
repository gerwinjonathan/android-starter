package com.example.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class KebudayaanDataAdapter extends RecyclerView.Adapter<KebudayaanDataAdapter.CategoryViewHolder> {

    private Context context;
    private ArrayList<KebudayaanDetail> listKebudayaanDetail;

    public KebudayaanDataAdapter(Context context) {
        this.context = context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<KebudayaanDetail> getListKebudayaanDetail() {
        return this.listKebudayaanDetail;
    }

    public void setListKebudayaanDetail(ArrayList<KebudayaanDetail> listKebudayaanDetail) {
        this.listKebudayaanDetail = listKebudayaanDetail;
    }

    @NonNull
    @Override
    public KebudayaanDataAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_kebudayaan_detail, viewGroup, false);
        return new KebudayaanDataAdapter.CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull KebudayaanDataAdapter.CategoryViewHolder categoryViewHolder, int position) {
        categoryViewHolder.tvNamaKebudayaan.setText(getListKebudayaanDetail().get(position).getNamaKebudayaan());
        categoryViewHolder.tvAsalKebudayaan.setText(getListKebudayaanDetail().get(position).getAsalKebudayaan());

        Glide.with(context)
                .load(getListKebudayaanDetail().get(position).getFoto())
                .apply(new RequestOptions().override(55, 55))
                .into(categoryViewHolder.imgFoto);
    }

    @Override
    public int getItemCount() {
        return getListKebudayaanDetail().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {

        TextView tvNamaKebudayaan;
        TextView tvAsalKebudayaan;
        ImageView imgFoto;

        CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaKebudayaan = itemView.findViewById(R.id.tv_item_name);
            tvAsalKebudayaan = itemView.findViewById(R.id.tv_item_remarks);
            imgFoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
