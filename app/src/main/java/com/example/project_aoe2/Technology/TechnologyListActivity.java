package com.example.project_aoe2.Technology;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.project_aoe2.ApiObjects.Technology;
import com.example.project_aoe2.R;

import com.example.project_aoe2.Tools.TouchListener;

import java.util.ArrayList;
import java.util.List;


public class TechnologyListActivity extends AppCompatActivity implements GetTechnologies.IDisplay {

    private RecyclerViewAdapterTechnology recyclerViewAdapterTechnology;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = this;
        setContentView(R.layout.activity_technology_list);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view_technology);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        this.recyclerViewAdapterTechnology = new RecyclerViewAdapterTechnology(this, new ArrayList<Technology>());
        recyclerView.setAdapter(this.recyclerViewAdapterTechnology);
        recyclerView.addOnItemTouchListener(new TouchListener(this, recyclerView, new TouchListener.ITouchListener() {
            @Override
            public void onClick(View v, int position) {
                Technology technology = recyclerViewAdapterTechnology.getTechnologyAtPosition(position);
                Intent intent = new Intent(context, TechnologyDetailActivity.class);
                intent.putExtra("technology", technology);
                startActivity(intent);
            }
        }));
        String url = "https://age-of-empires-2-api.herokuapp.com/api/v1/technologies";
        GetTechnologies getTechnologies = new GetTechnologies(url, this);
    }

    public void displayTechnology(List<Technology> technologyList){
        recyclerViewAdapterTechnology.showNewTechnologyList(technologyList);
    }
}