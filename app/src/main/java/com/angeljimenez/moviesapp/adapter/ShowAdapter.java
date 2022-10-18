package com.angeljimenez.moviesapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.angeljimenez.moviesapp.R;
import com.angeljimenez.moviesapp.Utils.Total;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ViewHolder> {
    ArrayList<HashMap<String,String>> arrayList;
    public ShowAdapter(ArrayList<HashMap<String,String>>arrayList){
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_shows,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HashMap<String,String> map = arrayList.get(position);
        holder.tvShowName.setText(map.get("name"));
        holder.tvShowId.setText(map.get("id"));
        holder.tvGenre.setText(map.get("genre"));
        holder.tvDuration.setText(map.get("duration"));
        holder.tvShowDescription.setText(map.get("description"));
        float precio = Float.parseFloat(map.get("rating"));
        holder.tvShowRating.setText("S/ "+ String.format("%.2f",precio));
        String ruta = Total.rutaServicio + map.get("image");
        Picasso.get().load(ruta).into(holder.ivShow);
        //Log.d("FOTO",map.get("imagenchica"));
        if(map.get("image") == "null") {
            Picasso.get().load(R.drawable.nophoto).into(holder.ivShow);
        }
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvShowId,tvShowRating,tvShowName,tvShowDescription,tvGenre,tvDuration;
        ImageView ivShow;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvShowId = itemView.findViewById(R.id.tvShowId);
            tvShowRating = itemView.findViewById(R.id.tvShowRating);
            tvShowName = itemView.findViewById(R.id.tvShowName);
            tvGenre = itemView.findViewById(R.id.tvGenre);
            tvDuration = itemView.findViewById(R.id.tvDuration);
            tvShowDescription = itemView.findViewById(R.id.tvShowDescription);
            ivShow = itemView.findViewById(R.id.ivShow);
        }
    }
}
