package com.example.listanime;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridAnimeAdapter extends RecyclerView.Adapter<GridAnimeAdapter.GridViewHolder> {
    private ArrayList<Anime> listAnime;

    GridAnimeAdapter(ArrayList<Anime> list) {
        this.listAnime = list;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.anime_grid, viewGroup, false);
        return new GridViewHolder(view);
    }

    public interface OnItemClickCallback {
        void onItemClicked(Anime data);
    }

    @Override
    public void onBindViewHolder(@NonNull final GridViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(listAnime.get(position).getImageResourceId())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listAnime.get(holder.getAdapterPosition()));
            }
        });
    }

    private GridAnimeAdapter.OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(GridAnimeAdapter.OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @Override
    public int getItemCount() {
        return listAnime.size();
    }

    static class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        LinearLayout item;

        GridViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            item = itemView.findViewById(R.id.an_item);
        }
    }
}