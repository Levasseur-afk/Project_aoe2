package com.example.project_aoe2.Unit;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.project_aoe2.ApiObjects.Unit;
import com.example.project_aoe2.R;

import java.util.List;

public class RecyclerViewAdapterUnit extends RecyclerView.Adapter<RecyclerViewAdapterUnit.ItemViewHolder>{
    private List<Unit> unitList;

    public RecyclerViewAdapterUnit(List<Unit> unitList){
        this.unitList = unitList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @SuppressLint("InflateParams") View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.unit, null);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Unit unit = this.unitList.get(position);
        holder.unit.setText(unit.getName());
    }

    @Override
    public int getItemCount() {
        return this.unitList.size();
    }

    public Unit getUnitAtPosition(int position) {
        return this.unitList.get(position);
    }

    public void showNewUnitList(List<Unit> unitList) {
        this.unitList = unitList;
        notifyDataSetChanged();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder{
        private final TextView unit;
        public ItemViewHolder(View itemView){
            super(itemView);
            this.unit = itemView.findViewById(R.id.unit);
        }
    }
}
