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

public class ListKebudayaanAdapter extends RecyclerView.Adapter<ListKebudayaanAdapter.CategoryViewHolder> {

    private Context context;
    private ArrayList<Kebudayaan> listKebudayaan;

    public ListKebudayaanAdapter(Context context) {
        this.context = context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<Kebudayaan> getListKebudayaan() {
        return this.listKebudayaan;
    }

    public void setListKebudayaan(ArrayList<Kebudayaan> listKebudayaan) {
        this.listKebudayaan = listKebudayaan;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_kebudayaan, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int position) {
        categoryViewHolder.tvNamaKebudayaan.setText(getListKebudayaan().get(position).getNamaKebudayaan());
        categoryViewHolder.tvDeskripsiKebudayaan.setText(getListKebudayaan().get(position).getDeskripsiKebudayaan());

        Glide.with(context)
                .load(getListKebudayaan().get(position).getFoto())
                .apply(new RequestOptions().override(55, 55))
                .into(categoryViewHolder.imgFoto);
    }

    @Override
    public int getItemCount() {
        return getListKebudayaan().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {

        TextView tvNamaKebudayaan;
        TextView tvDeskripsiKebudayaan;
        ImageView imgFoto;

        CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaKebudayaan = itemView.findViewById(R.id.tv_item_name);
            tvDeskripsiKebudayaan = itemView.findViewById(R.id.tv_item_remarks);
            imgFoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
