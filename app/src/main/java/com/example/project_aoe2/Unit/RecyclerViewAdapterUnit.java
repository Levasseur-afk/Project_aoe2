package com.example.project_aoe2.Unit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.project_aoe2.ApiObjects.Structure;
import com.example.project_aoe2.ApiObjects.Unit;
import com.example.project_aoe2.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapterUnit extends RecyclerView.Adapter<RecyclerViewAdapterUnit.ItemViewHolder> implements Filterable {
    private List<Unit> unitList;
    private List<Unit> unitListFull;
    private Context context;

    public RecyclerViewAdapterUnit(Context context, List<Unit> unitList){
        this.context = context;
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
        int id = 0;
        try {
            String toReplace[] = {" ", "-", "(", ")"};
            String name = unit.getName().toLowerCase() + "_aoe2de";
            for(String ch : toReplace){
                name = name.replace(ch,"_");
            }
            id = R.drawable.class.getField(name).getInt(null);
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
        return this.unitList.size();
    }

    public Unit getUnitAtPosition(int position) {
        return this.unitList.get(position);
    }

    public void showNewUnitList(List<Unit> unitList) {
        this.unitList = unitList;
        this.unitListFull = new ArrayList<>(unitList);
        notifyDataSetChanged();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder{
        private final TextView unit;
        private final ImageView imageView;
        public ItemViewHolder(View itemView){
            super(itemView);
            this.unit = itemView.findViewById(R.id.unit);
            this.imageView = itemView.findViewById(R.id.unit_icon);
        }
    }
    @Override
    public Filter getFilter() {
        return unitFilter;
    }

    private Filter unitFilter = new Filter(){

        // done in background thread
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Unit> filteredUnit = new ArrayList<>();
            if (constraint == null || constraint.length() == 0){
                filteredUnit.addAll(unitListFull);
            }
            else{
                String filteredPattern = constraint.toString().toLowerCase();
                for(Unit unit : unitListFull){
                    if(unit.getName().toLowerCase().contains(filteredPattern)){
                        filteredUnit.add(unit);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredUnit;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            unitList.clear();
            unitList.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };
}
