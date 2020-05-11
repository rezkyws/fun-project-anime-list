package com.example.listanime;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.CardViewViewHolder> {
    private ArrayList<Anime> listAnime;

    public CardViewAdapter(ArrayList<Anime> list) {
        this.listAnime = list;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.anime_cardview, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    private CardViewAdapter.OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(CardViewAdapter.OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder holder, int position) {
        Anime anime = listAnime.get(position);
        Glide.with(holder.itemView.getContext())
                .load(anime.getImageResourceId())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
        holder.tvDetail.setText(anime.getDescription());
        holder.tvName.setText(anime.getTitle());

        //Make item clickable
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listAnime.get(holder.getAdapterPosition()));
            }
        });
    }


    @Override
    public int getItemCount() {
        return listAnime.size();
    }

    public interface OnItemClickCallback {
        void onItemClicked(Anime data);
    }

    class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail;
        CardView cardView;

        CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.item_name);
            tvDetail = itemView.findViewById(R.id.item_detail);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }
}
