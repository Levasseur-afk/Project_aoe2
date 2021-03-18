package com.example.project_aoe2.Technology;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_aoe2.ApiObjects.Technology;
import com.example.project_aoe2.R;

import java.util.List;

public class RecyclerViewAdapterTechnology extends RecyclerView.Adapter<RecyclerViewAdapterTechnology.ItemViewHolder>{
    private Context context;
    private List<Technology> technologyList;

    public RecyclerViewAdapterTechnology(Context context, List<Technology> technologyList){
        this.context = context;
        this.technologyList = technologyList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.technology, null);
        ItemViewHolder itemViewHolder = new ItemViewHolder(v);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Technology technology = this.technologyList.get(position);
        holder.technology.setText(technology.getName());
    }

    @Override
    public int getItemCount() {
        return this.technologyList.size();
    }

    public Technology getTechnologyAtPosition(int position) {
        return this.technologyList.get(position);
    }

    public void showNewTechnologyList(List<Technology> technologyList) {
        this.technologyList = technologyList;
        notifyDataSetChanged();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
        private TextView technology;
        public ItemViewHolder(View itemView){
            super(itemView);
            this.technology = (TextView) itemView.findViewById(R.id.technology);
        }
    }

}