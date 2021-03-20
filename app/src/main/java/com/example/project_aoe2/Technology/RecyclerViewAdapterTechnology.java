package com.example.project_aoe2.Technology;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_aoe2.ApiObjects.Technology;
import com.example.project_aoe2.R;
import com.squareup.picasso.Picasso;

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
        @SuppressLint("InflateParams") View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.technology, null);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Technology technology = this.technologyList.get(position);
        holder.technology.setText(technology.getName());

        int id = 0;
        try {
            String toReplace[] = {" ", "-", "(", ")"};
            String name = technology.getName().toLowerCase();
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
        return this.technologyList.size();
    }

    public Technology getTechnologyAtPosition(int position) {
        return this.technologyList.get(position);
    }

    public void showNewTechnologyList(List<Technology> technologyList) {
        this.technologyList = technologyList;
        notifyDataSetChanged();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder{
        private final ImageView imageView;
        private final TextView technology;
        public ItemViewHolder(View itemView){
            super(itemView);
            this.imageView = itemView.findViewById(R.id.tech_icon);
            this.technology = itemView.findViewById(R.id.technology);
        }
    }

}