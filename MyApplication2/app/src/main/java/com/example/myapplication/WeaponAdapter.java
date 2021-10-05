package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WeaponAdapter extends RecyclerView.Adapter<WeaponAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Weapon> listManga;

    public WeaponAdapter(Context context, List<Weapon> listWeapon) {
        this.inflater = LayoutInflater.from(context);
        this.listManga = listWeapon;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.singleweapon, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Weapon manga = listManga.get(position);
        holder.textTittle.setText(manga.getName());
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
        }
    }
}
