package com.example.project_aoe2.Technology;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

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
        // init recycler view
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view_technology);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        this.recyclerViewAdapterTechnology = new RecyclerViewAdapterTechnology(this, new ArrayList<Technology>());
        recyclerView.setAdapter(this.recyclerViewAdapterTechnology);
        // on click, we want to launch a new activity to show details of the item clicked
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

    // insert my special menu to use SearchView
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView =  (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                recyclerViewAdapterTechnology.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
}