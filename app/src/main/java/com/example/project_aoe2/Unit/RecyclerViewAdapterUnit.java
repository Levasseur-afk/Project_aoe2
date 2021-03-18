package com.example.project_aoe2.Unit;

import android.content.Context;
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
    private Context context;
    private List<Unit> unitList;

    public RecyclerViewAdapterUnit(Context context, List<Unit> unitList){
        this.context = context;
        this.unitList = unitList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.unit, null);
        ItemViewHolder itemViewHolder = new ItemViewHolder(v);
        return itemViewHolder;
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

    class ItemViewHolder extends RecyclerView.ViewHolder{
        private TextView unit;
        public ItemViewHolder(View itemView){
            super(itemView);
            this.unit = (TextView) itemView.findViewById(R.id.unit);
        }
    }
}
