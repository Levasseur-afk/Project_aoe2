package com.example.project_aoe2.Civilization;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.project_aoe2.ApiObjects.Civilization;
import com.example.project_aoe2.R;
import com.example.project_aoe2.Tools.TouchListener;

import java.util.ArrayList;
import java.util.List;

public class CivilizationListActivity extends AppCompatActivity implements GetCivilizations.IDisplay {

    private RecyclerViewAdapterCivilization recyclerViewAdapterCivilization;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = this;
        setContentView(R.layout.activity_civilization_list);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view_civilization);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerViewAdapterCivilization = new RecyclerViewAdapterCivilization(new ArrayList<Civilization>());
        recyclerView.setAdapter(this.recyclerViewAdapterCivilization);
        recyclerView.addOnItemTouchListener(new TouchListener(this, recyclerView, new TouchListener.ITouchListener() {
            @Override
            public void onClick(View v, int position) {
                Civilization civ = recyclerViewAdapterCivilization.getCivilizationAtPosition(position);
                Intent intent = new Intent(context, CivilizationDetailActivity.class);
                intent.putExtra("civ", civ);
                startActivity(intent);
            }
        }));
        String url = "https://age-of-empires-2-api.herokuapp.com/api/v1/civilizations";
        GetCivilizations getCivilizations = new GetCivilizations(url, this);
    }

    public void displayCivilization(List<Civilization> civilizationList){
        recyclerViewAdapterCivilization.showNewCivilizationList(civilizationList);
    }
}