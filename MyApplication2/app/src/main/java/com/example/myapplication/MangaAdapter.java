package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MangaAdapter extends RecyclerView.Adapter<MangaAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Manga> listManga;

    public MangaAdapter(Context context, List<Manga> listManga) {
        this.inflater = LayoutInflater.from(context);
        this.listManga = listManga;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.singlemanga_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Manga manga = listManga.get(position);
        holder.textTittle.setText(manga.getName());
        holder.textRating.setText(manga.getStatus());
        holder.textYear.setText(manga.getCreatedAt());
    }

    @Override
    public int getItemCount() {
        return listManga.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textTittle, textRating, textYear;

        public ViewHolder(View itemView){
            super (itemView);

            textTittle = itemView.findViewById(R.id.main_title);
            textRating = itemView.findViewById(R.id.main_rating);
            textYear = itemView.findViewById(R.id.main_year);
        }
    }
}
