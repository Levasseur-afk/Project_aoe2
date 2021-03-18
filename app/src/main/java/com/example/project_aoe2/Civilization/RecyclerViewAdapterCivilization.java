package com.example.project_aoe2.Civilization;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_aoe2.ApiObjects.Civilization;
import com.example.project_aoe2.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapterCivilization extends RecyclerView.Adapter<RecyclerViewAdapterCivilization.ItemViewHolder>{
    private List<Civilization> civilizationList;
    private Context context;

    public RecyclerViewAdapterCivilization(Context context, List<Civilization> civilizationList){
        this.context = context;
        this.civilizationList = civilizationList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @SuppressLint("InflateParams") View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.civilization, null);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Civilization civ = this.civilizationList.get(position);
        holder.civilization.setText(civ.getName());

        int id = 0;
        try {
            id = R.drawable.class.getField(civ.getName().toLowerCase()).getInt(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        Picasso.with(context).load(id)
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return this.civilizationList.size();
    }

    public Civilization getCivilizationAtPosition(int position) {
        return this.civilizationList.get(position);
    }

    public void showNewCivilizationList(List<Civilization> civilizationList) {
        this.civilizationList = civilizationList;
        notifyDataSetChanged();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder{
        private final TextView civilization;
        private final ImageView imageView;
        public ItemViewHolder(View itemView){
            super(itemView);
            this.imageView = itemView.findViewById(R.id.civ_icon);
            this.civilization = itemView.findViewById(R.id.civilization);
        }
    }

}

