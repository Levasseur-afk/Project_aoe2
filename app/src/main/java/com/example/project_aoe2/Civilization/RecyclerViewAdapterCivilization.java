package com.example.project_aoe2.Civilization;

import android.content.Context;
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
    private Context context;
    private List<Civilization> civilizationList;

    public RecyclerViewAdapterCivilization(Context context, List<Civilization> civilizationList){
        this.context = context;
        this.civilizationList = civilizationList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.civilization, null);
        ItemViewHolder itemViewHolder = new ItemViewHolder(v);
        return itemViewHolder;
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

    class ItemViewHolder extends RecyclerView.ViewHolder{
        private TextView civilization;
        public ItemViewHolder(View itemView){
            super(itemView);
            this.civilization = (TextView) itemView.findViewById(R.id.civilization);
        }
    }

    public List<Civilization> getCivilizationList() {
        return civilizationList;
    }
}

