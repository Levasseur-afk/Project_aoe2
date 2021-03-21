package com.example.project_aoe2.Civilization;

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
        // init recycler view
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view_civilization);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        this.recyclerViewAdapterCivilization = new RecyclerViewAdapterCivilization(this, new ArrayList<Civilization>());
        recyclerView.setAdapter(this.recyclerViewAdapterCivilization);
        // on click, we want to launch a new activity to show details of the item clicked
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
                recyclerViewAdapterCivilization.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
}