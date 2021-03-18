package com.example.project_aoe2.Structure;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_aoe2.ApiObjects.Structure;
import com.example.project_aoe2.R;

import java.util.List;

public class RecyclerViewAdapterStructure extends RecyclerView.Adapter<RecyclerViewAdapterStructure.ItemViewHolder>{
    private List<Structure> structureList;

    public RecyclerViewAdapterStructure(List<Structure> structureList){
        this.structureList = structureList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @SuppressLint("InflateParams") View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.structure, null);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterStructure.ItemViewHolder holder, int position) {
        Structure structure = this.structureList.get(position);
        holder.structure.setText(structure.getName());
    }

    @Override
    public int getItemCount() {
        return this.structureList.size();
    }

    public Structure getStructureAtPosition(int position) {
        return this.structureList.get(position);
    }

    public void showNewStructureList(List<Structure> structureList) {
        this.structureList = structureList;
        notifyDataSetChanged();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder{
        private final TextView structure;
        public ItemViewHolder(View itemView){
            super(itemView);
            this.structure = itemView.findViewById(R.id.structure);
        }
    }

}