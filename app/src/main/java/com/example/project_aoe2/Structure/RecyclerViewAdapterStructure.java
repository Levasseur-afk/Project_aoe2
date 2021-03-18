package com.example.project_aoe2.Structure;

import android.content.Context;
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
    private Context context;
    private List<Structure> structureList;

    public RecyclerViewAdapterStructure(Context context, List<Structure> structureList){
        this.context = context;
        this.structureList = structureList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterStructure.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.structure, null);
        RecyclerViewAdapterStructure.ItemViewHolder itemViewHolder = new RecyclerViewAdapterStructure.ItemViewHolder(v);
        return itemViewHolder;
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

    class ItemViewHolder extends RecyclerView.ViewHolder{
        private TextView structure;
        public ItemViewHolder(View itemView){
            super(itemView);
            this.structure = (TextView) itemView.findViewById(R.id.structure);
        }
    }

}