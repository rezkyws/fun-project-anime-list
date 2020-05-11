package com.example.listanime;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import java.util.ArrayList;


/**
 * {@link AnimeAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Anime} objects.
 */
public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.ListViewHolder> {
    private ArrayList<Anime> listAnime;
    public AnimeAdapter(ArrayList<Anime> list) {
        this.listAnime = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ListViewHolder(view);
    }

    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Anime anime = listAnime.get(position);
        Glide.with(holder.itemView.getContext())
                .load(anime.getImageResourceId())
                .apply(new RequestOptions().override(200, 200))
                .into(holder.imageView);
        holder.name.setText(anime.getTitle());
        holder.synopsis.setText(anime.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listAnime.get(holder.getAdapterPosition()));
            }
        });
    }


    public interface OnItemClickCallback {
        void onItemClicked(Anime data);
    }

    @Override
    public int getItemCount() {
        return listAnime.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView synopsis, name;
        LinearLayout card;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.picture);
            synopsis = itemView.findViewById(R.id.description_text_view);
            name = itemView.findViewById(R.id.title_text_view);
            card = itemView.findViewById(R.id.an_item);
        }
    }
}
