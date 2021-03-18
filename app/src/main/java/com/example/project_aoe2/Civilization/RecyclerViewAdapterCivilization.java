package com.example.project_aoe2.Civilization;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_aoe2.ApiObjects.Civilization;
import com.example.project_aoe2.R;

import java.util.List;

public class RecyclerViewAdapterCivilization extends RecyclerView.Adapter<RecyclerViewAdapterCivilization.ItemViewHolder>{
    private List<Civilization> civilizationList;

    public RecyclerViewAdapterCivilization(List<Civilization> civilizationList){
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
        public ItemViewHolder(View itemView){
            super(itemView);
            this.civilization = itemView.findViewById(R.id.civilization);
        }
    }

}

