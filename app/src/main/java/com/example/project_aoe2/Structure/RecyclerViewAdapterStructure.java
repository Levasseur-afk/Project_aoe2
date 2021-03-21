package com.example.project_aoe2.Structure;

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
import com.example.project_aoe2.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapterStructure extends RecyclerView.Adapter<RecyclerViewAdapterStructure.ItemViewHolder> implements Filterable {
    private Context context;
    private List<Structure> structureList;
    private List<Structure> structureListFull;

    public RecyclerViewAdapterStructure(Context context, List<Structure> structureList){
        this.context = context;
        this.structureList = structureList;
    }

    // Build layout by inflating a layout as "template" multiple times (fragment mechanism)
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
        int id = 0;
        try {
            // I had namming issues with my images so I built this solution
            String toReplace[] = {" ", "-", "(", ")"};
            String name = structure.getName().toLowerCase() + "_aoe2de";
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
        return this.structureList.size();
    }

    public Structure getStructureAtPosition(int position) {
        return this.structureList.get(position);
    }

    public void showNewStructureList(List<Structure> structureList) {
        this.structureList = structureList;
        this.structureListFull = new ArrayList<>(structureList);
        notifyDataSetChanged();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder{
        private final ImageView imageView;
        private final TextView structure;
        public ItemViewHolder(View itemView){
            super(itemView);
            this.imageView = itemView.findViewById(R.id.structure_icon);
            this.structure = itemView.findViewById(R.id.structure);
        }
    }

    @Override
    public Filter getFilter() {
        return structureFilter;
    }

    private Filter structureFilter = new Filter(){

        // done in background thread
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Structure> filteredStructure = new ArrayList<>();
            if (constraint == null || constraint.length() == 0){
                filteredStructure.addAll(structureListFull);
            }
            else{
                // it's the input text of the user
                String filteredPattern = constraint.toString().toLowerCase();
                for(Structure structure : structureListFull){
                    if(structure.getName().toLowerCase().contains(filteredPattern)){
                        filteredStructure.add(structure);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredStructure;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            structureList.clear();
            structureList.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };

}